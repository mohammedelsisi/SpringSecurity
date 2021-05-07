<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Contact Us</title>
    <style>
        .card {
            width: 50%;
            margin: auto;
            margin-top: 41px;
            border-radius: 10px;
        }

    </style>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">Labs</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
            <li class="nav-item active">
                <a class="nav-link" href="${pageContext.request.contextPath}/contactus">Contact Us <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="${pageContext.request.contextPath}/admin/contact">Contact Us Admin<span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="${pageContext.request.contextPath}/manager/contact">Contact Us Manager <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/upload">Upload Pic</a>
            </li>
            <li class="nav-item">
                <a class="nav-link"  href="${pageContext.request.contextPath}/signup">Register User</a>
            </li>
            <li class="nav-item">
                <a class="nav-link"  href="${pageContext.request.contextPath}/header">Header Value</a>
            </li>
            <li class="nav-item">
                <a class="nav-link"  href="${pageContext.request.contextPath}/cookie">cookie Value</a>
            </li>
            <security:authorize access="isAuthenticated()">
                <li class="nav-item">
                    <a class="nav-link"  href="${pageContext.request.contextPath}/logout">logout</a>
                </li>
            </security:authorize>

        </ul>
    </div>
</nav>
<h2 align="center">
    <security:authorize access="hasAnyAuthority('ROLE_ADMIN','ROLE_MANAGER')">
        Welcome <security:authentication property="principal.username"/>
    </security:authorize>
</h2>