<%--
  Created by IntelliJ IDEA.
  User: vvt13
  Date: 9/16/2025
  Time: 4:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lỗi hệ thống</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f4f6f9;
            margin: 0;
            padding: 0;
        }
        .container {
            max-width: 600px;
            margin: 80px auto;
            background: #fff;
            padding: 30px 40px;
            border-radius: 12px;
            box-shadow: 0 4px 15px rgba(0,0,0,0.15);
            text-align: center;
        }
        h1 {
            color: #e74c3c;
            font-size: 36px;
            margin-bottom: 15px;
        }
        p {
            font-size: 18px;
            color: #333;
            margin: 10px 0;
        }
        .message {
            background: #fdecea;
            border: 1px solid #f5c2c0;
            color: #c0392b;
            padding: 12px;
            border-radius: 8px;
            margin: 20px 0;
        }
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
<div class="container">
    <h1>⚠️ Đã xảy ra lỗi!</h1>
    <p><strong>${errorTitle}</strong></p>
    <div class="message">
        ${errorMessage}
    </div>
    <a href="index.jsp">⬅ Quay lại chọn nguyên liệu</a>
</div>
</body>
</html>

