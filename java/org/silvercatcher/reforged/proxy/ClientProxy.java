package org.silvercatcher.reforged.proxy;

import org.silvercatcher.reforged.ReforgedRegistry;
import org.silvercatcher.reforged.ReforgedMod;
import org.silvercatcher.reforged.entities.EntityBoomerang;
import org.silvercatcher.reforged.entities.EntityBulletMusket;
import org.silvercatcher.reforged.entities.EntityJavelin;
import org.silvercatcher.reforged.gui.ReloadOverlay;
import org.silvercatcher.reforged.items.ReforgedItem;
import org.silvercatcher.reforged.render.RenderBoomerang;
import org.silvercatcher.reforged.render.RenderBulletMusket;
import org.silvercatcher.reforged.render.RenderJavelin;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);
		MinecraftForge.EVENT_BUS.register(new ReloadOverlay());
	}
	
	@Override
	public void init(FMLInitializationEvent event) {

		super.init(event);
		registerItemRenderers();
		registerEntityRenderers(Minecraft.getMinecraft().getRenderManager());
	}
	
	@Override
	protected void registerItemRenderers() {
		
		ItemModelMesher mesher = Minecraft.getMinecraft().getRenderItem().getItemModelMesher();
		
		String inventory = "inventory";
		
		for(ReforgedItem item : ReforgedRegistry.registratonList) {
			mesher.register(item, 0, new ModelResourceLocation(ReforgedMod.ID + ":" 
					+ item.getName(), inventory));
		}
		
		mesher.register(ReforgedRegistry.NEST_OF_BEES, 1, new ModelResourceLocation(ReforgedMod.ID
				+ ReforgedRegistry.NEST_OF_BEES.getName() + "_empty", inventory));
		
		mesher.register(ReforgedRegistry.NEST_OF_BEES, 2, new ModelResourceLocation(ReforgedMod.ID
				+ ReforgedRegistry.NEST_OF_BEES.getName() + "_powder", inventory));
	}
	
	@Override
	protected void registerEntityRenderers(RenderManager manager) {
		ReforgedRegistry.registerEntityRenderers(EntityBoomerang.class, new RenderBoomerang(manager));
		ReforgedRegistry.registerEntityRenderers(EntityBulletMusket.class, new RenderBulletMusket(manager));
		ReforgedRegistry.registerEntityRenderers(EntityJavelin.class, new RenderJavelin(manager));
	}
}
