package com.ray.service;

import com.ray.entity.Country;

import java.util.List;

/**
 * @author Ray
 * @date 2018/6/2 0002
 */
public interface CountryService {

    Country selectByKey(Integer id);
    List<Country> selectByCountryQueryModel(Country country, int page, int rows);
    void insert(Country country);
    void update(Country country);
    void delete(Integer id);
}
