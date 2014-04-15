<jsp:include page="include/header.jsp" />
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<section id="main">
	<h1 id="homeTitle"><!--  456-->${page.computerSize} <spring:message code="foundComputer.title" text="default"/>
	<c:if test="${page.search!=''}">with "${page.search}"</c:if></h1>
	<div id="actions">
		<form class="form-inline" action="" method="GET">
				<input class="form-control" type="search" id="searchbox" name="search"
					value="${page.search}" placeholder='<spring:message code="searchComputer.title" text="default"/>'>
				<input type="hidden" name="page" value="1">
				<input type="hidden" name="orderBy" value="${page.orderBy}">
				<input type="hidden" name="isDesc" value="${page.desc}">
				<input type="hidden" name="nbPage" value="${page.nbPage}">
				<input type="submit" id="searchsubmit"
					value='<spring:message code="filterComputer.title" text="default"/>'
					class="btn btn-primary">
			
		</form>
		<a class="btn btn-success" id="add" href="AddComputer"><spring:message code="addComputer.title" text="default"/></a>
	</div>

		<table class="table table-striped">
			<thead>
				<tr>
					<!-- Variable declarations for passing labels as parameters -->
					<!-- Table header for Computer Name -->
					
					<th><tags:url servlet="DashBoard" page="${page.page}" search="${page.search}" orderBy="2" isDesc="${(page.desc == 'false')?'true':'false'}" nbPage="${nbPage}"><spring:message code="Computer.title.name"/></tags:url></th>
					<th><tags:url servlet="DashBoard" page="${page.page}" search="${page.search}" orderBy="3" isDesc="${(page.desc =='false')?'true':'false'}" nbPage="${nbPage}"><spring:message code="Computer.title.introduced"/></tags:url></th>
					<!-- Table header for Discontinued Date -->
					<th><tags:url servlet="DashBoard" page="${page.page}" search="${page.search}" orderBy="4" isDesc="${(page.desc =='false')?'true':'false'}" nbPage="${nbPage}"><spring:message code="Computer.title.discontinued"/></tags:url></th>
					<!-- Table header for Company -->
					<th><tags:url servlet="DashBoard" page="${page.page}" search="${page.search}" orderBy="6" isDesc="${(page.desc =='false')?'true':'false'}" nbPage="${nbPage}"><spring:message code="Computer.title.company"/></tags:url></th>
				</tr>
			</thead>
			<tbody>
			
				<c:forEach var="item" items="${page.computerList}">
   					<tr><td><a href="UpdateComputer?id=${item.id}">${item.name}</a></td><td>${item.introduced} </td><td>${item.discontinued}</td><td>${item.company.name }</td><td><a class="btn btn-danger" onclick="deleteComputer('DeleteComputer?delete=${item.id}','<spring:message code="Delete.message" text="default"/>')"><spring:message code="deleteComputer.title" text="default"/></a></td></tr>
 				</c:forEach>
 				<!--  
				<tr>
					<td><a href="#" onclick="">ThinkPad T420</a></td>
					<td>2011-01-01</td>
					<td>2013-03-04</td>
					<td>Lenovo</td>
				</tr>
				<tr>
					<td><a href="#">Precision 3500</a></td>
					<td>2010-05-07</td>
					<td>2012-06-01</td>
					<td>Dell</td>
				</tr>
				<tr>
					<td><a href="#">Macbook Air</a></td>
					<td>2005-05-09</td>
					<td>2008-06-06</td>
					<td>Apple</td>
				</tr>
				-->
			</tbody>
		</table>
		
		<fmt:formatNumber var="nbPages" value="${page.computerSize/page.nbPage}"  maxFractionDigits="0" />
		<c:if test="${(page.computerSize/page.nbPage)-nbPages > 0}">
			<c:set var="nbPages" value="${nbPages+1}"></c:set>
		</c:if>
		<tags:pagination begin="1" end="${nbPages}" interval="${page.interval}" page="${page.page }" search="${page.search}" orderBy="${page.orderBy}" isDesc="${page.isDesc()}" nbPage="${page.nbPage}"></tags:pagination>
		
</section>

<jsp:include page="include/footer.jsp" />
