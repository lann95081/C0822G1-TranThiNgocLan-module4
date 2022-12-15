<%--
  Created by IntelliJ IDEA.
  User: tranthingoclan
  Date: 15/12/2022
  Time: 14:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Caculator</title>
</head>
<body>
<h1>Caculator</h1>
<form action="" method="post">
    <input type="text" name="number1" placeholder="Input first number" value="${number1}">
    <input type="text" name="number2" placeholder="Input second number" value="${number2}">
    <br>
    <br>
    <button type="submit" name="caculator" value="Addition"> Addition(+)</button>
    <button type="submit" name="caculator" value="Subtraction"> Subtraction(-)</button>
    <button type="submit" name="caculator" value="Multiplication"> Multiplication(x)</button>
    <button type="submit" name="caculator" value="Division"> Division(/)</button>

    <h3>Result: ${result}</h3>
</form>
</body>
</html>
