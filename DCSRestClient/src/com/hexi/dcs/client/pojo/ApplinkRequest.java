package com.hexi.dcs.client.pojo;

public class ApplinkRequest {
    private String assignedUser;
    private String role;

    public void setAssignedUser(String assignedUser) {
        this.assignedUser = assignedUser;
    }

    public String getAssignedUser() {
        return assignedUser;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
