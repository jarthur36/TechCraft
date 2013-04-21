package uk.co.alteff4.tc.gui.inventory;
import org.lwjgl.opengl.GL11;

import uk.co.alteff4.tc.inventory.ContainerComposter;
import uk.co.alteff4.tc.lib.Textures;
import uk.co.alteff4.tc.tileentity.TileComposter;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.StatCollector;


public class GuiComposter extends GuiContainer {

    private TileComposter tileComposter;
    
    public GuiComposter(InventoryPlayer inventoryPlayer, TileComposter tileComposter) {
        super(new ContainerComposter(inventoryPlayer, tileComposter));
        this.tileComposter = tileComposter;
        xSize = 176;
        ySize = 140;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int x, int y) {

        String containerName = tileComposter.isInvNameLocalized() ? tileComposter.getInvName() : StatCollector.translateToLocal(tileComposter.getInvName());
        fontRenderer.drawString(containerName, xSize / 2 - fontRenderer.getStringWidth(containerName) / 2, 6, 4210752);
        fontRenderer.drawString(Integer.toString(tileComposter.fullamount), xSize / 2 - fontRenderer.getStringWidth(Integer.toString(tileComposter.fullamount)) / 10, 30, 4210752);
        fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, ySize - 93, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {

        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        mc.renderEngine.bindTexture(Textures.GUI_COMPOSTER);
        int xStart = (width - xSize) / 2;
        int yStart = (height - ySize) / 2;
        this.drawTexturedModalRect(xStart, yStart, 0, 0, xSize, ySize);
    }
}


