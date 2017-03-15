package com.hexi.dcs.client.services;

import com.hexi.dcs.client.DocumentCloudServiceClient;

import com.hexi.dcs.client.pojo.DeleteFileRequest;
import com.hexi.dcs.client.pojo.DeleteFileResponse;
import com.hexi.dcs.client.pojo.DocumentUploadReponse;


import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import javax.ws.rs.core.Response;

import org.glassfish.jersey.media.multipart.FormDataMultiPart;

public class DCSFileService extends DocumentService{

    public DocumentUploadReponse uploadDocumentToDCS(FormDataMultiPart multipart) {

        DocumentUploadReponse documentUploadReponse = null;
        if (multipart != null) {
            WebTarget dcsFileTarget = DocumentCloudServiceClient.getDCSFileTarget();
            WebTarget fileTarget = dcsFileTarget.path("/data");
            Builder builder = fileTarget.request(MediaType.MULTIPART_FORM_DATA);
            builder.header("authorization", authorization);
            Response response = builder.post(Entity.entity(multipart, multipart.getMediaType()));
            if(response != null) {
                documentUploadReponse = response.readEntity(DocumentUploadReponse.class);
                if(documentUploadReponse != null)
                {
                documentUploadReponse.setHttpStatus(response.getStatus());
                }
            }
           
        }

        return documentUploadReponse;
    }
    
    public DocumentUploadReponse uploadDocumentToDCS(FormDataMultiPart multipart, String fileId) {
        DocumentUploadReponse documentUploadReponse = null;
       if(multipart != null && fileId != null) {
           WebTarget dcsFileTarget = DocumentCloudServiceClient.getDCSFileTarget();
           WebTarget fileTarget = dcsFileTarget.path("/{fileId}/data");
           Builder builder = fileTarget.resolveTemplate("fileId", fileId).request(MediaType.APPLICATION_JSON);
           builder.header("authorization", authorization);
           Response response = builder.post(Entity.entity(multipart, multipart.getMediaType()));
           if(response != null) {
               documentUploadReponse = response.readEntity(DocumentUploadReponse.class);
               if(documentUploadReponse != null)
               {
               documentUploadReponse.setHttpStatus(response.getStatus());
               }
           }
       }
        return documentUploadReponse;
    }
    
    public DeleteFileResponse deleteFile(DeleteFileRequest deleteFileRequest, String fileId) {
            DeleteFileResponse deleteFileResponse = null;
            if(deleteFileRequest != null && fileId != null) {
                WebTarget deleteFileTarget = DocumentCloudServiceClient.getDCSFileTarget();
                WebTarget fileTarget = deleteFileTarget.path("{fileId}");
                Builder builder = fileTarget.resolveTemplate("fileId", fileId).request(MediaType.APPLICATION_JSON);
                builder.header("authorization", authorization);
               deleteFileResponse = builder.post(Entity.json(deleteFileRequest),DeleteFileResponse.class);
            }
            
            return deleteFileResponse;
        }
    
}
