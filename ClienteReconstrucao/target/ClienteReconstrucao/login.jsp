<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="loginCliente">
<meta name="author" content="Claudia de Oliveira Guimaraes de Siqueira">
<meta name="generator" content="Jekyll v3.8.5">
<meta name="generator" content="Jekyll v3.8.5">
<title>Login</title>

<!-- Bootstrap core CSS -->
<link href="./login_files/bootstrap.min.css" rel="stylesheet"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="./js/style.css"/>
<link href="./login_files/signin.css" rel="stylesheet">
</head>
<body class="text-center">
	<form class="form-signin" action="login" method="post">
		<img class="mb-4" src="./login_files/bootstrap-solid.svg" alt=""
			width="72" height="72">
		<h1 class="h3 mb-3 font-weight-normal">Login</h1>
		<label for="usuario" class="sr-only">Usu�rio:</label><input
			type="text" id="inputUsuario" class="form-control"
			placeholder="Digite seu usu�rio" required="" autofocus=""> <label
			for="inputSenha" class="sr-only">Senha:</label> <input
			type="password" id="inputSenha" class="form-control"
			placeholder="Digite sua senha" required="">
		<div class="checkbox mb-3">
			<label> <input type="checkbox" value="guardarSenha">
				Lembrar-me
			</label>
		</div>
		<button class="btn btn-lg btn-primary btn-block" type="submit"
			id="logar">Logar</button>
		<button class="btn btn-lg btn-primary btn-block" type="submit"
			id="cadastrar">Cadastre-se</button>
		<p class="mt-5 mb-3 text-muted">� 2019 - Todos os direitos reservados</p>
	</form>
</body>
</html>