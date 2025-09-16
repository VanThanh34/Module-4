<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
<h1>Sandwich Condiments</h1>
<br/>
<form action="${pageContext.request.contextPath}/save" method="post">
  <label><input type="checkbox" name="condiment" value="lettuce"> Lettuce</label>
  <label><input type="checkbox" name="condiment" value="tomato"> Tomato</label>
  <label><input type="checkbox" name="condiment" value="mustard"> Mustard</label>
  <label><input type="checkbox" name="condiment" value="sprouts"> Sprouts</label>
  <br><br>
  <button type="submit">Save</button>
</form>

</body>
</html>