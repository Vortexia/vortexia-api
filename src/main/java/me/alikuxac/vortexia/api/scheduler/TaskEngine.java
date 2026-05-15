// Developed by alikuxac - Project Vortexia
package me.alikuxac.vortexia.api.scheduler;

public interface TaskEngine {
    /**
     * Registers a recurring task that runs at a fixed interval.
     * @param id Unique ID for the task
     * @param runnable Logic to run
     * @param interval Ticks between runs
     */
    void registerRecurringProcessor(String id, Runnable runnable, long interval);

    /**
     * Unregisters a recurring task.
     */
    void unregisterProcessor(String id);
}
