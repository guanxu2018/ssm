package cn.itcast.dao;

import cn.itcast.domain.Roles;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface RolesDao {

    @Select("select r.* from ROLE r where r.ID in (select ur.ROLEID from USERS_ROLE ur where ur.USERID= #{id})")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "roleName",column = "roleName"),
            @Result(property = "roleDesc",column = "roleDesc"),
            @Result(property = "permissions",column = "id",many = @Many(select = "cn.itcast.dao.PermissionDao.findById"))
    })
    List<Roles> findById(String id);

    @Select("select * from role")
    List<Roles> findAll();

    @Insert("insert into role(roleName,roleDesc) values(#{roleName},#{roleDesc})")
    void save(Roles roles);
}
