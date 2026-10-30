# Vortexia API

[![Latest Release](https://img.shields.io/github/v/release/Vortexia/vortexia-api?color=blue&label=Latest%20Release)](https://github.com/Vortexia/vortexia-api/releases/latest)
[![Dev Version](https://img.shields.io/badge/Dev%20Version-1.3.2--DEV-orange)](https://github.com/Vortexia/vortexia-api/tree/development)
[![Build Development](https://github.com/Vortexia/vortexia-api/actions/workflows/build-development.yml/badge.branch?branch=development)](https://github.com/Vortexia/vortexia-api/actions/workflows/build-development.yml)
[![PR Verification](https://github.com/Vortexia/vortexia-api/actions/workflows/build-pr.yml/badge.svg)](https://github.com/Vortexia/vortexia-api/actions/workflows/build-pr.yml)
[![Publish API](https://github.com/Vortexia/vortexia-api/actions/workflows/publish.yml/badge.svg)](https://github.com/Vortexia/vortexia-api/actions/workflows/publish.yml)

> [!WARNING]
> Experimental API build. Interfaces and package contracts are subject to change between releases.

Developer API for the **Vortexia** Minecraft plugin ecosystem (1.21+). Provides hooks for addons, multiblock grids, wireless network registrations, custom items, custom recipes, WAILA providers, and player identity lookups.

## Features

- **Identity & Metadata**: Async lookup of citizen identities, online/offline UUID mapping, and key-value metadata storage.
- **Addon Lifecycle**: Standardized entry points (`VortexiaAddon`) to load, enable, and unload addons safely.
- **Multiblock Grid Engine**: Extensible network solver interface (`GridNode`, `GridSolver`) for custom power, fluid, and item pipes.
- **Items & Recipes**: Programmatic registry for custom items (`VortexiaItem`) and crafting recipes (`CustomRecipe`) displayed in the guide GUI.
- **Wireless Networks**: Register, look up, and manage persistent wireless networks (`WirelessNetworkRegistry`).
- **WAILA Overlays**: Register custom HUD tooltip providers (`WailaProvider`) for blocks.
- **Task Scheduling**: Folia-aware regional scheduler and Bukkit async execution wrapper.
- **Direct Database Access**: Run async queries and updates directly against the shared Core database pool.

## Installation

### JitPack

Add JitPack and the dependency to `build.gradle.kts`:

```kotlin
repositories {
    maven("https://jitpack.io")
}

dependencies {
    compileOnly("com.github.alikuxac:vortexia-api:1.3.2")
}
```

### GitHub Packages

```kotlin
repositories {
    maven {
        name = "GitHubPackages"
        url = uri("https://maven.pkg.github.com/Vortexia/vortexia-api")
    }
}

dependencies {
    compileOnly("me.alikuxac.vortexia:vortexia-api:1.3.2")
}
```

## Usage

### 1. Hooking into the API

```java
import me.alikuxac.vortexia.api.VortexiaAPI;
import me.alikuxac.vortexia.api.VortexiaProvider;

public class MyPlugin extends JavaPlugin {
    @Override
    public void onEnable() {
        VortexiaAPI api = VortexiaProvider.get();
        if (api == null) {
            getLogger().warning("VortexiaCore not found.");
            return;
        }
    }
}
```

### 2. Creating an Addon

```java
import me.alikuxac.vortexia.api.addon.VortexiaAddon;

public class MyCustomAddon implements VortexiaAddon {
    @Override
    public String getAddonName() { return "CustomMachines"; }

    @Override
    public String getVersion() { return "1.0.0"; }

    @Override
    public String getAuthor() { return "YourName"; }

    @Override
    public void onAddonEnable() {
        // Register items, grids, and recipes
    }

    @Override
    public void onAddonDisable() {
        // Cleanup resources
    }
}
```

### 3. Registering a WAILA Tooltip Provider

```java
import me.alikuxac.vortexia.api.waila.WailaProvider;
import net.kyori.adventure.text.Component;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import java.util.List;

public class GeneratorWailaProvider implements WailaProvider {
    @Override
    public List<Component> getTooltip(Player player, Block block) {
        return List.of(
            Component.text("§6⚡ Steam Generator"),
            Component.text("§7Status: §aActive"),
            Component.text("§7Output: §e50 EU/t")
        );
    }
}

// In onAddonEnable:
VortexiaProvider.get().getWailaManager().registerProvider("generator", new GeneratorWailaProvider());
```

### 4. Registering a Grid Solver

```java
import me.alikuxac.vortexia.api.grid.Grid;
import me.alikuxac.vortexia.api.grid.GridSolver;

public class EnergyGridSolver implements GridSolver {
    @Override
    public void solve(Grid grid) {
        // Distribute energy across connected nodes
    }
}

// In onAddonEnable:
VortexiaProvider.get().getGridManager().registerSolver("energy", new EnergyGridSolver());
```

## License

GNU General Public License v3.0. See [LICENSE](LICENSE).
