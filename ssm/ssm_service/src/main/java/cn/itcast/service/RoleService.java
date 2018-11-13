package cn.itcast.service;

import cn.itcast.domain.Roles;

import java.util.List;

public interface RoleService {
    List<Roles> findAll();
    void save(Roles roles);
}
