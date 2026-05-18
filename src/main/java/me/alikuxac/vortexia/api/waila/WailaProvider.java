// Developed by alikuxac - Project Vortexia
package me.alikuxac.vortexia.api.waila;

import net.kyori.adventure.text.Component;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import java.util.List;

public interface WailaProvider {

    /**
     * Get list of information (as Adventure Component) to display on HUD when player looking at this block.
     * 
     * @param player The player who is looking at the block.
     * @param block  The block being looked at.
     * @return List of Components to display. Return empty list if provider does not support this block.
     */
    List<Component> getWailaInfo(Player player, Block block);
}
