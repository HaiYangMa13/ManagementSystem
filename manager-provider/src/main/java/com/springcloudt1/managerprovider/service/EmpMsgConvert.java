package com.springcloudt1.managerprovider.service;

import com.rabbitmq.client.Channel;
import com.springcloudt1.managerapi.entity.Emp;
import com.springcloudt1.managerprovider.dao.DeptDao;
import com.springcloudt1.managerprovider.dao.EmpDao;
import com.springcloudt1.managerprovider.dao.RoleinfoDao;
import com.springcloudt1.managerprovider.utils.RedisUtils;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class EmpMsgConvert {
    @Resource
    EmpDao dao;

    @RabbitListener(queues = "emp_add")
    public void add (Emp data, Message message, Channel channel) throws IOException {
        channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
        try {
            data.setPwd("111111");
            dao.insert(data);
        }catch (Exception e){
            channel.basicRecover(false);
        }
    }
    @RabbitListener(queues = "emp_del")
    public void del (int id,Message message, Channel channel) throws IOException {
        channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
        try {
            dao.deleteByPrimaryKey(id);
        }catch (Exception e){
            channel.basicRecover(false);
        }
    }
    @RabbitListener(queues = "emp_update")
    public void update (Emp data,Message message, Channel channel) throws IOException {
        channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
        try {
            dao.updateByPrimaryKey(data);
        }catch (Exception e){
            channel.basicRecover(false);
        }
    }

    @RabbitListener(queues = "emp_delAll")
    public void dellAll(int[] records,Message message, Channel channel) throws IOException {
        channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
        try {
            for (int id : records) {
                dao.deleteByPrimaryKey(id);
            }
        }catch (Exception e){
            channel.basicRecover(false);
        }
    }

}
