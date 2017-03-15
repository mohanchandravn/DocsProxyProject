package com.hexi.dcs.client.pojo;

public class PublicLinkRequest
{
    private String expirationTime;

    private String assignedUsers;

    private String role;

    private String password;

    private String linkName;

    public String getExpirationTime ()
    {
        return expirationTime;
    }

    public void setExpirationTime (String expirationTime)
    {
        this.expirationTime = expirationTime;
    }

    public String getAssignedUsers ()
    {
        return assignedUsers;
    }

    public void setAssignedUsers (String assignedUsers)
    {
        this.assignedUsers = assignedUsers;
    }

    public String getRole ()
    {
        return role;
    }

    public void setRole (String role)
    {
        this.role = role;
    }

    public String getPassword ()
    {
        return password;
    }

    public void setPassword (String password)
    {
        this.password = password;
    }

    public String getLinkName ()
    {
        return linkName;
    }

    public void setLinkName (String linkName)
    {
        this.linkName = linkName;
    }

    
}
