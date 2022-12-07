<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>flea market</title>
    <link href="./static/favicon.ico" rel="shortcut icon">
    <link href="./lib/admin_login.css" rel="stylesheet">
    <script src="./lib/common.js"></script>
  </head>
  <body>
  <%
    String msg = (String) request.getSession().getAttribute("msg");
    if (msg == null) {
      msg = "";
    };
//    request.getSession().removeAttribute("msg");
  %>
    <div>
      <form action="./admin_loginServlet" method="post">
        <div class="login">
          <div style="color: red" align="center"><%=msg%></div>
          <h1>管理员登录</h1>

          <form action="" method="post">
            <input type="text" name="u" placeholder="Username" required="required" />
            <input type="password" name="p" placeholder="Password" required="required" />
            <button type="submit" class="btn btn-primary btn-block btn-large" onclick="skip()">Let me in.</button>
          </form>
        </div>
      </form>
    </div>
  </body>
</html>
