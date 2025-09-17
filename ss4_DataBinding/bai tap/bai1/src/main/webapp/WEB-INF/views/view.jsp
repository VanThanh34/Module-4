<%--
  Created by IntelliJ IDEA.
  User: vvt13
  Date: 9/17/2025
  Time: 2:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Current Settings</title></head>
<body>
<h1>Current Email Settings</h1>
<ul>
  <li>Language: ${settings.language}</li>
  <li>Page Size: ${settings.pageSize}</li>
  <li>Spam Filter: ${settings.spam ? 'Enabled' : 'Disabled'}</li>
  <li>Signature: ${settings.sign}</li>
</ul>

<a href="${pageContext.request.contextPath}/setting">Back to Settings</a>
</body>
</html>

