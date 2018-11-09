package cn.itcast.dao;

import cn.itcast.domain.Member;
import cn.itcast.domain.Orders;
import cn.itcast.domain.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface OrdersDao {
    @Select("select * from orders")
    @Results({
            @Result(id = true , column = "id",property = "id"),
            @Result(column = "orderNum",property = "orderNum"),
            @Result(column = "orderTime",property = "orderTime"),
            @Result(column = "orderStatus",property = "orderStatus"),
            @Result(column = "peopleCount",property = "peopleCount"),
            @Result(column = "payType",property = "payType"),
            @Result(column = "orderDesc",property = "orderDesc"),
            @Result(column = "productId",property = "product",javaType = Product.class,one = @One(select = "cn.itcast.dao.ProductDao.findById")),
    })
    List<Orders> findAll();

    /**
     * 订单详情
     * @param id
     * @return
     */
    @Select("select * from orders where id =#{id}")
    @Results({
            @Result(id = true , column = "id",property = "id"),
            @Result(column = "orderNum",property = "orderNum"),
            @Result(column = "orderTime",property = "orderTime"),
            @Result(column = "orderStatus",property = "orderStatus"),
            @Result(column = "peopleCount",property = "peopleCount"),
            @Result(column = "payType",property = "payType"),
            @Result(column = "orderDesc",property = "orderDesc"),
            @Result(column = "productId",property = "product",javaType = Product.class,one = @One(select = "cn.itcast.dao.ProductDao.findById")),
            @Result(column = "memberId",property = "member",javaType = Member.class,one = @One(select = "cn.itcast.dao.MemberDao.findById")),
            @Result(column = "id",property = "travellers",many = @Many(select = "cn.itcast.dao.TravellerDao.findById"))
    })
    Orders findById(String id);
}
