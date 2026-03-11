// Developed by alikuxac - Project Vortexia
package me.alikuxac.vortexia.api;

public class VortexiaProvider {

    private static VortexiaAPI instance = null;

    public static VortexiaAPI get() {
        if (instance == null) {
            throw new IllegalStateException("VortexiaAPI is not initialized yet.");
        }
        return instance;
    }

    public static void register(VortexiaAPI api) {
        instance = api;
    }

    public static void unregister() {
        instance = null;
    }
}
