package org.cloudwarp.mobscarecrow.models;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.math.MatrixStack;
import org.cloudwarp.mobscarecrow.MobScarecrow;
import org.cloudwarp.mobscarecrow.entities.SmallPlushieEntity;

public class PigeonPlushieModel extends EntityModel<SmallPlushieEntity> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final EntityModelLayer LAYER_LOCATION = new EntityModelLayer(MobScarecrow.id("pigeon_plushie"), "main");
	private final ModelPart PigeonPlushie;

	public PigeonPlushieModel (ModelPart root) {
		this.PigeonPlushie = root.getChild("pigeon_plushie");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData ModelData = new ModelData();
		ModelPartData ModelPartData = ModelData.getRoot();

		ModelPartData Pigeon = ModelPartData.addChild("pigeon_plushie", ModelPartBuilder.create().uv(0, 0).cuboid(-3.0F, 3.0F, -3.0F, 6.0F, 5.0F, 7.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 16.0F, 0.0F));
		ModelPartData cube_r1 = Pigeon.addChild("cube_r1", ModelPartBuilder.create().uv(9, 23).cuboid(-1.0F, -3.0F, -5.0F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F))
				.uv(0, 33).cuboid(-1.0F, -2.0F, -6.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(28, 0).cuboid(-2.0F, -4.0F, -4.0F, 4.0F, 5.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 3.0F, 0.0F, -0.3927F, 0.0F, 0.0F));
		ModelPartData cube_r2 = Pigeon.addChild("cube_r2", ModelPartBuilder.create().uv(15, 16).cuboid(-3.0F, 0.0F, -9.0F, 3.0F, 0.01F, 7.0F, new Dilation(0.0F))
				.uv(0, 0).cuboid(-3.0F, -3.0F, -9.0F, 3.0F, 3.0F, 0.01F, new Dilation(0.0F)), ModelTransform.of(0.0F, 7.9F, 4.0F, 0.0F, 0.3927F, 0.0F));
		ModelPartData cube_r3 = Pigeon.addChild("cube_r3", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -3.0F, -9.0F, 3.0F, 3.0F, 0.01F, new Dilation(0.0F))
				.uv(15, 16).cuboid(0.0F, 0.0F, -9.0F, 3.0F, 0.01F, 7.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 7.9F, 4.0F, 0.0F, -0.3927F, 0.0F));
		return TexturedModelData.of(ModelData, 48, 48);
	}

	@Override
	public void setAngles(SmallPlushieEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		this.PigeonPlushie.pitch = (float)Math.PI / 180 * entity.getBodyRotation().getPitch();
		this.PigeonPlushie.yaw = (float)Math.PI / 180 * entity.getBodyRotation().getYaw();
		this.PigeonPlushie.roll = (float)Math.PI / 180 * entity.getBodyRotation().getRoll();
	}

	@Override
	public void render(MatrixStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		PigeonPlushie.render(poseStack, buffer, packedLight, packedOverlay);
	}
}