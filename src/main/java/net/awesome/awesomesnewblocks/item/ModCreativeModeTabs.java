package net.awesome.awesomesnewblocks.item;

import net.awesome.awesomesnewblocks.AwesomesNewBlocks;
import net.awesome.awesomesnewblocks.blocks.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {

	public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
			DeferredRegister.create(Registries.CREATIVE_MODE_TAB, AwesomesNewBlocks.MOD_ID);

	public static final Supplier<CreativeModeTab> BISMUTH_ITEMS_TAB = CREATIVE_MODE_TAB.register("bismuth_items_tab",
			() -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.BISMUTH.get()))
					.title(Component.translatable("creativetab.awesomesnewb.bismuth_items"))
					.displayItems((itemDisplayParameters, output) -> {
						output.accept(ModItems.BISMUTH);
						output.accept(ModItems.RAW_BISMUTH);
					}).build());


	public static final Supplier<CreativeModeTab> BISMUTH_BLOCK_TAB = CREATIVE_MODE_TAB.register("bismuth_block_tab",
			() -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.BISMUTH_BLOCK.get()))
					.withTabsBefore(ResourceLocation.fromNamespaceAndPath(AwesomesNewBlocks.MOD_ID,"bismuth_items_tab"))
					.title(Component.translatable("creativetab.awesomesnewb.bismuth_block"))
					.displayItems((itemDisplayParameters, output) -> {
						output.accept(ModBlocks.BISMUTH_BLOCK);
						output.accept(ModBlocks.BISMUTH_ORE);
					}).build());

	public static void register(IEventBus eventBus){
		CREATIVE_MODE_TAB.register(eventBus);
	}


}
