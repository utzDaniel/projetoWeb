<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"	%>
<html>
<head>
    <title>Lista de Livros</title>
</head>
<body>
<h3>Livro, cadastrado com sucesso!</h3>

<h1>Lista de Livros cadastrados</h1>
<br>
<table border="solid">
    <tr>
        <th>#</th>
        <th>Nome</th>
        <th>Autor</th>
    </tr>
    <c:forEach var="livro" items="${livros}" varStatus="id">
        <tr>
            <td>${id.count}</td>
            <td>${livro.nome}</td>
            <td>${livro.autor}</td>
        </tr>
    </c:forEach>
</table>
<a href="cadastrar-livro.jsp">Cadastre um novo Livro</a>
</body>
</html>
