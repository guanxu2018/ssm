package cn.itcast.service.impl;

import cn.itcast.dao.RolesDao;
import cn.itcast.domain.Roles;
import cn.itcast.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RolesDao rolesDao;
    @Override
    public List<Roles> findAll() {
        List<Roles> list = rolesDao.findAll();
        return list;
    }

    @Override
    public void save(Roles roles) {
        rolesDao.save(roles);
    }
}
