<%--
  Created by IntelliJ IDEA.
  User: Starry Sky
  Date: 2022/12/27
  Time: 2:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>会议室信息修改</title>
    <script src="<%=request.getContextPath()%>/Bootstrap5/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/Bootstrap5/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/ManageUpdateRoom.css">
</head>
<body>
<div class="card" style="width: 25rem; margin-top: 100px;margin-left: auto;margin-right: auto">
    <img src="./Pictures/main01.jpg" class="card-img-top" alt="...">
    <div class="card-body">
        <h5 class="card-title">预约会议室</h5>
        <p class="card-text">根据所需进行会议室预约</p>
    </div>
    <ul class="list-group list-group-flush">
        <form action="/Meeting/UpdateManageRoom" method="post">
            <li class="list-group-item">
                会议室编号：<input type="text" name="room_id" value="<%=request.getParameter("room_id")%>" readonly><br>
            </li>
            <li class="list-group-item">
                开始时间：<input type="text" name="start_time"><br>
            </li>
            <li class="list-group-item">
                结束时间：<input type="text" name="end_time"><br>
            </li>
            <li class="list-group-item">
                会议室地址：<input type="text" name="address"><br>
            </li>
            <li class="list-group-item">
                会议室最大容量：<input type="text" name="max_people"><br>
            </li>
            <li class="list-group-item">
                <input type="submit" value="修改" id="submit">
            </li>
        </form>
    </ul>
</div>
</body>
</html>
