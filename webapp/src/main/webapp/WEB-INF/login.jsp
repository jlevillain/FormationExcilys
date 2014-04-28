<jsp:include page="include/header.jsp" />
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="container" onload='document.loginForm.username.focus();'>
	<h1>
		<spring:message code="Login.title" text="default" />
	</h1>



	<form name='loginForm' class="form-signin" role="form"
		action="<c:url value='j_spring_security_check' />" method='POST'>

		<c:if test="${not empty error}">
			<div class="bg-danger">${error}</div>
		</c:if>
		<h3 class="form-signin-heading">
			<spring:message code="Login.title2" text="default" />
		</h3>

		<input class="form-control" type='text' name='username' value=''
			placeholder='<spring:message code="Login.user" text="default"/>'>

		<input class="form-control" type='password' name='password'
			placeholder='<spring:message code="Login.password" text="default"/>' />

		<input class="btn btn-lg btn-primary btn-block" name="submit"
			type="submit"
			value='<spring:message code="Login.submit" text="default"/>' /> <input
			type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

	</form>
</div>

<jsp:include page="include/footer.jsp" />