// Developed by alikuxac - Project Vortexia
package me.alikuxac.vortexia.api.item;

import org.bukkit.inventory.ItemStack;

public class VortexiaItem {
    private final String addonId;
    private final String itemId;
    private final ItemStack itemStack;
    private final ItemStack[] recipe; // 9 elements array representing 3x3 crafting grid. Nullable items are allowed.

    public VortexiaItem(String addonId, String itemId, ItemStack itemStack, ItemStack[] recipe) {
        this.addonId = addonId;
        this.itemId = itemId;
        this.itemStack = itemStack;
        this.recipe = recipe != null ? recipe.clone() : null;
    }

    public String getAddonId() {
        return addonId;
    }

    public String getItemId() {
        return itemId;
    }

    public ItemStack getItemStack() {
        return itemStack;
    }

    public ItemStack[] getRecipe() {
        return recipe != null ? recipe.clone() : null;
    }
}
