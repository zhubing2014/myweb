<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script>
    $(function () {
        var url = window.location.href;
        if (url.indexOf('settings') > -1) {
            $('#account_settings').addClass('active');
        } else if (url.indexOf('password') > -1) {
            $('#account_password').addClass('active');
        } else if (url.indexOf('destroy') > -1) {
            $('#account_destroy').addClass('active');
        }
    });
</script>