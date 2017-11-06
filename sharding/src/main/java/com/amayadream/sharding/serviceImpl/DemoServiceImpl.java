package com.amayadream.sharding.serviceImpl;

import com.amayadream.sharding.mapper.OrderItemMapper;
import com.amayadream.sharding.mapper.OrderMapper;
import com.amayadream.sharding.model.Order;
import com.amayadream.sharding.model.OrderItem;
import com.amayadream.sharding.service.DemoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author :  Amayadream
 * @date :  2017.11.06 22:24
 */
@Service
public class DemoServiceImpl implements DemoService {

    @Resource
    private OrderMapper orderMapper;

    @Resource
    private OrderItemMapper orderItemMapper;

    @Override
    public void demo() {
        orderMapper.createIfNotExistsTable();
        orderItemMapper.createIfNotExistsTable();
        orderMapper.truncateTable();
        orderItemMapper.truncateTable();
        List<Long> orderIds = new ArrayList<>(10);
        System.out.println("1.Insert--------------");
        for (int i = 0; i < 10; i++) {
            Order order = new Order();
            order.setUserId(1L);
            order.setStatus(1);
            orderMapper.insert(order);
            long orderId = order.getId();
            orderIds.add(orderId);

            OrderItem item = new OrderItem();
            item.setOrderId(orderId);
            item.setUserId(1L);
            item.setStatus(1);
            orderItemMapper.insert(item);
        }
        System.out.println(orderItemMapper.selectAll());
        System.out.println("2.Delete--------------");
        for (Long each : orderIds) {
            orderMapper.delete(each);
            orderItemMapper.delete(each);
        }
        System.out.println(orderItemMapper.selectAll());
        orderItemMapper.dropTable();
        orderMapper.dropTable();
    }

}
