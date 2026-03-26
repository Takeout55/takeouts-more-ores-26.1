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

public class ModItems {
    public static <T extends Item> T register(String name, Function<Item.Properties, T> itemFactory, Item.Properties settings) {
        // Create the item key.
        ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(TakeoutsMoreOres.MOD_ID, name));

        // Create the item instance.
        T item = itemFactory.apply(settings.setId(itemKey));

        // Register the item.
        Registry.register(BuiltInRegistries.ITEM, itemKey, item);
        // Register the group.
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, TAKEOUTS_MORE_ORES_ITEMSTAB_KEY, TAKEOUTS_MORE_ORES_ITEMSTAB);

        return item;
    }

    public static final ResourceKey<CreativeModeTab> TAKEOUTS_MORE_ORES_ITEMSTAB_KEY = ResourceKey.create(
            BuiltInRegistries.CREATIVE_MODE_TAB.key(), Identifier.fromNamespaceAndPath(TakeoutsMoreOres.MOD_ID, "takeouts_more_ores_itemstab")
    );
    public static final CreativeModeTab TAKEOUTS_MORE_ORES_ITEMSTAB = FabricCreativeModeTab.builder()
            .icon(() -> new ItemStack(ModItems.REFINED_DIAMOND))
            .title(Component.translatable("itemGroup.takeouts-more-ores-items"))
            .displayItems((params, output) -> {
                output.accept(ModItems.REFINED_DIAMOND);

            })
            .build();

    public static final Item REFINED_DIAMOND = register("refined_diamond", Item::new, new Item.Properties());

    public static void initialize() {
        //CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS)
        //        .register((itemGroup) -> itemGroup.accept(ModItems.REFINED_DIAMOND));
    }
}