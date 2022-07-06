package org.cloudwarp.mobscarecrow.models;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.math.MatrixStack;
import org.cloudwarp.mobscarecrow.MobScarecrow;
import org.cloudwarp.mobscarecrow.entities.SmallPlushieEntity;

public class CopperGolemPlushieModel extends EntityModel<SmallPlushieEntity> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final EntityModelLayer LAYER_LOCATION = new EntityModelLayer(MobScarecrow.id("copper_golem_plushie"), "main");
	private final ModelPart CopperGolemPlushie;

	public CopperGolemPlushieModel (ModelPart root) {
		this.CopperGolemPlushie = root.getChild("copper_golem_plushie");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData ModelData = new ModelData();
		ModelPartData ModelPartData = ModelData.getRoot();

		ModelPartData CopperGolem = ModelPartData.addChild("copper_golem_plushie", ModelPartBuilder.create().uv(0, 32).cuboid(-1.0F, -5.0F, 0.5F, 2.0F, 2.0F, 2.0F, new Dilation(0.1F))
				.uv(21, 25).cuboid(-3.0F, 4.0F, 0.0F, 6.0F, 4.0F, 3.0F, new Dilation(-0.1F))
				.uv(29, 7).cuboid(-1.0F, -1.0F, -2.75F, 2.0F, 3.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 0).cuboid(-4.0F, -3.0F, -1.5F, 8.0F, 4.0F, 6.0F, new Dilation(0.1F))
				.uv(29, 0).cuboid(-1.5F, -7.0F, 0.0F, 3.0F, 3.0F, 3.0F, new Dilation(0.1F)), ModelTransform.pivot(0.0F, 16.0F, 0.0F));
		ModelPartData cube_r1 = CopperGolem.addChild("cube_r1", ModelPartBuilder.create().uv(22, 16).mirrored().cuboid(-3.0F, -3.0F, -5.0F, 3.0F, 3.0F, 5.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(3.0F, 8.0F, 3.0F, 0.0F, -0.3927F, 0.0F));
		ModelPartData cube_r2 = CopperGolem.addChild("cube_r2", ModelPartBuilder.create().uv(22, 16).cuboid(0.0F, -3.0F, -5.0F, 3.0F, 3.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(-3.0F, 8.0F, 3.0F, 0.0F, 0.3927F, 0.0F));
		ModelPartData cube_r3 = CopperGolem.addChild("cube_r3", ModelPartBuilder.create().uv(0, 21).mirrored().cuboid(2.25F, -1.0F, -6.0F, 3.0F, 3.0F, 7.0F, new Dilation(0.0F)).mirrored(false)
				.uv(0, 21).cuboid(-5.25F, -1.0F, -6.0F, 3.0F, 3.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 2.0F, 0.0F, 0.3927F, 0.0F, 0.0F));
		ModelPartData cube_r4 = CopperGolem.addChild("cube_r4", ModelPartBuilder.create().uv(0, 11).cuboid(-4.0F, -1.0F, -1.5F, 8.0F, 4.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 2.0F, 1.0F, -0.3927F, 0.0F, 0.0F));
		return TexturedModelData.of(ModelData, 64, 64);
	}

	@Override
	public void setAngles(SmallPlushieEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		this.CopperGolemPlushie.pitch = (float)Math.PI / 180 * entity.getBodyRotation().getPitch();
		this.CopperGolemPlushie.yaw = (float)Math.PI / 180 * entity.getBodyRotation().getYaw();
		this.CopperGolemPlushie.roll = (float)Math.PI / 180 * entity.getBodyRotation().getRoll();
	}

	@Override
	public void render(MatrixStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		CopperGolemPlushie.render(poseStack, buffer, packedLight, packedOverlay);
	}
}