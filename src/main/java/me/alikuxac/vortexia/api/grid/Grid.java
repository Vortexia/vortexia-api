// Developed by alikuxac - Project Vortexia
package me.alikuxac.vortexia.api.grid;

import java.util.Collection;
import java.util.UUID;

/**
 * Represents a network grid consisting of connected {@link GridNode}s of the same type.
 */
public interface Grid {

    /**
     * Gets the unique identifier for this grid network.
     *
     * @return The UUID of the grid
     */
    UUID getId();

    /**
     * Gets the network type this grid belongs to.
     *
     * @return The network type string
     */
    String getNetworkType();

    /**
     * Gets a collection of all nodes currently belonging to this grid.
     *
     * @return Collection of GridNodes
     */
    Collection<GridNode> getNodes();

    /**
     * Adds a node to this grid.
     *
     * @param node The GridNode to add
     */
    void addNode(GridNode node);

    /**
     * Removes a node from this grid.
     *
     * @param node The GridNode to remove
     */
    void removeNode(GridNode node);

    /**
     * Triggers the logic ticks for this grid, which solves the grid's propagation calculations.
     */
    void tick();
}
