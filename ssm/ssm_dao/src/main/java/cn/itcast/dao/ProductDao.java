package cn.itcast.dao;

import cn.itcast.domain.Product;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface ProductDao {
    /**
     * 查询所有产品
     * @return
     */
    @Select("select * from product")
    List<Product> findAll();
}
