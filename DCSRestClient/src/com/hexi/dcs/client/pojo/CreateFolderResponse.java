package com.hexi.dcs.client.pojo;

import com.hexi.dcs.client.pojo.common.CreatedBy;
import com.hexi.dcs.client.pojo.common.ModifiedBy;
import com.hexi.dcs.client.pojo.common.CreatedBy;
import com.hexi.dcs.client.pojo.common.ModifiedBy;
import com.hexi.dcs.client.pojo.common.OwnedBy;

public class CreateFolderResponse {
    private CreatedBy createdBy;
    private String createdTime;
    private String description;
    private String errorCode;
    private String id;
    private ModifiedBy modifiedBy;
    private String modifiedTime;
    private String name;
    private OwnedBy ownedBy;
    private String parentID;
    private String type;

    public void setCreatedBy(CreatedBy createdBy) {
        this.createdBy = createdBy;
    }

    public CreatedBy getCreatedBy() {
        return createdBy;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setModifiedBy(ModifiedBy modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public ModifiedBy getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedTime(String modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public String getModifiedTime() {
        return modifiedTime;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setOwnedBy(OwnedBy ownedBy) {
        this.ownedBy = ownedBy;
    }

    public OwnedBy getOwnedBy() {
        return ownedBy;
    }

    public void setParentID(String parentID) {
        this.parentID = parentID;
    }

    public String getParentID() {
        return parentID;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
