<%@ page import="java.util.List" %>
<%@ page import="com.starry_sky.yang.bean.Appoint" %><%--
  Created by IntelliJ IDEA.
  User: Starry Sky
  Date: 2022/12/24
  Time: 2:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>取消预约</title>
    <script src="<%=request.getContextPath()%>/Bootstrap5/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/Bootstrap5/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/delAppoint.css">
</head>

<script>
    function delAppoint(appoint_id){
        if (window.confirm('请注意，删除数据后不可恢复')){
            document.location.href = '${pageContext.request.contextPath}/delAppoint?delAppoint_id='+appoint_id;
        }
    }
</script>
<body>
<div class="btn-group-vertical" role="group" aria-label="Vertical button group" style="float: left">
    <div class="btn-group" role="group">
        <button type="button" class="btn btn-primary dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
            下拉选择
        </button>
        <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="<%=request.getContextPath()%>/welcom.jsp">主页</a></li>
            <li><a class="dropdown-item" href="<%=request.getContextPath()%>/record">系统会议记录</a></li>
            <li><a class="dropdown-item" href="<%=request.getContextPath()%>/Appoint.jsp">预约会议室</a></li>
        </ul>
    </div>
</div>
<div class="container">
<table class="table table-striped" style="text-align: center;">
    <tr class="table-dark">
        <th>预约编号</th>
        <th>开始时间</th>
        <th>结束时间</th>
        <th>参会人数</th>
        <th>会议室编号</th>
        <th>预约部门编号</th>
        <th>员工编号</th>
        <th>删除</th>
    </tr>

        <%
        request.setAttribute("del",0);
    List<Appoint> appointList = (List<Appoint>) request.getAttribute("appointList");

   for (Appoint appoint:appointList){


%>
    <tr>
        <td><%=appoint.getAppoint_id()%></td>
        <td><%=appoint.getStart_time()%></td>
        <td><%=appoint.getEnd_time()%></td>
        <td><%=appoint.getPeople()%></td>
        <td><%=appoint.getRoom_id()%></td>
        <td><%=appoint.getDepartment_id()%></td>
        <td><%=appoint.getStaff_id()%></td>
        <td>

            <button onclick="delAppoint(<%=appoint.getAppoint_id()%>)">取消预约</button>

        </td>
    </tr>
        <%
        }
 %>
</div>
</body>


</html>
