package com.resource;

import com.beans.GeoCircle;

public class GeoResource {

    private double[][] area;
    private GeoCircle circle;

    public double[][] getArea() {
        return area;
    }

    public GeoResource setArea(double[][] area) {
        this.area = area;
        return this;
    }

    public GeoCircle getCircle() {
        return circle;
    }

    public GeoResource setCircle(GeoCircle circle) {
        this.circle = circle;
        return this;
    }
}
