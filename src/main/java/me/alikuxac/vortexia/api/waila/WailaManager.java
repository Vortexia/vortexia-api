// Developed by alikuxac - Project Vortexia
package me.alikuxac.vortexia.api.waila;

import net.kyori.adventure.text.Component;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import java.util.List;

public interface WailaManager {

    void registerProvider(WailaProvider provider);

    void unregisterProvider(WailaProvider provider);

    /**
     * Collect and combine all informations from WailaProvider for this block.
     * 
     * @param player The player who is looking.
     * @param block  The block being looked at.
     * @return List of Components to display.
     */
    List<Component> getInfo(Player player, Block block);
}
