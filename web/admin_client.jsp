<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: regia
  Date: 2022/12/6
  Time: 16:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>flea market</title>
    <link rel="stylesheet" href="./lib/layui/css/layui.css">
    <link href="./static/favicon.ico" rel="shortcut icon">
    <script src="./lib/layui/layui.js"></script>
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
    <script src="./lib/common.js"></script>

</head>
<body>

<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo layui-hide-xs layui-bg-black">后台管理系统</div>
        <!-- 头部区域（可配合layui 已有的水平导航） -->
        <ul class="layui-nav layui-layout-left">
            <!-- 移动端显示 -->
            <li class="layui-nav-item layui-show-xs-inline-block layui-hide-sm" lay-header-event="menuLeft">
                <i class="layui-icon layui-icon-spread-left"></i>
            </li>

        </ul>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item layui-hide layui-show-md-inline-block">
                <a href="javascript:;">
                    <img src="//tva1.sinaimg.cn/crop.0.0.118.118.180/5db11ff4gw1e77d3nqrv8j203b03cweg.jpg" class="layui-nav-img">
                    <%
                        out.print(request.getSession().getAttribute("admin_username"));
                    %>
                </a>
                <dl class="layui-nav-child">
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
                <li class="layui-nav-item"><a href="./admin_clientServlet">人员管理</a></li>
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="javascript:;">商品管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="./admin_liveProductServlet">生活用品</a></dd>
                        <dd><a href="./admin_studyProductServlet">学习用品</a></dd>
                        <dd><a href="./admin_elecProductServlet">数码产品</a></dd>
                        <dd><a href="./admin_otherProductServlet">其它产品</a></dd>
                        <!-- <dd><a href="">the links</a></dd> -->
                    </dl>
                </li>

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
                    <th>用户ID</th>
                    <th>用户名</th>
                    <th>用户密码</th>
                    <th>手机号码</th>
                    <th>QQ号码</th>
                    <th></th>
                    <th></th>
                </tr>
                </thead>
                <tbody>

                <c:forEach var = "c" items="${clientlist}">
                    <tr>
                        <td>${c.client_id}</td>
                        <td>${c.client_username}</td>
                        <td>${c.client_password}</td>
                        <td>${c.client_phoneNumber}</td>
                        <td>${c.client_QQ}</td>
                        <td><button class="layui-btn layui-btn-radius layui-btn-normal" type="submit" onclick="modify()">编辑</button></td>
                        <td><button class="layui-btn layui-btn-radius layui-btn-danger" onclick="wipe(${c.client_id})">删除</button></td>
                    </tr>
                </c:forEach>

                </tbody>

            </table>
        </div>
        <tr>
            <div align="right" style="bottom: 50px; right: 40px">
                <div ><h5 style="color: green;">共${tsum} 条记录，当前${cpage}/${tpage} 页&nbsp;&nbsp;</h5></div>
                <br>
                <a href="admin_clientServlet?cp=1"><button class="layui-btn layui-btn-xs">首页</button></a>
                <a href="admin_clientProductServlet?cp=${cpage-1 <1?1:cpage-1}"><button class="layui-btn layui-btn-xs">上一页</button></a>
                <a href="admin_clientProductServlet?cp=${cpage+1>tpage?tpage:cpage+1}"><button class="layui-btn layui-btn-xs">下一页</button></a>
                <a href="admin_clientProductServlet?cp=${tpage}"><button class="layui-btn layui-btn-xs">尾页</button></a>&nbsp;&nbsp;
            </div>
        </tr>
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
        <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;@ 2022 校园跳蚤市场</td>
    </div>
</div>

<script>
    function skip() {
        <%
         request.getSession().removeAttribute("admin_username");
         request.getSession().removeAttribute("admin_password");
         %>
        window.location.replace("./index.jsp");

    };
    function wipe(key) {


        layer.confirm("确定删除该用户吗?", {
            icon: 7,
            title: '确认框',
            time: 10000,
            shade: 0.5,
            yes: function (index) {
                $.ajax({
                    url: "./sub_ProductServlet?db=5",
                    type: "get",
                    data: {liveProduct_id: key},
                    success: function () {
                        layer.msg("删除成功", {
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
