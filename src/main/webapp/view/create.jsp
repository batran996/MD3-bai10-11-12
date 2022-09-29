<%--
  Created by IntelliJ IDEA.
  User: doquyen7796
  Date: 27/09/2022
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>FORM CREATE PRODUCT</h1>
<a href="/products">Back List product</a> <br>
<c:if test='${requestScope["message"]!=null}'>
    <span style="color: chocolate">${requestScope["message"]}</span> <br>
</c:if>
<form method="post">
    <lable>NAME</lable> <br>
    <input type="text" name="name"> <br>
    <lable>PRICE</lable> <br>
    <input type="text" name="price"> <br>
    <lable>STORAGE</lable>
    <br>
    <input type="text" name="storage"> <br>
    <button>Create</button>
</form>
</body>
</html>
