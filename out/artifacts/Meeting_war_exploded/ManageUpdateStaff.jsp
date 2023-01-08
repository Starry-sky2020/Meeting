<%--
  Created by IntelliJ IDEA.
  User: Starry Sky
  Date: 2022/12/26
  Time: 2:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改员工信息</title>
    <script src="<%=request.getContextPath()%>/Bootstrap5/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/Bootstrap5/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/ManageUpdateStaff.css">
</head>
<body>
<div class="card" style="width: 25rem; margin-top: 100px;margin-left: auto;margin-right: auto">
  <img src="./Pictures/main01.jpg" class="card-img-top" alt="...">
  <div class="card-body">
    <h5 class="card-title">预约会议室</h5>
    <p class="card-text">根据所需进行会议室预约</p>
  </div>
  <ul class="list-group list-group-flush">
    <form action="/Meeting/updateStaff" method="get">
      <li class="list-group-item">
        员工编号：<input type="text" name="staff_id" value="<%=request.getParameter("init_staff_id")%>" readonly><br>
      </li>
      <li class="list-group-item">
        员工姓名：<input type="text" name="staff_name"><br>
      </li>
      <li class="list-group-item">
        员工年龄：<input type="text" name="staff_age"><br>
      </li>
      <li class="list-group-item">
        联系方式：<input type="text" name="staff_phone"><br>
      </li>
      <li class="list-group-item">
        员工地址：<input type="text" name="staff_address"><br>
      </li>
      <li class="list-group-item">
        <input type="submit" value="修改" id="submit">
      </li>
    </form>
  </ul>
</div>
</body>
</html>
