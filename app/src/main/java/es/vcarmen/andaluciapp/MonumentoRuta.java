package es.vcarmen.andaluciapp;

/**
 * Created by conno on 19/05/2018.
 */

public class MonumentoRuta {
    private String name;
    private double lat;
    private double lng;
    private String imageUrlMin;

    public MonumentoRuta(String name, double lat, double lng, String imageUrlMin) {
        this.name = name;
        this.lat = lat;
        this.lng = lng;
        this.imageUrlMin = imageUrlMin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public String getImageUrlMin() {
        return imageUrlMin;
    }

    public void setImageUrlMin(String imageUrlMin) {
        this.imageUrlMin = imageUrlMin;
    }

    @Override
    public String toString() {
        return "MonumentoRuta{" +
                "name='" + name + '\'' +
                ", lat=" + lat +
                ", lng=" + lng +
                ", imageUrlMin='" + imageUrlMin + '\'' +
                '}';
    }
}
