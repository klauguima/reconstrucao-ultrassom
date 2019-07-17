$(function() {
	$(".custom-file-input").change(
			function() {
				var fileName = $(this).val().split("\\").pop();
				$(this).siblings(".custom-file-label").addClass("selected")
						.html(fileName);
			});
	
	$('#form-reconstrucao').submit(function (evento) {
		evento.preventDefault();

	    if($("#filename").val()== null || $("#filename").val() ==""){
	        alert('campo vazio');      
	        return;
	    }
	    
	    var data = new FormData($('#form-reconstrucao').get(0));
	    var contentType = false;
	    var processData = false;
	    
	    $.ajax({
	    	data: data,
	        type: "POST",
	        url: "http://localhost:8080/ClienteReconstrucao/reconstruir",
	        contentType: contentType,
	        processData: processData,
	        dataType: "json",
	        success: function (response) {
	        	$("#retorno").html("<p>Dados da Reconstrução</p>" +
	        			"<p> Identificação do usuário: "+response.usuario.nickName+"</p>" +
	        			"<p>Data e hora do início da reconstrução: "+response.dtHoraInicio.dayOfMonth+"/"
	        														+(response.dtHoraInicio.month+1)+"/"
	        														+response.dtHoraInicio.year+", "
	        														+response.dtHoraInicio.dayOfMonth+": "
	        														+response.dtHoraInicio.minute+": "
	        														+response.dtHoraInicio.second+"</p>"+
	        			"<p>Data e hora do término da reconstrução: "+response.dtHoraFim.dayOfMonth+"/"
	        														+(response.dtHoraFim.month+1)+"/"
	        														+response.dtHoraFim.year+", "
	        														+response.dtHoraFim.dayOfMonth+": "
	        														+response.dtHoraFim.minute+": "
	        														+response.dtHoraFim.second+"</p>"+
	        			"<p>Tamanho em pixels: "+response.tamPixels.altura+"x"+response.tamPixels.largura+"</p>" +
	        			"<p>O número de iterações executadas: "+response.numIteracoes+"</p>"+
	        			"<img src='http://localhost:8080/ClienteReconstrucao/imagerender?caminhoImagem="
	        																+response.caminhoImagem.replace(/\\/g, '/')+"'>");
	        }
	    });
	});
});