package cn.itcast.dao;

import cn.itcast.domain.Roles;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RolesDao {

    @Select("select r.* from ROLE r where r.ID in (select ur.ROLEID from USERS_ROLE ur where ur.USERID= #{id})")
    List<Roles> findById(String id);
}
