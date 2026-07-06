// Developed by alikuxac - Project Vortexia
package me.alikuxac.vortexia.api;

import me.alikuxac.vortexia.api.network.wireless.WirelessNetworkRegistry;
import me.alikuxac.vortexia.api.item.ItemRegistry;
import me.alikuxac.vortexia.api.waila.WailaManager;
import me.alikuxac.vortexia.api.model.Identity;
import me.alikuxac.vortexia.api.addon.AddonManager;
import me.alikuxac.vortexia.api.scheduler.TaskEngine;
import me.alikuxac.vortexia.api.storage.StorageManager;
import me.alikuxac.vortexia.api.grid.GridManager;
import me.alikuxac.vortexia.api.recipe.CustomRecipeManager;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;


import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public interface VortexiaAPI {

    AddonManager getAddonManager();

    TaskEngine getTaskEngine();

    StorageManager getStorageManager();

    StorageManager getStorageManager(Plugin plugin);

    ItemRegistry getItemRegistry();

    WirelessNetworkRegistry getWirelessRegistry();

    WailaManager getWailaManager();

    GridManager getGridManager();

    CustomRecipeManager getCustomRecipeManager();

    Identity getIdentity(UUID uuid);

    Identity getIdentityByName(String name);

    CompletableFuture<Optional<Identity>> getIdentityAsync(UUID uuid);

    CompletableFuture<Optional<Identity>> getIdentityByNameAsync(String name);

    Identity getIdentityByCitizenId(String citizenId);

    CompletableFuture<Optional<Identity>> getIdentityByCitizenIdAsync(String citizenId);

    UUID getLatestUUID(String playerName);

    boolean isSamePerson(UUID uuid1, UUID uuid2);

    boolean isSamePersonByUUIDs(UUID uuid1, UUID uuid2);

    UUID getEffectiveUUID(Player player);

    boolean isOnlineMode();

    long getCacheSize();

    void invalidateCache(UUID uuid);

    void clearCache();

    // Metadata API (Players)
    CompletableFuture<Optional<String>> getMetadata(UUID uuid, String key);
    CompletableFuture<Void> setMetadata(UUID uuid, String key, String value);
    CompletableFuture<Void> removeMetadata(UUID uuid, String key);

    // Metadata API (Blocks/Locations)
    CompletableFuture<Optional<String>> getBlockMetadata(Location loc, String key);
    CompletableFuture<Void> setBlockMetadata(Location loc, String key, String value);
    CompletableFuture<Void> removeBlockMetadata(Location loc, String key);

    // Guide/Creative GUI API
    void openGuide(Player player, String category);
}
