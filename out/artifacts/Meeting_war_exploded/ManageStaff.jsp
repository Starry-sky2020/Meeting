<%@ page import="java.util.List" %>
<%@ page import="com.starry_sky.yang.bean.Staff" %><%--
  Created by IntelliJ IDEA.
  User: Starry Sky
  Date: 2022/12/25
  Time: 4:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员工信息</title>
    <script src="<%=request.getContextPath()%>/Bootstrap5/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/Bootstrap5/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/CSS/ManageStaff.css">
</head>
<script>
    function delStaff(staff_id){
        window.location.href='${pageContext.request.contextPath}/delStaff?staff_id='+staff_id;
    }

    function updateStaff(staff_id){
        window.location.href='${pageContext.request.contextPath}/ManageUpdateStaff.jsp?init_staff_id='+staff_id;
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
            <li><a class="dropdown-item" href="<%=request.getContextPath()%>/ManageDept">部门信息管理</a></li>
            <li><a class="dropdown-item" href="<%=request.getContextPath()%>/ManageRoom">会议室信息管理</a></li>
            <li><a class="dropdown-item" href="<%=request.getContextPath()%>/ManageRecord">系统会议记录管理</a></li>
        </ul>
    </div>
</div>
<div class="container">
    <table class="table table-striped" style="text-align: center;">
        <tr class="table-dark">
            <td colspan="7" style="text-align: center;">
                <strong>员工信息表</strong>
            </td>
        </tr>
        <tr>
            <th>员工编号</th>
            <th>员工姓名</th>
            <th>员工年龄</th>
            <th>联系方式</th>
            <th>员工地址</th>
            <th>解雇员工</th>
            <th>修改信息</th>
        </tr>

        <%
            List<Staff> staffList = (List<Staff>) request.getAttribute("staffList");

            for (Staff staff : staffList){

        %>

        <tr>
            <td><%=staff.getStaff_id()%></td>
            <td><%=staff.getStaff_name()%></td>
            <td><%=staff.getStaff_age()%></td>
            <td><%=staff.getStaff_phone()%></td>
            <td><%=staff.getStaff_address()%></td>
            <td>
                <button onclick="delStaff(<%=staff.getStaff_id()%>)">解雇员工</button>
            </td>
            <td>
                <button onclick="updateStaff(<%=staff.getStaff_id()%>)">修改信息</button>
            </td>
        </tr>

        <%
            }
        %>
    </table>
</div>
</body>
</html>
