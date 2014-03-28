

$.validator.addMethod(
        "dateControl",
        function(value, element) {
        	try {
        		$.datepicker.parseDate( "yy-mm-dd", value );
        		return true;
        	}catch(e) {
        		return false;
        	}
        }, "Please enter a date in the format yyyy-mm-dd.");

$().ready(function() {
	$("#signupForm").validate({
		rules: {
			name : "required",
			introducedDate : {
				dateControl: true
			},
			discontinuedDate : {
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

