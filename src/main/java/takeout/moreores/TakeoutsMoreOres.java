package takeout.moreores;

import net.fabricmc.api.ModInitializer;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import takeout.moreores.Blocks.ModBlocks;
import takeout.moreores.Items.ModItems;

import static takeout.moreores.Blocks.ModBlocks.TAKEOUTS_MORE_ORES_BLOCKSTAB;
import static takeout.moreores.Blocks.ModBlocks.TAKEOUTS_MORE_ORES_BLOCKSTAB_KEY;
import static takeout.moreores.Items.ModItems.TAKEOUTS_MORE_ORES_ITEMSTAB;
import static takeout.moreores.Items.ModItems.TAKEOUTS_MORE_ORES_ITEMSTAB_KEY;

public class TakeoutsMoreOres implements ModInitializer {
	public static final String MOD_ID = "takeouts-more-ores";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");
		ModItems.initialize();
		ModBlocks.initialize();
		Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, TAKEOUTS_MORE_ORES_ITEMSTAB_KEY, TAKEOUTS_MORE_ORES_ITEMSTAB);
		Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, TAKEOUTS_MORE_ORES_BLOCKSTAB_KEY, TAKEOUTS_MORE_ORES_BLOCKSTAB);
	}
}