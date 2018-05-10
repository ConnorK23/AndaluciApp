package es.vcarmen.andaluciapp;

/**
 * Created by conno on 20/04/2018.
 */

public class Monumento {
    private String imageUrlMin;
    private String imageUrlMax;
    private String name;
    private String address;
    private String province;
    private int postalcode;
    private String municipality;
    private String info;
    private double lat;
    private double lng;

    public Monumento() {
    }

    public Monumento(String imageUrlMin, String imageUrlMax, String name, String address, String province, int postalcode, String municipality, String info, double lat, double lng) {
        this.imageUrlMin = imageUrlMin;
        this.imageUrlMax = imageUrlMax;
        this.name = name;
        this.address = address;
        this.province = province;
        this.postalcode = postalcode;
        this.municipality = municipality;
        this.info = info;
        this.lat = lat;
        this.lng = lng;
    }

    public String getImageUrlMin() {
        return imageUrlMin;
    }

    public String getImageUrlMax() {
        return imageUrlMax;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getProvince() {
        return province;
    }

    public int getPostalcode() {
        return postalcode;
    }

    public String getMunicipality() {
        return municipality;
    }

    public String getInfo() {
        return info;
    }

    public double getLat() {
        return lat;
    }

    public double getLng() {
        return lng;
    }

    @Override
    public String toString() {
        return "Monumento{" +
                "imageUrlMin='" + imageUrlMin + '\'' +
                ", imageUrlMax='" + imageUrlMax + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", province='" + province + '\'' +
                ", postalcode=" + postalcode +
                ", municipality='" + municipality + '\'' +
                ", info='" + info + '\'' +
                ", lat=" + lat +
                ", lng=" + lng +
                '}';
    }
}
