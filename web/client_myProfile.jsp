<%--
  Created by IntelliJ IDEA.
  User: regia
  Date: 2022/12/4
  Time: 17:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

  <title>flea market</title>
  <link rel="stylesheet" href="./lib/layui/css/layui.css">
  <link href="./static/favicon.ico" rel="shortcut icon">
  <script src="./lib/jquery.min.js"></script>
  <script src="./lib/layui/layui.js"></script>
  <script src="./lib/common.js"></script>

</head>
<body>
<div class="layui-layout layui-layout-admin">
  <div class="layui-header">
    <div class="layui-logo layui-hide-xs layui-bg-black">校园跳蚤市场</div>
    <!-- 头部区域（可配合layui 已有的水平导航） -->
    <ul class="layui-nav layui-layout-left">
      <!-- 移动端显示 -->
      <li class="layui-nav-item layui-show-xs-inline-block layui-hide-sm" lay-header-event="menuLeft">
        <i class="layui-icon layui-icon-spread-left"></i>
      </li>

      <li class="layui-nav-item layui-hide-xs"><a href="./client_liveProductServlet">功能1</a></li>
      <li class="layui-nav-item layui-hide-xs"><a href="./client_studyProductServlet">功能2</a></li>
      <li class="layui-nav-item layui-hide-xs"><a href="./client_elecProductServlet">功能3</a></li>
      <li class="layui-nav-item layui-hide-xs"><a href="./client_otherProductServlet">功能4</a></li>
      <li class="layui-nav-item">
        <a href="javascript:;">功能组</a></a>
        <dl class="layui-nav-child">
          <dd><a href="./client_liveProductServlet">生活用品</a></dd>
          <dd><a href="./client_studyProductServlet">学习用品</a></dd>
          <dd><a href="./client_elecProductServlet">数码产品</a></dd>
          <dd><a href="./client_otherProductServlet">其它产品</a></dd>
        </dl>
      </li>
    </ul>
    <ul class="layui-nav layui-layout-right">
      <li class="layui-nav-item layui-hide layui-show-md-inline-block">
        <a href="javascript:;">
          <img src="//tva1.sinaimg.cn/crop.0.0.118.118.180/5db11ff4gw1e77d3nqrv8j203b03cweg.jpg" class="layui-nav-img">
          <%
            out.print(request.getSession().getAttribute("client_username"));
          %>
        </a>
        <dl class="layui-nav-child">
          <dd><a href="./client_marketProfileServlet">个人简介</a></dd>
          <dd><a href="">设置</a></dd>
          <dd><a href="javascript:;" onclick="skip()">退出</a></dd>
        </dl>
      </li>
      <li class="layui-nav-item" lay-header-event="menuRight" lay-unselect>
        <a href="javascript:;">
          <i class="layui-icon layui-icon-more-vertical"></i>
        </a>
      </li>
    </ul>
  </div>

  <div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
      <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
      <ul class="layui-nav layui-nav-tree" lay-filter="test">
        <li class="layui-nav-item"><a href="./client_marketProfileServlet">市场简介</a></li>
        <li class="layui-nav-item layui-nav-itemed">
          <a class="" href="javascript:;">商品交易市场</a>
          <dl class="layui-nav-child">
            <dd><a href="./client_liveProductServlet">生活用品</a></dd>
            <dd><a href="./client_studyProductServlet">学习用品</a></dd>
            <dd><a href="./client_elecProductServlet">数码产品</a></dd>
            <dd><a href="./client_otherProductServlet">其它产品</a></dd>
            <!-- <dd><a href="">the links</a></dd> -->
          </dl>
        </li>
        <li class="layui-nav-item"><a href="./client_myProductServlet">我要发布</a></li>

      </ul>
    </div>
  </div>

  <div class="layui-body">
    <!-- 内容主体区域 -->
    <div style="padding: 15px;">
      <table class="layui-table">
        <colgroup>
          <col width="150">
          <col width="200">
          <col>
        </colgroup>
        <thead>
        <tr>
          <th>昵称</th>
          <th>加入时间</th>
          <th>签名</th>
        </tr>
        </thead>
        <tbody>
        <tr>
          <td>贤心</td>
          <td>2016-11-29</td>
          <td>人生就像是一场修行</td>
        </tr>
        <tr>
          <td>许闲心</td>
          <td>2016-11-28</td>
          <td>于千万人之中遇见你所遇见的人，于千万年之中，时间的无涯的荒野里…</td>
        </tr>
        </tbody>
      </table>
    </div>
  </div>

  <div class="layui-footer">
    <!-- 底部固定区域 -->
    <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
    <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
    <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
    <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
    <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
    <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
    <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
    <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
    <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
    <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
    <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
    <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
    <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
    <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
    <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;@ 2022 校园跳蚤市场</td>
  </div>
</div>

<script>
  function skip() {
        <%
         request.getSession().removeAttribute("client_username");
         request.getSession().removeAttribute("client_password");
         %>
    window.location.replace("./index.jsp");
  };
</script>

</body>
</html>
