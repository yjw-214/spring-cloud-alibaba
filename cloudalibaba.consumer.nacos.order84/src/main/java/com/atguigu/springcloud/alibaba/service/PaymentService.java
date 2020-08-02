package com.atguigu.springcloud.alibaba.service;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "nacos-payment-provider" )
public interface PaymentService {
}
