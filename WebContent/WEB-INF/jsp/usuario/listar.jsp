<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>http://wbotelhos.com</title>
	</head>
	<body>
		<a href="<c:url value='/'/>">Menu</a><br/>
		<h3>${msg}</h3>
		
		<form action="<c:url value='/usuario/adicionar'/>" method="post">
			<input type="text" name="usuario.nome"/> <input type="submit" value="Adicionar"/>
		</form><br/><br/>

		<c:forEach items="${sessionScope.usuarioDao.usuarioList}" var="item">
			${item.nome} <a href="<c:url value='/usuario/remover/${item.id}'/>">Remover</a><br/>
		</c:forEach>
	</body>
</html>