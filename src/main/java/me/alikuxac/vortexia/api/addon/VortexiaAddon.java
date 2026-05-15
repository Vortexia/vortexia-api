// Developed by alikuxac - Project Vortexia
package me.alikuxac.vortexia.api.addon;

public interface VortexiaAddon {

    /**
     * Gets the name of the addon.
     * 
     * @return Addon name
     */
    String getAddonName();

    /**
     * Gets the version of the addon.
     * 
     * @return Addon version
     */
    String getVersion();

    /**
     * Gets the author of the addon.
     * 
     * @return Addon author
     */
    String getAuthor();

    /**
     * Called when the addon is registered and enabled by Core.
     */
    void onAddonEnable();

    /**
     * Called when the addon is unregistered or Core is disabled.
     */
    void onAddonDisable();
}
