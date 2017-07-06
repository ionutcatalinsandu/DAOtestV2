package com.example.torridas.daotestv2.country.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Torridas on 06-Jul-17.
 */

@Entity
public class Country {

    @Id(autoincrement = true)
    private Long id;

    private String name;
    

    @Generated(hash = 668024697)
    public Country() {
    }

    public Country(Long id){
        this.id = id;
    }

    @Generated(hash = 1662620089)
    public Country(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {

        return id;
    }

    public String getName() {
        return name;
    }
}
