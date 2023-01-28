package com.team.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Player {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    private String country;
    private String role;
    @JsonProperty(value ="price-in-crores")
    private String price;



}
