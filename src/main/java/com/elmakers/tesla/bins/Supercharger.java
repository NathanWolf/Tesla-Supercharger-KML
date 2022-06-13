//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.elmakers.tesla.bins;

public class Supercharger {
    private int id;
    private String locationId;
    private String name;
    private String status;
    private Address address;
    private GPS gps;
    private String urlDiscuss;
    private int stallCount;
    private String hours;
    private boolean counted;
    private int elevationMeters;
    private String dateOpened;
    private String dateModified;

    public Supercharger() {
    }

    public Supercharger(int id, String locationId, String name, String status, Address address, GPS gps, String urlDiscuss, int stallCount, String hours, boolean counted, int elevationMeters, String dateOpened, String dateModified) {
        this.id = id;
        this.locationId = locationId;
        this.name = name;
        this.status = status;
        this.address = address;
        this.gps = gps;
        this.urlDiscuss = urlDiscuss;
        this.stallCount = stallCount;
        this.hours = hours;
        this.counted = counted;
        this.elevationMeters = elevationMeters;
        this.dateOpened = dateOpened;
        this.dateModified = dateModified;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocationId() {
        return this.locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Address getAddress() {
        return this.address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public GPS getGps() {
        return this.gps;
    }

    public void setGps(GPS gps) {
        this.gps = gps;
    }

    public String getUrlDiscuss() {
        return this.urlDiscuss;
    }

    public void setUrlDiscuss(String urlDiscuss) {
        this.urlDiscuss = urlDiscuss;
    }

    public int getStallCount() {
        return this.stallCount;
    }

    public void setStallCount(int stallCount) {
        this.stallCount = stallCount;
    }

    public String getHours() {
        return this.hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public boolean isCounted() {
        return this.counted;
    }

    public void setCounted(boolean counted) {
        this.counted = counted;
    }

    public int getElevationMeters() {
        return this.elevationMeters;
    }

    public void setElevationMeters(int elevationMeters) {
        this.elevationMeters = elevationMeters;
    }

    public String getDateOpened() {
        return this.dateOpened;
    }

    public void setDateOpened(String dateOpened) {
        this.dateOpened = dateOpened;
    }

    public String getDateModified() {
        return this.dateModified;
    }

    public void setDateModified(String dateModified) {
        this.dateModified = dateModified;
    }
}
