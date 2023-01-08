<%--
  Created by IntelliJ IDEA.
  User: Starry Sky
  Date: 2022/12/25
  Time: 4:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>管理员登录页面</title>
    <link rel="stylesheet"  type="text/css"  href="<%=request.getContextPath()%>/login.css"/>
</head>
<body>
<div class="container">
    <div class="login-wrapper">
        <div class="header">管理登录</div>
        <div class="form-wrapper">
            <form action="/Meeting/managerLogin" method="post">
                <input type="text" name="username" placeholder="username" class="input-item">
                <input type="password" name="password" placeholder="password" class="input-item">
                <input type="submit" value="登录" class="btn">
            </form>
        </div>
        <div class="msg">
            <a href="<%=request.getContextPath()%>/index.jsp">员工登录</a>
            &nbsp;&nbsp;&nbsp;&nbsp;
            <a href="<%=request.getContextPath()%>/submit.jsp">员工登记</a>
        </div>
    </div>
</div>

<%
    if (request.getAttribute("errorLogin") == null) request.setAttribute("errorLogin",4);
    if ((int) request.getAttribute("errorLogin") == 2){
        System.out.println((int) request.getAttribute("errorLogin"));
%>
<script>
    alert("姓名错误")
</script>
<%
    }
%>

<%
    if ((int) request.getAttribute("errorLogin") == 3){
        System.out.println((int) request.getAttribute("errorLogin"));
%>
<script>
    alert("密码错误")
</script>
<%
    }
%>


</body>
</html>
