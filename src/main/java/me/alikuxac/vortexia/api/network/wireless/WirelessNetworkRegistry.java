// Developed by alikuxac - Project Vortexia
package me.alikuxac.vortexia.api.network.wireless;

import java.util.Collection;
import java.util.Optional;

public interface WirelessNetworkRegistry {
    
    void registerNode(WirelessNode node);
    
    void unregisterNode(WirelessNode node);
    
    Collection<WirelessNode> getNodesByFrequency(String frequency);
    
    Optional<WirelessChannelInfo> getChannelInfo(String frequency);
    
    /**
     * Gửi yêu cầu truyền tải tài nguyên không dây đến các cổng OUTPUT.
     * 
     * @param frequency Tần số muốn truyền tải.
     * @param amount Lượng tài nguyên muốn gửi đi.
     * @return Lượng tài nguyên thực tế đã truyền qua thành công.
     */
    double requestTransfer(String frequency, double amount);
}
