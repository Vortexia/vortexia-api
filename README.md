# Vortexia API

The official API for the Vortexia plugin ecosystem. This module provides interfaces and models for building Addons and interacting with the Vortexia Core.

## Features

- **Identity Management**: Access and manipulate user identities across the Vortexia network.
- **Addon Lifecycle**: Register and manage your custom hooks into the Core lifecycle.
- **Event System**: Listen to identity loading, linking, and update events.

## Installation

### JitPack (Recommended)

Add the JitPack repository and the dependency to your `build.gradle.kts`:

```kotlin
repositories {
    maven("https://jitpack.io")
}

dependencies {
    compileOnly("com.github.Vortexia:vortexia-api:1.0.0")
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
    compileOnly("me.alikuxac.vortexia:vortexia-api:1.0.0")
}
```

## Usage

### Getting the API Instance

Use the `VortexiaProvider` to access the API singleton:

```java
VortexiaAPI api = VortexiaProvider.get();
if (api != null) {
    // Access features
    api.getAddonManager().registerAddon(myAddon);
}
```

### Implementing an Addon

Implement the `VortexiaAddon` interface in your main class:

```java
public class MyAddon implements VortexiaAddon {
    @Override
    public String getName() { return "MyAddon"; }
    
    @Override
    public void onAddonEnable() {
        // Startup logic
    }
}
```

## Development

Developed and maintained by **alikuxac**. 
Part of the **Vortexia** Project.
