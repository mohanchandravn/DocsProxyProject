package com.hexi.dcs.client.util;
import com.hexi.dcs.client.services.DCSAppLinkService;
import com.hexi.dcs.client.services.DCSFileService;
import com.hexi.dcs.client.services.DCSFolderService;
import com.hexi.dcs.client.services.DCSPublicLinkService;


public class DCSRestEndpointFactory {
      
    public static DCSFileService getDCSFileService() {
        return new DCSFileService();
    }
    
    public static DCSFolderService getDCSFolderService() {
        return new DCSFolderService();
    }
    
    public static DCSPublicLinkService getPublicLinkService() {
        return new DCSPublicLinkService();
    }
    
    public static DCSAppLinkService getAppLinkService() {
        return new DCSAppLinkService();
    }
    
}
