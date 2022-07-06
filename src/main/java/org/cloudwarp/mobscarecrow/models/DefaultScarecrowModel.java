package org.cloudwarp.mobscarecrow.models;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.math.MatrixStack;
import org.cloudwarp.mobscarecrow.MobScarecrow;
import org.cloudwarp.mobscarecrow.entities.SmallPlushieEntity;

public class DefaultScarecrowModel extends EntityModel<SmallPlushieEntity> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final EntityModelLayer LAYER_LOCATION = new EntityModelLayer(MobScarecrow.id("default_scarecrow"), "main");
	private final ModelPart DefaultScarecrow;

	public DefaultScarecrowModel (ModelPart root) {
		this.DefaultScarecrow = root.getChild("default_scarecrow");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData ModelData = new ModelData();
		ModelPartData ModelPartData = ModelData.getRoot();


		ModelPartData Scarecrow = ModelPartData.addChild("default_scarecrow", ModelPartBuilder.create().uv(0, 0).cuboid(-16.0F, -24.0F, 0.0F, 16.0F, 16.0F, 16.0F, new Dilation(-2.0F))
				.uv(50, 44).cuboid(-10.0F, -3.0F, 6.0F, 4.0F, 11.0F, 4.0F, new Dilation(0.0F))
				.uv(0, 33).cuboid(-12.0F, -11.0F, 4.0F, 8.0F, 11.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(8.0F, 16.0F, -8.0F));

		ModelPartData cube_r1 = Scarecrow.addChild("cube_r1", ModelPartBuilder.create().uv(44, 33).cuboid(-4.0F, 2.0F, -3.0F, 5.25F, 2.0F, 6.0F, new Dilation(0.0F))
				.uv(49, 0).mirrored().cuboid(-3.0F, 0.0F, -2.0F, 4.0F, 11.0F, 4.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-4.0F, -10.4F, 8.0F, 0.0F, 0.0F, -0.7854F));

		ModelPartData cube_r2 = Scarecrow.addChild("cube_r2", ModelPartBuilder.create().uv(0, 53).cuboid(-1.25F, 2.0F, -3.0F, 5.25F, 2.0F, 6.0F, new Dilation(0.0F))
				.uv(49, 0).cuboid(-1.0F, 0.0F, -2.0F, 4.0F, 11.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-12.0F, -10.4F, 8.0F, 0.0F, 0.0F, 0.7854F));

		ModelPartData cube_r3 = Scarecrow.addChild("cube_r3", ModelPartBuilder.create().uv(33, 33).cuboid(0.0F, 0.0F, -5.0F, 0.01F, 4.0F, 10.0F, new Dilation(0.0F)), ModelTransform.of(-4.0F, 0.0F, 8.0F, 0.0F, 0.0F, -0.3927F));

		ModelPartData cube_r4 = Scarecrow.addChild("cube_r4", ModelPartBuilder.create().uv(33, 33).cuboid(0.0F, 0.0F, -5.0F, 0.01F, 4.0F, 10.0F, new Dilation(0.0F)), ModelTransform.of(-12.0F, 0.0F, 8.0F, 0.0F, 0.0F, 0.3927F));

		ModelPartData cube_r5 = Scarecrow.addChild("cube_r5", ModelPartBuilder.create().uv(50, 60).cuboid(-5.0F, 0.0F, 0.0F, 10.0F, 4.0F, 0.01F, new Dilation(0.0F)), ModelTransform.of(-8.0F, 0.0F, 12.0F, 0.3927F, 0.0F, 0.0F));

		ModelPartData cube_r6 = Scarecrow.addChild("cube_r6", ModelPartBuilder.create().uv(50, 60).cuboid(-5.0F, 0.0F, 0.0F, 10.0F, 4.0F, 0.01F, new Dilation(0.0F)), ModelTransform.of(-8.0F, 0.0F, 4.0F, -0.3927F, 0.0F, 0.0F));

		return TexturedModelData.of(ModelData, 128, 128);
	}

	@Override
	public void setAngles(SmallPlushieEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		this.DefaultScarecrow.pitch = (float)Math.PI / 180 * entity.getBodyRotation().getPitch();
		this.DefaultScarecrow.yaw = (float)Math.PI / 180 * entity.getBodyRotation().getYaw();
		this.DefaultScarecrow.roll = (float)Math.PI / 180 * entity.getBodyRotation().getRoll();
	}

	@Override
	public void render(MatrixStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		DefaultScarecrow.render(poseStack, buffer, packedLight, packedOverlay);
	}
}