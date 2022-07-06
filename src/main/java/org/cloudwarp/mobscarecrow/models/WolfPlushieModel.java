package org.cloudwarp.mobscarecrow.models;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.math.MatrixStack;
import org.cloudwarp.mobscarecrow.MobScarecrow;
import org.cloudwarp.mobscarecrow.entities.SmallPlushieEntity;

public class WolfPlushieModel extends EntityModel<SmallPlushieEntity> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final EntityModelLayer LAYER_LOCATION = new EntityModelLayer(MobScarecrow.id("wolf_plushie"), "main");
	private final ModelPart Plushie;

	public WolfPlushieModel (ModelPart root) {
		this.Plushie = root.getChild("wolf_plushie");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData ModelData = new ModelData();
		ModelPartData ModelPartData = ModelData.getRoot();
		
		ModelPartData Plushie = ModelPartData.addChild("wolf_plushie", ModelPartBuilder.create().uv(17, 13).cuboid(-1.5F, -0.9703F, -6.1767F, 3.0F, 3.0F, 3.0F, new Dilation(0.0F))
				.uv(0, 0).cuboid(-3.0F, -3.4703F, -3.1767F, 6.0F, 5.0F, 4.0F, new Dilation(0.0F))
				.uv(17, 0).cuboid(-3.0F, -4.4703F, -0.1767F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F))
				.uv(17, 0).mirrored().cuboid(1.0F, -4.4703F, -0.1767F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(0.0F, 16.0F, 0.0F));

		Plushie.addChild("cube_r1", ModelPartBuilder.create().uv(17, 20).cuboid(1.5F, -6.0F, 0.0F, 2.0F, 6.0F, 2.0F, new Dilation(0.0F))
				.uv(17, 20).mirrored().cuboid(-1.5F, -6.0F, 0.0F, 2.0F, 6.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-1.0F, 8.0F, -4.0F, -0.3927F, 0.0F, 0.0F));

		Plushie.addChild("cube_r2", ModelPartBuilder.create().uv(15, 4).cuboid(-1.0824F, -2.0F, -5.3869F, 2.0F, 2.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(2.0F, 8.0F, 3.0F, 0.0F, -0.7854F, 0.0F));

		Plushie.addChild("cube_r3", ModelPartBuilder.create().uv(15, 4).mirrored().cuboid(-0.9176F, -2.0F, -5.3869F, 2.0F, 2.0F, 6.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-2.0F, 8.0F, 3.0F, 0.0F, 0.7854F, 0.0F));

		Plushie.addChild("cube_r4", ModelPartBuilder.create().uv(0, 10).cuboid(-2.0F, -8.5F, -4.0F, 4.0F, 8.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 8.0F, 5.0F, 0.3927F, 0.0F, 0.0F));
		
		return TexturedModelData.of(ModelData, 32, 32);
	}

	@Override
	public void setAngles(SmallPlushieEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		this.Plushie.pitch = (float)Math.PI / 180 * entity.getBodyRotation().getPitch();
		this.Plushie.yaw = (float)Math.PI / 180 * entity.getBodyRotation().getYaw();
		this.Plushie.roll = (float)Math.PI / 180 * entity.getBodyRotation().getRoll();
	}

	@Override
	public void render(MatrixStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Plushie.render(poseStack, buffer, packedLight, packedOverlay);
	}
}