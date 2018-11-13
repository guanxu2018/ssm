package cn.itcast.service;

import cn.itcast.domain.Roles;
import cn.itcast.domain.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.userdetails.UserDetailsService;


import java.util.List;


public interface UserService extends UserDetailsService {

    List<UserInfo> findAll();

    void save(UserInfo userInfo);

    UserInfo show(String id);

    List<Roles> findListUserByRole(String userId);

    void userAddRole(String userId,String[] adss,String[] ads);
}
