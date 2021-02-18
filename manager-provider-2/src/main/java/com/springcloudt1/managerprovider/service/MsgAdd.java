package com.springcloudt1.managerprovider.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MsgAdd {
    @Autowired
   private AmqpTemplate amqpTemplate;
    public void convertObj(String ex,String key,Object data){
        amqpTemplate.convertAndSend(ex,key,data);
    }
}
