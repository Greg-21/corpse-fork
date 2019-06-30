package de.maxhenkel.corpse.gui;

import de.maxhenkel.corpse.Main;
import de.maxhenkel.corpse.entities.CorpseEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.IInventory;

public class CorpseContainer extends ContainerBase {

    private CorpseEntity corpse;
    private boolean editable;

    public CorpseContainer(int id, IInventory playerInventory, CorpseEntity corpse, boolean editable) {
        super(Main.CONTAINER_TYPE_CORPSE, id, playerInventory, corpse);
        this.corpse = corpse;
        this.editable = editable;

        setSlots(0);
    }

    public CorpseContainer(int id, IInventory playerInventory, CorpseEntity corpse) {
        this(id, playerInventory, corpse, false);
    }

    public void setSlots(int start) {
        inventorySlots.clear();
        for (int j = 0; j < 6; j++) {
            for (int k = 0; k < 9; k++) {
                addSlot(new CorpseSlot(corpse, start + k + j * 9, 8 + k * 18, 19 + j * 18, editable));
            }
        }

        addInvSlots();
        detectAndSendChanges();
    }

    public CorpseEntity getCorpse() {
        return corpse;
    }

    public boolean isEditable() {
        return editable;
    }

    @Override
    public boolean canInteractWith(PlayerEntity playerIn) {
        return true;
    }

    @Override
    public int getInvOffset() {
        return 82;
    }

    @Override
    public int getInventorySize() {
        return 54;
    }
}