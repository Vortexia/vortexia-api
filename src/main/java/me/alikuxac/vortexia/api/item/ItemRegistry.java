// Developed by alikuxac - Project Vortexia
package me.alikuxac.vortexia.api.item;

import java.util.Collection;
import java.util.Optional;

public interface ItemRegistry {

    /**
     * Registers a custom item to the global registry.
     *
     * @param item The custom VortexiaItem
     */
    void registerItem(VortexiaItem item);

    /**
     * Retrieves an item by its unique ID (format: "addonId:itemId").
     *
     * @param id The unique item ID
     * @return Optional containing the VortexiaItem if found, empty otherwise
     */
    Optional<VortexiaItem> getItem(String id);

    /**
     * Retrieves all registered items.
     *
     * @return Collection of all items
     */
    Collection<VortexiaItem> getItems();

    /**
     * Retrieves all registered items for a specific addon.
     *
     * @param addonId The ID of the addon
     * @return Collection of items registered by the addon
     */
    Collection<VortexiaItem> getItemsByAddon(String addonId);
}
