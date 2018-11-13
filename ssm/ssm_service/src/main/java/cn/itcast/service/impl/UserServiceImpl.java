package cn.itcast.service.impl;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.Permission;
import cn.itcast.domain.Roles;
import cn.itcast.domain.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements cn.itcast.service.UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserInfo userInfo = userDao.login(username);
        User user=new User(userInfo.getUsername(),userInfo.getPassword(),getAuthority(userInfo.getRoles()));
        return user;
    }


    public List<SimpleGrantedAuthority> getAuthority(List<Roles> roles){

        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for (Roles role : roles) {
            list.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
            List<Permission> permission = role.getPermissions();
            for (Permission per : permission) {
                list.add(new SimpleGrantedAuthority(per.getPermissionName()));
            }
        }
        return list;
    }

    @Override
    public List<UserInfo> findAll() {
        List<UserInfo> list = userDao.findAll();
        return list;
    }

    @Override
    public void save(UserInfo userInfo) {
         userInfo.setPassword(bCryptPasswordEncoder.encode(userInfo.getPassword()));
        userDao.save(userInfo);
    }

    @Override
    public UserInfo show(String id) {
        UserInfo userInfo = userDao.show(id);
        return userInfo;
    }

    @Override
    public List<Roles> findListUserByRole(String userId) {
        List<Roles> list = userDao.findListUserByRole(userId);
        return list;
    }

    @Override
    public void userAddRole(String userId,String[] adss,String[] ads) {
        /*
        删除用户角色
         */
        if(adss.length!=0&&adss!=null){
            for (String s : adss) {
                userDao.delRole(userId,s);
            }
        }
         /*
        给用户添加角色
         */
        if(ads.length!=0&&ads!=null){
            for (String s : ads) {
                userDao.saveRole(userId,s);
            }
        }
    }


}
