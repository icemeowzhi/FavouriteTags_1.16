package com.imz.favourite_tags.util;


public class ARGBColor {
    public static int toInt(int r,int g,int b,int a) throws IllegalArgumentException{
        if ( r>255 || g>255 || b>255 || a>255 || r<0 || g<0 || b<0 || a<0){throw new IllegalArgumentException();}
        return (a<<24) | (r<<16) | (g<<8) | b;
    }

}
