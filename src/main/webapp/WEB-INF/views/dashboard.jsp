<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Bógmacher</title>
    <script src="<c:url value="/webjars/jquery/3.0.0/jquery.min.js"/>"></script>
    <script src="<c:url value="/webjars/bootstrap/4.3.1/js/bootstrap.min.js"/>"></script>
    <link href="<c:url value="/webjars/bootstrap/4.3.1/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/main.css"/>" rel="stylesheet">
</head>
<body>

<%@include file="/WEB-INF/views/fragments/header.jspf" %>

<div class="container up225">
    <div class="card text-center">
        <div class="ctr">
            <sec:authorize access="hasRole('ADMIN')">
                <h1 class="up50">Witaj ${user.username}!</h1>
                <h3 class="up25 down75">Zarządzaj meczami.</h3>
            </sec:authorize>

            <sec:authorize access="hasRole('USER')">
                <h1 class="up50">Witaj ${user.username}!</h1>
                <h3 class="up25">Aktualnie posiadasz <fmt:formatNumber value="${user.credit}" type="currency" currencySymbol="zł"/>.</h3>
                <p class="up50 down75">Trochę mało. Może obstaw jakiś meczyk...</p>
            </sec:authorize>
        </div>
    </div>
</div>
</body>
</html>