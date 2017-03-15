package com.hexi.dcs.client.services;

import com.hexi.dcs.client.DocumentCloudServiceClient;
import com.hexi.dcs.client.pojo.AppLinkRefreshRequest;
import com.hexi.dcs.client.pojo.AppLinkResponse;

import com.hexi.dcs.client.pojo.ApplinkRequest;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class DCSAppLinkService extends DocumentService {
   
    public AppLinkResponse createFileAppLink(ApplinkRequest appLinkRequest, String fileId) {
            AppLinkResponse appLinkResponse = null;
            if(appLinkRequest != null && fileId != null)
            {
                WebTarget appLinkTarget = DocumentCloudServiceClient.getDCSAppLinkTarget();
                WebTarget fileTarget = appLinkTarget.path("/file/{fileId}");
                Builder builder = fileTarget.resolveTemplate("fileId", fileId).request(MediaType.APPLICATION_JSON);
                builder.header("authorization", authorization);
                appLinkResponse = builder.post(Entity.json(appLinkRequest),AppLinkResponse.class);
            }
            
            return appLinkResponse;
            
        }
    
    public AppLinkResponse refreshAppLink(AppLinkRefreshRequest appLinkRefreshRequest) {
            AppLinkResponse appLinkResponse = null;
            if(appLinkRefreshRequest != null)
            {
                WebTarget appLinkTarget = DocumentCloudServiceClient.getDCSAppLinkTarget();
                WebTarget fileTarget = appLinkTarget.path("/token");
                Builder builder = fileTarget.request(MediaType.APPLICATION_JSON);
                builder.header("authorization", authorization);
                builder.header("appLinkID", appLinkRefreshRequest.getAppLinkID());
                builder.header("accessToken", appLinkRefreshRequest.getAccessToken());
                builder.header("refreshToken", appLinkRefreshRequest.getAppLinkID());
                appLinkResponse = builder.put(Entity.json(appLinkRefreshRequest),AppLinkResponse.class);
            }
            
            return appLinkResponse;
            
        }
}
