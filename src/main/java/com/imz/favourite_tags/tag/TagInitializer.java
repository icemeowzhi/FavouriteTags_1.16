package com.imz.favourite_tags.tag;


import java.util.ArrayList;

public class TagInitializer {
    private static final ArrayList<ITag> allTag = new ArrayList<>();

    public static ArrayList<ITag> getAllTag() {
        return allTag;
    }
}
