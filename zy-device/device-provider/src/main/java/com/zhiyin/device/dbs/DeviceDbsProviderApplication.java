package com.zhiyin.device.dbs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

//@EnableEurekaClient
@SpringBootApplication
//@EnableAutoConfiguration(exclude={DubboAutoConfiguration.class})
public class DeviceDbsProviderApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(DeviceDbsProviderApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(DeviceDbsProviderApplication.class, args);
    }

}

