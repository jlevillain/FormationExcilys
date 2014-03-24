<jsp:include page="include/header.jsp" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<section id="main">

	<h1><c:if test="${computer==null}">Add Computer</c:if>
		<c:if test="${computer!=null}">Edit Computer</c:if>
	</h1>
	<c:if test="${computer==null}"><form class="form-horizontal" action="AddComputer" method="POST"></c:if>
	<c:if test="${computer!=null}"><form class="form-horizontal" action="UpdateComputer" method="POST">
		<input type="hidden" name="id" value="${computer.id }"/>
	</c:if>
	
		<fieldset>
			<div class="form-group">
				<label for="name">Computer name:</label>
				<div class="input-group">
				
					<input class="form-control" type="text" name="name" value="${computer.name}"/>
					<span class="help-block">Required</span>
				</div>
			</div>
	
			<div class="form-group">
				<label for="introduced">Introduced date:</label>
				<div class="input-group">
					<input class="form-control" type="date" name="introducedDate" value="${computer.introduced}"/>
					<span class="help-block">YYYY-MM-DD</span>
				</div>
			</div>
			<div class="form-group">
				<label for="discontinued">Discontinued date:</label>
				<div class="input-group">
					<input class="form-control" type="date" name="discontinuedDate" value="${computer.discontinued}"/>
					<span class="help-block">YYYY-MM-DD</span>
				</div>
			</div>
			<div class="form-group">
				<label for="company">Company Name:</label>
				<div class="input-group">
					<select name="company">
						<option value="null">--</option>
						<c:forEach var="item" items="${companyList}">
							<c:if test="${item.id==computer.company.id}">
								<option value="${item.id}" selected>${item.name}</option>
								
							</c:if>
							<c:if test="${item.id!=computer.company.id}">
								<option value="${item.id}">${item.name}</option>
								
							</c:if>
							    
						</c:forEach>
						<!--  
						<option value="0">--</option>
						<option value="1">--</option>
						<option value="1">Apple</option>
						<option value="2">Dell</option>
						<option value="3">Lenovo</option>
						-->
					</select>
				</div>
			</div>
		</fieldset>
		<div class="actions">
			<c:if test="${computer==null}"><input type="submit" value="Add" class="btn btn-primary"></c:if>
			<c:if test="${computer!=null}"><input type="submit" value="Edit" class="btn btn-primary"></c:if>
			
			or <a href="DashBoard" class="btn btn-default">Cancel</a>
		</div>
	</form>
</section>

<jsp:include page="include/footer.jsp" />