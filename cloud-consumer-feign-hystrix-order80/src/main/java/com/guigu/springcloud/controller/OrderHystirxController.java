package com.guigu.springcloud.controller;


import com.guigu.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
//@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class OrderHystirxController {

    @Resource
    private PaymentHystrixService paymentHystrixService;


    @GetMapping(value = "/consumer/payment/hystrix/OK/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id){
        return paymentHystrixService.paymentInfo_OK(id);
    }

    @GetMapping(value = "/consumer/payment/hystrix/timeout/{id}")
 /*   @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties =
    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")
    )*/
  //  @HystrixCommand
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id){
       // int num = 100/0;
        String result = paymentHystrixService.paymentInfo_TimeOut(id);
        return result;
    }



    public String paymentInfo_TimeOutHandler(Integer id){

        return "线程池:"+Thread.currentThread().getName()+"系统繁忙或者运行报错，请稍后再试,o(╥﹏╥)o";

    }

    public String payment_Global_FallbackMethod(){
        return "Global 异常处理信息，请稍后再试 o(╥﹏╥)o";
    }
}
