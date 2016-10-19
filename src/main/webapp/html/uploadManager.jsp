<%--
  Created by IntelliJ IDEA.
  User: litianyi
  Date: 2016/07/12, 0012
  Time: 15:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>SpringMVC 上传文件管理</title>

    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="/resource/css/bootstrap.min.css">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <style>
        .table th{
            text-align: center;
            width:10%;
            vertical-align: middle;
        }
        .table td{
            text-align: center;
            vertical-align: middle;
            word-break:break-all;
        }
        .table a{
            margin: 2px;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>SpringMVC cms系统-上传文件管理</h1>
    <hr/>

    <h3>所有app信息 <a href="/addapp" type="button" class="btn btn-default btn-sm">添加</a></h3>

    <!-- 如果用户列表为空 -->
    <c:if test="${empty appList}">
        <p class="bg-warning">
            <br/>
            appversion表为空，请<a href="/addapp" type="button" class="btn btn-default btn-sm">添加</a>
            <br/>
            <br/>
        </p>
    </c:if>

    <!-- 如果用户列表非空 -->
    <c:if test="${!empty appList}">
        <table class="table table-bordered table-striped table-condensed table-responsive">
            <tr>
                <th>app类型</th>
                <th>客户端类型</th>
                <th>app版本</th>
                <th>新版本功能描述</th>
                <th>是否强制更新</th>
                <th>当前状态</th>
                <th>安装包地址</th>
                <th>安装包升级hash值</th>
                <th>app渠道</th>
                <th>操作</th>
            </tr>

            <c:forEach items="${appList}" var="appversion">
                <tr>
                    <td>
                        <c:choose>
                            <c:when test="${appversion.apptype==1}">
                                车国app
                            </c:when>
                            <c:when test="${appversion.apptype==2}">
                                车商app）
                            </c:when>
                            <c:otherwise>
                                其他app
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td> ${appversion.clienttype}</td>
                    <td >${appversion.appversion}</td>
                    <td>${appversion.funcdesc}</td>
                    <td>
                        <c:choose>
                            <c:when test="${appversion.forceupdate==1}">
                                否
                            </c:when>
                            <c:when test="${appversion.forceupdate==2}">
                                是
                            </c:when>
                            <c:otherwise>
                                其他
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td>
                        <c:choose>
                            <c:when test="${appversion.status==0}">
                                正常
                            </c:when>
                            <c:otherwise>
                                停用
                            </c:otherwise>
                        </c:choose></td>
                    <td>${appversion.packageurl}</td>
                    <td>${appversion.hashvalue}</td>
                    <td>${appversion.channel}</td>
                    <td>
                        <a href="/showApp/${appversion.id}" type="button" class="btn btn-sm btn-success">详情</a>
                        <a href="/updateApp/${appversion.id}" type="button" class="btn btn-sm btn-warning">修改</a>
                        <a href="/deleteApp/${appversion.id}" type="button" class="btn btn-sm btn-danger">删除</a>
                        <a href="/showAppJson/${appversion.id}" type="button" class="btn btn-sm btn-info">json</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</div>

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="/resource/js/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="/resource/js/bootstrap.min.js"></script>
</body>
</html>
