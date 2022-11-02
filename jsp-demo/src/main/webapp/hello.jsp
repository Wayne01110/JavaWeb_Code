<%--
  Created by IntelliJ IDEA.
  User: wayne
  Date: 2022/6/21
  Time: 15:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <h1>Hello jsp</h1>

    <%
        out.println("hello jsp ~");
        int i = 3;
    %>

    <%="hello"%>
    <%=i%>

    <%!
        void show() {}
        String name = "zhangsan";
    %>


</body>
</html>
