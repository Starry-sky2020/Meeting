<%@ page import="com.starry_sky.yang.bean.Dept" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Starry Sky
  Date: 2022/12/26
  Time: 3:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理部门信息</title>
    <script src="<%=request.getContextPath()%>/Bootstrap5/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/Bootstrap5/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/ManageDept.css">

</head>
<script>
    function delDept(id){
        window.location.href='${pageContext.request.contextPath}/DelDept?id='+id;
    }

    function updateDept(id){
        window.location.href='${pageContext.request.contextPath}/ManageUpdateDept.jsp?init_id='+id;
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
            <li><a class="dropdown-item" href="<%=request.getContextPath()%>/ManageRoom">会议室信息管理</a></li>
            <li><a class="dropdown-item" href="<%=request.getContextPath()%>/ManageRecord">系统会议记录管理</a></li>
        </ul>
    </div>
</div>
<div class="container">
<table class="table table-striped" style="text-align: center;">
    <tr class="table-dark">
        <td colspan="7">
            部门信息管理
        </td>
    </tr>
    <tr>
        <th>部门编号</th>
        <th>部门名称</th>
        <th>部门人数</th>
        <th>管理员编号</th>
        <th>管理员姓名</th>
        <th>删除部门</th>
        <th>修改信息</th>
    </tr>

        <%
        List<Dept> deptList = (List<Dept>) request.getAttribute("deptList");

        for (Dept dept : deptList){

    %>

    <tr>
        <td><%=dept.getId()%></td>
        <td><%=dept.getDep_name()%></td>
        <td><%=dept.getPerson_num()%></td>
        <td><%=dept.getManage_id()%></td>
        <td><%=dept.getManage_name()%></td>
        <td>
            <button onclick="delDept(<%=dept.getId()%>)">删除部门</button>
        </td>
        <td>
            <button onclick="updateDept(<%=dept.getManage_id()%>)">修改信息</button>
        </td>
    </tr>

        <%
        }
    %>
</div>
</body>
</html>
