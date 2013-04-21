package uk.co.alteff4.tc.core.proxy;

import net.minecraftforge.common.ForgeDirection;

public class ClientProxy extends CommonProxy {

    @Override
    public void registerKeyBindingHandler() {

        //KeyBindingRegistry.registerKeyBinding(new KeyBindingHandler());
    }

    @Override
    public void registerRenderTickHandler() {

        //TickRegistry.registerTickHandler(new TransmutationTargetOverlayHandler(), Side.CLIENT);
    }

    @Override
    public void registerDrawBlockHighlightHandler() {

        //MinecraftForge.EVENT_BUS.register(new DrawBlockHighlightHandler());
    }

    @Override
    public void setKeyBinding(String name, int value) {

        //KeyBindingHelper.addKeyBinding(name, value);
        //KeyBindingHelper.addIsRepeating(false);
    }

    @Override
    public void registerSoundHandler() {

        //MinecraftForge.EVENT_BUS.register(new SoundHandler());
    }

    @Override
    public void initRenderingAndTextures() {

        //RenderIds.calcinatorRenderId = RenderingRegistry.getNextAvailableRenderId();
      
        //MinecraftForgeClient.registerItemRenderer(BlockIds.CALCINATOR, new ItemCalcinatorRenderer());
     
    }

    @Override
    public void registerTileEntities() {

        super.registerTileEntities();

        //ClientRegistry.bindTileEntitySpecialRenderer(TileCalcinator.class, new TileEntityCalcinatorRenderer());
       
    }

    @Override
    public void sendRequestEventPacket(byte eventType, int originX, int originY, int originZ, byte sideHit, byte rangeX, byte rangeY, byte rangeZ, String data) {

        //PacketDispatcher.sendPacketToServer(PacketTypeHandler.populatePacket(new PacketRequestEvent(eventType, originX, originY, originZ, sideHit, rangeX, rangeY, rangeZ, data)));
    }

    @Override
    public void handleTileEntityPacket(int x, int y, int z, ForgeDirection orientation, byte state, String customName) {

    }

}
