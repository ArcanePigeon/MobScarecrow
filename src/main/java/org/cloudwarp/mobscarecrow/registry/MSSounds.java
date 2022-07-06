package org.cloudwarp.mobscarecrow.registry;

import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class MSSounds {
	public static final Identifier PLUSHIE_SQUEAK_ID = new Identifier("mobscarecrow:plushie_squeak");
	public static final Identifier PLUSHIE_BREAK_ID = new Identifier("mobscarecrow:plushie_break");
	public static SoundEvent PLUSHIE_SQUEAK_EVENT = new SoundEvent(PLUSHIE_SQUEAK_ID);
	public static SoundEvent PLUSHIE_BREAK_EVENT = new SoundEvent(PLUSHIE_BREAK_ID);

	public static void registerSounds () {
		Registry.register(Registry.SOUND_EVENT, PLUSHIE_SQUEAK_ID, PLUSHIE_SQUEAK_EVENT);
		Registry.register(Registry.SOUND_EVENT, PLUSHIE_BREAK_ID, PLUSHIE_BREAK_EVENT);
	}
}
