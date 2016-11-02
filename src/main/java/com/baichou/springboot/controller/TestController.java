package com.baichou.springboot.controller;/**
 * Created by root on 16-11-2.
 * <p>
 * 多数据源测试控制类
 *
 * @author zyang0419
 * @create 2016-11-02 下午2:37
 **/

/**
 * 多数据源测试控制类
 *
 * @author zyang0419
 * @create 2016-11-02 下午2:37
 **/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;


@RestController
public class TestController {


//没有指定为主数据源.
    @Autowired
    @Qualifier("primaryDataSource")
    private DataSource dataSource;


    @Autowired
    @Qualifier("thirdDataSource")
    private DataSource dataSource1;


    @Autowired
    @Qualifier("secondaryDataSource")
    private DataSource dataSource2;


    @Autowired
    @Qualifier("primaryJdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Autowired
    @Qualifier("secondaryJdbcTemplate")
    private JdbcTemplate jdbcTemplate2;



    @RequestMapping("/get")
    public String get() {
        //观察控制台的打印信息.
        System.out.println(dataSource);
        return "ok";

    }


    @RequestMapping("/get1")
    public String get1() {
        //观察控制台的打印信息.
        System.out.println(dataSource1);
        return "ok.1";

    }


    @RequestMapping("/get2")
    public String get2() {
        //观察控制台的打印信息.
        System.out.println(dataSource2);
        return "ok.2";

    }






}