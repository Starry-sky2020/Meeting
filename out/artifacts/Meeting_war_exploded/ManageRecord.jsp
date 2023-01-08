<%@ page import="java.util.List" %>
<%@ page import="com.starry_sky.yang.bean.Record" %><%--
  Created by IntelliJ IDEA.
  User: Starry Sky
  Date: 2022/12/27
  Time: 3:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>系统会议记录管理</title>
    <script src="<%=request.getContextPath()%>/Bootstrap5/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/Bootstrap5/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/ManageRecord.css">
</head>
<script>
    function delRecord(record_id){
        window.location.href="${pageContext.request.contextPath}/DelRecord?record_id="+record_id;
    }
</script>
<body>
<div class="btn-group-vertical" role="group" aria-label="Vertical button group" style="float: left">
    <div class="btn-group" role="group">
        <button type="button" class="btn btn-primary dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
            下拉选择
        </button>
        <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="<%=request.getContextPath()%>/ManagerWelcome.jsp">主页</a></li>
            <li><a class="dropdown-item" href="<%=request.getContextPath()%>/ManageStaff">员工信息管理</a></li>
            <li><a class="dropdown-item" href="<%=request.getContextPath()%>/ManageDept">部门信息管理</a></li>
            <li><a class="dropdown-item" href="<%=request.getContextPath()%>/ManageRoom">会议室信息管理</a></li>
        </ul>
    </div>
</div>
<div class="container">
<table class="table table-striped" style="text-align: center;">
    <tr class="table-dark">
        <td colspan="5">
            系统会议记录管理
        </td>
    </tr>
    <tr>
        <th>会议记录编号</th>
        <th>开始时间</th>
        <th>结束时间</th>
        <th>参会部门编号</th>
        <th>删除记录</th>
    </tr>

        <%
        List<Record> recordList = (List<Record>) request.getAttribute("recordList");

        for (Record record : recordList){

    %>

    <tr>
        <td><%=record.getRecord_id()%></td>
        <td><%=record.getStart_time()%></td>
        <td><%=record.getEnd_time()%></td>
        <td><%=record.getDepartment_id()%></td>
        <td>
            <button onclick="delRecord(<%=record.getRecord_id()%>)">删除会议室</button>
        </td>
    </tr>

        <%
        }
    %>
</div>
</body>
</html>
