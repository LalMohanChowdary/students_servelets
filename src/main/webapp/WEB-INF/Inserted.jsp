<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Data Inserted</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
    }

    .message-container {
        background-color: #fff;
        padding: 30px;
        border-radius: 10px;
        box-shadow: 0px 0px 20px rgba(0, 0, 0, 0.1);
        text-align: center;
        width: 300px;
    }

    .message-container h1 {
        color: #009879;
        font-size: 24px;
        margin-bottom: 20px;
    }

    .message-container p {
        font-size: 16px;
        color: #333;
        margin-bottom: 20px;
    }

    .message-container a {
        display: inline-block;
        padding: 10px 20px;
        background-color: #009879;
        color: white;
        text-decoration: none;
        border-radius: 5px;
        transition: background-color 0.3s ease;
    }

    .message-container a:hover {
        background-color: #007a63;
    }
</style>
</head>
<body>
<form id="form-1" action="inserted">
<div class="message-container">
    <h1>Success!</h1>
    <p>Data has been successfully inserted.</p>
    <a href="index.jsp">Go Back to Home</a>
</div>

</form>
</body>
</html>
