package com.hexi.dcs.client;

import com.sun.jersey.core.util.Base64;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.glassfish.jersey.media.multipart.internal.MultiPartWriter;

public class DocumentCloudServiceClient {
    private final static Client client = ClientBuilder.newClient();
    private static WebTarget baseTarget = null;
    private static WebTarget publicLinkTarget = null;
    private static WebTarget dcsFileTarget = null;
    private static WebTarget dcsFolderTarget = null;
    private static WebTarget dcsAppLinkTarget = null;
    private final static String DCS_URL = "https://documents-usoracleam82569.documents.us2.oraclecloud.com/documents/api/1.1";
    private final static String DCS_PUBLIC_LINK_URL = "/publiclinks/file/";
    private final static String DCS_FILE_URL = "/files";
    private final static String DCS_FOLDER_URL = "/folders/";
    private final static String DCS_APPLINK_URL = "/applinks";
    
    
    
    private static WebTarget getBaseTarget() {
        if(baseTarget == null) {
            client.register(MultiPartWriter.class);
            baseTarget = client.target(DCS_URL);
        }
        
        return baseTarget;
    }
    
    
    public static WebTarget getDCSAppLinkTarget() {
        if(dcsAppLinkTarget == null) {
            dcsAppLinkTarget = getBaseTarget().path(DCS_APPLINK_URL);
        }
        
        return dcsAppLinkTarget;
    }
    
    
    public static WebTarget getDCSPublicLinkTarget() {
        if(publicLinkTarget == null) {
            publicLinkTarget = getBaseTarget().path(DCS_PUBLIC_LINK_URL);
        }
        
        return publicLinkTarget;
    }
    
    public static WebTarget getDCSFileTarget() {
        if(dcsFileTarget == null) {
            dcsFileTarget = getBaseTarget().path(DCS_FILE_URL);
        }
        
        return dcsFileTarget;
    }
    
    public static WebTarget getDCSFolderTarget() {
        if(dcsFolderTarget == null) {
            dcsFolderTarget = getBaseTarget().path(DCS_FOLDER_URL);
        }
        
        return dcsFolderTarget;
    }
    
}
