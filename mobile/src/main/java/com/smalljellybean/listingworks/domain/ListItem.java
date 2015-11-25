package com.smalljellybean.listingworks.domain;


public class ListItem {
    String objectId;
    String name;
    String description;

    @Override
    public String toString() {
        return String.format("objectId: %s;name: %s;description: %s", objectId, name, description);
    }
}
