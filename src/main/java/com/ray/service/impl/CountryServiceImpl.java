package com.ray.service.impl;

import com.github.pagehelper.PageHelper;
import com.ray.dao.CountryDao;
import com.ray.entity.Country;
import com.ray.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Ray
 * @date 2018/6/2 0002
 */
@Service //@Service用于标注业务层组件
public class CountryServiceImpl implements CountryService {

    @Autowired //@Autowired按byType自动注入
    private CountryDao countryDao;

    @Override
    public Country selectByKey(Integer id) {
        return countryDao.selectByKey(id);
    }

    @Override
    public List<Country> selectByCountryQueryModel(Country country, int page, int rows) {
        // 分页查询,从第page页开始，每页显示rows条记录
        PageHelper.startPage(page, rows); 
        // 只有紧跟在 PageHelper.startPage 方法后的第一个 Mybatis 的查询（Select）方法会被分页(重点)
        return countryDao.selectByCountryQueryModel(country);
    }

    @Override
    public void insert(Country country) {
        countryDao.insert(country);
    }

    @Override
    public void update(Country country) {
        countryDao.update(country);
    }

    @Override
    public void delete(Integer id) {
        countryDao.delete(id);
    }
}
