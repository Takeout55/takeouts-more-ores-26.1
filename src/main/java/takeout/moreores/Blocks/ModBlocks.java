package takeout.moreores.Blocks;

import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import takeout.moreores.TakeoutsMoreOres;

import java.util.function.Function;

public class ModBlocks {
    private static Block register(String name, Function<BlockBehaviour.Properties, Block> blockFactory, BlockBehaviour.Properties settings, boolean shouldRegisterItem) {
        // Create a registry key for the block
        ResourceKey<Block> blockKey = keyOfBlock(name);
        // Create the block instance
        Block block = blockFactory.apply(settings.setId(blockKey));

        // Sometimes, you may not want to register an item for the block.
        // Eg: if it's a technical block like `minecraft:moving_piston` or `minecraft:end_gateway`
        if (shouldRegisterItem) {
            // Items need to be registered with a different type of registry key, but the ID
            // can be the same.
            ResourceKey<Item> itemKey = keyOfItem(name);

            BlockItem blockItem = new BlockItem(block, new Item.Properties().setId(itemKey).useBlockDescriptionPrefix());
            Registry.register(BuiltInRegistries.ITEM, itemKey, blockItem);
            Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, TAKEOUTS_MORE_ORES_BLOCKSTAB_KEY, TAKEOUTS_MORE_ORES_BLOCKSTAB);
        }

        return Registry.register(BuiltInRegistries.BLOCK, blockKey, block);
    }

    private static ResourceKey<Block> keyOfBlock(String name) {
        return ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(TakeoutsMoreOres.MOD_ID, name));
    }

    private static ResourceKey<Item> keyOfItem(String name) {
        return ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(TakeoutsMoreOres.MOD_ID, name));
    }

    public static final ResourceKey<CreativeModeTab> TAKEOUTS_MORE_ORES_BLOCKSTAB_KEY = ResourceKey.create(
            BuiltInRegistries.CREATIVE_MODE_TAB.key(), Identifier.fromNamespaceAndPath(TakeoutsMoreOres.MOD_ID, "takeouts_more_ores_blockstab")
    );
    public static final CreativeModeTab TAKEOUTS_MORE_ORES_BLOCKSTAB = FabricCreativeModeTab.builder()
            .icon(() -> new ItemStack(ModBlocks.REFINED_DIAMOND_BLOCK))
            .title(Component.translatable("itemGroup.takeouts-more-ores-blocks"))
            .displayItems((params, output) -> {
                output.accept(ModBlocks.REFINED_DIAMOND_BLOCK);
            })
            .build();

    public static final Block REFINED_DIAMOND_BLOCK = register(
            "refined_diamond_block",
            Block::new,
            BlockBehaviour.Properties.of().sound(SoundType.IRON),
            true
    );

    public static void initialize() {}
}