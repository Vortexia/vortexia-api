// Developed by alikuxac - Project Vortexia
package me.alikuxac.vortexia.api;

import org.bukkit.NamespacedKey;

public class VortexiaKeys {

    /**
     * Marker key to identify any item belonging to the Vortexia ecosystem.
     * Value type: Integer (1 = true)
     */
    public static final NamespacedKey VORTEXIA_ITEM = new NamespacedKey("vortexia", "item");

    /**
     * Key to store the specific item ID/Type.
     * Value type: String (e.g., "controller", "drive", "cell_1k")
     */
    public static final NamespacedKey ITEM_ID = new NamespacedKey("vortexia", "id");

    /**
     * Key to store the addon ID that owns this item.
     * Value type: String (e.g., "storage", "industrial")
     */
    public static final NamespacedKey ADDON_ID = new NamespacedKey("vortexia", "addon");

    /**
     * Key to store custom metadata for specific items.
     * Value type: String (JSON or serialized data)
     */
    public static final NamespacedKey ITEM_DATA = new NamespacedKey("vortexia", "data");

}
