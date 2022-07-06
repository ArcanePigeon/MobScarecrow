package org.cloudwarp.mobscarecrow.models;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.math.MatrixStack;
import org.cloudwarp.mobscarecrow.MobScarecrow;
import org.cloudwarp.mobscarecrow.entities.SmallPlushieEntity;

public class CatPlushieModel extends EntityModel<SmallPlushieEntity> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final EntityModelLayer LAYER_LOCATION = new EntityModelLayer(MobScarecrow.id("cat_plushie"), "main");
	private final ModelPart CatPlushie;

	public CatPlushieModel(ModelPart root) {
		this.CatPlushie = root.getChild("cat_plushie");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData ModelData = new ModelData();
		ModelPartData ModelPartData = ModelData.getRoot();

		ModelPartData CatPlushie = ModelPartData.addChild("cat_plushie", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 16.0F, 0.0F));
		CatPlushie.addChild("cube_r1", ModelPartBuilder.create().uv(0, 22).mirrored().cuboid(1.5F, -5.0F, 0.0F, 2.0F, 5.0F, 2.0F, new Dilation(0.0F)).mirrored(false)
				.uv(0, 22).cuboid(-1.5F, -5.0F, 0.0F, 2.0F, 5.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-1.0F, 8.0F, -3.0F, -0.3927F, 0.0F, 0.0F));
		CatPlushie.addChild("cube_r2", ModelPartBuilder.create().uv(15, 4).mirrored().cuboid(0.0F, -2.0F, -8.0F, 2.0F, 2.0F, 6.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, 8.0F, 5.0F, 0.0F, -0.3927F, 0.0F));
		CatPlushie.addChild("cube_r3", ModelPartBuilder.create().uv(15, 4).cuboid(-2.0F, -2.0F, -8.0F, 2.0F, 2.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 8.0F, 5.0F, 0.0F, 0.3927F, 0.0F));
		CatPlushie.addChild("cube_r4", ModelPartBuilder.create().uv(0, 10).cuboid(-2.0F, -7.5F, -4.0F, 4.0F, 7.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 8.0F, 5.0F, 0.3927F, 0.0F, 0.0F));
		ModelPartData group = CatPlushie.addChild("group", ModelPartBuilder.create(), ModelTransform.pivot(8.0F, 8.0F, -8.0F));
		group.addChild("cube_r5", ModelPartBuilder.create().uv(9, 25).cuboid(-2.0F, -2.0F, -6.0F, 3.0F, 2.0F, 1.0F, new Dilation(0.0F))
				.uv(0, 0).cuboid(-3.0F, -4.0F, -5.0F, 5.0F, 4.0F, 5.0F, new Dilation(0.0F))
				.uv(25, 25).cuboid(-2.5F, -5.0F, -2.1F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F))
				.uv(26, 1).cuboid(0.5F, -5.0F, -2.1F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-7.5F, -5.6225F, 9.5887F, 0.3927F, 0.0F, 0.0F));

		return TexturedModelData.of(ModelData, 32, 32);
	}

	@Override
	public void setAngles(SmallPlushieEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		this.CatPlushie.pitch = (float)Math.PI / 180 * entity.getBodyRotation().getPitch();
		this.CatPlushie.yaw = (float)Math.PI / 180 * entity.getBodyRotation().getYaw();
		this.CatPlushie.roll = (float)Math.PI / 180 * entity.getBodyRotation().getRoll();
	}

	@Override
	public void render(MatrixStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		CatPlushie.render(poseStack, buffer, packedLight, packedOverlay);
	}
}