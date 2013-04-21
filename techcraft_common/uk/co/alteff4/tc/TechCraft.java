package uk.co.alteff4.tc;


import net.minecraft.block.Block;
import uk.co.alteff4.tc.blocks.BlockComposter;
import uk.co.alteff4.tc.core.proxy.CommonProxy;

import uk.co.alteff4.tc.lib.Reference;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
public class TechCraft {

    @Instance(Reference.MOD_ID)
    public static TechCraft instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;
    
    public Block composter = new BlockComposter(500,"Composter");
    
    
    @PreInit
    public void preInit(FMLPreInitializationEvent event) {

    }

    @Init
    public void init(FMLInitializationEvent event) {
      GameRegistry.registerBlock(composter,"composter");
      LanguageRegistry.addName(composter, "Composter");
      proxy.registerTileEntities();
      NetworkRegistry.instance().registerGuiHandler(instance, proxy);
    }
    
    @PostInit
    public void postInit(FMLPostInitializationEvent event) {
        
    }
}
