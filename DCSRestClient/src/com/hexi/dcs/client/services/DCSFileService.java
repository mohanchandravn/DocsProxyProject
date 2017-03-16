package com.hexi.dcs.client.services;

import com.hexi.dcs.client.DocumentCloudServiceClient;

import com.hexi.dcs.client.pojo.DeleteFileRequest;
import com.hexi.dcs.client.pojo.DeleteFileResponse;
import com.hexi.dcs.client.pojo.DocumentUploadReponse;


import com.hexi.dcs.client.pojo.DownloadFileRequest;

import com.hexi.dcs.client.pojo.DownloadFileResponse;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import java.nio.file.Files;

import java.nio.file.StandardCopyOption;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import com.sun.jersey.api.client.ClientResponse;

import java.io.BufferedReader;

import java.io.InputStreamReader;

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
    
    public String downloadFile(DownloadFileRequest downloadFileRequest,String fileId)  {
            DownloadFileResponse downloadFileResponse = null;
            String benefit = null;
            if(fileId != null) {
                WebTarget downloadFileTarget = DocumentCloudServiceClient.getDCSFileTarget();
                WebTarget fileTarget = downloadFileTarget.path("{fileId}/data");
                Builder builder = fileTarget.resolveTemplate("fileId", fileId).request(MediaType.APPLICATION_JSON);
                builder.header("authorization", authorization);
               Response response  = builder.get(Response.class);
                int status = response.getStatus();
                if(status == 200){
                    MultivaluedMap<String, Object>  headers = response.getHeaders();
                    String contentDisposition = (String)headers.getFirst("Content-Disposition");  //This header is formatted like this:     attachment; filename*=UTF-8''helloworld.txt; filename="helloworld.txt"
                     
                    //Use regex to pull out filename from content-disposition header. Following sample from Stack Overflow http://stackoverflow.com/questions/8092244/regex-to-extract-filename
                    String fileName = null;
                    Pattern regex = Pattern.compile("(?<=filename=\").*?(?=\")");
                    Matcher regexMatcher = regex.matcher(contentDisposition);
                    if (regexMatcher.find()) {
                        fileName = regexMatcher.group();
                    }
                 
                    String outputDir = "/Users/vignesh";
                    String line;
                    StringBuilder sb = new StringBuilder();
                    InputStream is = (InputStream)response.getEntity();
                    try {
                        //For sample test, overwrite file if it exists
//                        Files.copy(is, new File(outputDir + fileName).toPath(), StandardCopyOption.REPLACE_EXISTING);
//                        System.out.println("Saved file " + fileId + " to path : " + outputDir + fileName + ".");
                        BufferedReader br =new BufferedReader(new InputStreamReader(is));
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
                        benefit = sb.toString();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                else{
                    System.out.println("Error: " + status + ": " + response.getStatusInfo());
                }
            }

            return benefit;
        }
    public static void main(String[] args) {
        DCSFileService service = new DCSFileService();
       DownloadFileRequest downloadFileRequest = new DownloadFileRequest();
       String fileId = "D3F5504F9DA4A15438619823DB81338485D611EEEC77";
       service.downloadFile(downloadFileRequest, fileId);
   }
}
