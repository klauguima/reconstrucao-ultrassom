<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<!doctype html>
<html lang="pt-br">
	<head>
		<meta charset="utf-8">
		<meta name="viewport"content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<meta name="description" content="">
		<meta name="author" content="">
		<title> Formulário de Cadastro </title>
		<link href="./login_files/bootstrap.min.css" rel="stylesheet" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"crossorigin="anonymous">
		<link rel="stylesheet" type="text/css" href="./js/style.css" />
		<link href="./login_files/signin.css" rel="stylesheet">

		<body>
			<form action="cadastro.jsp" method ="post">
			<div class="col-md-8 order-md-1">
				<h1 class="h3 mb-3 font-weight-normal text-center">Login<br></h1>
				<div class="row">
					<div class="col-md-6 mb-3">
						<label for="primeiroNome">Nome</label> <input type="text" 
						class="form-control align" id="primeiroNome" placeholder="" value=""required>
					</div>
				<div class="col-md-6 mb-3">
					<label for="sobrenome">Sobrenome</label> <input type="text"
						class="form-control" id="sobrenome" placeholder="" value=""required>
				</div>
				</div>
				<div class="row">
					<div class="col-md-6 mb-3">
						<label for="cpf">CPF</label> <input type="text"
						class="form-control" id="cpf" placeholder="" value="" required>
					</div>
					<div class="col-md-6 mb-3">
						<label for="senha">Senha</label> <input type="text"
						class="form-control" id="senha" placeholder="" value=""
						required>
					</div>
				</div>
				<div class="mb-3">
					<label for="inputEmail">E-mail</label>
					<div class="input-group">
						<input type="email" class="form-control" id="email"
						placeholder="fulano@exemplo.com">
					</div>
				</div>
				<div>
					<hr class="mb-4">
					<button class="btn btn-primary btn-lg btn-block" type="submit">Cadastrar</button>
				</form>
			</div>
		</div>
		</div>
	</head>
	</div>

<!-- Principal JavaScript do Bootstrap
    ================================================== -->
<!-- Foi colocado no final para a página carregar mais rápido -->
<script src="../jquery-3.4.1.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script>
	window.jQuery
			|| document
					.write('<script src="../../assets/js/vendor/jquery-slim.min.js"><\/script>')
	<!--
</script>
<script src="../../assets/js/vendor/popper.min.js"></script>
<script src="../bootstrap.min.js"></script>
<script src="../holder.min.js"></script>
<script>
	// Exemplo de JavaScript para desativar o envio do formulário, se tiver algum campo inválido.
	(function() {
		'use strict';
		window.addEventListener('load', function() {
			//secione todos os campos que nós queremos aplicar estilos Bootstrap de validação customizados.
			var forms = document.getElementsByClassName('needs-validation');
			// Faz um loop neles e previne envio
			var validation = Array.prototype.filter.call(forms, function(form) {
				form.addEventListener('submit', function(event) {
					if (form.checkValidity() === false) {
						event.preventDefault();
						event.stopPropagation();
					}
					form.classList.add('was-validated');
				}, false);
			});
		}, false);
	})();
</script>
</body>
</html>
