<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>http://wbotelhos.com.br</title>
	</head>
	<body>
		<a href="${pageContext.request.contextPath}/">In&iacute;cio</a><br/>
		<a href="${pageContext.request.contextPath}/usuario">Listar usu&aacute;rios</a><br/>
		<a href="${pageContext.request.contextPath}/admin">Administra&ccedil;&atilde;o</a>

		<h3>${notice}</h3>
	</body>
</html>