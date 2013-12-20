<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/pages/public/import_header.jsp" %>
<html>
<head>
    <title>Error</title>
    <style>
        body {
            padding-top: 150px;
            padding-bottom: 40px;
            background-color: #eee;
        }

        .form {
            max-width: 380px;
            padding: 15px;
            margin: 0 auto;
        }

    </style>
    <script>
        $(function () {
            $(".alert").alert();
        });
    </script>
</head>
<body>
<div class="container">

    <form class="form">

        <div class="alert alert-danger fade in" style="margin-top: 10px;">
            <strong>Error!</strong>

            <p>${message}</p>

            <p>Please access <a href="${ctx}/login">Login page</a>.</p>
        </div>

    </form>
</div>
<%@ include file="/WEB-INF/pages/public/import_footer.jsp" %>
</body>
</html>