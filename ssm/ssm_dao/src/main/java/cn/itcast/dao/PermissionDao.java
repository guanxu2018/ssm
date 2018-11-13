package cn.itcast.dao;

import cn.itcast.domain.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PermissionDao {

    @Select("select* from permission where id in (select R.PERMISSIONID  from ROLE_PERMISSION R where roleId =#{roleId} )")
    List<Permission> findById(String roleId);
    @Select("select * from permission")
    List<Permission> findAll();

    @Insert("insert into permission(permissionname,url) values(#{permissionName},#{url})")
    void save(Permission permission);
}
