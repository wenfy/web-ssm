<%--
  Created by IntelliJ IDEA.
  User: w-fy
  Date: 2017/1/11
  Time: 16:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <base href="../">
    <script type="text/javascript" src="js/jquery/1.9.1/jquery.min.js"></script>
    <script type="text/javascript" src="js/laydate/laydate.js"></script>
    <script type="text/javascript" src="js/layer/layer.js"></script>
    <script  type="text/javascript"  src="js/H-ui.js"></script>
    <script  type="text/javascript"   src="js/H-ui.admin.js"></script>
<style>
    #a1{margin-left: 1000px;margin-top: 2px}
</style>
</head>
<body>
<table>
<form action="./Record/seach" method="post">
    <label class="title"><b>姓名：</b></label>
    <input type="text" name="username" >
    <button type="submit">查询</button>
</form>
<a id="a1" href="http://localhost:8080/web-ssm/User/add">注册新用户</a>
</table>
<table border="2" >
    <thead>
    <tr>
        <th width="20%">标题</th>
        <th width="10%">编写人</th>
        <th width="10%">时间</th>
        <th width="15%">操作</th>
    </tr>
    </thead>
    <tbody align="center">
    <c:forEach items="${requestScope.userList}" var="row">
        <tr>
            <td >${row.name}</td>
            <td >${row.username}</td>
            <td >${row.data}</td>
            <td >
                <!--   <a href="javascript:openedit(${row.id});">修改</a>  -->
                <a href="./Record/look2?id=${row.id}">查看内容</a>
            </td>

        </tr>
    </c:forEach>




    </div>
    </tbody>

</table>

</body>
</html>
