package com.example.torridas.daotestv2.city.model;

import com.example.torridas.daotestv2.country.model.Country;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.DaoException;
import com.example.torridas.daotestv2.country.model.CountryDao;

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

    @ToOne(joinProperty = "id")
    private Country country;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 448079911)
    private transient CityDao myDao;

    @Generated(hash = 1591299782)
    private transient Long country__resolvedKey;


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

    /** To-one relationship, resolved on first access. */
    @Generated(hash = 1528699633)
    public Country getCountry() {
        Long __key = this.id;
        if (country__resolvedKey == null || !country__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            CountryDao targetDao = daoSession.getCountryDao();
            Country countryNew = targetDao.load(__key);
            synchronized (this) {
                country = countryNew;
                country__resolvedKey = __key;
            }
        }
        return country;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1814181214)
    public void setCountry(Country country) {
        synchronized (this) {
            this.country = country;
            id = country == null ? null : country.getId();
            country__resolvedKey = id;
        }
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 293508440)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getCityDao() : null;
    }
    //changes
}
