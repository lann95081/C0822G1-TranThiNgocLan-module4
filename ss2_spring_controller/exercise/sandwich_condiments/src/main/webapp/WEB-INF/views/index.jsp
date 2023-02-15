<%--
  Created by IntelliJ IDEA.
  User: tranthingoclan
  Date: 15/12/2022
  Time: 13:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Sandwich Condiments</title>
</head>
<body>
<h1>Sandwich Condiments</h1>

<form action="/save" method="get">
    <input type="checkbox" name="condiment" value="Lettuce">Lettuce
    <input type="checkbox" name="condiment" value="Tomato">Tomato
    <input type="checkbox" name="condiment" value="Mustard">Mustard
    <input type="checkbox" name="condiment" value="Sprouts">Sprouts
    <hr style="margin-right: 1150px">

    <br>
    <button type="submit">Save</button>

    <h3>Condiments:</h3>
    <c:forEach var="temp" items="${condiment}">${temp} <br></c:forEach>
</form>
</body>
</html>
