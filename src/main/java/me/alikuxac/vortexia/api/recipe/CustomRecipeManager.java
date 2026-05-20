// Developed by alikuxac - Project Vortexia
package me.alikuxac.vortexia.api.recipe;

import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import java.util.Collection;
import java.util.Optional;

/**
 * Manages custom grid-based recipes (up to 5x5).
 */
public interface CustomRecipeManager {

    /**
     * Registers a new custom recipe.
     */
    void registerRecipe(CustomRecipe recipe);

    /**
     * Matches a 2D matrix of input items against all registered recipes.
     * The input matrix can be up to 5x5.
     * Null elements or AIR represent empty spaces.
     */
    Optional<CustomRecipe> matchRecipe(ItemStack[][] inputMatrix);

    /**
     * Gets a registered recipe by its key.
     */
    Optional<CustomRecipe> getRecipe(NamespacedKey key);

    /**
     * Gets all registered custom recipes.
     */
    Collection<CustomRecipe> getRecipes();
}
