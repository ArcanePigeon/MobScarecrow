package org.cloudwarp.mobscarecrow.models;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.math.MatrixStack;
import org.cloudwarp.mobscarecrow.MobScarecrow;
import org.cloudwarp.mobscarecrow.entities.SmallPlushieEntity;

public class GoldPigPlushieModel extends EntityModel<SmallPlushieEntity> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final EntityModelLayer LAYER_LOCATION = new EntityModelLayer(MobScarecrow.id("gold_pig_plushie"), "main");
	private final ModelPart GoldPigPlushie;

	public GoldPigPlushieModel (ModelPart root) {
		this.GoldPigPlushie = root.getChild("gold_pig_plushie");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData ModelData = new ModelData();
		ModelPartData ModelPartData = ModelData.getRoot();

		ModelPartData pig = ModelPartData.addChild("gold_pig_plushie", ModelPartBuilder.create().uv(22, 0).cuboid(-3.0F, 6.0F, 2.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 12).cuboid(-3.0F, 2.0F, -2.0F, 6.0F, 4.0F, 6.0F, new Dilation(0.0F))
				.uv(22, 0).cuboid(-3.0F, 6.0F, -2.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(22, 0).cuboid(1.0F, 6.0F, -2.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(22, 0).cuboid(1.0F, 6.0F, 2.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 16.0F, 0.0F));
		ModelPartData cube_r1 = pig.addChild("cube_r1", ModelPartBuilder.create().uv(19, 12).cuboid(-2.0F, -2.0F, -3.0F, 4.0F, 3.0F, 1.0F, new Dilation(0.0F))
				.uv(0, 0).cuboid(-4.0F, -4.0F, -2.0F, 8.0F, 6.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 2.0F, -2.0F, -0.3927F, 0.0F, 0.0F));
		return TexturedModelData.of(ModelData, 32, 32);
	}

	@Override
	public void setAngles(SmallPlushieEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		this.GoldPigPlushie.pitch = (float)Math.PI / 180 * entity.getBodyRotation().getPitch();
		this.GoldPigPlushie.yaw = (float)Math.PI / 180 * entity.getBodyRotation().getYaw();
		this.GoldPigPlushie.roll = (float)Math.PI / 180 * entity.getBodyRotation().getRoll();
	}

	@Override
	public void render(MatrixStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		GoldPigPlushie.render(poseStack, buffer, packedLight, packedOverlay);
	}
}