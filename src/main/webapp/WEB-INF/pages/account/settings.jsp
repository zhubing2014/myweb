<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/pages/public/import_header.jsp" %>
<%--@elvariable id="account" type="com.zchen.bean.Account"--%>
<html>
<head>
    <title>My Info Page</title>
    <link rel='stylesheet' href="${ctx}/static/css/bootstrap-datetimepicker.min.css">
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
    <form action="${ctx}/account/save" method="POST" class="form-horizontal" role="form">
        <input type="hidden" name="id" value="${account.id}">
        <input type="hidden" name="username" value="${account.username}">

        <%--User name field--%>
        <div class="form-group">
            <label class="col-sm-2 control-label">User name :</label>

            <div class="col-sm-4">
                <p class="form-control-static">${account.username}</p>
            </div>
        </div>
        <%--Nick name field--%>

        <div class="form-group">
            <label for="nickname" class="col-sm-2 control-label">Nick name :</label>

            <div class="col-sm-4">
                <input id="nickname" name="nickname" type="text" class="form-control" value="${account.nickname}">
            </div>
        </div>
        <%--Real name field--%>
        <div class="form-group">
            <label for="realname" class="col-sm-2 control-label">Real name :</label>

            <div class="col-sm-4">
                <input id="realname" name="realname" type="text" class="form-control" value="${account.realname}">
            </div>
        </div>
        <%--Sex field--%>
        <div class="form-group">
            <label class="col-sm-2 control-label">Gender :</label>

            <div class="col-sm-4">
                <div class="btn-group" data-toggle="buttons">
                    <c:if test="${account.sex == '1'}">
                        <label id="male_gender" class="btn btn-default active" style="width: 70px">
                            <input type="radio" name="sex" value="1" checked="checked"> Male
                        </label>
                        <label id="female_gender" class="btn btn-default" style="width: 70px">
                            <input type="radio" name="sex" value="0"> Female
                        </label>
                    </c:if>
                    <c:if test="${account.sex == '0'}">
                        <label id="male_gender" class="btn btn-default" style="width: 70px">
                            <input type="radio" name="sex" value="1"> Male
                        </label>
                        <label id="female_gender" class="btn btn-default active" style="width: 70px">
                            <input type="radio" name="sex" value="0" checked="checked"> Female
                        </label>
                    </c:if>
                </div>
            </div>
        </div>

        <%--birthday--%>
        <div class="form-group">
            <label for="birthday" class="col-sm-2 control-label">Birthday :</label>

            <div class="input-group date form_date col-sm-4" data-date-format="yyyy-mm-dd" data-link-field="dtp_input1">
                <input id="birthday" name="birthday" class="form-control" type="text" value="${account.birthday}"
                       readonly>
                <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
            </div>
        </div>

        <%--email--%>
        <div class="form-group">
            <label for="email" class="col-sm-2 control-label">Contact email :</label>

            <div class="col-sm-4">
                <input id="email" name="email" type="email" class="form-control" value="${account.email}">
            </div>
        </div>
        <lable class="col-sm-2"></lable>
        <button type="submit" class="btn btn-primary col-sm-2" style="margin-left: 5px"><span
                class="glyphicon glyphicon-floppy-disk"></span> Save
        </button>
        <button type="reset" class="btn btn-default" style="margin-left: 10px" onclick="reset_gender()">Cancel</button>

    </form>


</div>
<%@ include file="/WEB-INF/pages/public/import_footer.jsp" %>
<%@ include file="/WEB-INF/pages/public/settings_navigation_footer.jsp" %>
<script src='${ctx}/static/js/bootstrap-datetimepicker.min.js'></script>
<%--<script src='${ctx}/static/js/locales/bootstrap-datetimepicker.zh-CN.js'></script>--%>
<script>
    $(function () {
        $('.btn-group').button();
        $('.form_date').datetimepicker({
//                language: 'zh-CN',
            autoclose: 1,
            startView: 2,
            minView: 2,
            forceParse: 0
        });
        gender = ${account.sex};
    });

    function reset_gender() {
        if (gender == 1) {
            $('#male_gender').addClass('active');
            $('#female_gender').removeClass('active');
        } else if (gender == 0) {
            $('#female_gender').addClass('active');
            $('#male_gender').removeClass('active');
        }
    }
</script>
</body>
</html>