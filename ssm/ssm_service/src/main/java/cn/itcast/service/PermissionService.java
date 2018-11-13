package cn.itcast.service;

import cn.itcast.domain.Permission;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PermissionService {
    List<Permission> findAll();

    public void save(Permission permission);
}
