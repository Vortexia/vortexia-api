// Developed by alikuxac - Project Vortexia
package me.alikuxac.vortexia.api.addon;

import java.util.Collection;

public interface AddonManager {

    /**
     * Registers an addon into the Vortexia Core lifecycle.
     * 
     * @param addon Implementor of VortexiaAddon
     */
    void registerAddon(VortexiaAddon addon);

    /**
     * Unregisters an addon from the Vortexia Core lifecycle.
     * 
     * @param addon Implementor of VortexiaAddon
     */
    void unregisterAddon(VortexiaAddon addon);

    /**
     * Unregisters an addon by name.
     * 
     * @param name Name of the addon
     */
    void unregisterAddon(String name);

    /**
     * Retrieves an active addon by name.
     * 
     * @param name Name of the addon
     * @param <T>  Type of the addon
     * @return The addon instance or null if not found
     */
    <T extends VortexiaAddon> T getAddon(String name);

    /**
     * Retrieves all currently registered addons.
     * 
     * @return Collection of addons
     */
    Collection<VortexiaAddon> getAddons();
}
