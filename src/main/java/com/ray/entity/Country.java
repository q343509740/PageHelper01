package com.ray.entity;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Ray
 * @date 2018/6/2 0002
 */
public class Country {

    private Integer id; //ID
    private String countryname; //国家(地区)名
    private String countrycode; //国家(地区)代码

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", countryname='" + countryname + '\'' +
                ", countrycode='" + countrycode + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCountryname() {
        return countryname;
    }

    public void setCountryname(String countryname) {
        this.countryname = countryname;
    }

    public String getCountrycode() {
        return countrycode;
    }

    public void setCountrycode(String countrycode) {
        this.countrycode = countrycode;
    }
}
