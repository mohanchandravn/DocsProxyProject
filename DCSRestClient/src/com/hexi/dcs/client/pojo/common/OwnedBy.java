package com.hexi.dcs.client.pojo.common;

public class OwnedBy {
    public OwnedBy() {
        super();
    }
    
    private String id;

       private String type;

       private String displayName;

       public String getId ()
       {
           return id;
       }

       public void setId (String id)
       {
           this.id = id;
       }

       public String getType ()
       {
           return type;
       }

       public void setType (String type)
       {
           this.type = type;
       }

       public String getDisplayName ()
       {
           return displayName;
       }

       public void setDisplayName (String displayName)
       {
           this.displayName = displayName;
       }
}
