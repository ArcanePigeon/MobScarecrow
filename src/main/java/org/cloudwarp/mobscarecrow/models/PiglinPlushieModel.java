package org.cloudwarp.mobscarecrow.models;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.math.MatrixStack;
import org.cloudwarp.mobscarecrow.MobScarecrow;
import org.cloudwarp.mobscarecrow.entities.SmallPlushieEntity;

public class PiglinPlushieModel extends EntityModel<SmallPlushieEntity> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final EntityModelLayer LAYER_LOCATION = new EntityModelLayer(MobScarecrow.id("piglin_plushie"), "main");
	private final ModelPart PiglinPlushie;

	public PiglinPlushieModel (ModelPart root) {
		this.PiglinPlushie = root.getChild("piglin_plushie");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData ModelData = new ModelData();
		ModelPartData ModelPartData = ModelData.getRoot();

		ModelPartData Piglin = ModelPartData.addChild("piglin_plushie", ModelPartBuilder.create().uv(21, 13).cuboid(-3.0F, 2.0F, 0.0F, 6.0F, 6.0F, 3.0F, new Dilation(-0.1F)), ModelTransform.pivot(0.0F, 16.0F, 0.0F));
		ModelPartData cube_r1 = Piglin.addChild("cube_r1", ModelPartBuilder.create().uv(0, 13).cuboid(0.0F, -3.0F, -7.0F, 3.0F, 3.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(-3.0F, 8.0F, 3.0F, 0.0F, 0.3927F, 0.0F));
		ModelPartData cube_r2 = Piglin.addChild("cube_r2", ModelPartBuilder.create().uv(16, 23).mirrored().cuboid(0.25F, 0.0F, -5.0F, 3.0F, 3.0F, 5.0F, new Dilation(0.0F)).mirrored(false)
				.uv(16, 23).cuboid(-3.25F, 0.0F, -5.0F, 3.0F, 3.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 2.0F, 0.0F, 0.3927F, 0.0F, 0.0F));
		ModelPartData cube_r3 = Piglin.addChild("cube_r3", ModelPartBuilder.create().uv(29, 6).cuboid(-3.0F, -2.0F, -3.5F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
				.uv(29, 6).cuboid(2.0F, -2.0F, -3.5F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
				.uv(23, 0).cuboid(-2.0F, -3.0F, -3.5F, 4.0F, 3.0F, 1.0F, new Dilation(0.1F))
				.uv(0, 24).mirrored().cuboid(-5.0F, -4.0F, -1.5F, 1.0F, 5.0F, 4.0F, new Dilation(0.0F)).mirrored(false)
				.uv(0, 24).cuboid(4.0F, -4.0F, -1.5F, 1.0F, 5.0F, 4.0F, new Dilation(0.0F))
				.uv(0, 0).cuboid(-4.0F, -6.0F, -2.5F, 8.0F, 6.0F, 6.0F, new Dilation(0.1F)), ModelTransform.of(0.0F, 2.0F, 1.0F, -0.3927F, 0.0F, 0.0F));
		ModelPartData cube_r4 = Piglin.addChild("cube_r4", ModelPartBuilder.create().uv(0, 13).mirrored().cuboid(-3.0F, -3.0F, -7.0F, 3.0F, 3.0F, 7.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(3.0F, 8.0F, 3.0F, 0.0F, -0.3927F, 0.0F));
		return TexturedModelData.of(ModelData, 48, 48);
	}

	@Override
	public void setAngles(SmallPlushieEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		this.PiglinPlushie.pitch = (float)Math.PI / 180 * entity.getBodyRotation().getPitch();
		this.PiglinPlushie.yaw = (float)Math.PI / 180 * entity.getBodyRotation().getYaw();
		this.PiglinPlushie.roll = (float)Math.PI / 180 * entity.getBodyRotation().getRoll();
	}

	@Override
	public void render(MatrixStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		PiglinPlushie.render(poseStack, buffer, packedLight, packedOverlay);
	}
}