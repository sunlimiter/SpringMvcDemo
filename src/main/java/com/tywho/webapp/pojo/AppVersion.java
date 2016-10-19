package com.tywho.webapp.pojo;

import java.util.Date;

public class AppVersion {
    private Integer id;

    private Integer apptype;

    private String clienttype;

    private String appversion;

    private String funcdesc;

    private Integer forceupdate;

    private Integer status;

    private String packageurl;

    private String hashvalue;

    private Integer tipnum;

    private String channel;

    private Date releasetime;

    private Date offlinetime;

    private Date ctime;

    private Date mtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getApptype() {
        return apptype;
    }

    public void setApptype(Integer apptype) {
        this.apptype = apptype;
    }

    public String getClienttype() {
        return clienttype;
    }

    public void setClienttype(String clienttype) {
        this.clienttype = clienttype == null ? null : clienttype.trim();
    }

    public String getAppversion() {
        return appversion;
    }

    public void setAppversion(String appversion) {
        this.appversion = appversion == null ? null : appversion.trim();
    }

    public String getFuncdesc() {
        return funcdesc;
    }

    public void setFuncdesc(String funcdesc) {
        this.funcdesc = funcdesc == null ? null : funcdesc.trim();
    }

    public Integer getForceupdate() {
        return forceupdate;
    }

    public void setForceupdate(Integer forceupdate) {
        this.forceupdate = forceupdate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPackageurl() {
        return packageurl;
    }

    public void setPackageurl(String packageurl) {
        this.packageurl = packageurl == null ? null : packageurl.trim();
    }

    public String getHashvalue() {
        return hashvalue;
    }

    public void setHashvalue(String hashvalue) {
        this.hashvalue = hashvalue == null ? null : hashvalue.trim();
    }

    public Integer getTipnum() {
        return tipnum;
    }

    public void setTipnum(Integer tipnum) {
        this.tipnum = tipnum;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel == null ? null : channel.trim();
    }

    public Date getReleasetime() {
        return releasetime;
    }

    public void setReleasetime(Date releasetime) {
        this.releasetime = releasetime;
    }

    public Date getOfflinetime() {
        return offlinetime;
    }

    public void setOfflinetime(Date offlinetime) {
        this.offlinetime = offlinetime;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public Date getMtime() {
        return mtime;
    }

    public void setMtime(Date mtime) {
        this.mtime = mtime;
    }
}