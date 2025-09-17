<%--
  Created by IntelliJ IDEA.
  User: vvt13
  Date: 9/17/2025
  Time: 2:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Email Settings</title></head>
<body>
<h1>Email Settings</h1>

<form:form method="post" modelAttribute="settings">
    <table cellpadding="8">
        <tr>
            <td><strong>Languages:</strong></td>
            <td>
                <form:select path="language" items="${languages}"/>
            </td>
        </tr>
        <tr>
            <td><strong>Page Size:</strong></td>
            <td>
                Show <form:select path="pageSize" items="${pageSizes}"/> emails per page
            </td>
        </tr>
        <tr>
            <td><strong>Spam filter:</strong></td>
            <td>
                <form:checkbox path="spam"/> Enable spam filter
            </td>
        </tr>
        <tr>
            <td><strong>Signature:</strong></td>
            <td>
                <form:textarea path="sign" rows="5" cols="30"/>
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <button type="submit">Update</button>
            </td>
        </tr>
    </table>
</form:form>

</body>
</html>

