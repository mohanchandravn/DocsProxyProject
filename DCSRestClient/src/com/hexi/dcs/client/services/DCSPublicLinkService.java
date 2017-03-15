package com.hexi.dcs.client.services;

import com.hexi.dcs.client.DocumentCloudServiceClient;
import com.hexi.dcs.client.pojo.PublicLinkRequest;
import com.hexi.dcs.client.pojo.PublicLinkResponse;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class DCSPublicLinkService extends DocumentService {
    
   public PublicLinkResponse createPublicLinkforaFile(String fileId, PublicLinkRequest publicLinkRequest) {
            if (fileId == null) {
                throw new IllegalArgumentException("File ID should be valid");
            }
            if (publicLinkRequest == null) {
                throw new IllegalArgumentException("Request to create public link is not valid");
            }
            
            WebTarget publicLinkTarget = DocumentCloudServiceClient.getDCSPublicLinkTarget();
            WebTarget fileIdTarget = publicLinkTarget.path("{fileId}");

            Builder builder = fileIdTarget.resolveTemplate("fileId", fileId).request(MediaType.APPLICATION_JSON);
            builder.header("authorization", authorization);
            PublicLinkResponse publicLinkResponse = builder.post(Entity.json(publicLinkRequest),PublicLinkResponse.class);
            System.out.println("response:" + publicLinkResponse.getHttpStatusCode());
            return publicLinkResponse;

        }
}
