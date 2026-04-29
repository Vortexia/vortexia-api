// Developed by alikuxac - Project Vortexia
package me.alikuxac.vortexia.api;

import me.alikuxac.vortexia.api.model.Identity;
import me.alikuxac.vortexia.api.addon.AddonManager;
import org.bukkit.entity.Player;

import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public interface VortexiaAPI {

    AddonManager getAddonManager();

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

    // Metadata API
    CompletableFuture<Optional<String>> getMetadata(UUID uuid, String key);

    CompletableFuture<Void> setMetadata(UUID uuid, String key, String value);

    CompletableFuture<Void> removeMetadata(UUID uuid, String key);
}
