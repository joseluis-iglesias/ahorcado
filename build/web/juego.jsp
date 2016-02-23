<%-- 
    Document   : juego
    Created on : 08-nov-2015, 20:22:57
    Author     : josei_000
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="ahorcado" class="logica.Ahorcado" scope="session"/>
<% if (session != null && !session.getAttribute("nombre").equals("")
            && session.getAttribute("nombre") != null && ahorcado.getJuego()) {%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ahorcado</title>
    </head>
    <body>
        <h1>Bienvenido Al Ahorcado, <%=(String) ahorcado.getNombre()%></h1>
        <%
            if (ahorcado.isError()) {
        %>        
        <p> <%=(String) ahorcado.getMensajeError()%></p>
        <% } %>
        <form name="formulario2" method="post" action="Juego">
            Letra: <input type="text"   name="letra" autofocus><br/>

            <input type="submit" value="comprobar" name="enviar">

            <% if (ahorcado.isJuego()) {
                    char[] aux = ahorcado.getPalabraAdiv();%>
            <p>palabra a adivinar:<%=String.valueOf(aux)%></p>
            <%
                aux = ahorcado.getLetrasdichas();%>
            <p>Letras dichas:<%=String.valueOf(aux)%></p>
            <p>intento:<%=ahorcado.getCont2()%></p>
            <%
                }
                if (!ahorcado.getMensaje().equals("")) {%>

            <p><%=(String) ahorcado.getMensaje()%></p>
            <input type="submit" value="inicio" name="enviar">
            <%}
            %>
        </form>       
    </body>
</html>
<%} else {
            response.sendRedirect("index.jsp");
        }
    %>