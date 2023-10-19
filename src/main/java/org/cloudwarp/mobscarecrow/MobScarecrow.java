package org.cloudwarp.mobscarecrow;

import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.cloudwarp.mobscarecrow.registry.*;
import org.cloudwarp.mobscarecrow.utils.Config;

public class MobScarecrow implements ModInitializer {
	public static final Logger LOGGER = LogManager.getLogger();
	public static final String MOD_ID = "mobscarecrow";
	public static double mobScarecrowRadius;

	public static Identifier id (String path) {
		return new Identifier(MOD_ID, path);
	}

	@Override
	public void onInitialize () {
		LOGGER.info("[Mob-Scarecrow] is initializing.");
		Config.getInstance().loadConfig();
		Config config = Config.getInstance();
		mobScarecrowRadius = config.getScarerowDistance();
		MSEntityTags.init();
		MSParticles.init();
		MSMemoryModules.init();
		MSSensors.init();
		MSEntities.init();
		MSSounds.registerSounds();
		MSItems.registerItems();
		LOGGER.info("[Mob-Scarecrow] has successfully been initialized.");
		LOGGER.info("[Mob-Scarecrow] if you have any issues or questions feel free to join my Discord: https://discord.gg/fvcFxTg6sB");
	}

}
