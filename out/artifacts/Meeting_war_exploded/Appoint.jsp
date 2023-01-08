<%--
  Created by IntelliJ IDEA.
  User: Starry Sky
  Date: 2022/12/24
  Time: 0:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>预约会议室</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/Bootstrap5/css/bootstrap.min.css">
    <script src="<%=request.getContextPath()%>/Bootstrap5/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/CSS/Appoint.css">
</head>
<body>
<div class="btn-group-vertical" role="group" aria-label="Vertical button group" style="float: left">
    <div class="btn-group" role="group">
        <button type="button" class="btn btn-primary dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
            下拉选择
        </button>
        <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="<%=request.getContextPath()%>/welcom.jsp">主页</a></li>
            <li><a class="dropdown-item" href="<%=request.getContextPath()%>/record">系统会议记录</a></li>
            <li><a class="dropdown-item" href="<%=request.getContextPath()%>/lookAppoint">取消预约</a></li>
        </ul>
    </div>
</div>
<div class="card" style="width: 25rem; margin-top: 100px;margin-left: auto;margin-right: auto">
    <img src="./Pictures/main01.jpg" class="card-img-top" alt="...">
    <div class="card-body">
        <h5 class="card-title">预约会议室</h5>
        <p class="card-text">根据所需进行会议室预约</p>
    </div>
    <ul class="list-group list-group-flush">
        <form action="\Meeting\appoint" method="Get">
            <li class="list-group-item">
                预约会议室编号：<input type="text" name="room" placeholder="预约会议室编号"><br>
            </li>
            <li class="list-group-item">
                会议开始时间：<input type="text" name="start_time" placeholder="会议开始时间"><br>
            </li>
            <li class="list-group-item">
                会议结束时间：<input type="text" name="end_time" placeholder="会议结束时间"><br>
            </li>
            <li class="list-group-item">
                参会人数：<input type="text" name="people" placeholder="参会人数"><br>
            </li>
            <li class="list-group-item">
                部门编号: <input type="text" name="department_id" placeholder="部门编号"><br>
            </li>
            <li class="list-group-item">
                员工编号: <input type="text" name="staff_id" placeholder="员工编号"><br>
            </li>
            <li class="list-group-item">
                <input type="submit" value="提交申请" id="submit">
            </li>
        </form>
    </ul>
</div>
</body>
</html>
