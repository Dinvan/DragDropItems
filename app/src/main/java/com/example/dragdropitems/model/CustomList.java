package com.example.dragdropitems.model;
import java.io.Serializable;
public class CustomList implements Serializable {

    public static final long serialID = 1234L;
    public String id;
    public String name;
    public String address;
    public String mobile;
    public double lat;
    public double lng;
    public String estimatedTime;

    public CustomList() {
    }

    /**
     * @param id
     * @param estimatedTime
     * @param address
     * @param name
     * @param lng
     * @param lat
     * @param mobile
     */
    public CustomList(String id, String name, String address,
                      String mobile, double lat, double lng, String estimatedTime) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.mobile = mobile;
        this.lat = lat;
        this.lng = lng;
        this.estimatedTime = estimatedTime;
    }
}
