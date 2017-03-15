package com.hexi.dcs.client.services;

import com.hexi.dcs.client.DocumentCloudServiceClient;

import com.hexi.dcs.client.pojo.CreateFolderRequest;
import com.hexi.dcs.client.pojo.CreateFolderResponse;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class DCSFolderService extends DocumentService {
   
    public CreateFolderResponse createFolder(String baseFolderId,CreateFolderRequest createFolderRequest) {
            CreateFolderResponse createFolderResponse = null;
            if(createFolderRequest != null) {
                WebTarget folderTarget = DocumentCloudServiceClient.getDCSFolderTarget();
                WebTarget folderIdTarget = folderTarget.path("{folderId}");
                Builder builder = folderIdTarget.resolveTemplate("folderId", baseFolderId).request(MediaType.APPLICATION_JSON);
                builder.header("authorization", authorization);
                createFolderResponse = builder.post(Entity.json(createFolderRequest),CreateFolderResponse.class);
                
            }
            return createFolderResponse;
        }
}
