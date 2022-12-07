<%@ page import="java.util.List" %>
<%@ page import="com.chzu.bean.Product" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

  <title>flea market</title>
  <link rel="stylesheet" href="./lib/layui/css/layui.css">
  <link href="./static/favicon.ico" rel="shortcut icon">
  <script src="./lib/layui/layui.js"></script>
  <script src="./lib/common.js"></script>
  <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>


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
          <dd><a href="./client_myProfileServlet">个人简介</a></dd>
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

  <div class="layui-side layui-bg-black" id="menu">
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
    <div  style="width: 400px; height: 500px;padding: 50px; margin-left: 300px;" >
      <form class="layui-form layui-form-pane" action="./Add_ProductServlet" method="post">

        <div class="layui-form-item">
          <label class="layui-form-label">宝贝类型</label>
          <div class="layui-input-block">
            <select name="type" lay-verify="required">
              <option value=""></option>
              <option value="0">生活用品</option>
              <option value="1">学习用品</option>
              <option value="2">数码产品</option>
              <option value="3">其他产品</option>
            </select>
          </div>
        </div>

        <div class="layui-form-item">
          <label class="layui-form-label">宝贝名称</label></label>
          <div class="layui-input-block">
            <input type="text" name="product_name" required  lay-verify="required" placeholder="请输入宝贝名称" autocomplete="off" class="layui-input">
          </div>
        </div>

        <div class="layui-form-item">
          <label class="layui-form-label">宝贝价格</label>
          <div class="layui-input-block">
            <input type="text" name="product_price" required  lay-verify="required" placeholder="请输入宝贝价格" autocomplete="off" class="layui-input">
          </div>
        </div>

        <div class="layui-form-item layui-form-text">
          <label class="layui-form-label">宝贝描述</label>
          <div class="layui-input-block">
            <textarea name="product_description" placeholder="请输入" class="layui-textarea"></textarea>
          </div>
        </div>

        <div class="layui-form-item">
          <label class="layui-form-label">宝贝数量</label>
          <div class="layui-input-block">
            <input type="text" name="product_quantity" required  lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
          </div>
        </div>

        <div class="layui-form-item">
          <div class="layui-input-block">
            <button class="layui-btn" lay-submit lay-filter="formDemo" type="submit">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
          </div>
        </div>

      </form>

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
