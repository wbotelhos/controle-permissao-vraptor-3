<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>http://wbotelhos.com.br</title>
	</head>
	<body>
		<a href="<c:url value='/'/>">Menu</a><br/>
		<h3>${message}</h3>
		
		<form action="<c:url value='/usuario/adicionar'/>" method="post">
			<input type="text" name="usuario.nome"/> <input type="submit" value="Adicionar"/>
		</form><br/><br/>

		<c:forEach items="${sessionScope.usuarioDao.usuarios}" var="usuario">
			${usuario.nome} <a href="<c:url value='/usuario/${usuario.id}/remover'/>">Remover</a><br/>
		</c:forEach>
	</body>
</html>