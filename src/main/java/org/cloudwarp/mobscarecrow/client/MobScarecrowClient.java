package org.cloudwarp.mobscarecrow.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.particle.FireworksSparkParticle;
import org.cloudwarp.mobscarecrow.entities.renderers.*;
import org.cloudwarp.mobscarecrow.models.*;
import org.cloudwarp.mobscarecrow.registry.MSEntities;
import org.cloudwarp.mobscarecrow.registry.MSParticles;

@Environment(EnvType.CLIENT)
public class MobScarecrowClient implements ClientModInitializer {
	@Override
	public void onInitializeClient () {


		ParticleFactoryRegistry.getInstance().register(MSParticles.PLUSHIE_PARTICLE, FireworksSparkParticle.ExplosionFactory::new);

		EntityRendererRegistry.register(MSEntities.CAT_PLUSHIE, ((context) -> new CatPlushieEntityRenderer(context)));
		EntityModelLayerRegistry.registerModelLayer(CatPlushieModel.LAYER_LOCATION, CatPlushieModel::getTexturedModelData);

		EntityRendererRegistry.register(MSEntities.PILLAGER_PLUSHIE, ((context) -> new PillagerPlushieEntityRenderer(context)));
		EntityModelLayerRegistry.registerModelLayer(PillagerPlushieModel.LAYER_LOCATION, PillagerPlushieModel::getTexturedModelData);

		EntityRendererRegistry.register(MSEntities.STEVE_PLUSHIE, ((context) -> new StevePlushieEntityRenderer(context)));
		EntityModelLayerRegistry.registerModelLayer(StevePlushieModel.LAYER_LOCATION, StevePlushieModel::getTexturedModelData);

		EntityRendererRegistry.register(MSEntities.VILLAGER_PLUSHIE, ((context) -> new VillagerPlushieEntityRenderer(context)));
		EntityModelLayerRegistry.registerModelLayer(VillagerPlushieModel.LAYER_LOCATION, VillagerPlushieModel::getTexturedModelData);

		EntityRendererRegistry.register(MSEntities.WOLF_PLUSHIE, ((context) -> new WolfPlushieEntityRenderer(context)));
		EntityModelLayerRegistry.registerModelLayer(WolfPlushieModel.LAYER_LOCATION, WolfPlushieModel::getTexturedModelData);

		EntityRendererRegistry.register(MSEntities.ZOMBIE_PLUSHIE, ((context) -> new ZombiePlushieEntityRenderer(context)));
		EntityModelLayerRegistry.registerModelLayer(ZombiePlushieModel.LAYER_LOCATION, ZombiePlushieModel::getTexturedModelData);

		EntityRendererRegistry.register(MSEntities.AXOLOTL_PLUSHIE, ((context) -> new AxolotlPlushieEntityRenderer(context)));
		EntityModelLayerRegistry.registerModelLayer(AxolotlPlushieModel.LAYER_LOCATION, AxolotlPlushieModel::getTexturedModelData);

		EntityRendererRegistry.register(MSEntities.CHICKEN_PLUSHIE, ((context) -> new ChickenPlushieEntityRenderer(context)));
		EntityModelLayerRegistry.registerModelLayer(ChickenPlushieModel.LAYER_LOCATION, ChickenPlushieModel::getTexturedModelData);

		EntityRendererRegistry.register(MSEntities.COPPER_GOLEM_PLUSHIE, ((context) -> new CopperGolemPlushieEntityRenderer(context)));
		EntityModelLayerRegistry.registerModelLayer(CopperGolemPlushieModel.LAYER_LOCATION, CopperGolemPlushieModel::getTexturedModelData);

		EntityRendererRegistry.register(MSEntities.DEFAULT_SCARECROW, ((context) -> new DefaultScarecrowEntityRenderer(context)));
		EntityModelLayerRegistry.registerModelLayer(DefaultScarecrowModel.LAYER_LOCATION, DefaultScarecrowModel::getTexturedModelData);

		EntityRendererRegistry.register(MSEntities.GOLD_PIG_PLUSHIE, ((context) -> new GoldPigPlushieEntityRenderer(context)));
		EntityModelLayerRegistry.registerModelLayer(GoldPigPlushieModel.LAYER_LOCATION, GoldPigPlushieModel::getTexturedModelData);

		EntityRendererRegistry.register(MSEntities.PIGEON_PLUSHIE, ((context) -> new PigeonPlushieEntityRenderer(context)));
		EntityModelLayerRegistry.registerModelLayer(PigeonPlushieModel.LAYER_LOCATION, PigeonPlushieModel::getTexturedModelData);

		EntityRendererRegistry.register(MSEntities.PIGLIN_PLUSHIE, ((context) -> new PiglinPlushieEntityRenderer(context)));
		EntityModelLayerRegistry.registerModelLayer(PiglinPlushieModel.LAYER_LOCATION, PiglinPlushieModel::getTexturedModelData);

		EntityRendererRegistry.register(MSEntities.RABBIT_PLUSHIE, ((context) -> new RabbitPlushieEntityRenderer(context)));
		EntityModelLayerRegistry.registerModelLayer(RabbitPlushieModel.LAYER_LOCATION, RabbitPlushieModel::getTexturedModelData);

		EntityRendererRegistry.register(MSEntities.SNOW_GOLEM_PLUSHIE, ((context) -> new SnowGolemPlushieEntityRenderer(context)));
		EntityModelLayerRegistry.registerModelLayer(SnowGolemPlushieModel.LAYER_LOCATION, SnowGolemPlushieModel::getTexturedModelData);

		EntityRendererRegistry.register(MSEntities.ZOMBIFIED_PIGLIN_PLUSHIE, ((context) -> new ZombifiedPiglinPlushieEntityRenderer(context)));
		EntityModelLayerRegistry.registerModelLayer(ZombifiedPiglinPlushieModel.LAYER_LOCATION, ZombifiedPiglinPlushieModel::getTexturedModelData);

		EntityRendererRegistry.register(MSEntities.IRON_GOLEM_PLUSHIE, ((context) -> new IronGolemPlushieEntityRenderer(context)));
		EntityModelLayerRegistry.registerModelLayer(IronGolemPlushieModel.LAYER_LOCATION, IronGolemPlushieModel::getTexturedModelData);
	}
}
