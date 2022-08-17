<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page
	import="java.util.*, br.com.caelum.agenda.ContatoDAO, br.com.caelum.agenda.Contato"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listar Contatos</title>
</head>
<body>
	<%
	ContatoDAO dao = new ContatoDAO();
	List<Contato> contatos = dao.getList();
	for (Contato contato : contatos) {
	%>
	<table>
		<tr>
			<td>
				<%=
				contato.getNome()
				%>
			</td>
			<td>
				<%=
				contato.getEndereco()
				%>
			</td>
			<td>
				<%=
				contato.getEmail()
				%>
			</td>
			<td>
				<%=
				contato.getDataNascimento().getTime()
				%>
			</td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>