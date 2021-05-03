package com.example.crm.citystate;

import java.util.List;

import lombok.Data;

@Data
public class object {
    List<Cities> cities;

    public object(List<Cities> cities) {
        this.cities = cities;
    }

    public List<Cities> getCities() {
        return cities;
    }

    public void setCities(List<Cities> cities) {
        this.cities = cities;
    }
}
