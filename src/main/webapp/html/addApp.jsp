<%--
  Created by IntelliJ IDEA.
  User: litianyi
  Date: 2016/07/12, 0012
  Time: 15:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>SpringMVC 上传文件</title>

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
    <form:form action="/upload.do" method="post" enctype="multipart/form-data">
        <div class="form-group">
            <label for="uploadFile">apk文件:</label>
            <input type="file" name="uploadFile" id="uploadFile" class="form-control" placeholder="Enter uploadFile:">
        </div>
        <div class="form-group">
            <label for="apptype">app所属:</label>
            <select class="form-control" id="apptype" name="apptype">
                <option value="1">车国app</option>
                <option value="2">车商app</option>
            </select>
        </div>
        <div class="form-group">
            <label for="clienttype">app类型:</label>
            <select class="form-control" id="clienttype" name="clienttype">
                <option value="Android">Android</option>
                <option value="IOS">IOS</option>
            </select>
        </div>
        <div class="form-group hidden">
            <label for="appversion">app版本:</label>
            <input type="text" class="form-control" id="appversion" name="appversion" placeholder="版本号，android不用输入，自动识别:"/>
        </div>
        <div class="form-group">
            <label for="funcdesc">更新日志:</label>
            <textarea class="input-xlarge form-control" id="funcdesc" name="funcdesc" rows="3" placeholder="更新日志:"></textarea>
        </div>
        <div class="form-group">
            <label for="forceupdate">是否强制升级:</label>
            <select class="form-control" id="forceupdate" name="forceupdate">
                <option value="1">否</option>
                <option value="2">是</option>
            </select>
        </div>
        <div class="form-group">
            <label for="status">当前状态:</label>
            <select class="form-control" id="status" name="status">
                <option value="0">正常</option>
                <option value="1">停用</option>
            </select>
        </div>
        <div class="form-group hidden">
            <label for="channel">渠道:</label>
            <input type="text" class="form-control" id="channel" name="channel" placeholder="输入渠道，android不用输入，自动识别:"/>
        </div>
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
