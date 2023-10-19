package org.cloudwarp.mobscarecrow.registry;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class MSSounds {
	public static final Identifier PLUSHIE_SQUEAK_ID = new Identifier("mobscarecrow:plushie_squeak");
	public static final Identifier PLUSHIE_BREAK_ID = new Identifier("mobscarecrow:plushie_break");
	public static SoundEvent PLUSHIE_SQUEAK_EVENT = SoundEvent.of(PLUSHIE_SQUEAK_ID);
	public static SoundEvent PLUSHIE_BREAK_EVENT = SoundEvent.of(PLUSHIE_BREAK_ID);

	public static void registerSounds () {
		Registry.register(Registries.SOUND_EVENT, PLUSHIE_SQUEAK_ID, PLUSHIE_SQUEAK_EVENT);
		Registry.register(Registries.SOUND_EVENT, PLUSHIE_BREAK_ID, PLUSHIE_BREAK_EVENT);
	}
}
