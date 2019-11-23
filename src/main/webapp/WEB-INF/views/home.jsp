<%--
  Created by IntelliJ IDEA.
  User: wojciech
  Date: 22.09.19
  Time: 12:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Strona główna</title>
    <script src="<c:url value="/webjars/jquery/3.0.0/jquery.min.js"/>"></script>
    <script src="<c:url value="/webjars/bootstrap/4.3.1/js/bootstrap.min.js"/>"></script>
    <link href="<c:url value="/webjars/bootstrap/4.3.1/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/main.css"/>" rel="stylesheet">
</head>
<body>
<%@include file="/WEB-INF/views/fragments/header.jspf" %>

<div class="container mainBody">
    <div class="card text-center">
        <div class="ctr">
            <h1 class="primaryTitle">Witaj na stronie Bógmacher!</h1>
            <h3 class="secondaryTitle">Strona dla hazardzistów o mocnych nerwach!</h3><br>
            <p class="primaryComment">Obstawiaj mecze swoich ulubionych druzyn.</p>
            <p class="primaryComment"> Wygrywaj ogromne pieniądze i zostań obrzydliwie bogaty.</p>
            <p class="secondaryComment"> Do dzieła! Rejestruj się!</p>
        </div>
    </div>
</div>
<%--
    <sec:authorize access="isAuthenticated()">
    <h1>Jesteś zalogowany!</h1>
    </sec:authorize>
    <sec:authorize access="hasRole('ADMIN')">
        JESTEŚ ADMINEM!!!
    </sec:authorize>
    <sec:authorize access="isAuthenticated()">
        <p>Zalogowany jako: <sec:authentication property="principal.username"/></p>
        <p>Posiada role: <sec:authentication property="principal.authorities"/></p>
    </sec:authorize>
--%>
</body>
</html>