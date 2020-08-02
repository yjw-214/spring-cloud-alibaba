package com.atgugui.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.pojo.CommonResult;
import com.atguigu.springcloud.pojo.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class FlowLimitController {



    @GetMapping("/testA")
    public String testA() {
      /*  try {
            TimeUnit.SECONDS.sleep(1);

        }catch (InterruptedException e){
            e.printStackTrace();
        }*/
        System.out.println("111");
        return "-------testA";
    }

    @GetMapping("/testB")
    public String testB() {
        return "-------testB";
    }



    @GetMapping("/testE")
    public String testE(){
        int age = 10/0;
        return "========testE";
    }



    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotkey",blockHandler = "deal_testHotKey",fallback = "handlerFallback")
    public String testHotkey(@RequestParam(value = "p1",required = false) String p1,
                             @RequestParam(value = "p2",required = false)String p2){
        return "-----------testHotKey";
    }



    public String deal_testHotKey(String p1,String p2,BlockException exception) {

        return "-----------deal_testHotKey,o(╥﹏╥)o";

    }
    public CommonResult handlerFallback(@RequestParam(value = "p1",required = false) String p1,
                                        @RequestParam(value = "p2",required = false)String p2,Throwable e){

        return new CommonResult(444,"兜底异常handlerFallback,exception内容"+e.getMessage());
    }
}
