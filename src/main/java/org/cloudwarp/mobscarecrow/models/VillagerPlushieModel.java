package org.cloudwarp.mobscarecrow.models;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.math.MatrixStack;
import org.cloudwarp.mobscarecrow.MobScarecrow;
import org.cloudwarp.mobscarecrow.entities.SmallPlushieEntity;

public class VillagerPlushieModel extends EntityModel<SmallPlushieEntity> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final EntityModelLayer LAYER_LOCATION = new EntityModelLayer(MobScarecrow.id("villager_plushie"), "main");
	private final ModelPart Plushie;

	public VillagerPlushieModel (ModelPart root) {
		this.Plushie = root.getChild("villager_plushie");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData ModelData = new ModelData();
		ModelPartData ModelPartData = ModelData.getRoot();

		ModelPartData Plushie = ModelPartData.addChild("villager_plushie", ModelPartBuilder.create().uv(21, 18).cuboid(-3.0F, 2.0F, 0.0F, 6.0F, 6.0F, 3.0F, new Dilation(-0.1F)), ModelTransform.pivot(0.0F, 16.0F, 0.0F));

		Plushie.addChild("cube_r1", ModelPartBuilder.create().uv(0, 14).cuboid(0.0F, -3.0F, -7.0F, 3.0F, 3.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(-3.0F, 8.0F, 3.0F, 0.0F, 0.3927F, 0.0F));

		Plushie.addChild("cube_r2", ModelPartBuilder.create().uv(21, 10).cuboid(-3.25F, 0.0F, -4.0F, 6.0F, 3.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 2.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		Plushie.addChild("cube_r3", ModelPartBuilder.create().uv(19, 0).cuboid(-1.0F, -2.5F, -3.75F, 2.0F, 3.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 0).cuboid(-3.0F, -7.0F, -2.5F, 6.0F, 7.0F, 6.0F, new Dilation(0.1F)), ModelTransform.of(0.0F, 2.0F, 1.0F, -0.3927F, 0.0F, 0.0F));

		Plushie.addChild("cube_r4", ModelPartBuilder.create().uv(0, 14).mirrored().cuboid(-3.0F, -3.0F, -7.0F, 3.0F, 3.0F, 7.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(3.0F, 8.0F, 3.0F, 0.0F, -0.3927F, 0.0F));

		return TexturedModelData.of(ModelData, 48, 48);
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