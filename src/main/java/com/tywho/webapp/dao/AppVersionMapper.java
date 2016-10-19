package com.tywho.webapp.dao;

import com.tywho.webapp.pojo.AppVersion;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppVersionMapper {
    @Delete({
        "delete from app_version",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into app_version (apptype, clienttype, ",
        "appversion, funcdesc, ",
        "forceupdate, status, ",
        "packageurl, hashvalue, ",
        "tipnum, channel, ",
        "releasetime, offlinetime, ",
        "ctime, mtime)",
        "values (#{apptype,jdbcType=INTEGER}, #{clienttype,jdbcType=VARCHAR}, ",
        "#{appversion,jdbcType=VARCHAR}, #{funcdesc,jdbcType=VARCHAR}, ",
        "#{forceupdate,jdbcType=INTEGER}, #{status,jdbcType=INTEGER}, ",
        "#{packageurl,jdbcType=VARCHAR}, #{hashvalue,jdbcType=VARCHAR}, ",
        "#{tipnum,jdbcType=INTEGER}, #{channel,jdbcType=VARCHAR}, ",
        "#{releasetime,jdbcType=TIMESTAMP}, #{offlinetime,jdbcType=TIMESTAMP}, ",
        "#{ctime,jdbcType=TIMESTAMP}, #{mtime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(AppVersion record);

    int insertSelective(AppVersion record);

    @Select({
        "select",
        "id, apptype, clienttype, appversion, funcdesc, forceupdate, status, packageurl, ",
        "hashvalue, tipnum, channel, releasetime, offlinetime, ctime, mtime",
        "from app_version",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    AppVersion selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AppVersion record);

    @Update({
        "update app_version",
        "set apptype = #{apptype,jdbcType=INTEGER},",
          "clienttype = #{clienttype,jdbcType=VARCHAR},",
          "appversion = #{appversion,jdbcType=VARCHAR},",
          "funcdesc = #{funcdesc,jdbcType=VARCHAR},",
          "forceupdate = #{forceupdate,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "packageurl = #{packageurl,jdbcType=VARCHAR},",
          "hashvalue = #{hashvalue,jdbcType=VARCHAR},",
          "tipnum = #{tipnum,jdbcType=INTEGER},",
          "channel = #{channel,jdbcType=VARCHAR},",
          "releasetime = #{releasetime,jdbcType=TIMESTAMP},",
          "offlinetime = #{offlinetime,jdbcType=TIMESTAMP},",
          "ctime = #{ctime,jdbcType=TIMESTAMP},",
          "mtime = #{mtime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(AppVersion record);

    @Select({
            "select",
            "id, apptype, clienttype, appversion, funcdesc, forceupdate, status, packageurl, ",
            "hashvalue, tipnum, channel, releasetime, offlinetime, ctime, mtime",
            "from app_version"
    })
    @ResultMap("BaseResultMap")
    List<AppVersion> findAll();
}