package org.cloudwarp.mobscarecrow.entities;

import com.mojang.logging.LogUtils;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.TargetPredicate;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.vehicle.AbstractMinecartEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.Wearable;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import net.minecraft.particle.BlockStateParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.predicate.entity.EntityPredicates;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.*;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.*;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.LightType;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.cloudwarp.mobscarecrow.MobScarecrow;
import org.cloudwarp.mobscarecrow.registry.MSItems;
import org.cloudwarp.mobscarecrow.registry.MSParticles;
import org.cloudwarp.mobscarecrow.registry.MSSounds;
import org.cloudwarp.mobscarecrow.utils.ScarecrowAccess;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.function.Predicate;

public class SmallPlushieEntity extends LivingEntity {

	public static final int HIDE_BASE_PLATE_FLAG = 8;
	public static final int MARKER_FLAG = 16;
	public static final TrackedData<Byte> PLUSHIE_FLAGS = DataTracker.registerData(SmallPlushieEntity.class, TrackedDataHandlerRegistry.BYTE);
	public static final TrackedData<EulerAngle> TRACKER_HEAD_ROTATION = DataTracker.registerData(SmallPlushieEntity.class, TrackedDataHandlerRegistry.ROTATION);
	public static final TrackedData<EulerAngle> TRACKER_BODY_ROTATION = DataTracker.registerData(SmallPlushieEntity.class, TrackedDataHandlerRegistry.ROTATION);
	private static final EulerAngle DEFAULT_HEAD_ROTATION = new EulerAngle(0.0f, 0.0f, 0.0f);
	private static final EulerAngle DEFAULT_BODY_ROTATION = new EulerAngle(0.0f, 0.0f, 0.0f);
	private static final EntityDimensions MARKER_DIMENSIONS = new EntityDimensions(0.0f, 0.0f, true);
	private static final Predicate<Entity> RIDEABLE_MINECART_PREDICATE = entity -> entity instanceof AbstractMinecartEntity && ((AbstractMinecartEntity)entity).getMinecartType() == AbstractMinecartEntity.Type.RIDEABLE;
	private static final Logger LOGGER = LogUtils.getLogger();
	private boolean invisible;
	public long lastHitTime;
	private EulerAngle headRotation = DEFAULT_HEAD_ROTATION;
	private EulerAngle bodyRotation = DEFAULT_BODY_ROTATION;
	private MSEntityTypes scarecrowType;
	protected int cooldown;

	private double distance = 16D;

	public SmallPlushieEntity (EntityType<? extends SmallPlushieEntity> entityType, World world, MSEntityTypes scarecrowType) {
		super((EntityType<? extends LivingEntity>)entityType, world);
		this.stepHeight = 0.0f;
		this.scarecrowType = scarecrowType;
		this.distance = MobScarecrow.mobScarecrowRadius + 8D;
	}

	@Override
	protected void initDataTracker() {
		super.initDataTracker();
		this.dataTracker.startTracking(PLUSHIE_FLAGS, (byte)0);
		this.dataTracker.startTracking(TRACKER_HEAD_ROTATION, DEFAULT_HEAD_ROTATION);
		this.dataTracker.startTracking(TRACKER_BODY_ROTATION, DEFAULT_BODY_ROTATION);
	}

	@Override
	public void calculateDimensions() {
		double d = this.getX();
		double e = this.getY();
		double f = this.getZ();
		super.calculateDimensions();
		this.setPosition(d, e, f);
	}

	private boolean canClip() {
		return !this.isMarker() && !this.hasNoGravity();
	}

	@Override
	public boolean canMoveVoluntarily() {
		return super.canMoveVoluntarily() && this.canClip();
	}

	@Override
	public boolean isPushable() {
		return false;
	}

	@Override
	protected void pushAway(Entity entity) {
	}

	@Override
	protected void tickCramming() {
		List<Entity> list = this.world.getOtherEntities(this, this.getBoundingBox(), RIDEABLE_MINECART_PREDICATE);
		for (int i = 0; i < list.size(); ++i) {
			Entity entity = list.get(i);
			if (!(this.squaredDistanceTo(entity) <= 0.2)) continue;
			entity.pushAwayFrom(this);
		}
	}

	@Override
	public ActionResult interactAt(PlayerEntity player, Vec3d hitPos, Hand hand) {
		ItemStack itemStack = player.getStackInHand(hand);
		if (this.isMarker() || itemStack.isOf(Items.NAME_TAG)) {
			return ActionResult.PASS;
		}
		if (player.isSpectator()) {
			return ActionResult.SUCCESS;
		}
		if(scarecrowType != MSEntityTypes.DEFAULT_SCARECROW) {
			this.playSqueakSound();
		}
		return ActionResult.PASS;
	}

	@Override
	public boolean damage(DamageSource source, float amount) {
		if (this.world.isClient || this.isRemoved()) {
			return false;
		}
		if (DamageSource.OUT_OF_WORLD.equals(source)) {
			this.kill();
			return false;
		}
		if (this.isInvulnerableTo(source) || this.invisible || this.isMarker()) {
			return false;
		}
		if (source.isExplosive()) {
			this.onBreak(source);
			this.kill();
			return false;
		}
		if (DamageSource.IN_FIRE.equals(source)) {
			if (this.isOnFire()) {
				this.updateHealth(source, 0.15f);
			} else {
				this.setOnFireFor(5);
			}
			return false;
		}
		if (DamageSource.ON_FIRE.equals(source) && this.getHealth() > 0.5f) {
			this.updateHealth(source, 4.0f);
			return false;
		}
		boolean bl = source.getSource() instanceof PersistentProjectileEntity;
		boolean bl2 = bl && ((PersistentProjectileEntity)source.getSource()).getPierceLevel() > 0;
		boolean bl3 = "player".equals(source.getName());
		if (!bl3 && !bl) {
			return false;
		}
		if (source.getAttacker() instanceof PlayerEntity && !((PlayerEntity)source.getAttacker()).getAbilities().allowModifyWorld) {
			return false;
		}
		if (source.isSourceCreativePlayer()) {
			this.playBreakSound();
			this.spawnBreakParticles();
			this.kill();
			return bl2;
		}
		long l = this.world.getTime();
		if (l - this.lastHitTime <= 5L || bl) {
			this.breakAndDropItem(source);
			this.spawnBreakParticles();
			this.kill();
		} else {
			this.world.sendEntityStatus(this, (byte)32);
			this.emitGameEvent(GameEvent.ENTITY_DAMAGE, source.getAttacker());
			this.lastHitTime = l;
		}
		return true;
	}

	@Override
	public void handleStatus(byte status) {
		if (status == 32) {
			if (this.world.isClient) {
				this.world.playSound(this.getX(), this.getY(), this.getZ(), SoundEvents.ENTITY_ARMOR_STAND_HIT, this.getSoundCategory(), 0.3f, 1.0f, false);
				this.lastHitTime = this.world.getTime();
			}
		} else {
			super.handleStatus(status);
		}
	}

	@Override
	public Iterable<ItemStack> getArmorItems () {
		return DefaultedList.ofSize(4,ItemStack.EMPTY);
	}

	@Override
	public ItemStack getEquippedStack (EquipmentSlot slot) {
		return ItemStack.EMPTY;
	}

	@Override
	public void equipStack (EquipmentSlot slot, ItemStack stack) {

	}

	@Override
	public boolean shouldRender(double distance) {
		double d = this.getBoundingBox().getAverageSideLength() * 4.0;
		if (Double.isNaN(d) || d == 0.0) {
			d = 4.0;
		}
		return distance < (d *= 64.0) * d;
	}

	private void spawnBreakParticles() {
		if (this.world instanceof ServerWorld) {
			if(scarecrowType == MSEntityTypes.DEFAULT_SCARECROW){
				((ServerWorld)this.world).spawnParticles(new BlockStateParticleEffect(ParticleTypes.BLOCK, Blocks.HAY_BLOCK.getDefaultState()), this.getX(), this.getBodyY(0.6666666666666666), this.getZ(), 10, this.getWidth() / 4.0f, this.getHeight() / 4.0f, this.getWidth() / 4.0f, 0.05);
				return;
			}
			((ServerWorld)this.world).spawnParticles(MSParticles.PLUSHIE_PARTICLE, this.getX(), this.getBodyY(0.66666), this.getZ(), 10, this.getWidth() / 8.0f, this.getHeight() / 8.0f, this.getWidth() / 8.0f, 0.2);
		}
	}

	private void updateHealth(DamageSource damageSource, float amount) {
		float f = this.getHealth();
		if ((f -= amount) <= 0.5f) {
			this.onBreak(damageSource);
			this.kill();
		} else {
			this.setHealth(f);
			this.emitGameEvent(GameEvent.ENTITY_DAMAGE, damageSource.getAttacker());
		}
	}

	private void breakAndDropItem(DamageSource damageSource) {
		Block.dropStack(this.world, this.getBlockPos(), new ItemStack(MSItems.get(scarecrowType.id)));
		this.onBreak(damageSource);
	}

	private void onBreak(DamageSource damageSource) {
		this.playBreakSound();
		this.drop(damageSource);
	}

	private void playBreakSound() {
		if(scarecrowType == MSEntityTypes.DEFAULT_SCARECROW){
			this.world.playSound(null, this.getX(), this.getY(), this.getZ(), SoundEvents.BLOCK_GRASS_BREAK, this.getSoundCategory(), 1.0f, 1.0f);
			return;
		}
		this.world.playSound(null, this.getX(), this.getY(), this.getZ(), MSSounds.PLUSHIE_BREAK_EVENT, this.getSoundCategory(), 1.0f, 1.0f);
	}
	private void playSqueakSound() {
		this.world.playSound(null, this.getX(), this.getY(), this.getZ(), MSSounds.PLUSHIE_SQUEAK_EVENT, this.getSoundCategory(), 1.0f, 1.0f);
	}

	@Override
	protected float getActiveEyeHeight(EntityPose pose, EntityDimensions dimensions) {
		return dimensions.height * 0.5f;
	}

	@Override
	protected float turnHead(float bodyRotation, float headRotation) {
		this.prevBodyYaw = this.prevYaw;
		this.bodyYaw = this.getYaw();
		return 0.0f;
	}

	@Override
	public void travel(Vec3d movementInput) {
		if (!this.canClip()) {
			return;
		}
		super.travel(movementInput);
	}

	@Override
	public void setBodyYaw(float bodyYaw) {
		this.prevBodyYaw = this.prevYaw = bodyYaw;
		this.prevHeadYaw = this.headYaw = bodyYaw;
	}

	@Override
	public Arm getMainArm () {
		return null;
	}

	@Override
	public void setHeadYaw(float headYaw) {
		this.prevBodyYaw = this.prevYaw = headYaw;
		this.prevHeadYaw = this.headYaw = headYaw;
	}

	@Override
	protected void updatePotionVisibility() {
		this.setInvisible(this.invisible);
	}

	@Override
	public void setInvisible(boolean invisible) {
		this.invisible = invisible;
		super.setInvisible(invisible);
	}

	@Override
	public void kill() {
		this.remove(Entity.RemovalReason.KILLED);
	}

	@Override
	public boolean isImmuneToExplosion() {
		return this.isInvisible();
	}

	@Override
	public PistonBehavior getPistonBehavior() {
		if (this.isMarker()) {
			return PistonBehavior.IGNORE;
		}
		return super.getPistonBehavior();
	}

	private void setMarker(boolean marker) {
		this.dataTracker.set(PLUSHIE_FLAGS, this.setBitField(this.dataTracker.get(PLUSHIE_FLAGS), MARKER_FLAG, marker));
	}

	public boolean isMarker() {
		return (this.dataTracker.get(PLUSHIE_FLAGS) & 0x10) != 0;
	}

	private byte setBitField(byte value, int bitField, boolean set) {
		value = set ? (byte)(value | bitField) : (byte)(value & ~bitField);
		return value;
	}

	public void setHeadRotation(EulerAngle angle) {
		this.headRotation = angle;
		this.dataTracker.set(TRACKER_HEAD_ROTATION, angle);
	}

	public void setBodyRotation(EulerAngle angle) {
		this.bodyRotation = angle;
		this.dataTracker.set(TRACKER_BODY_ROTATION, angle);
	}

	public EulerAngle getHeadRotation() {
		return this.headRotation;
	}

	public EulerAngle getBodyRotation() {
		return this.bodyRotation;
	}



	@Override
	public boolean handleAttack(Entity attacker) {
		return attacker instanceof PlayerEntity && !this.world.canPlayerModifyAt((PlayerEntity)attacker, this.getBlockPos());
	}

	@Override
	public LivingEntity.FallSounds getFallSounds() {
		if(scarecrowType == MSEntityTypes.DEFAULT_SCARECROW){
			return new LivingEntity.FallSounds(SoundEvents.BLOCK_GRASS_FALL, SoundEvents.BLOCK_GRASS_FALL);
		}
		return new LivingEntity.FallSounds(MSSounds.PLUSHIE_BREAK_EVENT, MSSounds.PLUSHIE_BREAK_EVENT);
	}

	@Override
	@Nullable
	protected SoundEvent getHurtSound(DamageSource source) {
		if(scarecrowType == MSEntityTypes.DEFAULT_SCARECROW){
			return SoundEvents.BLOCK_GRASS_HIT;
		}
		return MSSounds.PLUSHIE_BREAK_EVENT;
	}

	@Override
	@Nullable
	protected SoundEvent getDeathSound() {
		if(scarecrowType == MSEntityTypes.DEFAULT_SCARECROW){
			return SoundEvents.BLOCK_GRASS_BREAK;
		}
		return MSSounds.PLUSHIE_BREAK_EVENT;
	}

	@Override
	public void onStruckByLightning(ServerWorld world, LightningEntity lightning) {
	}

	@Override
	public boolean isAffectedBySplashPotions() {
		return false;
	}

	@Override
	public void onTrackedDataSet(TrackedData<?> data) {
		if (PLUSHIE_FLAGS.equals(data)) {
			this.calculateDimensions();
			this.intersectionChecked = !this.isMarker();
		}
		super.onTrackedDataSet(data);
	}

	@Override
	public boolean isMobOrPlayer() {
		return false;
	}

	private void setHideBasePlate(boolean hideBasePlate) {
		this.dataTracker.set(PLUSHIE_FLAGS, this.setBitField(this.dataTracker.get(PLUSHIE_FLAGS), HIDE_BASE_PLATE_FLAG, hideBasePlate));
	}

	public boolean shouldHideBasePlate() {
		return (this.dataTracker.get(PLUSHIE_FLAGS) & 8) != 0;
	}

	@Override
	public EntityDimensions getDimensions(EntityPose pose) {
		return this.getDimensions(this.isMarker());
	}

	private EntityDimensions getDimensions(boolean marker) {
		if (marker) {
			//return MARKER_DIMENSIONS;
		}
		return this.getType().getDimensions();
	}

	@Override
	public Vec3d getClientCameraPosVec(float tickDelta) {
		if (this.isMarker()) {
			Box box = this.getDimensions(false).getBoxAt(this.getPos());
			BlockPos blockPos = this.getBlockPos();
			int i = Integer.MIN_VALUE;
			for (BlockPos blockPos2 : BlockPos.iterate(new BlockPos(box.minX, box.minY, box.minZ), new BlockPos(box.maxX, box.maxY, box.maxZ))) {
				int j = Math.max(this.world.getLightLevel(LightType.BLOCK, blockPos2), this.world.getLightLevel(LightType.SKY, blockPos2));
				if (j == 15) {
					return Vec3d.ofCenter(blockPos2);
				}
				if (j <= i) continue;
				i = j;
				blockPos = blockPos2.toImmutable();
			}
			return Vec3d.ofCenter(blockPos);
		}
		return super.getClientCameraPosVec(tickDelta);
	}

	@Override
	public ItemStack getPickBlockStack() {
		return new ItemStack(MSItems.get(scarecrowType.id));
	}

	@Override
	public boolean isPartOfGame() {
		return !this.isInvisible() && !this.isMarker();
	}

	@Override
	public void writeCustomDataToNbt(NbtCompound nbt) {
		super.writeCustomDataToNbt(nbt);
		nbt.putBoolean("Invisible", this.isInvisible());
		nbt.putBoolean("NoBasePlate", this.shouldHideBasePlate());
		if (this.isMarker()) {
			nbt.putBoolean("Marker", this.isMarker());
		}
		nbt.put("Pose", this.poseToNbt());
	}

	@Override
	public void readCustomDataFromNbt(NbtCompound nbt) {
		int i;

		this.setInvisible(nbt.getBoolean("Invisible"));
		this.setHideBasePlate(nbt.getBoolean("NoBasePlate"));
		this.setMarker(nbt.getBoolean("Marker"));
		this.noClip = !this.canClip();
		NbtCompound nbtCompound = nbt.getCompound("Pose");
		this.readPoseNbt(nbtCompound);
	}

	private void readPoseNbt(NbtCompound nbt) {
		NbtList nbtList = nbt.getList("Head", 5);
		this.setHeadRotation(nbtList.isEmpty() ? DEFAULT_HEAD_ROTATION : new EulerAngle(nbtList));
		NbtList nbtList2 = nbt.getList("Body", 5);
		this.setBodyRotation(nbtList2.isEmpty() ? DEFAULT_BODY_ROTATION : new EulerAngle(nbtList2));
	}

	private NbtCompound poseToNbt() {
		NbtCompound nbtCompound = new NbtCompound();
		if (!DEFAULT_HEAD_ROTATION.equals(this.headRotation)) {
			nbtCompound.put("Head", this.headRotation.toNbt());
		}
		if (!DEFAULT_BODY_ROTATION.equals(this.bodyRotation)) {
			nbtCompound.put("Body", this.bodyRotation.toNbt());
		}
		return nbtCompound;
	}

	@Override
	public void tick() {
		EulerAngle eulerAngle2;
		super.tick();
		EulerAngle eulerAngle = this.dataTracker.get(TRACKER_HEAD_ROTATION);
		if (!this.headRotation.equals(eulerAngle)) {
			this.setHeadRotation(eulerAngle);
		}
		if (!this.bodyRotation.equals(eulerAngle2 = this.dataTracker.get(TRACKER_BODY_ROTATION))) {
			this.setBodyRotation(eulerAngle2);
		}

		if (this.cooldown > 0) {
			this.cooldown -= 1;
			return;
		}
		this.cooldown = MathHelper.ceilDiv(10, 2);

		scarecrowType.getScaredEntities().forEach(entity -> {
			List<? extends LivingEntity> targets =  this.world.getEntitiesByClass(entity,
					this.getBoundingBox().expand(distance, 3.0, distance),
					living -> true);
			targets.forEach(livingEntity -> {
				((ScarecrowAccess)livingEntity).addScarecrow(this, ((ScarecrowAccess)livingEntity).getScaryScarecrows());
			});
		});
		scarecrowType.getAttractedEntities().forEach(entity -> {
			List<? extends LivingEntity> targets =  this.world.getEntitiesByClass(entity,
					this.getBoundingBox().expand(distance, 3.0, distance),
					living -> true);
			targets.forEach(livingEntity -> {
				((ScarecrowAccess)livingEntity).addScarecrow(this, ((ScarecrowAccess)livingEntity).getAttractiveScarecrows());
			});
		});
	}
}
