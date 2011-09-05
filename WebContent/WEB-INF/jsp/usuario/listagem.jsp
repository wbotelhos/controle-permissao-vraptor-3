<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
		
		<form action="${pageContext.request.contextPath}/usuario" method="post">
			<input type="text" name="usuario.nome" />
			<input type="submit" value="Salvar" />
		</form><br/><br/>

		<c:forEach items="${usuarioList}" var="usuario">
			${usuario.nome}

			<form action="${pageContext.request.contextPath}/usuario/${usuario.id}" method="post">
				<input type="hidden" name="_method" value="delete" />
				<input type="submit" value="Remover" />
			</form><br/>
		</c:forEach>
	</body>
</html>