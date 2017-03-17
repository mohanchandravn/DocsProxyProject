package com.hexi.dcs.client.services;

import com.hexi.dcs.model.daoImpl.DCSPropertiesDAOImpl;
import com.hexi.dcs.model.pojo.DCSProperties;
import com.hexi.dcs.model.util.EncryptionUtil;

import com.sun.jersey.core.util.Base64;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.apache.log4j.Logger;

import org.glassfish.jersey.media.multipart.internal.MultiPartWriter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public abstract class DocumentService {
    private static final Logger logger = Logger.getLogger(DocumentService.class);
    protected String authorization;
    private final static Client client = ClientBuilder.newClient();
    private static WebTarget baseTarget = null;
    private static WebTarget publicLinkTarget = null;
    private static WebTarget dcsFileTarget = null;
    private static WebTarget dcsFolderTarget = null;
    private static WebTarget dcsAppLinkTarget = null;
    private final static String DOCUMENT_CLOUD_SERVICE_URL_KEY = "DOCUMENT_CLOUD_SERVICE_URL";
    private final static String DOCUMENT_CLOUD_SERVICE_USER_KEY = "DOCUMENT_CLOUD_SERVICE_USER";
    private final static String DOCUMENT_CLOUD_SERVICE_PWD_KEY = "DOCUMENT_CLOUD_SERVICE_PWD";
    private String DCS_URL = null;
    private final static String DCS_PUBLIC_LINK_URL = "/publiclinks/file/";
    private final static String DCS_FILE_URL = "/files";
    private final static String DCS_FOLDER_URL = "/folders/";
    private final static String DCS_APPLINK_URL = "/applinks";
    
    public DocumentService() {
        execute();
    }
    
    
    protected void execute() {
        try{
        ApplicationContext context = new ClassPathXmlApplicationContext("/META-INF/dcsServices-config.xml");
        DCSPropertiesDAOImpl dcsPropertiesDAO = (DCSPropertiesDAOImpl)context.getBean("dCSPropertiesDAO");
        List<DCSProperties> listOfDcsProperties = dcsPropertiesDAO.retrieveDCSProperties();
        if(listOfDcsProperties != null && !(listOfDcsProperties.isEmpty())) {
            String authorizationUserName = null;
            String decodeDcsPwd = null;
            for(DCSProperties dcsProp: listOfDcsProperties) {
                if(dcsProp.getRuleKey() != null) {
                    if(dcsProp.getRuleKey().equals(DocumentService.DOCUMENT_CLOUD_SERVICE_URL_KEY)) {
                        this.setDCS_URL(dcsProp.getRuleValue());
                    }
                    else if(dcsProp.getRuleKey().equals(DocumentService.DOCUMENT_CLOUD_SERVICE_USER_KEY)) {
                        authorizationUserName = dcsProp.getRuleValue();
                    }
                    else if(dcsProp.getRuleKey().equals(DocumentService.DOCUMENT_CLOUD_SERVICE_PWD_KEY)) {
                        decodeDcsPwd = EncryptionUtil.decryptString(dcsProp.getRuleValue());
                    }
                }
                if(authorizationUserName != null && decodeDcsPwd != null) {
                    this.setAuthorization(authorizationUserName+":"+decodeDcsPwd);
                }
                
            }
        }
        }catch(Exception exp) {
            logger.info("exp:"+exp.getMessage());
            exp.printStackTrace();
        }
        
    }
    
    private WebTarget getBaseTarget() {
        if(baseTarget == null) {
            client.register(MultiPartWriter.class);
            baseTarget = client.target(this.getDCS_URL());
        }
        
        return baseTarget;
    }
    
    
    protected WebTarget getDCSAppLinkTarget() {
        if(dcsAppLinkTarget == null) {
            dcsAppLinkTarget = getBaseTarget().path(DCS_APPLINK_URL);
        }
        
        return dcsAppLinkTarget;
    }
    
    
    public WebTarget getDCSPublicLinkTarget() {
        if(publicLinkTarget == null) {
            publicLinkTarget = getBaseTarget().path(DCS_PUBLIC_LINK_URL);
        }
        
        return publicLinkTarget;
    }
    
    public WebTarget getDCSFileTarget() {
        if(dcsFileTarget == null) {
            dcsFileTarget = getBaseTarget().path(DCS_FILE_URL);
        }
        
        return dcsFileTarget;
    }
    
    public WebTarget getDCSFolderTarget() {
        if(dcsFolderTarget == null) {
            dcsFolderTarget = getBaseTarget().path(DCS_FOLDER_URL);
        }
        
        return dcsFolderTarget;
    }

    public void setDCS_URL(String DCS_URL) {
        this.DCS_URL = DCS_URL;
    }

    public String getDCS_URL() {
        return DCS_URL;
    }

    public void setAuthorization(String authorization) {
        this.authorization = "Basic " + new String(Base64.encode(authorization)); ;//"cloud.admin:extra@4CraWleR"
    }

    public String getAuthorization() {
        return authorization;
    }
}
