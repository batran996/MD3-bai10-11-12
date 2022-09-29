<%--
  Created by IntelliJ IDEA.
  User: doquyen7796
  Date: 27/09/2022
  Time: 16:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>DELETE STUDENT</h1>
<c:if test='${requestScope["message"]!=null}'>
    <span style="color: chocolate">${requestScope["message"]}</span>
</c:if>
<form method="post">
    <lable>Name</lable>
    <br>
    <p>${requestScope["product"].name}</p>
    <lable>Price</lable>
    <br>
    <p>${requestScope["product"].price}</p>
    <br>
    <lable>Storage</lable>
    <p>${requestScope["product"].storage}</p>
    <button>Click for delete</button>
</form>
<a href="/view"><button>click for List</button></a>
</body>
</html>
