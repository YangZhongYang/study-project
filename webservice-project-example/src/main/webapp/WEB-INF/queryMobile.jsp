<%--
  User: meicai
  Date: 2016/3/9
  Time: 11:18
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>归属地查询</title>
</head>
<body>
<form action="queryMobile.action" method="post">
    手机号：<input type="text" name="phoneNum"><br>
    <input type="submit" value="查询">
    查询结果：${result}
</form>
</body>
</html>