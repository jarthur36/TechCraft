package uk.co.alteff4.tc.core.proxy;

import uk.co.alteff4.tc.gui.inventory.GuiComposter;
import uk.co.alteff4.tc.inventory.ContainerComposter;
import uk.co.alteff4.tc.tileentity.TileComposter;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.registry.GameRegistry;

public class CommonProxy implements IGuiHandler {

    public void registerKeyBindingHandler() {

    }

    public void registerRenderTickHandler() {

    }

    public void registerDrawBlockHighlightHandler() {

    }

    public void setKeyBinding(String name, int value) {

    }

    public void registerSoundHandler() {

    }

    public void initRenderingAndTextures() {

    }

    public void registerTileEntities() {
        
        GameRegistry.registerTileEntity(TileComposter.class, "TileComposter");

    }

    public void sendRequestEventPacket(byte eventType, int originX,
            int originY, int originZ, byte sideHit, byte rangeX, byte rangeY,
            byte rangeZ, String data) {

    }

    public void handleTileEntityPacket(int x, int y, int z,
            ForgeDirection orientation, byte state, String customName) {

    }

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world,
            int x, int y, int z) {
        if (ID == 0){
            System.out.println("Loaded Container");
            return new ContainerComposter(player.inventory, (TileComposter) world.getBlockTileEntity(x, y, z));
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world,
            int x, int y, int z) {
        if (ID == 0){
            System.out.println("Loaded GUI");
            return new GuiComposter(player.inventory, (TileComposter) world.getBlockTileEntity(x, y, z));
        }
        return null;
    }
}
