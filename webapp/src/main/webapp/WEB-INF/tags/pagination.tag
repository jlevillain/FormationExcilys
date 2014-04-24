<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@attribute name="begin" required="true" %>
<%@attribute name="end" required="true" %>
<%@attribute name="interval" required="true" %>
<%@attribute name="page" required="true"  %>
<%@attribute name="search" required="true" %>
<%@attribute name="isDesc" required="true" %>
<%@attribute name="orderBy" required="true" %>
<%@attribute name="nbPage" required="true" %>
<c:if test="${page+0<begin}"><c:set var="page" value="${begin}"></c:set></c:if>
<c:if test="${page+0>end}"><c:set var="page" value="${end}"></c:set></c:if>
<div align="center">
	<ul class="pagination">
		<li><tags:url servlet="DashBoard" pageNumber="${(page-1<begin)?begin:page-1}" search="${search}" orderBy="${orderBy}" isDesc="${isDesc}" nbPage="${nbPage}">&laquo;</tags:url></li>
			<c:forEach var="nombre" begin="${(page-interval)<begin?begin:page-interval}" end="${(page+interval)>end?end:page+interval}">
				<li>
				
				<tags:url servlet="DashBoard" pageNumber="${nombre}" search="${search}" orderBy="${orderBy}" isDesc="${isDesc}"  nbPage="${nbPage}">${nombre}</tags:url></li>
				
				<!-- <a href="?search=${search}&page=${nombre}&orderBy=&="></a></li>  -->
			</c:forEach>
	  	<li><tags:url servlet="DashBoard" pageNumber="${(page+1>end)?end:page+1}" search="${search}" orderBy="${orderBy}" isDesc="${isDesc}" nbPage="${nbPage}">&raquo;</tags:url></li>
	</ul>
</div>
