<%-- 
    Document   : index
    Created on : 06-nov-2015, 11:01:41
    Author     : josei_000
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="ahorcado" class="logica.Ahorcado" scope="session"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ahorcado</title>
    </head>
    <body>
        <h1>Ahorcado</h1>
        <%
            if (ahorcado.isError()) {
        %>        
        <p> <%=(String) ahorcado.getMensajeError()%></p>
        <% }%>

        <form name="formulario1" method="post" action="Paso1">
            Nombre:<input type="text"   name="nombre"> <br/>
            <input type="radio"  name="nivel" value="1" checked="checked" >Facil <br/>
            <input type="radio"  name="nivel" value="2"> Medio <br/>
            <input type="radio"  name="nivel" value="3"> Dificil <br/>
            <input type="radio"  name="nivel" value="4"> Dios <br/>

            <input type="submit" value="comienza" name="enviar">
        </form>
    </body>
</html>