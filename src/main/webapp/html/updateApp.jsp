<%--
  Created by IntelliJ IDEA.
  User: litianyi
  Date: 2016/07/12, 0012
  Time: 18:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>SpringMVC Demo 首页</title>

    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="/resource/css/bootstrap.min.css">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="container">
    <h1>SpringMVC 上传文件</h1>
    <hr/>
    <form:form action="/updateAppPost.do" method="post" enctype="multipart/form-data">
        <div class="form-group">
            <label for="packageurl">apk文件:</label>
            <input type="text" name="packageurl" readonly="readonly" id="packageurl" class="form-control" placeholder="Enter uploadFile:" value="${appversion.packageurl}"/>
        </div>
        <div class="form-group">
            <label for="apptype">app所属:</label>
            <select class="form-control" id="apptype" name="apptype">
                <option value="1" ${appversion.apptype==1?'selected':''}>车国app</option>
                <option value="2" ${appversion.apptype==2?'selected':''}>车商app</option>
            </select>
        </div>
        <div class="form-group">
            <label for="clienttype">app类型:</label>
            <select class="form-control" id="clienttype" name="clienttype">
                <option value="IOS" ${appversion.clienttype=='IOS'?'selected':''}>IOS</option>
                <option value="Android" ${appversion.clienttype=='Android'?'selected':''}>Android</option>
            </select>
        </div>
        <div class="form-group">
            <label for="appversion">app版本:</label>
            <input type="text" class="form-control" id="appversion" name="appversion" placeholder="Enter appversion:" value="${appversion.appversion}"/>
        </div>
        <div class="form-group">
            <label for="funcdesc">更新日志:</label>
            <input type="text" class="form-control" id="funcdesc" name="funcdesc" placeholder="Enter funcdesc:" value="${appversion.funcdesc}"/>
        </div>
        <div class="form-group">
            <label for="forceupdate">是否强制升级:</label>
            <select class="form-control" id="forceupdate" name="forceupdate">
                <option value="1" ${appversion.forceupdate==1?'selected':''}>否</option>
                <option value="2" ${appversion.forceupdate==2?'selected':''}>是</option>
            </select>
        </div>
        <div class="form-group">
            <label for="status">当前状态:</label>
            <select class="form-control" id="status" name="status">
                <option value="0" ${appversion.status==0?'selected':''}>正常</option>
                <option value="1" ${appversion.status==1?'selected':''}>停用</option>
            </select>
        </div>
        <div class="form-group">
            <label for="channel">渠道:</label>
            <input type="text" class="form-control" id="channel" name="channel" placeholder="Enter channel:" value="${appversion.channel}"/>
        </div>
        <!-- 把 id 一并写入 userP 中 -->
        <input type="hidden" id="id" name="id" value="${appversion.id}"/>
        <div class="form-group">
            <button type="submit" class="btn btn-sm btn-success">提交</button>
        </div>
    </form:form>
</div>

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="/resource/js/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="/resource/js/bootstrap.min.js"></script>
</body>
</html>
