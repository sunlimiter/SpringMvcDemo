package com.tywho.webapp.controller;

import com.tywho.webapp.pojo.AppVersion;
import com.tywho.webapp.service.AppVersionService;
import com.tywho.webapp.utils.Md5Utils;
import com.tywho.webapp.utils.apkUtil.ApkUtil;
import com.tywho.webapp.utils.apkUtil.bean.ApkInfo;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by litianyi on 2016/07/12, 0012.
 */
@Controller
public class FileController {
    private String apkFilePath = "/upload/apks/";
    @Resource
    private AppVersionService appVersionService;

    @RequestMapping(value = "/apps", method = RequestMethod.GET)
    public String apps(ModelMap modelMap) {
        List<AppVersion> appVersionList = this.appVersionService.findAll();
        modelMap.addAttribute("appList", appVersionList);
        return "uploadManager";
    }

    @RequestMapping(value = "/addapp", method = RequestMethod.GET)
    public String upload() {
        return "addApp";
    }

    @RequestMapping(value = "/upload.do", method = {RequestMethod.POST, RequestMethod.GET})
    public String addApp(HttpServletRequest request, AppVersion appVersion, @RequestParam("uploadFile") MultipartFile tmpFile) {
        // MultipartFile是对当前上传的文件的封装，当要同时上传多个文件时，可以给定多个MultipartFile参数(数组)
        if (!tmpFile.isEmpty()) {

            try {
                String type = tmpFile.getOriginalFilename().substring(tmpFile.getOriginalFilename().lastIndexOf("."));// 取文件格式后缀名
                String filename = System.currentTimeMillis() + type;// 取当前时间戳作为文件名
                String path = request.getSession().getServletContext().getRealPath(apkFilePath + filename);// 存放位置
                File destFile = new File(path);

                // FileUtils.copyInputStreamToFile()这个方法里对IO进行了自动操作，不需要额外的再去关闭IO流
                FileUtils.copyInputStreamToFile(tmpFile.getInputStream(), destFile);// 复制临时文件到指定目录下
                appVersion.setHashvalue(Md5Utils.getFileMd5(destFile));

                ApkInfo apkInfo = ApkUtil.getApkInfo(path);
                appVersion.setChannel(apkInfo.getChannel());
                appVersion.setAppversion(apkInfo.getVersionName());

                String basePath = request.getScheme() + "://"
                        + request.getServerName() + ":" + request.getServerPort()
                        + request.getContextPath() + apkFilePath + filename;
                appVersion.setCtime(new Date());
                appVersion.setPackageurl(basePath);
                appVersionService.insert(appVersion);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            appVersion.setPackageurl("");
        }

        return "redirect:/apps";
    }


    @RequestMapping(value = "/deleteApp/{appId}", method = RequestMethod.GET)
    public String deleteApp(@PathVariable("appId") Integer appId) {
        this.appVersionService.deleteByPrimaryKey(appId);
        return "redirect:/apps";
    }

    @RequestMapping(value = "/showApp/{appId}", method = RequestMethod.GET)
    public String showApp(@PathVariable("appId") Integer appId, ModelMap modelMap) {
        AppVersion appVersion = this.appVersionService.selectByPrimaryKey(appId);
        modelMap.addAttribute("appversion", appVersion);
        return "appDetail";
    }

    @RequestMapping(value = "/showAppJson/{appId}", method = RequestMethod.GET)
    @ResponseBody
    public AppVersion showApp(@PathVariable("appId") Integer appId) {
        AppVersion appVersion = this.appVersionService.selectByPrimaryKey(appId);
        return appVersion;
    }

    @RequestMapping(value = "/updateApp/{appId}", method = RequestMethod.GET)
    public String updateApp(@PathVariable("appId") Integer userId, ModelMap modelMap) {
        AppVersion appVersion = this.appVersionService.selectByPrimaryKey(userId);
        modelMap.addAttribute("appversion", appVersion);
        return "updateApp";
    }


    @RequestMapping(value = "/updateAppPost.do", method = {RequestMethod.POST, RequestMethod.GET})
    public String updateAppPost(AppVersion appVersion) {
        appVersion.setMtime(new Date());
        appVersionService.updateByPrimaryKeySelective(appVersion);
        return "redirect:/apps";
    }
}
