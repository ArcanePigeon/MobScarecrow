package org.cloudwarp.mobscarecrow.entities.renderers;

import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3f;
import org.cloudwarp.mobscarecrow.MobScarecrow;
import org.cloudwarp.mobscarecrow.entities.SmallPlushieEntity;
import org.cloudwarp.mobscarecrow.models.PiglinPlushieModel;
import org.jetbrains.annotations.Nullable;

public class PiglinPlushieEntityRenderer extends LivingEntityRenderer<SmallPlushieEntity, PiglinPlushieModel> {
	public static final Identifier TEXTURE = MobScarecrow.id("textures/entity/piglin_plushie.png");

	public PiglinPlushieEntityRenderer (EntityRendererFactory.Context context) {
		super(context, new PiglinPlushieModel(context.getPart(PiglinPlushieModel.LAYER_LOCATION)), 0.3f);
	}

	@Override
	public Identifier getTexture(SmallPlushieEntity smallPlushieEntity) {
		return TEXTURE;
	}

	@Override
	protected void setupTransforms(SmallPlushieEntity smallPlushieEntity, MatrixStack matrixStack, float f, float g, float h) {
		matrixStack.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(180.0f - g));
		float i = (float)(smallPlushieEntity.world.getTime() - smallPlushieEntity.lastHitTime) + h;
		if (i < 5.0f) {
			matrixStack.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(MathHelper.sin(i / 1.5f * (float)Math.PI) * 3.0f));
		}
	}

	@Override
	protected boolean hasLabel(SmallPlushieEntity smallPlushieEntity) {
		float f;
		double d = this.dispatcher.getSquaredDistanceToCamera(smallPlushieEntity);
		float f2 = f = smallPlushieEntity.isInSneakingPose() ? 32.0f : 64.0f;
		if (d >= (double)(f * f)) {
			return false;
		}
		return smallPlushieEntity.isCustomNameVisible();
	}

	@Override
	@Nullable
	protected RenderLayer getRenderLayer(SmallPlushieEntity smallPlushieEntity, boolean bl, boolean bl2, boolean bl3) {
		if (! smallPlushieEntity.isMarker()) {
			return super.getRenderLayer(smallPlushieEntity, bl, bl2, bl3);
		}
		Identifier identifier = this.getTexture(smallPlushieEntity);
		if (bl2) {
			return RenderLayer.getEntityTranslucent(identifier, false);
		}
		if (bl) {
			return RenderLayer.getEntityCutoutNoCull(identifier, false);
		}
		return null;
	}
}