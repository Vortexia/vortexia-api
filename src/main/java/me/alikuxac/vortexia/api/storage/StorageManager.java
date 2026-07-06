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

    /**
     * Gets a connection from the core database pool.
     * Ensure the connection is closed after use using try-with-resources.
     */
    java.sql.Connection getConnection() throws java.sql.SQLException;

    /**
     * Executes a SQL update or DDL command (e.g. CREATE TABLE, INSERT, UPDATE).
     */
    CompletableFuture<Void> executeUpdate(String sql, Object... params);

    /**
     * Executes a SQL query and maps the result.
     */
    <T> CompletableFuture<T> executeQuery(String sql, SQLFunction<java.sql.ResultSet, T> mapper, Object... params);

    /**
     * Returns the database type ("MYSQL" or "SQLITE").
     */
    String getDatabaseType();
}

