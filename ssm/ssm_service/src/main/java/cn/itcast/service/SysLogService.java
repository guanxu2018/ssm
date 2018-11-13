package cn.itcast.service;

import cn.itcast.domain.SysLog;

import java.util.List;

public interface SysLogService {
    void saveSysLog(SysLog sysLog);

    List<SysLog> findAll();
}
