package cn.itcast.dao;

import cn.itcast.domain.SysLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SysLogDao {

    @Insert("insert into syslog(userName,visitTime,ip,url,executionTime,method) values(#{userName},#{visitTime},#{ip},#{url},#{executionTime},#{method})")
    void saveSysLog(SysLog sysLog);

    @Select("select * from syslog")
    List<SysLog> findAll();
}
