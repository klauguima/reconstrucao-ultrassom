$(function() {
	$(".custom-file-input").change(
			function() {
				var fileName = $(this).val().split("\\").pop();
				$(this).siblings(".custom-file-label").addClass("selected")
						.html(fileName);
			});
	
	$("#form-reconstrucao").submit(function() {
	    if($("#filename").val()== null || $("#filename").val() ==""){
	        alert('campo vazio');      
	        return false;
	    }
	});
	
	$
	// $("#meuFormulario").on("submit", function() {})
	$('#form-reconstrucao').submit(function (evento) {
		evento.preventDefault();
	    var data = new FormData($('#form-reconstrucao').get(0));
	    var contentType = false;
	    var processData = false;
	    
	    $.ajax({
	    	data: data,
	        type: "POST",
	        url: "http://localhost:8080/ServidorReconstrucao/reconstruir",
	        contentType: contentType,
	        processData: processData,
	        success: function (response) {}
	    });
	});
});