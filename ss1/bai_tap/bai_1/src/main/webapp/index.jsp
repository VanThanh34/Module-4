<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Money Convert" %></h1>
<br/>
<form action="${pageContext.request.contextPath}/convert">
<label for="usd">USD: </label>
<input type="number" id="usd" name="usd">
<button type="submit">Convert</button>
</form>

</body>
</html>