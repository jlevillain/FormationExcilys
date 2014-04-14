<jsp:include page="include/header.jsp" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<script src="<c:url value="/ressources/js/validation.js"/>"></script>
<script>
	$(function() {
		$("#introduced").datepicker();
		$("#introduced").datepicker("option", "dateFormat", "yy-mm-dd");
		$("#introduced").datepicker("setDate", "${computer.introduced}");
		$("#introduced").datepicker({
			onClose : function(selectedDate) {
				$('#introduced').trigger('change');
				$('#discontinued').trigger('onkeypress');
			}
		});
	});
	$(function() {

		$("#discontinued").datepicker();
		$("#discontinued").datepicker("option", "dateFormat", "yy-mm-dd");
		$("#discontinued")
				.datepicker("setDate", "${computer.discontinued}");
		$("#discontinued").datepicker({
			onClose : function(selectedDate) {
				$('#discontinued').trigger('change');
				$('#discontinued').trigger('onkeypress');
			}
		});
	});
</script>

<section id="main">

	<h1>
		<c:choose>
			<c:when test="${computer!=null && computer.id!=0}"><spring:message code="editComputer.title" text="default"/></c:when>
			<c:otherwise><spring:message code="addComputer.title" text="default"/></c:otherwise>
		</c:choose>
	</h1>

	<div class="container">
		<c:if test="${not empty error}">

			<ul class="bg-danger">
				<c:forEach var="item" items="${error}">
					<li>${item}</li>
				</c:forEach>
			</ul>

		</c:if>
		<form:form id="signupForm" commandName="computer" cssClass="form-horizontal" 
					action="/computer-database${(computer!=null && computer.id!=0)?'/UpdateComputer':'/AddComputer'}" method="POST">
			<form:input type="hidden" path="id" />
		

		<fieldset>
			<div class="form-group has-feedback">
				<label class="control-label" for="name">Computer name:</label>
				<form:input id="name" cssClass="form-control" type="text"
					path="name" placeholder="name" /><form:errors path="name" cssClass="bg-danger" />
			</div>
			<div class="form-group has-feedback">
				<label class="control-label" for="introduced">Introduced
					date:</label>
				<form:input id="introduced" class="form-control" type="text"
					path="introduced" placeholder="YYYY-MM-DD" />
					<form:errors path="introduced" cssClass="bg-danger" />
			</div>
			<div class="form-group has-feedback">
				<label class="control-label" for="discontinued">Discontinued
					date:</label>
				<form:input id="discontinued" class="form-control" type="text"
					path="discontinued" placeholder="YYYY-MM-DD" />
				<form:errors path="discontinued" cssClass="bg-danger" />
			</div>
			<div class="form-group has-feedback">
				<label for="company">Company Name:</label>
				<form:select path="company.id" valueItem="company.id" class="form-control">
					<form:option value="0" label="--"></form:option>
					<form:options items="${companyList}"></form:options>
					
						<!--  
						<option value="0">--</option>
						<option value="1">--</option>
						<option value="1">Apple</option>
						<option value="2">Dell</option>
						<option value="3">Lenovo</option>
						-->
				</form:select>
				<form:input type="hidden" path="company.name" value="a"/>
			</div>


			<div class="actions">
				<c:choose>
					<c:when test="${computer!=null && computer.id!=0}">
						<input type="submit" value='<spring:message code="editComputer.input.text" text="default"/>' class="btn btn-primary"/>
					</c:when>
					<c:otherwise>
						<input type="submit" value='<spring:message code="addComputer.input.text" text="default"/>' class="btn btn-primary"/>
					</c:otherwise>
				</c:choose>
				or <a onclick="history.back()" class="btn btn-default">Cancel</a>
			</div>
		</fieldset>
		</form:form>
	</div>
</section>

<jsp:include page="include/footer.jsp" />