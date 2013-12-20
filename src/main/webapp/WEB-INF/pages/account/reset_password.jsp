<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/pages/public/import_header.jsp" %>
<html>
<head>
    <title>Forget Password</title>
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
    <form class="form" action="${ctx}/account/resetPassword" method="POST">
        <div class="form-group">
            <strong>Reset Password</strong>
            <a href="${ctx}/login" class="pull-right"><span>Login</span> <span
                    class="glyphicon glyphicon-circle-arrow-right"></span></a>
        </div>
        <div class="form-group">
            <input id="username" name="username" type="email" class="form-control" placeholder="Email address" required>

            <p class="help-block">We will send an email that includes resetting password link to you soon.</p>
        </div>

        <button id="save_btn" class="btn  btn-primary btn-block" type="submit" data-loading-text="Sending..."
                onclick="sending()"><span class="glyphicon glyphicon-envelope"></span>
            Reset Password
        </button>
        <c:if test="${message != null}">
            <div class="alert alert-danger fade in" style="margin-top: 10px;">
                <a class="close" data-dismiss="alert" href="#" aria-hidden="true">&times;</a>
                <strong>Warning!</strong>

                <p>${message}</p>
            </div>
        </c:if>
        <c:if test="${success != null}">
            <div class="alert alert-success  fade in" style="margin-top: 10px;">
                <a class="close" data-dismiss="alert" href="#" aria-hidden="true">&times;</a>
                <strong>Info</strong>

                <p>${success}</p>
            </div>
        </c:if>
    </form>
</div>
<%@ include file="/WEB-INF/pages/public/import_footer.jsp" %>
<script>
    function sending() {
        $('#save_btn').button('loading');
    }
</script>
</body>
</html>