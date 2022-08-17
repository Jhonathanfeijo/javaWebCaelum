<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista Contatos</title>
</head>
<body>
	<jsp:useBean id="dao" class="br.com.caelum.agenda.ContatoDAO"/>
	<table>
		<c:forEach var="contato" items="${dao.list}">
			<tr>
				<td>${contato.nome}</td>
				<td>
					<c:if test="${not empty contato.email}">
						<a href="mailto:${contato.email}">${contato.email}</a>
					</c:if>
					
					<c:if test="${empty contato.email}">
						Email nao informado
					</c:if>
				</td>
				<td>${contato.endereco}</td>
				<td><fmt:formatDate value="${contato.dataNascimento.time}"
				pattern="dd/MM/yyyy"/>
				</td>
				<td><a href= "mvc?logica=RemoveContatoLogica&id=${contato.id}">Remover</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>