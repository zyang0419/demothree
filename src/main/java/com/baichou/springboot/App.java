package com.baichou.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@SpringBootApplication(scanBasePackages = {
        "com.baichou"
})
@RestController  //等价于@Controller 和 @ResponseBody
@ServletComponentScan//这个就是扫描相应的Servlet包;
//注册动态多数据源
//@Import({DynamicDataSourceRegister.class})//引入不在APP包以及子包中的类，或者未交给spring容器管理的类.或者通过@Bean注入
public class App extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(App.class);
        app.run(args);
        //SpringApplication.run(Application.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(App.class);
    }
}