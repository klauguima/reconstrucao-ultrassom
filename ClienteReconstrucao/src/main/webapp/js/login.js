$(function() {
	$("#login").submit(function(evento) {
		evento.preventDefault(); // impede de submeter a página, parametros
									// explicitos na url
		$.post("login", $(this).serialize(), function(retorno) {
			if (retorno.sucesso) {
				document.location = "reconstruir.html"
			} else {
				alert("Usuário e/ou senha incorreta.");
			}
		}, "json");
		// pasta, o que vc quer enviar como parametro para o servelet
	});
});
