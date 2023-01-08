<%--
  Created by IntelliJ IDEA.
  User: Starry Sky
  Date: 2022/12/23
  Time: 0:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
  <title>注册页面</title>
  <link rel="stylesheet"  type="text/css"  href="<%=request.getContextPath()%>/login.css"/>
</head>
<body>
<div class="container">
  <div class="login-wrapper">
    <div class="header">员工信息登记</div>
    <div class="form-wrapper">
      <form action="/Meeting/submit" method="post">
        <input type="text" name="username" placeholder="姓名" class="input-item">
        <input type="password" name="password" placeholder="手机号（密码）" class="input-item">
        <input type="text" name="address" placeholder="家庭住址" class="input-item">
        <input type="text" name="age" placeholder="年龄" class="input-item">
        <input type="submit" value="注册" class="btn">
      </form>
    </div>


    <div class="msg">
      <a href="<%=request.getContextPath()%>/index.jsp">员工登录</a>
      &nbsp;&nbsp;&nbsp;&nbsp;
      <a href="<%=request.getContextPath()%>/ManagerLogin.jsp">员工登录</a>
    </div>
  </div>
</div>
</body>
</html>
