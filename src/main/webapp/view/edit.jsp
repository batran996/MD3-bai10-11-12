<%--
  Created by IntelliJ IDEA.
  User: doquyen7796
  Date: 27/09/2022
  Time: 16:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>edit</title>
</head>
<body>
<a href="/products"><button>Back</button></a>
<form method="post">
    <h1>EDIT</h1>
    <lable>Name</lable>
    <br>
    <input type="text" name="name"> <br>
    <lable>Price</lable>
    <br>
    <input type="text" name="price"><br>
    <lable>Storage</lable>
    <br>
    <input type="text" name="storage"><br>
    <button style="border-radius: 15%;color: darkred">Update</button>
</form>

</body>
</html>
