package com.amayadream.sharding.mapper;

import com.amayadream.sharding.model.Order;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author :  Amayadream
 * @date :  2017.11.06 22:22
 */
@Mapper
public interface OrderMapper {

    void createIfNotExistsTable();

    void truncateTable();

    Long insert(Order model);

    void delete(Long orderId);

    void dropTable();

}
