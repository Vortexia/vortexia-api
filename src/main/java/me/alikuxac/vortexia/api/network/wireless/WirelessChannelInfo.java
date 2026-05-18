// Developed by alikuxac - Project Vortexia
package me.alikuxac.vortexia.api.network.wireless;

public interface WirelessChannelInfo {
    
    String getFrequency();
    
    double getMaxThroughput();
    
    double getSpeedMultiplier();
    
    int getActiveInputsCount();
    
    int getActiveOutputsCount();
    
    int getActiveSupportsCount();
}
