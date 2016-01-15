package com.smalljellybean.listingworks.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Catalogue {
    private int imageResId;
    private String name;
    private int background;
    private List<String> categories = new ArrayList<>();

    public Catalogue(int imageResId, String name, int background, String... interest) {
        this.imageResId = imageResId;
        this.name = name;
        this.background = background;
        categories.addAll(Arrays.asList(interest));
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getName() {
        return name;
    }

    public int getBackground() {
        return background;
    }

    public List<String> getCategories() {
        return categories;
    }
}
