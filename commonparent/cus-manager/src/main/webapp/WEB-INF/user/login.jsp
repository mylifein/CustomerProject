<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/3
  Time: 15:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/user/login.do">
    <table align="center" width="800px">
        <tr>
            <td>用户名：</td>
            <td><input type="text" name="username"/></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input type="password" name="password"/></td>
        </tr>
        <tr>
            <td colspan="2"><div style="color:red;font-size: 12px">提示信息：${requestScope.msg}</div></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" name="登陆"/></td>
        </tr>
    </table>
</form>
</body>
</html>
