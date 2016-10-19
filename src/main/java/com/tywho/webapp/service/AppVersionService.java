package com.tywho.webapp.service;

import com.tywho.webapp.pojo.AppVersion;

import java.util.List;

/**
 * Created by litianyi on 2016/07/12, 0012.
 */
public interface AppVersionService {
    public List<AppVersion> findAll();

    public int deleteByPrimaryKey(Integer id);

    public int insert(AppVersion record);

    public int insertSelective(AppVersion record);

    public AppVersion selectByPrimaryKey(Integer id);

    public int updateByPrimaryKeySelective(AppVersion record);

    public int updateByPrimaryKey(AppVersion record);
}
