<%@ page import="java.util.List" %>
<%@ page import="com.starry_sky.yang.bean.Record" %><%--
  Created by IntelliJ IDEA.
  User: Starry Sky
  Date: 2022/12/23
  Time: 19:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>系统会议记录查询</title>
<%--    <link rel="stylesheet" type="text/css" href="./CSS/record.css">--%>
    <script src="<%=request.getContextPath()%>/Bootstrap5/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/Bootstrap5/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/CSS/record.css">
</head>
<body>
<div class="btn-group-vertical" role="group" aria-label="Vertical button group" style="float: left">
    <div class="btn-group" role="group">
        <button type="button" class="btn btn-primary dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
            下拉选择
        </button>
        <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="<%=request.getContextPath()%>/welcom.jsp">主页</a></li>
            <li><a class="dropdown-item" href="<%=request.getContextPath()%>/Appoint.jsp">预约会议室</a></li>
            <li><a class="dropdown-item" href="<%=request.getContextPath()%>/lookAppoint">取消预约</a></li>
        </ul>
    </div>
</div>
<div class="container">
<table class="table table-striped" style="text-align: center;">
    <tr class="table-dark">
        <td colspan="4" style="text-align: center;">
            <strong>系统会议记录表</strong>
        </td>
    </tr>
    <tr>
        <th>记录编号</th>
        <th>开始时间</th>
        <th>结束时间</th>
        <th>部门编号</th>
    </tr>
<%
    List<Record> recordList = (List<Record>) request.getAttribute("list");

   for (Record record:recordList){


%>
    <tr>
        <td><%=record.getRecord_id()%></td>
        <td><%=record.getStart_time()%></td>
        <td><%=record.getEnd_time()%></td>
        <td><%=record.getDepartment_id()%></td>
    </tr>
 <%
        }
 %>
</div>
</body>
</html>
