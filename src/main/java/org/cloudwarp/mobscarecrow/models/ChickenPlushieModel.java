package org.cloudwarp.mobscarecrow.models;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.math.MatrixStack;
import org.cloudwarp.mobscarecrow.MobScarecrow;
import org.cloudwarp.mobscarecrow.entities.SmallPlushieEntity;

public class ChickenPlushieModel extends EntityModel<SmallPlushieEntity> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final EntityModelLayer LAYER_LOCATION = new EntityModelLayer(MobScarecrow.id("chicken_plushie"), "main");
	private final ModelPart ChickenPlushie;

	public ChickenPlushieModel (ModelPart root) {
		this.ChickenPlushie = root.getChild("chicken_plushie");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData ModelData = new ModelData();
		ModelPartData ModelPartData = ModelData.getRoot();

		ModelPartData Chicken = ModelPartData.addChild("chicken_plushie", ModelPartBuilder.create().uv(0, 0).cuboid(-3.0F, 3.0F, -3.0F, 6.0F, 5.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 16.0F, 0.0F));
		ModelPartData cube_r1 = Chicken.addChild("cube_r1", ModelPartBuilder.create().uv(0, 23).cuboid(-1.0F, 0.0F, -5.0F, 2.0F, 3.0F, 5.0F, new Dilation(0.0F))
				.uv(0, 14).cuboid(-2.0F, -2.0F, -6.0F, 4.0F, 2.0F, 6.0F, new Dilation(0.0F))
				.uv(21, 0).cuboid(-2.0F, -4.0F, -4.0F, 4.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 3.0F, 0.0F, -0.3927F, 0.0F, 0.0F));
		ModelPartData cube_r2 = Chicken.addChild("cube_r2", ModelPartBuilder.create().uv(14, 16).cuboid(-3.0F, 0.0F, -11.0F, 3.0F, 0.01F, 7.0F, new Dilation(0.0F))
				.uv(0, 0).cuboid(-3.0F, -3.0F, -11.0F, 3.0F, 3.0F, 0.01F, new Dilation(0.0F)), ModelTransform.of(0.0F, 7.9F, 5.0F, 0.0F, 0.3927F, 0.0F));
		ModelPartData cube_r3 = Chicken.addChild("cube_r3", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -3.0F, -11.0F, 3.0F, 3.0F, 0.01F, new Dilation(0.0F))
				.uv(14, 16).cuboid(0.0F, 0.0F, -11.0F, 3.0F, 0.01F, 7.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 7.9F, 5.0F, 0.0F, -0.3927F, 0.0F));
		return TexturedModelData.of(ModelData, 48, 48);
	}

	@Override
	public void setAngles(SmallPlushieEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		this.ChickenPlushie.pitch = (float)Math.PI / 180 * entity.getBodyRotation().getPitch();
		this.ChickenPlushie.yaw = (float)Math.PI / 180 * entity.getBodyRotation().getYaw();
		this.ChickenPlushie.roll = (float)Math.PI / 180 * entity.getBodyRotation().getRoll();
	}

	@Override
	public void render(MatrixStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		ChickenPlushie.render(poseStack, buffer, packedLight, packedOverlay);
	}
}