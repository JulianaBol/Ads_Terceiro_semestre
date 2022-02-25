<%-- 
    Document   : lista
    Created on : 13 de fev de 2022, 13:38:36
    Author     : julia
--%>

<%@page import="java.util.List"%>
<%@page import="br.animais.ifrs.modelo.Animal"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="estilos.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h1>Lista de Animais</h1>
        <hr>                              
        <a href="Formulario.html">Inserir</a>
        <a href="index.html">Voltar para o Início</a>  
        <table border="1">
            <tr>
                <th>Especie</th>
                <th>Classe</th>
                <th>Peso</th>
                <th>Idade</th>
            </tr>
            <%
                List<Animal> animais = (List<Animal>)request.getAttribute("resultado");
                for (int i=0; i<animais.size(); i++) {
                    Animal a = animais.get(i);
            %>
            <tr>
                <td><%= a.getEspecie()%></td>
                <td><%= a.getClasse()%></td>
                <td><%= a.getPeso()%></td>
                <td><%= a.getIdade()%></td>
            </tr>
            <%
                }
            %>
        </table>
    </body>
</html>
