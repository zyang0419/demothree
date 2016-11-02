package com.baichou.springboot.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.baichou.springboot.model.Group;
import com.baichou.springboot.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;


/**
 * fastjson测试控制器
 *
 * @author zyang0419
 * @create 2016-11-02 下午5:23
 **/
@RestController
@RequestMapping("/fastjson")
public class JsonController {

    @RequestMapping("/beanToJson")
    public String beanToJson(){
        Group group = new Group();
        group.setId(0L);
        group.setName("admin");

        User guestUser = new User();
        guestUser.setId(2L);
        guestUser.setName("guest");

        User rootUser = new User();
        rootUser.setId(3L);
        rootUser.setName("root");

        group.addUser(guestUser);
        group.addUser(rootUser);

        String jsonString = JSON.toJSONString(group);
        return jsonString;
    }

    @RequestMapping("jsonToBean")
    public String jsonToBean(){
        String jsonString = "{\"id\":0,\"name\":\"admin\",\"users\":[{\"id\":2,\"name\":\"guest\"},{\"id\":3,\"name\":\"root\"}]}\n";
        Group group = JSON.parseObject(jsonString, Group.class);
        System.out.println(group.toString());
        return "json to bean successfully";
    }

    @RequestMapping("listToJson")
    public String listToJson(){
        List<User> list = new ArrayList<User>();
        User user = new User();
        user.setId(1L);
        user.setName("A");
        list.add(user);
        user = new User();
        user.setId(2L);
        user.setName("B");
        list.add(user);

        String jsonString = JSON.toJSONString(list,true);
        return jsonString;
    }

    @RequestMapping("complexToJson")
    public String complexToJson(){
        // 复杂数据类型
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("username", "zhangsan");
            map.put("age", 24);
            map.put("sex", "男");

            // map集合
            HashMap<String, Object> temp = new HashMap<String, Object>();
            temp.put("name", "xiaohong");
            temp.put("age", "23");
            map.put("girlInfo", temp);

            // list集合
            List<String> list = new ArrayList<String>();
            list.add("爬山");
            list.add("骑车");
            list.add("旅游");
            map.put("hobby", list);
            String jsonString = JSON.toJSONString(map);
            return jsonString;
        //    System.out.println("复杂数据类型:" + jsonString);

    }

    @RequestMapping("dateToJson")
    public String dateToJson(){
//        LocalDateTime date = LocalDateTime.now();
        Date date = new Date();
        System.out.println("输出毫秒值：" + JSON.toJSONString(date));
        System.out.println("默认格式为:"
                + JSON.toJSONString(date,
                SerializerFeature.WriteDateUseDateFormat));
        System.out.println("localDateTime:"+
                JSON.toJSONStringWithDateFormat(LocalDateTime.now(), "yyyy-MM-dd HH:mm:ss.SSS"));

        String jsonString = JSON.toJSONStringWithDateFormat(date, "yyyy-MM-dd",
                SerializerFeature.WriteDateUseDateFormat);
        System.out.println("自定义日期："
                +jsonString);


        return jsonString;
    }
}
