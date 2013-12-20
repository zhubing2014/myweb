<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/pages/public/import_header.jsp" %>
<html>
<head>
    <title>Sign in</title>
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
    <script>
        $(function () {
            $(".alert").alert();
        });
    </script>
</head>
<body>
<div class="container">
    <form class="form" action="${ctx}/account/signIn" method="POST">
        <div class="form-group">
            <strong>Sign in</strong>
            <a href="${ctx}/login" class="pull-right"><span>Login</span> <span
                    class="glyphicon glyphicon-circle-arrow-right"></span></a>
        </div>
        <%--username--%>
        <div class="form-group">
            <input name="username" type="email" class="form-control" placeholder="Email address" required>
            <%--password--%>
        </div>
        <div class="form-group">
            <input name="password" type="password" class="form-control" placeholder="Password" required>
        </div>


        <button class="btn  btn-primary btn-block" type="submit"><span class="glyphicon glyphicon-user"></span> Sign in
        </button>

        <c:if test="${message != null}">
            <div class="alert alert-danger fade in" style="margin-top: 10px;">
                <a class="close" data-dismiss="alert" href="#" aria-hidden="true">&times;</a>
                <strong>Warning!</strong>

                <p>${message}</p>
            </div>
        </c:if>
    </form>
</div>
<%@ include file="/WEB-INF/pages/public/import_footer.jsp" %>
</body>
</html>