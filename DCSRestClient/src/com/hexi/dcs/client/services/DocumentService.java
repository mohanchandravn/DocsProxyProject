package com.hexi.dcs.client.services;

import com.sun.jersey.core.util.Base64;

public abstract class DocumentService {
    protected String authorization = "Basic " + new String(Base64.encode("cloud.admin:extra@4CraWleR")); 
}
