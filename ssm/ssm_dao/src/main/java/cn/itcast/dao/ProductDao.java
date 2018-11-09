package cn.itcast.dao;

import cn.itcast.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface ProductDao {
    /**
     * 查询所有产品
     * @return
     */
    @Select("select * from product")
    List<Product> findAll();

    /**
     * 保存产品
     * @param product
     */

    @Insert("insert into product(productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void saveProduct(Product product);

    @Select("select * from product where id =#{id}")
    Product findById(String id);
}
