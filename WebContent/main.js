$(document).ready(function() {
				
	$('#registration_firstName').on('input', function() {
		var input=$(this);
		var is_firstName=input.val();
		if(is_firstName){input.removeClass("invalid").addClass("valid");}
		else{input.removeClass("valid").addClass("invalid");
		$("#spanId").html("keimeno");
		}
		console.log($("#spanId").html("keimeno"));
	});
	
	$('#registration_lastName').on('input', function() {
		var input=$(this);
		var is_lastName=input.val();
		if(is_lastName){input.removeClass("invalid").addClass("valid");}
		else{input.removeClass("valid").addClass("invalid");}
	});
	
	$('#registration_email').on('input', function() {
		var input=$(this);
		var regex = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;
		var is_email=regex.test(input.val());
		
		if(is_email){
			input.removeClass("invalid").addClass("valid");
		}else{
			input.removeClass("valid").addClass("invalid");
		}
	});
	
	$('#registration_pass').on('input',function(){
		var input=$(this);
		var regex = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]/;
		var is_password = regex.test(input.val());
		if($("#registration_pass").val().length<8){
			input.removeClass("valid").addClass("invalid");
		}else if(is_password){
			input.removeClass("invalid").addClass("valid");
		}else{
			input.removeClass("valid").addClass("invalid");
		}
	});
	
	$('#registration_confirmPass').on('input',function(){
		var input=$(this);
		var regex = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]/;
		var is_password = regex.test(input.val());
		if($("#registration_pass").val() != $("#registration_confirmPass").val()){
			input.removeClass("valid").addClass("invalid");
		}else if(is_password){
			input.removeClass("invalid").addClass("valid")
		}else {
			input.removeClass("valid").addClass("invalid");
		}
		
	});

	$("#submitBtn").click(function(event){
		var form_data=$("#registationForm").serializeArray();
		var error_free=false;
		for (var input in form_data){
			var element=$("#registration_"+form_data[input]['firstName']);
			var valid=element.hasClass("valid");
			var error_element=$("span", element.parent());
			
			if (!valid){
				error_element.removeClass("error").addClass("error_show"); 
				error_free=false;
			}else{
				error_element.removeClass("error_show").addClass("error");
				error_free=true;
			}
			
		}
	
		if(($("#registration_pass").val() != $("#registration_confirmPass").val()) || $("#registration_pass").val().length <1 ){
			error_free = false;
		}else{
			error_free = true;
		}
		
		if (!error_free){
			event.preventDefault(); 
		}
		else{
			console.log("Form will be submitted");
		}
	});
	

});










function signup(){
	window.location.href="indexSignUp.html";
}



