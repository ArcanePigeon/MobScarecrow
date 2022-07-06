package org.cloudwarp.mobscarecrow.registry;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.BlockStateParticleEffect;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.particle.ParticleType;
import net.minecraft.util.registry.Registry;
import org.cloudwarp.mobscarecrow.MobScarecrow;

public class MSParticles {
	//
	public static final DefaultParticleType PLUSHIE_PARTICLE = FabricParticleTypes.simple();
	//public static final ParticleType<BlockStateParticleEffect> PLUSHIE_PARTICLE = FabricParticleTypes.complex(BlockStateParticleEffect.PARAMETERS_FACTORY);

	public static void init(){
		Registry.register(Registry.PARTICLE_TYPE, MobScarecrow.id("plushie_particle"), PLUSHIE_PARTICLE);
	}
}
