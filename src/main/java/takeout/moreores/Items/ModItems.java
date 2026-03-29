package takeout.moreores.Items;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.ItemLore;
import takeout.moreores.Blocks.ModBlocks;
import takeout.moreores.TakeoutsMoreOres;

import java.util.List;
import java.util.function.Function;

import static takeout.moreores.Blocks.ModBlocks.TAKEOUTS_MORE_ORES_BLOCKSTAB;
import static takeout.moreores.Blocks.ModBlocks.TAKEOUTS_MORE_ORES_BLOCKSTAB_KEY;

public class ModItems {
    public static <T extends Item> T register(String name, Function<Item.Properties, T> itemFactory, Item.Properties settings) {
        // Create the item key.
        ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(TakeoutsMoreOres.MOD_ID, name));

        // Create the item instance.
        T item = itemFactory.apply(settings.setId(itemKey));

        // Register the item.
        Registry.register(BuiltInRegistries.ITEM, itemKey, item);
        // Register the group.


        return item;
    }

    // Creative Mode Items Tab
    public static final ResourceKey<CreativeModeTab> TAKEOUTS_MORE_ORES_ITEMSTAB_KEY = ResourceKey.create(
            BuiltInRegistries.CREATIVE_MODE_TAB.key(), Identifier.fromNamespaceAndPath(TakeoutsMoreOres.MOD_ID, "takeouts_more_ores_itemstab")
    );
    public static final CreativeModeTab TAKEOUTS_MORE_ORES_ITEMSTAB = FabricCreativeModeTab.builder()
            .icon(() -> new ItemStack(ModItems.REFINED_DIAMOND))
            .title(Component.translatable("itemGroup.takeouts-more-ores-items"))
            .displayItems((params, output) -> {
                output.accept(ModItems.REFINED_DIAMOND);
                output.accept(ModItems.RUBY);
                output.accept(ModItems.SAPPHIRE);
                output.accept(ModItems.ZIRCON);
                output.accept(ModItems.THIMEITE);
                output.accept(ModItems.PLUNGITE);
                output.accept(ModItems.MULTIVERSIUM_INGOT);
                output.accept(ModItems.EARIUM);
                output.accept(ModItems.OCARITE);
                output.accept(ModItems.GLITCHITE);
                output.accept(ModItems.FLAMING_TAKEITE);
                output.accept(ModItems.FROZEN_TAKEITE);
                output.accept(ModItems.CHEESIUM);
                output.accept(ModItems.GASNITE);
            })
            .build();

    // The Item Classes
    public static final Item REFINED_DIAMOND = register("refined_diamond", Item::new, new Item.Properties());
    public static final Item RUBY = register("ruby", Item::new, new Item.Properties());
    public static final Item SAPPHIRE = register("sapphire", Item::new, new Item.Properties());
    public static final Item ZIRCON = register("zircon", Item::new, new Item.Properties());
    public static final Item THIMEITE = register("thimeite", Item::new, new Item.Properties());
    public static final Item PLUNGITE = register("plungite", Item::new, new Item.Properties());
    public static final Item MULTIVERSIUM_INGOT = register("multiversium_ingot", Item::new, new Item.Properties());
    public static final Item EARIUM = register("earium", Item::new, new Item.Properties());
    public static final Item OCARITE = register("ocarite", Item::new, new Item.Properties());
    public static final Item GLITCHITE = register("glitchite", Item::new, new Item.Properties());
    public static final Item FLAMING_TAKEITE = register("flaming_takeite", Item::new, new Item.Properties());
    public static final Item FROZEN_TAKEITE = register("frozen_takeite", Item::new, new Item.Properties());
    public static final Item CHEESIUM = register("cheesium", Item::new, new Item.Properties());
    public static final Item GASNITE = register("gasnite", Item::new, new Item.Properties());

    public static void initialize() {}
}
