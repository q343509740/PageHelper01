package com.ray.dao;

import com.ray.entity.Country;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author Ray
 * @date 2018/6/2 0002
 */
public interface CountryDao{

    /**
     * 查询所有国家信息
     */
    List<Country> selectByCountryQueryModel(Country country);

    /**
     * 根据id查询所有国家信息
     */
    Country selectByKey(@Param("id") Integer id);

    /**
     * 修改国家信息
     */
    void update(Country country);

    /**
     * 新增国家信息
     */
    void insert(Country country);

    /**
     * 删除国家信息
     */
    void delete(@Param("id") Integer id);
}
