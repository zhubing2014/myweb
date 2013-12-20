<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/pages/public/import_header.jsp" %>

<html>
<head>
    <title>Login</title>

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

    <form class="form" action="${ctx}/j_spring_security_check" method="POST">
        <div class="form-group">
            <strong>Login</strong>
            <a href="account/signIn" class="pull-right"><span>Sign in</span> <span
                    class="glyphicon glyphicon-circle-arrow-right"></span></a>
        </div>
        <div class="form-group">
            <input name="j_username" type="email" class="form-control" placeholder="Email address" required>

        </div>
        <div class="form-group">
            <input name="j_password" type="password" class="form-control" placeholder="Password">
        </div>

        <span class="checkbox">
            <input id="ck" type="checkbox" name="_spring_security_remember_me"> <label for="ck">Remember me</label>
            <a href="${ctx}/account/resetPassword" class="pull-right"> Forget password?</a>
        </span>

        <button class="btn  btn-primary btn-block" type="submit"><span class="glyphicon glyphicon-log-in"></span> Login
            Account
        </button>
        <c:if test="${SPRING_SECURITY_LAST_EXCEPTION != null}">
            <div class="alert alert-danger fade in" style="margin-top: 10px;">
                <a class="close" data-dismiss="alert" href="#" aria-hidden="true">&times;</a>
                <strong>Warning!</strong>

                <p>Username or password is wrong.</p>
            </div>
        </c:if>
    </form>
</div>
<%@ include file="/WEB-INF/pages/public/import_footer.jsp" %>
<script>
    $(function () {
        $(".alert").alert();
    });
</script>
</body>
</html>