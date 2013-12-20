<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/pages/public/import_header.jsp" %>
<html>
<head>
    <title>My Info Page</title>
    <style>
        body {
            padding-top: 50px;
        }
    </style>
</head>
<body>
<jsp:include page="../public/home_navigation.jsp"/>
<div class="container">
    <jsp:include page="../public/settings_navigation_header.jsp"/>
    <form action="${ctx}/account/password" method="POST" class="form-horizontal" role="form"
          onsubmit="return check_password();">

        <%--old password--%>
        <div class="form-group">
            <label for="oldPassword" class="col-sm-2 control-label">Old password :</label>

            <div class="col-sm-4">
                <input id="oldPassword" name="oldPassword" type="password" class="form-control" required>
            </div>
        </div>
        <%--new password--%>

        <div class="form-group">
            <label for="newPassword" class="col-sm-2 control-label">New password :</label>

            <div class="col-sm-4">
                <input id="newPassword" name="newPassword" type="password" class="form-control" required>
            </div>
        </div>

        <div class="form-group" id="rePassword_form_group">
            <label for="rePassword" class="col-sm-2 control-label">Re-password :</label>

            <div class="col-sm-4">
                <input id="rePassword" type="password" class="form-control" required onblur="check_password()">
            </div>
            <p id="password_help" class="help-block hidden"><span class="glyphicon glyphicon-lock"></span> Passwords are
                not equal.</p>
        </div>

        <lable class="col-sm-2"></lable>
        <button type="submit" class="btn btn-primary col-sm-2" style="margin-left: 5px"><span
                class="glyphicon glyphicon-floppy-disk"></span> Save
        </button>
            <button type="reset" class="btn btn-default" style="margin-left: 10px" onclick="clean_error()">Cancel
            </button>

    </form>


</div>
<%@ include file="/WEB-INF/pages/public/import_footer.jsp" %>
<%@ include file="/WEB-INF/pages/public/settings_navigation_footer.jsp" %>
<script>
    function check_password() {
        var newPassword = $("#newPassword").val();
        var rePassword = $("#rePassword").val();
        if (newPassword != rePassword) {
            $("#rePassword_form_group").addClass("has-error");
            $("#password_help").removeClass("hidden");
            return false;
        } else {
            $("#rePassword_form_group").removeClass("has-error");
            $("#password_help").addClass("hidden");
            return true;
        }
    }
    function clean_error() {
        $("#password_help").addClass("hidden");
    }
</script>
</body>
</html>