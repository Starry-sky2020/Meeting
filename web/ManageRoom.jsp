<%@ page import="com.starry_sky.yang.bean.Room" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Starry Sky
  Date: 2022/12/27
  Time: 1:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理会议室信息</title>
    <script src="<%=request.getContextPath()%>/Bootstrap5/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/Bootstrap5/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/ManageRoom.css">
</head>
<script>
    function delMeetingRoom(room_id){
        window.location.href="${pageContext.request.contextPath}/DelManageRoom?room_id=" + room_id;
    }

    function updateMeetingRoom(room_id){
        window.location.href="${pageContext.request.contextPath}/ManageUpdateRoom.jsp?room_id=" + room_id;
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
            <li><a class="dropdown-item" href="<%=request.getContextPath()%>/ManageRecord">系统会议记录管理</a></li>
        </ul>
    </div>
</div>
<div class="container">
<table class="table table-striped" style="text-align: center;">
    <tr class="table-dark">
        <td colspan="7">
            会议室信息管理
        </td>
    </tr>
    <tr>
        <th>会议室编号</th>
        <th>开始时间</th>
        <th>结束时间</th>
        <th>会议室地址</th>
        <th>会议室最大人数</th>
        <th>删除会议室</th>
        <th>修改会议室</th>
    </tr>

        <%
        List<Room> roomList = (List<Room>) request.getAttribute("roomList");

        for (Room room : roomList){

    %>

    <tr>
        <td><%=room.getRoom_id()%></td>
        <td><%=room.getStart_time()%></td>
        <td><%=room.getEnd_time()%></td>
        <td><%=room.getAddress()%></td>
        <td><%=room.getMax_people()%></td>
        <td>
            <button onclick="delMeetingRoom(<%=room.getRoom_id()%>)">删除会议室</button>
        </td>
        <td>
            <button onclick="updateMeetingRoom(<%=room.getRoom_id()%>)">修改会议室</button>
        </td>
    </tr>

        <%
        }
    %>
</div>
</body>
</html>
