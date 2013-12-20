<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/pages/public/import_header.jsp" %>
<html>
<head>
    <title>Set New Password</title>
    <style>
        body {
            padding-top: 130px;
            padding-bottom: 40px;
            background-color: #eee;
        }

        .form {
            max-width: 330px;
            padding: 15px;
            margin: 0 auto;
        }
    </style>
</head>
<body>
<div class="container">
    <form class="form" action="${ctx}/account/setNewPassword" method="POST">
        <div class="form-group">
            <strong>Set New Password</strong>
        </div>
        <input type="hidden" name="username" value="${username}">

        <div class="form-group">
            <input name="password" type="password" class="form-control" placeholder="New password" required>
        </div>

        <div class="form-group">
            <input name="rePassword" type="password" class="form-control" placeholder="Re-password" required>
        </div>

        <button class="btn  btn-primary btn-block" type="submit"><span class="glyphicon glyphicon-lock"></span>
            Set New Password
        </button>
    </form>
</div>
<%@ include file="/WEB-INF/pages/public/import_footer.jsp" %>
</body>
</html>