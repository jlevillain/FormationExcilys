<jsp:include page="include/header.jsp" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<section id="main">
	<h1 id="homeTitle"><!--  456-->${computerSize} Computers found</h1>
	<div id="actions">
		<form class="form-inline" action="" method="GET">
				<input class="form-control" type="search" id="searchbox" name="search"
					value="" placeholder="Search name">
				<input type="submit" id="searchsubmit"
					value="Filter by name"
					class="btn btn-primary">
			
		</form>
		<a class="btn btn-success" id="add" href="AddComputer">Add Computer</a>
	</div>

		<table class="table table-striped">
			<thead>
				<tr>
					<!-- Variable declarations for passing labels as parameters -->
					<!-- Table header for Computer Name -->
					<th>Computer Name</th>
					<th>Introduced Date</th>
					<!-- Table header for Discontinued Date -->
					<th>Discontinued Date</th>
					<!-- Table header for Company -->
					<th>Company</th>
				</tr>
			</thead>
			<tbody>
			
				<c:forEach var="item" items="${computerList}">
   					<tr><td><a href="UpdateComputer?id=${item.id}">${item.name}</a></td><td><fmt:formatDate value="${item.introduced}" pattern="yyyy-MM-dd" /> </td><td><fmt:formatDate value="${item.discontinued}" pattern="yyyy-MM-dd" /></td><td>${item.company.name }</td><td><a class="btn btn-danger" href="?delete=${item.id}">Delete</a></td></tr>
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
</section>

<jsp:include page="include/footer.jsp" />
