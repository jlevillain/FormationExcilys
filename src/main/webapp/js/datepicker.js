
$(function() {
	$( "#introducedDate" ).datepicker();
	$( "#introducedDate" ).datepicker("option", "dateFormat",  "yy-mm-dd");
	$( "#introducedDate" ).datepicker("setDate","${computer.introduced}");
	$( "#introducedDate" ).datepicker({
		onClose: function( selectedDate ) {
			$('#introducedDate').trigger('change');
			$('#discontinuedDate').trigger('onkeypress');
		}
	});
});
$(function() {
	
	$( "#discontinuedDate" ).datepicker();
	$( "#discontinuedDate" ).datepicker("option", "dateFormat", "yy-mm-dd");
	$( "#discontinuedDate" ).datepicker("setDate", "${computer.discontinued}");
	$( "#discontinuedDate" ).datepicker({
		onClose: function( selectedDate ) {
			$('#discontinuedDate').trigger('change');
			$('#discontinuedDate').trigger('onkeypress');
		}
	});
});