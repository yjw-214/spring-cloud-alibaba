package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringCloudApplication
@EnableEurekaServer
public class EurekaMain7003 {

        public static void main(String[] args) {
            SpringApplication.run(EurekaMain7003.class,args);
        }

}
