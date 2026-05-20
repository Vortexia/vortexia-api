// Developed by alikuxac - Project Vortexia
package me.alikuxac.vortexia.api.recipe;

import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;

/**
 * Represents a custom grid-based recipe (up to 5x5).
 */
public interface CustomRecipe {

    /**
     * Gets the unique namespaced key for this recipe.
     */
    NamespacedKey getKey();

    /**
     * Gets the width of the recipe grid (1 to 5).
     */
    int getWidth();

    /**
     * Gets the height of the recipe grid (1 to 5).
     */
    int getHeight();

    /**
     * Gets the ingredients matrix for this recipe.
     * Dimensions are [height][width]. Empty spaces are represented by null.
     */
    RecipeChoice[][] getIngredients();

    /**
     * Gets the result item stack when crafted.
     */
    ItemStack getResult();

    /**
     * Creates a new CustomRecipe instance using a simple inline factory.
     */
    static CustomRecipe of(NamespacedKey key, int width, int height, RecipeChoice[][] ingredients, ItemStack result) {
        return new CustomRecipe() {
            @Override
            public NamespacedKey getKey() {
                return key;
            }

            @Override
            public int getWidth() {
                return width;
            }

            @Override
            public int getHeight() {
                return height;
            }

            @Override
            public RecipeChoice[][] getIngredients() {
                return ingredients;
            }

            @Override
            public ItemStack getResult() {
                return result.clone();
            }
        };
    }
}
