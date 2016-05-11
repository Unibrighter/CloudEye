package com.beans;

/**
 * 
 * @author Team 2 CloudEye
 * 
 *         COMP90024
 *
 */
public class GeoCircle {

    private double latitude;
    private double longitude;
    private double radius;

    public GeoCircle(double latitude, double longitude, double radius) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.radius = radius;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getRadius() {
        return radius;
    }
}
