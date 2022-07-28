<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edição de Livro</title>
</head>
<body>
<h1>Edição de Livro</h1>
<fieldset>
    <legend>Dados basicos</legend>
    <form action="editar-livro" method="post">
        <div>
            <input type="hidden" name="id" value="${livro.id}">
        </div>
        <div>
            <label for="idNome">Nome:</label>
            <input type="text" id="idNome" name="nome" value="${livro.nome}">
        </div>
        <div>
            <label for="idAutor">Autor:</label>
            <input type="text" id="idAutor" name="autor" value="${livro.autor}">
        </div>
        <input type="submit" value="Enviar">
    </form>
</fieldset>
</body>
</html>
