package com.resource;

/**
 * 
 * @author Team 2 CloudEye
 * 
 *         COMP90024
 *
 */
public enum GeoType {

    Inner_Rct("search for the Inner of the melbourne as a rectangle"),

    East_Rct("search for the East of the melbourne as a rectangle"),

    West_Rct("search for the West of the melbourne as a rectangle"),

    North_Rct("search for the North of the melbourne as a rectangle"),

    Inner_Cir("search for the Inner of the melbourne as a circle"),

    East_Cir("search for the East of the melbourne as a circle"),

    West_Cir("search for the West of the melbourne as a circle"),

    North_Cir("search for the North of the melbourne as a circle");

    private String description;

    GeoType(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}
