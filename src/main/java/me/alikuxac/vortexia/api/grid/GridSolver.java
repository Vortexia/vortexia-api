// Developed by alikuxac - Project Vortexia
package me.alikuxac.vortexia.api.grid;

/**
 * Handles the calculation/simulation logic for a specific grid network type.
 * Registered via {@link GridManager}.
 */
public interface GridSolver {

    /**
     * Solves the propagation logic for the given grid.
     * Called automatically during the grid manager's ticking.
     *
     * @param grid The Grid to solve
     */
    void solve(Grid grid);
}
