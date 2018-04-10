package com.fsu.base.federationofsport.storage;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by yana on 10.04.18.
 */

@ConfigurationProperties("storage")
public class StorageProperties {

    /**
     * Folder location for storing files
     */
    private String location = "upload-dir";

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}