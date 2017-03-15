package com.hexi.dcs.client.pojo;

import com.hexi.dcs.client.pojo.common.CreatedBy;
import com.hexi.dcs.client.pojo.common.ModifiedBy;
import com.hexi.dcs.client.pojo.common.OwnedBy;


public class DocumentUploadReponse {
    public DocumentUploadReponse() {
        super();
    }
    
    private String errorMessage;

        private String createdTime;

        private ModifiedBy modifiedBy;

        private String modifiedTime;

        private String type;

        private String version;

        private String size;

        private String id;

        private String parentID;

        private CreatedBy createdBy;

        private String name;

        private String errorCode;

        private OwnedBy ownedBy;

        private String errorKey;

        private String mimeType;
        
        private int httpStatus;


        public String getErrorMessage ()
        {
            return errorMessage;
        }

        public void setErrorMessage (String errorMessage)
        {
            this.errorMessage = errorMessage;
        }

        public String getCreatedTime ()
        {
            return createdTime;
        }

        public void setCreatedTime (String createdTime)
        {
            this.createdTime = createdTime;
        }

        public ModifiedBy getModifiedBy ()
        {
            return modifiedBy;
        }

        public void setModifiedBy (ModifiedBy modifiedBy)
        {
            this.modifiedBy = modifiedBy;
        }

        public String getModifiedTime ()
        {
            return modifiedTime;
        }

        public void setModifiedTime (String modifiedTime)
        {
            this.modifiedTime = modifiedTime;
        }

        public String getType ()
        {
            return type;
        }

        public void setType (String type)
        {
            this.type = type;
        }

        public String getVersion ()
        {
            return version;
        }

        public void setVersion (String version)
        {
            this.version = version;
        }

        public String getSize ()
        {
            return size;
        }

        public void setSize (String size)
        {
            this.size = size;
        }

        public String getId ()
        {
            return id;
        }

        public void setId (String id)
        {
            this.id = id;
        }

        public String getParentID ()
        {
            return parentID;
        }

        public void setParentID (String parentID)
        {
            this.parentID = parentID;
        }

        public CreatedBy getCreatedBy ()
        {
            return createdBy;
        }

        public void setCreatedBy (CreatedBy createdBy)
        {
            this.createdBy = createdBy;
        }

        public String getName ()
        {
            return name;
        }

        public void setName (String name)
        {
            this.name = name;
        }

        public String getErrorCode ()
        {
            return errorCode;
        }

        public void setErrorCode (String errorCode)
        {
            this.errorCode = errorCode;
        }

        public OwnedBy getOwnedBy ()
        {
            return ownedBy;
        }

        public void setOwnedBy (OwnedBy ownedBy)
        {
            this.ownedBy = ownedBy;
        }

        public String getErrorKey ()
        {
            return errorKey;
        }

        public void setErrorKey (String errorKey)
        {
            this.errorKey = errorKey;
        }

        public String getMimeType ()
        {
            return mimeType;
        }

        public void setMimeType (String mimeType)
        {
            this.mimeType = mimeType;
        }


    public void setHttpStatus(int httpStatus) {
        this.httpStatus = httpStatus;
    }

    public int getHttpStatus() {
        return httpStatus;
    }
}
