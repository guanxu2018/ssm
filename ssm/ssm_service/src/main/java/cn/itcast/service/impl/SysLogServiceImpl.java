package cn.itcast.service.impl;

import cn.itcast.dao.SysLogDao;
import cn.itcast.domain.SysLog;
import cn.itcast.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysLogServiceImpl implements SysLogService {

    @Autowired
    private SysLogDao sysLogDao;
    @Override
    public void saveSysLog(SysLog sysLog) {
        sysLogDao.saveSysLog(sysLog);
    }

    @Override
    public List<SysLog> findAll() {
        List<SysLog> list = sysLogDao.findAll();
        return list;
    }
}
