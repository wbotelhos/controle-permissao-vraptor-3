<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>http://wbotelhos.com.br</title>
	</head>
	<body>
		<a href="${pageContext.request.contextPath}/">In&iacute;cio</a><br/>
		<a href="${pageContext.request.contextPath}/usuario">Listar usu&aacute;rios</a><br/>
		<a href="${pageContext.request.contextPath}/admin">Administra&ccedil;&atilde;o</a><br/><br/>

		Seja bem vindo: ${userSession.user.nome}
	</body>
</html>