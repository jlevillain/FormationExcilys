<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<title>EPF Computer Database</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- Bootstrap -->
<link href="<c:url value="/resources/css/bootstrap.min.css"/>"
	rel="stylesheet" media="screen">
<link href="<c:url value="/resources/css/bootstrap.theme.css"/>"
	rel="stylesheet" media="screen">
<link href="<c:url value="/resources/css/main.css"/>" rel="stylesheet"
	media="screen">
<link href="<c:url value="/resources/css/signing.css"/>"
	rel="stylesheet" media="screen">

<link
	href="<c:url value="/resources/css/ui-lightness/jquery-ui-1.10.4.custom.css"/>"
	rel="stylesheet">

<script src="<c:url value="/resources/js/jquery-1.10.2.js"/>"></script>

<script src="<c:url value="/resources/js/jquery.validate.js"/>"></script>
<script src="<c:url value="/resources/js/additional-methods.js"/>"></script>
<script src="<c:url value="/resources/js/jquery-ui-1.10.4.custom.js"/>"></script>
<script src="<c:url value="/resources/js/main.js"/>"></script>
<script
	src="<c:url value="/resources/development-bundle/ui/i18n/jquery-ui-i18n.js"/>"></script>
<script
	src="<c:url value="/resources/development-bundle/ui/i18n/jquery.ui.datepicker-fr.js"/>"></script>
<style>
.error {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #a94442;
	background-color: #f2dede;
	border-color: #ebccd1;
}

.msg {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #31708f;
	background-color: #d9edf7;
	border-color: #bce8f1;
}

#login-box {
	width: 300px;
	padding: 20px;
	margin: 100px auto;
	background: #fff;
	-webkit-border-radius: 2px;
	-moz-border-radius: 2px;
	border: 1px solid #000;
}
</style>
</head>
<body>
	<noscript>
		<h1>
			<spring:message code="Javascript.without" text="default" />
		</h1>
	</noscript>
	<header class="navbar navbar-inverse">
		<h1 class="fill">
			<tags:url servlet="DashBoard">
				<spring:message code="Application.name" text="default" />
			</tags:url>

			<span style="float: right"> <c:url
					value="/j_spring_security_logout" var="logoutUrl" /> <!-- csrt for log out-->
				<form action="${logoutUrl}" method="post" id="logoutForm">
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
				</form> <script>
					function formSubmit() {
						document.getElementById("logoutForm").submit();
					}
				</script> <c:if test="${pageContext.request.userPrincipal.name != null}">
					<h4>
						<spring:message code="Header.welcome" text="default" />
						: ${pageContext.request.userPrincipal.name} | <a
							href="javascript:formSubmit()"> <spring:message
								code="Header.logout" text="default" /></a>
					</h4>
				</c:if> <c:if test="${not empty msg}">
					<div class="btn btn-success">${msg}</div>
				</c:if> <a href="?lang=en"><img
					src='<c:url value="/resources/images/anglais.png"/>' /></a> | <a
				href="?lang=fr"><img
					src='<c:url value="/resources/images/francais.png"/>' /></a>
			</span>
			<!-- <a href="DashBoard?search=&page=1"> Application - Computer Database </a> -->
		</h1>
	</header>