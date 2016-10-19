package com.tywho.webapp.service.impl;

import com.tywho.webapp.dao.AppVersionMapper;
import com.tywho.webapp.pojo.AppVersion;
import com.tywho.webapp.service.AppVersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by litianyi on 2016/07/13, 0013.
 */
@Service
public class AppVersionServiceImpl implements AppVersionService {
    @Autowired
    private AppVersionMapper appVersionMapper;

    public List<AppVersion> findAll() {
        return appVersionMapper.findAll();
    }

    public int deleteByPrimaryKey(Integer id) {
        return appVersionMapper.deleteByPrimaryKey(id);
    }

    public int insert(AppVersion record) {
        return appVersionMapper.insert(record);
    }

    public int insertSelective(AppVersion record) {
        return appVersionMapper.insertSelective(record);
    }

    public AppVersion selectByPrimaryKey(Integer id) {
        return appVersionMapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(AppVersion record) {
        return appVersionMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(AppVersion record) {
        return appVersionMapper.updateByPrimaryKey(record);
    }
}
