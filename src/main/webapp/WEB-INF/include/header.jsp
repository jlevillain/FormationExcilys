<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>EPF Computer Database</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- Bootstrap -->
<link href="<c:url value="/ressources/css/bootstrap.min.css"/>" rel="stylesheet" media="screen">
<link href="<c:url value="/ressources/css/bootstrap.theme.css"/>" rel="stylesheet" media="screen">
<link href="<c:url value="/ressources/css/main.css"/>" rel="stylesheet" media="screen">
<link href="<c:url value="/ressources/css/ui-lightness/jquery-ui-1.10.4.custom.css"/>" rel="stylesheet">
<script src="<c:url value="/ressources/js/jquery-1.10.2.js"/>"></script>

<script src="<c:url value="/ressources/js/jquery.validate.js"/>"></script>
<script src="<c:url value="/ressources/js/additional-methods.js"/>"></script>
<script src="<c:url value="/ressources/js/jquery-ui-1.10.4.custom.js"/>"></script>
<script src="<c:url value="/ressources/js/main.js"/>"></script>
</head>
<body>
	<noscript>
		<h1>Our site Work Better with JavaScript</h1> 
	</noscript>
	<header class="navbar navbar-inverse">
		<h1 class="fill">
		<tags:url servlet="DashBoard"> Application - Computer Database </tags:url></li>
			
			<!-- <a href="DashBoard?search=&page=1"> Application - Computer Database </a> -->
		</h1>
	</header>
	