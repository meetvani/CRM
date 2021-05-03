package com.example.crm.citystate;

import lombok.Data;

@Data
public class Cities {
    String City;
    String State;

    public Cities(String city, String state) {
        City = city;
        State = state;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }
}
