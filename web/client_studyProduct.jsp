<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

  <title>flea market</title>
  <link rel="stylesheet" href="./lib/layui/css/layui.css">
  <script src="./lib/layui/layui.js"></script>
  <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
  <script src="./lib/common.js"></script>
  <link href="./static/favicon.ico" rel="shortcut icon">

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
        <li class="layui-nav-item"><a href="./client_myProductServlet" class="myproduct">我要发布</a></li>

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
          <th>商品编号</th>
          <th>商品名称</th>
          <th>商品价格</th>
          <th>商品描述</th>
          <th>商品库存</th>
          <th></th>
          <th></th>
        </tr>
        </thead>
        <tbody>

        <c:forEach var = "p" items="${productlist}">
          <tr>
            <td>${p.product_id}</td>
            <td>${p.product_name}</td>
            <td>${p.product_price}</td>
            <td>${p.product_description}</td>
            <td>${p.product_quantity}</td>
            <td><button class="layui-btn layui-btn-normal" type="submit" onclick="buy(${p.product_id})">购买</button></td>
            <td><button class="layui-btn layui-btn-danger" onclick="accuse()">举报</button></td>
          </tr>
        </c:forEach>

        </tbody>


      </table>
    </div>
    <div align="right" style="bottom: 50px; right: 40px" >
      <div ><h5 style="color: green;">共${tsum} 条记录，当前${cpage}/${tpage} 页&nbsp;&nbsp;</h5></div>
      <br>
      <a href="client_studyProductServlet?cp=1"><button class="layui-btn layui-btn-xs">首页</button></a>
      <a href="client_studyProductServlet?cp=${cpage-1 <1?1:cpage-1}"><button class="layui-btn layui-btn-xs">上一页</button></a>
      <a href="client_studyProductServlet?cp=${cpage+1>tpage?tpage:cpage+1}"><button class="layui-btn layui-btn-xs">下一页</button></a>
      <a href="client_studyProductServlet?cp=${tpage}"><button class="layui-btn layui-btn-xs">尾页</button></a>&nbsp;&nbsp;
    </div>
    <br><br><br><br>
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
    <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
    <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
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

  function buy(key) {


    layer.confirm("确定购买吗", {
      icon: 6,
      title: '确认框',
      time: 10000,
      anim: 2,
      shade: 0.5,
      yes: function (index) {
        $.ajax({
          url: "./sub_ProductServlet?db=2",
          type: "get",
          data: {liveProduct_id: key},
          success: function () {
            layer.msg("购买成功", {
              icon: 1,
              time: 1000
            })
            setTimeout(function () {window.location.reload(true)},1000)
          }
        })
        layer.close(index)
      },
      btn2: function (index) {
        layer.close(index)
      }
    })

  }
</script>

</body>
</html>
