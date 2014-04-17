<jsp:include page="../include/header.jsp" />
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	
	<h1>System Errors</h1>
 
	<c:if test="${not empty exception.message}">
		<h4>${exception.message}</h4>
	</c:if>
<jsp:include page="../include/footer.jsp" />
