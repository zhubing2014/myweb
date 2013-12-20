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
    <form action="${ctx}/account/destroy" method="POST" class="form-horizontal" role="form">
        <lable class="col-sm-2"></lable>
        <button type="submit" class="btn btn-danger col-sm-2" style="margin-left: 5px"><span
                class="glyphicon glyphicon-trash"></span> DESTROY
        </button>
    </form>
</div>
<%@ include file="/WEB-INF/pages/public/import_footer.jsp" %>
<%@ include file="/WEB-INF/pages/public/settings_navigation_footer.jsp" %>
</body>
</html>