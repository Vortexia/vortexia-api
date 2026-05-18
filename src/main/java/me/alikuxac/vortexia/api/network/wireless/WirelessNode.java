// Developed by alikuxac - Project Vortexia
package me.alikuxac.vortexia.api.network.wireless;

import org.bukkit.Location;

public interface WirelessNode {
    
    Location getLocation();
    
    String getFrequency();
    
    WirelessRole getRole();
    
    /**
     * Nhận tài nguyên phân phối qua mạng không dây.
     * Trả về lượng tài nguyên thực tế đã tiêu thụ/lưu trữ được.
     * 
     * @param amount Lượng tài nguyên đầu vào.
     * @return Lượng tài nguyên thực tế được chấp nhận.
     */
    default double acceptResource(double amount) {
        return 0;
    }
}
