<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@    taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Lista de Livros</title>
</head>
<body>
<h1>Lista de Livros cadastrados</h1>
<br>
<table border="solid">
    <tr>
        <th>#</th>
        <th>ID</th>
        <th>Nome</th>
        <th>Autor</th>
    </tr>
    <c:forEach var="livro" items="${livros}" varStatus="id">
        <tr>
            <td>${id.count}</td>
            <td>${livro.id}</td>
            <td>${livro.nome}</td>
            <td>${livro.autor}</td>
            <td><a href="${pageContext.request.contextPath}/livro-servlet/edicao?id=
                <c:out value='${livro.id}' />">Editar</a></td>
            <td><a href="${pageContext.request.contextPath}/livro-servlet/deletar?id=
                <c:out value='${livro.id}' />">Deletar</a></td>
        </tr>
    </c:forEach>
</table>
<a href="${pageContext.request.contextPath}/cadastrar-livro.jsp">Cadastre um novo Livro</a>
</body>
</html>
