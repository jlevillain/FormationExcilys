

$.validator.addMethod(
        "dateControl",
        function(value, element) {
            return value.match(/^$/) || value.match(/^(\d{4})([\/-])(0[1-9]|1[012])\2(0[1-9]|[12][0-9]|3[01])$/);
        }, "Please enter a date in the format yyyy-mm-dd.");

$().ready(function() {
	$("#signupForm").validate({
		rules: {
			name : "required",
			introducedDate : {
				dateISO: true
			},
			discontinuedDate : {
				dateISO: true
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