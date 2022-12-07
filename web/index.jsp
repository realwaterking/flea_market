<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>flea market</title>
    <link href="./static/favicon.ico" rel="shortcut icon">
    <link href="./lib/common.css" rel="stylesheet">
    <script src="./lib/jquery.min.js"></script>
    <script src="./lib/common.js"></script>
</head>
<body>
<%
    String msg = (String) request.getSession().getAttribute("msg");
    if (msg == null) {
        msg = "";
    };
    request.getSession().removeAttribute("msg");
%>
    <div class="container">
        <div class="logo">校园跳蚤市场</div>
        <div></div>
        <div style="color: red" align="center"><%=msg%></div>
        <div class="login-item">
            <form action="./Client_loginServlet" method="post" class="form form-login">
                <div class="form-field">
                    <label class="user" for="login-username"><span class="hidden">Username</span></label>
                    <input id="login-username" type="text" class="form-input" placeholder="请输入账号" required name="client_username">
                </div>

                <div class="form-field">
                    <label class="lock" for="login-password"><span class="hidden">Password</span></label>
                    <input id="login-password" type="password" class="form-input" placeholder="请输入密码" required name="client_password">
                </div>

                <div class="form-field">
                    <input type="submit" value="登录">
                </div>
                <div class="login-msg">
                    <a href="./client_register.jsp">还没有账号?</a>
                </div>
            </form>
        </div>
    </div>

</body>
</html>
