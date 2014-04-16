<jsp:include page="include/header.jsp" />
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<script src="<c:url value="/ressources/js/validation.js"/>"></script>
<script>
	$.validator.addMethod(
	        "dateControl",
	        function(value, element) {
	        	try {
	        		$.datepicker.parseDate( '<spring:message code="Date.pattern.javascript" text="default"/>', value );
	        		return true;
	        	}catch(e) {
	        		return false;
	        	}
	        }, '<spring:message code="Datepicker.message.error" text="default"/> <spring:message code="Date.pattern.text" text="default"/>.');
	
	$().ready(function() {
		$("#signupForm").validate({
			rules: {
				name : "required",
				introduced : {
					dateControl: true
				},
				discontinued : {
					dateControl: true
				}
			},
			highlight: function(element) {
				 $(element).closest('.form-group').removeClass('has-success').addClass('has-error');
			},
			success: function(element) {
				 $(element).closest('.form-group').removeClass('has-error').addClass('has-success');
			}
		});
	});

	$(function() {
		$("#introduced").datepicker();
		
		$("#introduced").datepicker( "option",$.datepicker.regional['<spring:message code="DatePicker.lang" text="default"/>'] );
		$("#introduced").datepicker("option", "dateFormat", '<spring:message code="Date.pattern.javascript" text="default"/>');
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
	
		
		$("#discontinued").datepicker( "option",$.datepicker.regional['<spring:message code="DatePicker.lang" text="default"/>'] );
		$("#discontinued").datepicker("option", "dateFormat", '<spring:message code="Date.pattern.javascript" text="default"/>');
		$("#discontinued").datepicker("setDate", "${computer.discontinued}");
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
				<label class="control-label" for="name"><spring:message code="Computer.input.name" text="default"/></label>
				<spring:message code="Computer.label.name" var="placeholderName"/>
				<form:input id="name" cssClass="form-control" type="text"
					path="name" placeholder='${placeholderName}'/><form:errors path="name" cssClass="bg-danger" />
			</div>
			<div class="form-group has-feedback">
				<label class="control-label" for="introduced"><spring:message code="Computer.input.introduced" text="default"/></label>
				<spring:message code="Date.pattern.text" var="placeholderIntroduced"/>
				<form:input id="introduced" class="form-control" type="text"
					path="introduced" placeholder="${placeholderIntroduced}" />
					<form:errors path="introduced" cssClass="bg-danger" />
			</div>
			<div class="form-group has-feedback">
				<label class="control-label" for="discontinued"><spring:message code="Computer.input.discontinued" text="default"/></label>
				<spring:message code="Date.pattern.text" var="placeholderDiscontinued"/>
				<form:input id="discontinued" class="form-control" type="text"
					path="discontinued" placeholder="${placeholderDiscontinued}" />
				<form:errors path="discontinued" cssClass="bg-danger" />
			</div>
			<div class="form-group has-feedback">
				<label for="company"><spring:message code="Computer.input.company" text="default"/></label>
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
						<input type="submit" value='<spring:message code="editComputer.input.submit" text="default"/>' class="btn btn-primary"/>
					</c:when>
					<c:otherwise>
						<input type="submit" value='<spring:message code="addComputer.input.submit" text="default"/>' class="btn btn-primary"/>
					</c:otherwise>
				</c:choose>
				or <a onclick="history.back()" class="btn btn-default"><spring:message code="Cancel.button.text" text="default"/></a>
			</div>
		</fieldset>
		</form:form>
	</div>
</section>

<jsp:include page="include/footer.jsp" />