<%--
  Created by IntelliJ IDEA.
  User: Starry Sky
  Date: 2022/12/25
  Time: 4:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员主页</title>
    <link rel="stylesheet" type="text/css" href="./CSS/ManageWelcome.css">
    <script src="<%=request.getContextPath()%>/Bootstrap5/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/Bootstrap5/css/bootstrap.min.css">
</head>
<script>
    function Function01(){
        window.location.href='<%=request.getContextPath()%>/ManageStaff';
    }

    function Function02(){
        window.location.href='<%=request.getContextPath()%>/ManageDept';
    }

    function Function03(){
        window.location.href='<%=request.getContextPath()%>/ManageRoom';
    }

    function Function04(){
        window.location.href='<%=request.getContextPath()%>/ManageRecord';
    }
</script>
<body>
<h1 id="welcome_font">欢迎，<%=session.getAttribute("manager_name")%></h1>
<button onclick="Function01()" type="button" class="btn btn-primary" id="btn01">员工信息管理</button>
<button onclick="Function02()" type="button" class="btn btn-primary" id="btn02">部门信息管理</button>
<button onclick="Function03()" type="button" class="btn btn-primary" id="btn03">会议室信息管理</button>
<button onclick="Function04()" type="button" class="btn btn-primary" id="btn04">系统会议记录管理</button>
</body>
</html>
