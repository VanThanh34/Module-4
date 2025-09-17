<%--
  Created by IntelliJ IDEA.
  User: vvt13
  Date: 9/16/2025
  Time: 1:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        a {
            display: inline-block;
            margin-top: 20px;
            padding: 12px 24px;
            background: #3498db;
            color: #fff;
            text-decoration: none;
            font-size: 16px;
            border-radius: 8px;
            transition: background 0.3s ease;
        }
        a:hover {
            background: #2980b9;
        }
    </style>
</head>
<body>
<h2>Result</h2>
<p>English: ${word}</p>
<p>Vietnamese: ${meaning}</p>

<a href="index.jsp">Back to Home</a>

</body>
</html>
