<%--
  Created by IntelliJ IDEA.
  User: Starry Sky
  Date: 2022/12/26
  Time: 4:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改部门信息</title>
    <script src="<%=request.getContextPath()%>/Bootstrap5/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/Bootstrap5/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/ManageUpdateDept.css">
</head>
<body>
<div class="card" style="width: 25rem; margin-top: 100px;margin-left: auto;margin-right: auto">
    <img src="./Pictures/main01.jpg" class="card-img-top" alt="...">
    <div class="card-body">
        <h5 class="card-title">预约会议室</h5>
        <p class="card-text">根据所需进行会议室预约</p>
    </div>
    <ul class="list-group list-group-flush">
        <form action="/Meeting/UpdateDept" method="post">
            <li class="list-group-item">
                部门编号：<input type="text" name="id" value="<%=request.getParameter("init_id")%>" readonly><br>
            </li>
            <li class="list-group-item">
                部门名称：<input type="text" name="dep_name"><br>
            </li>
            <li class="list-group-item">
                部门人数：<input type="text" name="person_num"><br>
            </li>
            <li class="list-group-item">
                管理员编号：<input type="text" name="manage_id"><br>
            </li>
            <li class="list-group-item">
                管理员姓名：<input type="text" name="manage_name"><br>
            </li>
            <li class="list-group-item">
                <input type="submit" value="修改" id="submit">
            </li>
        </form>
    </ul>
</div>
</body>
</html>
