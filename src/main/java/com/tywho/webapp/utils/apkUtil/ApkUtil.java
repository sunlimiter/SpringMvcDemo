package com.tywho.webapp.utils.apkUtil;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import com.alibaba.fastjson.JSON;
import com.tywho.webapp.utils.apkUtil.bean.ApkInfo;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.Namespace;
import org.jdom.input.SAXBuilder;


public class ApkUtil {

    private static final Namespace NS = Namespace.getNamespace("http://schemas.android.com/apk/res/android");

    @SuppressWarnings("unchecked")
    public static ApkInfo getApkInfo(String apkPath) {
        ApkInfo apkInfo = new ApkInfo();
        SAXBuilder builder = new SAXBuilder();
        Document document = null;
        try {
            document = builder.build(getXmlInputStream(apkPath));
        } catch (Exception e) {
            e.printStackTrace();
        }
        Element root = document.getRootElement();//跟节点-->manifest
        apkInfo.setVersionCode(root.getAttributeValue("versionCode", NS));
        apkInfo.setVersionName(root.getAttributeValue("versionName", NS));
        apkInfo.setApkPackage(root.getAttributeValue("package", NS));
        Element elemUseSdk = root.getChild("uses-sdk");//子节点-->uses-sdk
        apkInfo.setMinSdkVersion(elemUseSdk.getAttributeValue("minSdkVersion", NS));
        List listPermission = root.getChildren("uses-permission");//子节点是个集合
        List permissions = new ArrayList();
        for (Object object : listPermission) {
            String permission = ((Element) object).getAttributeValue("name", NS);
            permissions.add(permission);
        }
        apkInfo.setUses_permission(permissions);

        Element elemUseApp = root.getChild("application");//子节点-->uses-sdk
        List listEle = elemUseApp.getChildren();
        for (Object object : listEle) {
            if(((Element) object).getAttributeValue("name", NS).contains("UMENG_CHANNEL")){
                apkInfo.setChannel(((Element) object).getAttributeValue("value", NS));
            }
        }

//		return root.getAttributes().toString();
        return apkInfo;
    }

    private static InputStream getXmlInputStream(String apkPath) {
        InputStream inputStream = null;
        InputStream xmlInputStream = null;
        ZipFile zipFile = null;
        try {
            zipFile = new ZipFile(apkPath);
            ZipEntry zipEntry = new ZipEntry("AndroidManifest.xml");
            inputStream = zipFile.getInputStream(zipEntry);
            AXMLPrinter xmlPrinter = new AXMLPrinter();
            xmlPrinter.startPrinf(inputStream);
            xmlInputStream = new ByteArrayInputStream(xmlPrinter.getBuf().toString().getBytes("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
            try {
                inputStream.close();
                zipFile.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        return xmlInputStream;
    }

}
