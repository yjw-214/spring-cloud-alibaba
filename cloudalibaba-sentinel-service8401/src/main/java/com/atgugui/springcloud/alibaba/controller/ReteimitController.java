package com.atgugui.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atgugui.springcloud.alibaba.myhandler.CustomerBlockHandler;
import com.atguigu.springcloud.pojo.CommonResult;
import com.atguigu.springcloud.pojo.Payment;
import org.springframework.web.bind.annotation.GetMapping;

public class ReteimitController {

    @GetMapping("/byResource")
    @SentinelResource(value = "byResource",blockHandler ="handIeException" )
    public CommonResult  byResource(){

        return  new CommonResult(200,"按资源名称限流测试ok",new Payment(2020,"serial001"));

    }


    public CommonResult handIeException(BlockException exception){

        return new CommonResult(444,exception.getClass().getCanonicalName()+"\t服务不可用");
    }

    @GetMapping("/rateLimit/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler",blockHandlerClass = CustomerBlockHandler.class,blockHandler = "handlerException")
    public CommonResult customerBlockHandler(){
        return new CommonResult(200,"按客户自定义",new Payment(200,"serial003"));
    }










}
