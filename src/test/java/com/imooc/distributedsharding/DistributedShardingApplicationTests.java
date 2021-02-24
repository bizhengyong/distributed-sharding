package com.imooc.distributedsharding;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Random;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class DistributedShardingApplicationTests {

//    @Test
//    void contextLoads() {
//    }

    @Autowired
    private OrderDao orderDao;

    @Test
    public void insert(){
        OrderEntity orderEntity = new OrderEntity();
//        orderEntity.setOrderId(System.currentTimeMillis());
        orderEntity.setUserId(new Random().nextInt(999));
        orderDao.save(orderEntity);
    }

    @Test
    public void findByOrderId(){
        OrderEntity byOrderId = orderDao.findByOrderId(571081152908472320L);
        log.info("byOrderId={}",byOrderId);
    }

    @Test
    public void findByUserId(){
        List<OrderEntity> byUserId = orderDao.findByUserId(394);
        log.info("byUserId={}",byUserId);
    }

    @Test
    public void update() {
        OrderEntity byOrderId = orderDao.findByOrderId(571443121222037504L);
        log.info("byOrderId={}", byOrderId);
        byOrderId.setUserId(999);
        orderDao.save(byOrderId);
    }
}
