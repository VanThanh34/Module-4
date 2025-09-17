<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
<h1>Dictionary</h1>
<br/>
<form action="${pageContext.request.contextPath}/dictionary">
<label for="eng">Word: </label>
<input type="text" id="eng" name="eng">
<button type="submit">Search</button>
</form>
</body>
</html>