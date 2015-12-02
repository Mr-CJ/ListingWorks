package com.smalljellybean.listingworks.domain;


import org.joda.time.DateTime;

public class ListItem {
    String objectId;
    String name;
    String description;
    String createdAt;

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getObjectId() {
        return objectId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "ListItem{" +
                "objectId='" + objectId + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
