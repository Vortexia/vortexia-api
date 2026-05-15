// Developed by alikuxac - Project Vortexia
package me.alikuxac.vortexia.api.storage;

import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public interface StorageManager {
    /**
     * Retrieves metadata for a specific UUID (Player or virtual Block UUID).
     */
    CompletableFuture<Optional<String>> getMetadata(UUID uuid, String key);

    /**
     * Saves metadata for a specific UUID.
     */
    CompletableFuture<Void> setMetadata(UUID uuid, String key, String value);

    /**
     * Removes metadata for a specific UUID.
     */
    CompletableFuture<Void> removeMetadata(UUID uuid, String key);
}
