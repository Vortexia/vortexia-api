// Developed by alikuxac - Project Vortexia
package me.alikuxac.vortexia.api.storage;

import java.sql.SQLException;

@FunctionalInterface
public interface SQLFunction<T, R> {
    R apply(T t) throws SQLException;
}
