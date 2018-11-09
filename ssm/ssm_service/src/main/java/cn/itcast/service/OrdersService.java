package cn.itcast.service;

import cn.itcast.dao.OrdersDao;
import cn.itcast.domain.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface OrdersService {

    List<Orders> findAll(int pageNum,int pageSize);

    /**
     * 订单详情
     * @param id
     * @return
     */
    Orders findById(String id);

}
