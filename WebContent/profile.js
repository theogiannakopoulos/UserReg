$(document).ready(function(){
	
	
	console.log("dsd");
	console.log($('#emailid').val());
	$.ajax({
		
		url : 'ProfileServlet',
		data : {
			email : $('#emailid').val(),
			p : $('#pid').val()
		},
		
		success : function(responseText) {
			var obj = JSON.parse(responseText);
			$('#firstName').text(obj.firstName);
			$('#lastName').text(obj.lastName);
			$('#email').text(obj.email);
			$('#number').text(obj.number);
			$('#company').text(obj.company);
			
			console.log(responseText);
			
				
		}
	});
	


});
function signin(){
	window.location.href="indexSignIn.html";
}
