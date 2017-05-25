<%@page import="java.util.ArrayList"%>
<%@page import="model.dto.Comentario"%>
<%@page import="model.dao.ComentarioDAO"%>
<%
  ComentarioDAO ComentDAO = new ComentarioDAO();
  ArrayList<Comentario> Comentarios = ComentDAO.listar();
  
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Forum</h1>
        <h3>Comentarios</h3>
        
        <table>
            <tr>
                <td>Modificar</td>
                <td>Eliminar</td>
                <td>Id Comentario</td>
                <td>usuario_id</td>
                <td>post_id</td>
                <td>comentario</td>
                <td>comentarioestado_id</td>
                <td>fechacreacion</td>
            </tr>
            
            
            <% for(Comentario c : Comentarios){ %>
            <tr>
                <td><a href="Profesor/buscar?id=<%=c.getId()%>"><img src="img/edit.png" /></a></td>
                <td><a href="Profesor/eliminar?id=<%=c.getId()%>"><img src="img/delete.png" /></a></td>
                <td><%=c.getId()%></td>
                <td><%=c.getUsuario_id()%></td>
                <td><%=c.getPost_id()%></td>
                <td><%=c.getComentario()%></td>
                <td><%=c.getComentarioestado()%></td>
                <td><%=c.getFechacreacion()%></td>
                
            </tr>
            
            <% } %>
        </table>
        
        <a href="index.html">Volver</a>
    </body>
</html>
