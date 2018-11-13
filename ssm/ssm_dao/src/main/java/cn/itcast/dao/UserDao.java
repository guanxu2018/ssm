package cn.itcast.dao;

import cn.itcast.domain.Roles;
import cn.itcast.domain.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserDao {

    @Select("select * from users where username=#{userName}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "email",column = "email"),
            @Result(property = "password",column = "password"),
            @Result(property = "phoneNum",column = "phoneNum"),
            @Result(property = "status",column = "status"),
            @Result(property = "roles",column = "id",many = @Many(select = "cn.itcast.dao.RolesDao.findById")),
    })
    UserInfo login(String userName);

    @Select("select * from users")
    List<UserInfo> findAll();

    @Insert("insert into users(username,email,password,phoneNum,status) values(#{username},#{email},#{password},#{phoneNum},#{status})")
    void save(UserInfo userInfo);

    @Select("select * from users where id =#{id}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "email",column = "email"),
            @Result(property = "password",column = "password"),
            @Result(property = "phoneNum",column = "phoneNum"),
            @Result(property = "status",column = "status"),
            @Result(property = "roles",column = "id",many = @Many(select = "cn.itcast.dao.RolesDao.findById")),
    })
    UserInfo show(String id);

    @Select("select role.*,ur.userid from role left join (select * from users_role  where users_role.userid=#{userId}) ur on role.id=ur.roleid")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "roleName",column = "roleName"),
            @Result(property = "roleDesc",column = "roleDesc"),
            @Result(property = "users.id",column = "userId")
    })
    List<Roles> findListUserByRole(String userId);

    @Delete("delete from users_role where userId=#{userId} and roleId =#{roleId} ")
    void delRole(@Param(value = "userId") String userId,@Param(value = "roleId") String roleId);

    @Insert("insert into users_role(userId,roleId) values (#{userId},#{roleId})")
    void saveRole(@Param(value = "userId") String userId,@Param(value = "roleId") String roleId);
}
