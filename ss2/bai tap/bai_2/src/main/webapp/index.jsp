<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>Calculator</h1>
<br/>
<form action="calculate">
<input type="text" name="num1">
<input type="text" name="num2"><br><br>
    <button type="submit" name="operation" value="Addition">Addition(+)</button>
    <button type="submit" name="operation" value="Subtraction">Subtraction(-)</button>
    <button type="submit" name="operation" value="Multiplication">Multiplication(X)</button>
    <button type="submit" name="operation" value="Division">Division(/)</button>

</form>
</body>
</html>