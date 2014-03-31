<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@attribute name="servlet" required="true"  %>
<%@attribute name="page" required="false"  %>
<%@attribute name="search" required="false" %>
<%@attribute name="orderBy" required="false" %>
<%@attribute name="isDesc" required="false" %>
<jsp:doBody var="tagBody"/>
<c:if test="${empty page}">
	<c:set var="page" value="1"></c:set>
</c:if>
<c:if test="${empty orderBy}">
	<c:set var="orderBy" value="2"></c:set>
</c:if>
<c:if test="${empty isDesc}">
	<c:set var="isDesc" value="false"></c:set>
</c:if>
<a href="${servlet}?search=${search}&page=${page}&orderBy=${orderBy}&isDesc=${isDesc}">${tagBody}</a>