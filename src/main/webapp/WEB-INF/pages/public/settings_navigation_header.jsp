<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx">${pageContext.request.contextPath}</c:set>

<ul class="nav nav-tabs col-sm-offset-1" style="margin-top: 30px; margin-bottom: 30px">
    <li id="account_settings"><a href="${ctx}/account/settings">Account Settings</a></li>
    <li id="account_password"><a href="${ctx}/account/password">Change Password</a></li>
    <li id="account_destroy"><a href="${ctx}/account/destroy">Destroy Account</a></li>
</ul>