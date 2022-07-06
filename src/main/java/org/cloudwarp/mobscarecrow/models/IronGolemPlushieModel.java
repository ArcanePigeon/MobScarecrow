package org.cloudwarp.mobscarecrow.models;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.math.MatrixStack;
import org.cloudwarp.mobscarecrow.MobScarecrow;
import org.cloudwarp.mobscarecrow.entities.SmallPlushieEntity;

public class IronGolemPlushieModel extends EntityModel<SmallPlushieEntity> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final EntityModelLayer LAYER_LOCATION = new EntityModelLayer(MobScarecrow.id("iron_golem_plushie"), "main");
	private final ModelPart IronGolemPlushie;

	public IronGolemPlushieModel (ModelPart root) {
		this.IronGolemPlushie = root.getChild("iron_golem_plushie");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData ModelData = new ModelData();
		ModelPartData ModelPartData = ModelData.getRoot();

		ModelPartData IronGolem = ModelPartData.addChild("iron_golem_plushie", ModelPartBuilder.create().uv(18, 24).cuboid(-1.0F, -3.0F, -3.0F, 2.0F, 3.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 24).cuboid(-3.0F, 2.0F, 0.0F, 6.0F, 6.0F, 3.0F, new Dilation(-0.1F))
				.uv(28, 0).cuboid(-3.0F, -8.0F, -2.0F, 6.0F, 7.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 16.0F, 0.0F));

		ModelPartData cube_r1 = IronGolem.addChild("cube_r1", ModelPartBuilder.create().uv(22, 13).cuboid(-3.0F, -3.0F, -7.0F, 3.0F, 3.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(3.0F, 8.0F, 3.0F, 0.0F, -0.3927F, 0.0F));

		ModelPartData cube_r2 = IronGolem.addChild("cube_r2", ModelPartBuilder.create().uv(22, 13).mirrored().cuboid(0.0F, -3.0F, -7.0F, 3.0F, 3.0F, 7.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-3.0F, 8.0F, 3.0F, 0.0F, 0.3927F, 0.0F));

		ModelPartData cube_r3 = IronGolem.addChild("cube_r3", ModelPartBuilder.create().uv(1, 14).mirrored().cuboid(2.25F, -1.0F, -4.0F, 3.0F, 3.0F, 7.0F, new Dilation(0.0F)).mirrored(false)
				.uv(1, 14).cuboid(-5.25F, -1.0F, -4.0F, 3.0F, 3.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 2.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		ModelPartData cube_r4 = IronGolem.addChild("cube_r4", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -3.0F, -2.5F, 8.0F, 6.0F, 6.0F, new Dilation(0.1F)), ModelTransform.of(0.0F, 2.0F, 1.0F, -0.3927F, 0.0F, 0.0F));

		return TexturedModelData.of(ModelData, 64, 64);
	}

	@Override
	public void setAngles(SmallPlushieEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		this.IronGolemPlushie.pitch = (float)Math.PI / 180 * entity.getBodyRotation().getPitch();
		this.IronGolemPlushie.yaw = (float)Math.PI / 180 * entity.getBodyRotation().getYaw();
		this.IronGolemPlushie.roll = (float)Math.PI / 180 * entity.getBodyRotation().getRoll();
	}

	@Override
	public void render(MatrixStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		IronGolemPlushie.render(poseStack, buffer, packedLight, packedOverlay);
	}
}