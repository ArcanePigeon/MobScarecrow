package org.cloudwarp.mobscarecrow.models;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.math.MatrixStack;
import org.cloudwarp.mobscarecrow.MobScarecrow;
import org.cloudwarp.mobscarecrow.entities.SmallPlushieEntity;

public class RabbitPlushieModel extends EntityModel<SmallPlushieEntity> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final EntityModelLayer LAYER_LOCATION = new EntityModelLayer(MobScarecrow.id("rabbit_plushie"), "main");
	private final ModelPart RabbitPlushie;

	public RabbitPlushieModel (ModelPart root) {
		this.RabbitPlushie = root.getChild("rabbit_plushie");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData ModelData = new ModelData();
		ModelPartData ModelPartData = ModelData.getRoot();

		ModelPartData Rabbit = ModelPartData.addChild("rabbit_plushie", ModelPartBuilder.create().uv(15, 0).cuboid(-3.25F, 7.0F, -0.25F, 2.0F, 1.0F, 4.0F, new Dilation(0.0F))
				.uv(15, 0).cuboid(1.25F, 7.0F, -0.25F, 2.0F, 1.0F, 4.0F, new Dilation(0.0F))
				.uv(0, 10).cuboid(-2.5F, -0.25F, -4.0F, 5.0F, 3.0F, 5.0F, new Dilation(0.0F))
				.uv(0, 0).cuboid(-0.5F, 1.5F, -4.5F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 16.0F, -1.0F));
		ModelPartData cube_r1 = Rabbit.addChild("cube_r1", ModelPartBuilder.create().uv(7, 19).mirrored().cuboid(0.0F, -3.0F, 0.0F, 2.0F, 3.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.1F, 0.0F, -1.0F, 0.0F, 0.3927F, 0.0F));
		ModelPartData cube_r2 = Rabbit.addChild("cube_r2", ModelPartBuilder.create().uv(0, 19).cuboid(0.75F, -2.0F, 0.0F, 1.0F, 5.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 19).cuboid(-2.25F, -2.0F, 0.0F, 1.0F, 5.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 5.0F, -2.25F, -0.3927F, 0.0F, 0.0F));
		ModelPartData cube_r3 = Rabbit.addChild("cube_r3", ModelPartBuilder.create().uv(18, 7).cuboid(1.25F, -3.0F, -2.95F, 2.0F, 3.0F, 3.0F, new Dilation(0.4F))
				.uv(18, 7).cuboid(-3.25F, -3.0F, -2.95F, 2.0F, 3.0F, 3.0F, new Dilation(0.4F)), ModelTransform.of(0.0F, 7.0F, 3.7F, -0.3927F, 0.0F, 0.0F));
		ModelPartData cube_r4 = Rabbit.addChild("cube_r4", ModelPartBuilder.create().uv(0, 0).cuboid(-2.0F, -3.75F, -6.0F, 4.0F, 3.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 8.0F, 2.0F, -0.7854F, 0.0F, 0.0F));
		ModelPartData cube_r5 = Rabbit.addChild("cube_r5", ModelPartBuilder.create().uv(7, 19).cuboid(-2.0F, -3.0F, 0.0F, 2.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.2F, 0.0F, -1.0F, 0.0F, -0.3927F, 0.0F));
		return TexturedModelData.of(ModelData, 32, 32);
	}

	@Override
	public void setAngles(SmallPlushieEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		this.RabbitPlushie.pitch = (float)Math.PI / 180 * entity.getBodyRotation().getPitch();
		this.RabbitPlushie.yaw = (float)Math.PI / 180 * entity.getBodyRotation().getYaw();
		this.RabbitPlushie.roll = (float)Math.PI / 180 * entity.getBodyRotation().getRoll();
	}

	@Override
	public void render(MatrixStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		RabbitPlushie.render(poseStack, buffer, packedLight, packedOverlay);
	}
}