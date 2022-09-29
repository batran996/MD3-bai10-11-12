<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1 style="text-align: center;color: darkred">----------PRODUCT MANAGE---------------</h1>
<a href="view?action=create"><button>CreateNewProduct</button></a>
<form method="post">
    <input type="text" name="search"><button>search</button>
</form>
<table border="1" width="100%" style="color: darkred">
    <tr>
        <th>ID</th>
        <th>NAME</th>
        <th>PRICE</th>
        <th>EDIT</th>
        <th>DELETE</th>
    </tr>
    <c:forEach var="pr" items='${requestScope["productList"]}'>
        <tr>
            <td>${pr.id}</td>
            <td>${pr.name}</td>
            <td>${pr.price}</td>
       <td><a href="view?action=edit&id=${pr.id}"><button style="color: #340d59;border-radius: 15%">Edit</button></a></td>
            <td><a href="view?action=delete&id=${pr.id}"><button style="color: #340d59;border-radius: 15%">Delete</button></a></td>


<%--            <td>${pr.storage}</td>--%>
        </tr>

    </c:forEach>
</table>

</body>
</html>