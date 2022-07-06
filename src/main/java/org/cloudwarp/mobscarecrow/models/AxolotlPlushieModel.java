package org.cloudwarp.mobscarecrow.models;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.math.MatrixStack;
import org.cloudwarp.mobscarecrow.MobScarecrow;
import org.cloudwarp.mobscarecrow.entities.SmallPlushieEntity;

public class AxolotlPlushieModel extends EntityModel<SmallPlushieEntity> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final EntityModelLayer LAYER_LOCATION = new EntityModelLayer(MobScarecrow.id("axolotl_plushie"), "main");
	private final ModelPart AxolotlPlushie;

	public AxolotlPlushieModel (ModelPart root) {
		this.AxolotlPlushie = root.getChild("axolotl_plushie");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData ModelData = new ModelData();
		ModelPartData ModelPartData = ModelData.getRoot();

		ModelPartData group2 = ModelPartData.addChild("axolotl_plushie", ModelPartBuilder.create().uv(16, 10).cuboid(-8.0F, -3.0F, 10.0F, 0.0F, 3.0F, 5.0F, new Dilation(0.0F))
				.uv(14, 19).cuboid(-8.1F, -4.0F, 6.0F, 0.01F, 1.0F, 5.0F, new Dilation(0.0F))
				.uv(0, 15).cuboid(-10.0F, -3.0F, 6.0F, 4.0F, 3.0F, 5.0F, new Dilation(0.0F))
				.uv(-2, 27).cuboid(-14.0F, 0.0F, 4.0F, 4.0F, 0.01F, 3.0F, new Dilation(0.0F))
				.uv(-2, 27).cuboid(-14.0F, 0.0F, 8.0F, 4.0F, 0.01F, 3.0F, new Dilation(0.0F))
				.uv(-2, 27).mirrored().cuboid(-6.0F, 0.0F, 4.0F, 4.0F, 0.01F, 3.0F, new Dilation(0.0F)).mirrored(false)
				.uv(-2, 27).mirrored().cuboid(-6.0F, 0.0F, 8.0F, 4.0F, 0.01F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(8.0F, 24.0F, -8.0F));
		ModelPartData group = group2.addChild("group", ModelPartBuilder.create().uv(0, 6).cuboid(-6.25F, 3.5355F, -5.4645F, 6.0F, 4.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-5.0F, -7.5355F, 7.4645F));
		ModelPartData cube_r1 = group.addChild("cube_r1", ModelPartBuilder.create().uv(20, 19).cuboid(0.0F, -4.0F, -0.0431F, 3.0F, 4.0F, 0.01F, new Dilation(0.0F)), ModelTransform.of(-0.25F, 7.5355F, -1.4213F, 0.0F, 0.3927F, 0.0F));
		ModelPartData cube_r2 = group.addChild("cube_r2", ModelPartBuilder.create().uv(20, 0).cuboid(-3.0F, -4.0F, -0.0431F, 3.0F, 4.0F, 0.01F, new Dilation(0.0F)), ModelTransform.of(-6.25F, 7.5355F, -1.4213F, 0.0F, -0.3927F, 0.0F));
		ModelPartData cube_r3 = group.addChild("cube_r3", ModelPartBuilder.create().uv(17, 6).cuboid(-3.0F, -3.0F, -0.0431F, 6.0F, 3.0F, 0.01F, new Dilation(0.0F)), ModelTransform.of(-3.25F, 3.5355F, -1.4213F, 0.3927F, 0.0F, 0.0F));
		return TexturedModelData.of(ModelData, 32, 32);
	}

	@Override
	public void setAngles(SmallPlushieEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		this.AxolotlPlushie.pitch = (float)Math.PI / 180 * entity.getBodyRotation().getPitch();
		this.AxolotlPlushie.yaw = (float)Math.PI / 180 * entity.getBodyRotation().getYaw();
		this.AxolotlPlushie.roll = (float)Math.PI / 180 * entity.getBodyRotation().getRoll();
	}

	@Override
	public void render(MatrixStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		AxolotlPlushie.render(poseStack, buffer, packedLight, packedOverlay);
	}
}