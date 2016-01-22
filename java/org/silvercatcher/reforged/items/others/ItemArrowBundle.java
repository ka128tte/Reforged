package org.silvercatcher.reforged.items.others;

import org.silvercatcher.reforged.ReforgedMod;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemArrowBundle extends Item {

	
	public ItemArrowBundle() {
		
		setMaxStackSize(16);
		setUnlocalizedName("arrow_bundle");
		setCreativeTab(ReforgedMod.tabReforged);
	}


	public void registerRecipes() {
		
		GameRegistry.addShapelessRecipe(new ItemStack(this),
			new ItemStack(Items.arrow, 8), new ItemStack(Items.string));
	}


	public float getHitDamage() {
		return 0f;
	}
}
