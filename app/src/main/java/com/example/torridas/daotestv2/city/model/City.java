package com.example.torridas.daotestv2.city.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Torridas on 06-Jul-17.
 */


@Entity
public class City {

    @Id(autoincrement = true)
    private Long id;

    private String name;

    @NotNull
    private Long countryOfProvenience;



    @Generated(hash = 750791287)
    public City() {
    }

    @Generated(hash = 1613983339)
    public City(Long id, String name, @NotNull Long countryOfProvenience) {
        this.id = id;
        this.name = name;
        this.countryOfProvenience = countryOfProvenience;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountryOfProvenience(Long countryOfProvenience) {
        this.countryOfProvenience = countryOfProvenience;
    }

    public Long getId() {

        return id;
    }

    public String getName() {
        return name;
    }

    public Long getCountryOfProvenience() {
        return countryOfProvenience;
    }
}
