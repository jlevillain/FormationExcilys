<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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