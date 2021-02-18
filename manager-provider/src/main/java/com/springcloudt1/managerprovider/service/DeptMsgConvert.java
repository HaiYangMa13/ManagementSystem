package com.springcloudt1.managerprovider.service;

import com.rabbitmq.client.Channel;
import com.springcloudt1.managerapi.entity.Dept;
import com.springcloudt1.managerprovider.dao.DeptDao;
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
public class DeptMsgConvert {
    @Resource
    DeptDao dao;

    @RabbitListener(queues = "dept_add")
    public void add(Dept data, Message message, Channel channel) throws IOException {
        channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
        try {
            dao.insert(data);
        }catch (Exception e){
            channel.basicRecover(false);
        }

    }
    @RabbitListener(queues = "dept_del")
    public void del(int id,Message message, Channel channel) throws IOException {
        channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
        try {
            dao.deleteByPrimaryKey(id);
        }catch (Exception e){
            channel.basicRecover(false);
        }
    }
    @RabbitListener(queues = "dept_update")
    public void update(Dept data,Message message, Channel channel) throws IOException {
        channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
        try {
            dao.updateByPrimaryKey(data);
        }catch (Exception e){
            channel.basicRecover(false);
        }
    }
    @RabbitListener(queues = "dept_delAll")
    public void delAll(int[] records,Message message, Channel channel) throws IOException {
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
