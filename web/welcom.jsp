<%--
  Created by IntelliJ IDEA.
  User: Starry Sky
  Date: 2022/12/23
  Time: 7:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主页面</title>
    <link rel="stylesheet" type="text/css" href="./CSS/welcom.css">
    <script src="<%=request.getContextPath()%>/Bootstrap5/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/Bootstrap5/css/bootstrap.min.css">
</head>
<body>
<h1 id="welcome_font">欢迎，<%=session.getAttribute("staff_name")%></h1>
<script>
    function myFunction01(){
        window.location.href='<%=request.getContextPath()%>/record';
    }

    function myFunction02(){
        window.location.href='<%=request.getContextPath()%>/Appoint.jsp';
    }

    function myFunction03(){
        window.location.href='<%=request.getContextPath()%>/lookAppoint';
    }

</script>
<button onclick="myFunction01()" type="button" class="btn btn-primary" id="btn01">查看系统会议记录</button>
<button onclick="myFunction02()" type="button" class="btn btn-primary" id="btn02">预约会议室</button>
<button onclick="myFunction03()" type="button" class="btn btn-primary" id="btn03">取消预约</button>
</body>
</html>
