package com.smalljellybean.listingworks.utils;

import com.smalljellybean.listingworks.R;
import com.smalljellybean.listingworks.domain.Catalogue;

import java.util.ArrayList;
import java.util.List;

public class CatalogueUtil {
    public static final List<Catalogue> catalogues = new ArrayList<>();

    static {
        catalogues.add(new Catalogue(R.drawable.film, "FILM", R.color.sienna, "Science Fiction", "Comedy", "Action", "Drama", "Cartoon"));
        catalogues.add(new Catalogue(R.drawable.book, "BOOK", R.color.saffron, "Science Fiction", "Poetry", "Fairy", "Painting", "Biography"));
        catalogues.add(new Catalogue(R.drawable.travel, "TRAVEL", R.color.green, "Photo", "Foods", "Travel Line", "Hotel", "Friends"));
        catalogues.add(new Catalogue(R.drawable.art, "ART", R.color.pink, "Painting", "Calligraphy", "Design", "Sculpture", "Photography"));
        catalogues.add(new Catalogue(R.drawable.music, "MUSIC", R.color.purple, "Rock", "Ballad", "Pure", "Love Song", "Heavy Metal"));
        catalogues.add(new Catalogue(R.drawable.technology, "TECHNOLOGY", R.color.orange, "Web", "Server", "Android", "iOS", "OS"));
        catalogues.add(new Catalogue(R.drawable.life, "LIFE", R.color.saffron, "Pets", "Friends", "Health", "Sport", "Kids"));
        catalogues.add(new Catalogue(R.drawable.activity, "ACTIVITY", R.color.green, "Community", "Volunteer", "Meeting", "Party", "KTV"));
    }
}
