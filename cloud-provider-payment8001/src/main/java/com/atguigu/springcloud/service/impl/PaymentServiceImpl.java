package com.atguigu.springcloud.service.impl;


import com.atguigu.springcloud.dao.PaymentMapper;
import com.atguigu.springcloud.service.PaymentService;
import com.atguigu.springcloud.pojo.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class PaymentServiceImpl  implements PaymentService {

    @Resource
    private PaymentMapper paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(int id) {
        log.info("+"+id+"+");
        return paymentDao.getPaymentById(id);
    }
}
