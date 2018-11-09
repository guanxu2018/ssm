package cn.itcast.dao;

import cn.itcast.domain.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TravellerDao {
    /**
     * 根据ordersId查询旅客
     * @return
     */
    @Select("select t1.* \n" +
            "from TRAVELLER t1 ,\n" +
            "(select  o.TRAVELLERID from ORDER_TRAVELLER o where orderid=#{id}) t2\n" +
            "where t1.ID=t2.TRAVELLERID")
    List<Traveller> findById(String id);
}
