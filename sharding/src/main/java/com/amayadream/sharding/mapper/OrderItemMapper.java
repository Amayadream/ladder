package com.amayadream.sharding.mapper;

import com.amayadream.sharding.model.OrderItem;

import java.util.List;

/**
 * @author :  Amayadream
 * @date :  2017.11.06 22:23
 */
public interface OrderItemMapper {

    void createIfNotExistsTable();

    void truncateTable();

    Long insert(OrderItem model);

    void delete(Long orderItemId);

    List<OrderItem> selectAll();

    void dropTable();

}

