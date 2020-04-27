package com.atguigu.springcloud.controller;


import com.atguigu.springcloud.pojo.CommonResult;
import com.atguigu.springcloud.pojo.Payment;
import com.atguigu.springcloud.service.PaymentService;


import jdk.internal.instrumentation.Logger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;
    @PostMapping(value = "/payment/create")
    public CommonResult create(Payment payment){

       int result = paymentService.create(payment);
       //System.out.println();
       log.info("******插入结果"+result);

       if(result>0){
           return  new CommonResult(200,"插入数据库成功",result);
       }else{
           return new CommonResult(444,"插入失败",null);
       }
   }


    @GetMapping(value = "/payment/ById/{id}")
    public CommonResult getPaymentById(@PathVariable("id") int id){

        Payment payment = paymentService.getPaymentById(id);
        //System.out.println();
        log.info("******插入结果"+payment);

        if(payment!=null){
            return  new CommonResult(200,"查询成功",payment);
        }else{
            return new CommonResult(444,"没有对应记录,查询id"+id,null);
        }
    }










}