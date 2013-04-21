package uk.co.alteff4.tc.tileentity;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import uk.co.alteff4.tc.TechCraft;
import uk.co.alteff4.tc.lib.Strings;

public class TileComposter extends TileEntity implements ISidedInventory {

    /*
     * Stores the Composter's current Inventory
     */
    private ItemStack[] composterStacks = new ItemStack[2];

    /*
     * Amount of ticks so far through the current composting cycle
     */
    public int compostingTime = 0;
    public int fullamount = 0;
    public int RETURN_ID = TechCraft.instance.composter.blockID;
    
    private static final int[] field_102010_d = new int[] { 0 };
    private static final int[] field_102011_e = new int[] { 2, 1 };

    public void updateEntity()
    {
        if(composterStacks[0]!=null && fullamount < 100){
            decrStackSize(0,1);
            fullamount += 1;
        }
        if(compostingTime<200&&fullamount>0){
            compostingTime += 1;
        }
        if(compostingTime==200){
           compostingTime=0;
           setInventorySlotContents(1,new ItemStack(Block.blocksList[RETURN_ID],getStackInSlot(1).stackSize+1));
           
        }
        
    }
    
    @Override
    public int getSizeInventory() {
        return composterStacks.length;
    }

    @Override
    public ItemStack getStackInSlot(int i) {
        return composterStacks[i];
    }

    @Override
    public ItemStack decrStackSize(int i, int j) {
        ItemStack itemstack = composterStacks[i].copy();
        if (itemstack == null)
            return null;
        if (itemstack.stackSize - j <= 0) {
            itemstack = null;
            return itemstack;
        }
        itemstack.stackSize = itemstack.stackSize - j;
        return itemstack;

    }

    @Override
    public ItemStack getStackInSlotOnClosing(int i) {
        if (composterStacks[i] != null) {
            ItemStack itemstack = composterStacks[i];
            composterStacks[i] = null;
            return itemstack;
        } else
            return null;
    }

    @Override
    public void setInventorySlotContents(int i, ItemStack itemstack) {
        composterStacks[i] = itemstack;

        if (itemstack != null
                && itemstack.stackSize > this.getInventoryStackLimit()) {
            itemstack.stackSize = this.getInventoryStackLimit();
        }
    }

    @Override
    public String getInvName() {
        return Strings.COMPOSTER_INV;
    }

    @Override
    public boolean isInvNameLocalized() {
        return true;
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer entityplayer) {
        return worldObj.getBlockTileEntity(xCoord, yCoord, zCoord) != this ? false
                : entityplayer.getDistanceSq(xCoord + 0.5D, yCoord + 0.5D,
                        zCoord + 0.5D) <= 64.0D;
    }

    @Override
    public void openChest() {
    }

    @Override
    public void closeChest() {
    }

    @Override
    public boolean isStackValidForSlot(int i, ItemStack itemstack) {
        return i == 1 ? false : i == 0 ? isItemGreen(itemstack) : true;
    }

    public boolean isItemGreen(ItemStack itemstack) {

        int id = itemstack.itemID;
        if (id == Item.seeds.itemID || id == Item.wheat.itemID
                || id == Block.sapling.blockID || id == Block.grass.blockID)
            return true;
        return false;
    }

    @Override
    public int[] getSizeInventorySide(int var1) {
        return var1 == 0 ? field_102011_e : field_102010_d;

    }

    @Override
    public boolean func_102007_a(int i, ItemStack itemstack, int j) {
        return this.isStackValidForSlot(i, itemstack);
    }

    @Override
    public boolean func_102008_b(int i, ItemStack itemstack, int j) {
        return j != 0 || i != 1 || itemstack.itemID == Item.bucketEmpty.itemID;
    }

}
