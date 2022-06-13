package com.elmakers.tesla.bins;

public class Address {
    private String street;
    private String city;
    private String state;
    private String zip;
    private int countryId;
    private String country;
    private String region;

    public Address() {
    }

    public Address(String street, String city, String state, String zip, int countryId, String country, String region) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.countryId = countryId;
        this.country = country;
        this.region = region;
    }

    public String getStreet() {
        return this.street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return this.zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public int getCountryId() {
        return this.countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return this.region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}
