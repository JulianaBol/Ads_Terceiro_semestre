<%-- 
    Document   : resposta
    Created on : 13 de fev de 2022, 17:56:28
    Author     : julia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="estilos.css" rel="stylesheet" type="text/css"/>
        <title>Zoo</title>
    </head>
    <body>
        <h1>Zoo</h1> <hr> 
        <p><%= request.getAttribute("mensagem")%></p><br>
        <a href="index.html">Voltar para o Início</a>
    </body>
</html>
