package com.smalljellybean.listingworks.domain;

import java.io.Serializable;

public class User implements Serializable{
    private String objectId;
    private String username;
    private String email;
    private String password;
    private String createdAt;
    private String updatedAt;
    private String sessionToken;

    public String getObjectId() {
        return objectId;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public String getSessionToken() {
        return sessionToken;
    }
}
