// Developed by alikuxac - Project Vortexia
package me.alikuxac.vortexia.api.grid;

import org.bukkit.Location;
import java.util.Collection;

/**
 * Manages all active grid networks and handles registration, merging, and splitting of physical nodes.
 */
public interface GridManager {

    /**
     * Registers a new node at its physical location.
     * Automatically scans 6-direction adjacent blocks to merge existing grids if they connect.
     *
     * @param node The GridNode to register
     */
    void registerNode(GridNode node);

    /**
     * Unregisters the node at the specified location.
     * Automatically executes a BFS graph check to split the network into separate grids if it has been broken.
     *
     * @param location The Location of the node
     * @param networkType The type of the network
     */
    void unregisterNode(Location location, String networkType);

    /**
     * Gets all active grids of a specific network type.
     *
     * @param networkType The network type
     * @return Collection of active Grids
     */
    Collection<Grid> getGrids(String networkType);

    /**
     * Finds the grid containing the node at the specified location.
     *
     * @param location The Location
     * @param networkType The network type
     * @return The Grid containing the node, or null if none exists
     */
    Grid getGridAt(Location location, String networkType);

    /**
     * Registers a custom simulation solver for a specific network type.
     *
     * @param networkType The network type string
     * @param solver The GridSolver logic
     */
    void registerSolver(String networkType, GridSolver solver);
}
