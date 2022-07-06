package org.cloudwarp.mobscarecrow.models;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.math.MatrixStack;
import org.cloudwarp.mobscarecrow.MobScarecrow;
import org.cloudwarp.mobscarecrow.entities.SmallPlushieEntity;

public class SnowGolemPlushieModel extends EntityModel<SmallPlushieEntity> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final EntityModelLayer LAYER_LOCATION = new EntityModelLayer(MobScarecrow.id("snow_golem_plushie"), "main");
	private final ModelPart SnowGolemPlushie;

	public SnowGolemPlushieModel (ModelPart root) {
		this.SnowGolemPlushie = root.getChild("snow_golem_plushie");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData ModelData = new ModelData();
		ModelPartData ModelPartData = ModelData.getRoot();

		ModelPartData SnowGolem = ModelPartData.addChild("snow_golem_plushie", ModelPartBuilder.create().uv(0, 0).cuboid(-3.5F, -5.0F, -3.5F, 7.0F, 7.0F, 7.0F, new Dilation(0.0F))
				.uv(0, 15).cuboid(-3.5F, 4.0F, -3.5F, 7.0F, 4.0F, 7.0F, new Dilation(0.0F))
				.uv(24, 10).cuboid(-2.5F, 2.0F, -2.5F, 5.0F, 2.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 16.0F, 0.0F));
		ModelPartData cube_r1 = SnowGolem.addChild("cube_r1", ModelPartBuilder.create().uv(22, 0).mirrored().cuboid(0.0F, 0.0F, -1.5F, 4.0F, 2.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(2.5F, 2.0F, 0.0F, 0.0F, 0.0F, 0.3927F));
		ModelPartData cube_r2 = SnowGolem.addChild("cube_r2", ModelPartBuilder.create().uv(22, 0).cuboid(-4.0F, 0.0F, -1.5F, 4.0F, 2.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-2.5F, 2.0F, 0.0F, 0.0F, 0.0F, -0.3927F));
		return TexturedModelData.of(ModelData, 64, 64);
	}

	@Override
	public void setAngles(SmallPlushieEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		this.SnowGolemPlushie.pitch = (float)Math.PI / 180 * entity.getBodyRotation().getPitch();
		this.SnowGolemPlushie.yaw = (float)Math.PI / 180 * entity.getBodyRotation().getYaw();
		this.SnowGolemPlushie.roll = (float)Math.PI / 180 * entity.getBodyRotation().getRoll();
	}

	@Override
	public void render(MatrixStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		SnowGolemPlushie.render(poseStack, buffer, packedLight, packedOverlay);
	}
}