package com.ray.test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ray.dao.CountryDao;
import com.ray.entity.Country;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author Ray
 * @date 2018/6/2 0002
 */

public class PageHelperTest extends BaseTest{

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CountryDao countryDao;

    @Test
    public void selectByKey(){

        Country country = countryDao.selectByKey(6);
        System.out.println(country);
    }
}
