// Developed by alikuxac - Project Vortexia
package me.alikuxac.vortexia.api.grid;

import org.bukkit.Location;

/**
 * Represents a single node (device, pipe, wire, gear, etc.) in a physical network.
 */
public interface GridNode {

    /**
     * Gets the physical location of the node in the Minecraft world.
     *
     * @return The Location of this node
     */
    Location getLocation();

    /**
     * Gets the type of the network this node belongs to (e.g. "storage", "kinetic", "fluid", "electricity").
     *
     * @return The unique string representing the network type
     */
    String getNetworkType();

    /**
     * Gets the active grid instance this node is currently associated with.
     *
     * @return The Grid containing this node, or null if none
     */
    Grid getGrid();

    /**
     * Sets the active grid instance this node is associated with.
     *
     * @param grid The new Grid
     */
    void setGrid(Grid grid);
}
