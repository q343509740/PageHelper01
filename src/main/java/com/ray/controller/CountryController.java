package com.ray.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ray.entity.Country;
import com.ray.service.CountryService;
import com.ray.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author Ray
 * @date 2018/6/2 0002
 */
@Controller //@Controller用于标注控制层组件（如struts中的action）
public class CountryController {

    @Autowired
    private CountryService countryService;

    private String page_list = "list"; //分页页面
    private String page_view = "view"; //修改页面
    private String redirect_list = "redirect:list"; //重定向,地址栏的url变成了新的url

    /**
     * 分页视图
     */
    @RequestMapping(value = {"list", "index", "index.html"})
    public ModelAndView getList(Country country,
                                @RequestParam(required = false, defaultValue = "1") int page,
                                @RequestParam(required = false, defaultValue = "10") int rows){
        ModelAndView modelAndView = new ModelAndView(page_list);
        // 执行查询操作
        List<Country> countryList = countryService.selectByCountryQueryModel(country, page, rows);
        // 使用参数名生成向模型添加属性
        modelAndView.addObject("pageInfo", new PageInfo<Country>(countryList)); // 分页控制(重点)
        modelAndView.addObject("country", country); // country对象
        modelAndView.addObject("page", page); // 页码
        modelAndView.addObject("rows", rows); // 行数
        return modelAndView;
    }

    /**
     * 修改视图
     */
    @RequestMapping(value = "view", method = RequestMethod.GET)
    public ModelAndView getView(Country country){
        ModelAndView modelAndView = new ModelAndView(page_view);
        if(country.getId() != null){
            // 查询操作
            country = countryService.selectByKey(country.getId());
        }
        // 使用参数名生成向模型添加属性
        modelAndView.addObject("country", country);
        return modelAndView;
    }

    /**
     * 新增视图
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public ModelAndView save(Country country){
        ModelAndView modelAndView = new ModelAndView(redirect_list);
        if(country.getId() != null){
            // 修改操作
            countryService.update(country);
        }else{
            // 新增操作
            countryService.insert(country);
        }
        return modelAndView;
    }

    /**
     * 删除操作
     */
    @RequestMapping(value = "delete")
    public String delete(Integer id){
        countryService.delete(id);
        return redirect_list;
    }
}
