<jsp:include page="include/header.jsp" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script src="js/validation.js"></script>
<script src="js/datepicker.js"></script>

<section id="main">
  	
	<h1><c:if test="${computer==null}">Add Computer</c:if>
		<c:if test="${computer!=null}">Edit Computer</c:if>
	</h1>
	<div class="container">
	<c:if test="${computer==null}"><form id="signupForm" class="form-horizontal" action="AddComputer" method="POST"></c:if>
	<c:if test="${computer!=null}"><form id="signupForm" class="form-horizontal" action="UpdateComputer" method="POST">
		<input type="hidden" name="id" value="${computer.id }"/>
	</c:if>
	
	<fieldset>
			<div class="form-group has-feedback">
				<label class="control-label" for="name">Computer name:</label>	
				<input id="name" class="form-control" type="text" name="name" value="${computer.name}" placeholder="name"/>
			</div>
			<div class="form-group has-feedback">
				<label class="control-label" for="introduced">Introduced date:</label>	
				<input id="introducedDate" class="form-control" type="text" name="introducedDate" value="${computer.introduced}" placeholder="YYYY-MM-DD"/>
			</div>
			<div class="form-group has-feedback">
				<label class="control-label" for="discontinued">Discontinued date:</label>
				<input id="discontinuedDate" class="form-control" type="text" name="discontinuedDate" value="${computer.discontinued}" placeholder="YYYY-MM-DD"/>
				
			</div>
			<div class="form-group has-feedback">
				<label for="company">Company Name:</label>
					<select name="company" class="form-control">
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
			
		
		<div class="actions">
			<c:if test="${computer==null}"><input type="submit" value="Add" class="btn btn-primary"></c:if>
			<c:if test="${computer!=null}"><input type="submit" value="Edit" class="btn btn-primary"></c:if>
			
			or <a onclick="history.back()" class="btn btn-default">Cancel</a>
		</div>
		</fieldset>
	</form>
	</div>
</section>

<jsp:include page="include/footer.jsp" />