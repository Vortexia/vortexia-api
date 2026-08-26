# Vortexia API

[![Latest Release](https://img.shields.io/github/v/release/Vortexia/vortexia-api?color=blue&label=Latest%20Release)](https://github.com/Vortexia/vortexia-api/releases/latest)
[![Dev Version](https://img.shields.io/badge/Dev%20Version-1.3.2--DEV-orange)](https://github.com/Vortexia/vortexia-api/tree/development)
[![Build Development](https://github.com/Vortexia/vortexia-api/actions/workflows/build-development.yml/badge.branch?branch=development)](https://github.com/Vortexia/vortexia-api/actions/workflows/build-development.yml)
[![PR Verification](https://github.com/Vortexia/vortexia-api/actions/workflows/build-pr.yml/badge.svg)](https://github.com/Vortexia/vortexia-api/actions/workflows/build-pr.yml)
[![Publish API](https://github.com/Vortexia/vortexia-api/actions/workflows/publish.yml/badge.svg)](https://github.com/Vortexia/vortexia-api/actions/workflows/publish.yml)

> [!WARNING]
> This is an **experimental** API build for the Vortexia ecosystem. Interfaces, classes, and packages are subject to change, and major breaking changes can happen without notice. Use at your own risk!

The official developer API for the **Vortexia** Minecraft Plugin ecosystem (1.21+). Build addons, extend digital grids, define wireless structures, register custom items/recipes, and query player identities with ease.

## Features

- **Identity Management & Metadata**: Query user identities asynchronously, fetch effective UUIDs (handling cracked/premium mismatches), and store metadata on players or locations.
- **Addon Lifecycle**: Interface hooks to safely load, enable, and disable your custom extensions.
- **Dynamic Grid System**: Deeply integrate with energy, resource, and storage meshes by providing your custom `GridNode` and `GridSolver`.
- **Item & Custom Recipe Registry**: Programmatically register custom items (`VortexiaItem`) and recipe inputs (`CustomRecipe`) which immediately interface with the interactive Guide GUI.
- **Wireless Networking**: Query, create, or register physical networks into the wireless registry (`WirelessNetworkRegistry`).
- **WAILA HUD Provider**: Hook customized look-at block displays directly into the on-screen real-time WAILA engine.
- **Unified Task Engine**: Run Folia-safe region-based asynchronous tasks or delay execution on standard Spigot regions.
- **Database & Storage API**: Directly query or run async updates against the shared Core database (MySQL/SQLite).

## Installation

### JitPack (Recommended)

Add the JitPack repository and the dependency to your `build.gradle.kts`:

```kotlin
repositories {
    maven("https://jitpack.io")
}

dependencies {
    compileOnly("com.github.alikuxac:vortexia-api:1.3.2")
}
```

### GitHub Packages

If you prefer using the GitHub Maven registry, add the following to your `build.gradle.kts`:

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

## Usage & Integration

### 1. Fetching the API Singleton

Access the centralized API using the static provider class:

```java
import me.alikuxac.vortexia.api.VortexiaAPI;
import me.alikuxac.vortexia.api.VortexiaProvider;

public class MyPlugin extends JavaPlugin {
    @Override
    public void onEnable() {
        VortexiaAPI api = VortexiaProvider.get();
        if (api != null) {
            getLogger().info("Successfully hooked into VortexiaAPI version: " + api.getAddonManager().getClass().getPackage().getImplementationVersion());
        }
    }
}
```

### 2. Developing an Addon

Implement the `VortexiaAddon` lifecycle to hook into plugin stages:

```java
import me.alikuxac.vortexia.api.addon.VortexiaAddon;

public class MyCustomAddon implements VortexiaAddon {
    @Override
    public String getAddonName() {
        return "CustomMachines";
    }

    @Override
    public String getVersion() {
        return "1.0.0";
    }

    @Override
    public String getAuthor() {
        return "YourName";
    }

    @Override
    public void onAddonEnable() {
        // Startup code, register grids, items, etc.
    }

    @Override
    public void onAddonDisable() {
        // Cleanup code
    }
}
```

### 3. Adding a custom WAILA Tooltip Provider

Register a tooltip to display when players look at your custom block:

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
            Component.text("§7Energy Output: §e50 EU/t")
        );
    }
}

// Inside onAddonEnable:
VortexiaProvider.get().getWailaManager().registerProvider("generator", new GeneratorWailaProvider());
```

### 4. Registering a Grid Solver

Hook your modular block ticks into the central Grid tick loop:

```java
import me.alikuxac.vortexia.api.grid.Grid;
import me.alikuxac.vortexia.api.grid.GridSolver;

public class EnergyGridSolver implements GridSolver {
    @Override
    public void solve(Grid grid) {
        // Distribute energy from producers to consumers within this network
    }
}

// Inside onAddonEnable:
VortexiaProvider.get().getGridManager().registerSolver("energy", new EnergyGridSolver());
```

## License

This project is licensed under the GNU General Public License v3.0 - see the [LICENSE](LICENSE) file for details.

---

> *Copyright belongs to Team Vortexia | API developed by: @alikuxac.*
