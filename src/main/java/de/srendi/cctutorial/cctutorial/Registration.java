package de.srendi.cctutorial.cctutorial;

import com.google.common.collect.Sets;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class Registration {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, CCtutorial.MODID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CCtutorial.MODID);
    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, CCtutorial.MODID);

    //Blocks
    public static final RegistryObject<Block> CC_BLOCK = register("tutorial_block", CCBlock::new);

    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> block) {
        RegistryObject<T> registryObject = BLOCKS.register(name, block);
        ITEMS.register(name, ()->new BlockItem(registryObject.get(), new Item.Properties().group(ItemGroup.REDSTONE)));
        return registryObject;
    }

    //Tile Entities
    public static final RegistryObject<TileEntityType<CCTileEntity>> CC_TILEENTITY = Registration.TILE_ENTITIES.register("tutorial_block", () -> new TileEntityType<>(CCTileEntity::new, Sets.newHashSet(CC_BLOCK.get()), null));

    //Register our stuff
    public static void register() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);
        TILE_ENTITIES.register(modEventBus);
    }
}