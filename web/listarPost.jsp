<%@page import="java.util.ArrayList"%>
<%@page import="model.dto.Post"%>
<%@page import="model.dao.PostDAO"%>
<%
  PostDAO PoDAO = new PostDAO();
  ArrayList<Post> Posts = PoDAO.listar();
  
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
        <h3>Posts</h3>
        
        <table>
            <tr>
                <td>Modificar</td>
                <td>Eliminar</td>
                <td>Id Post</td>
                <td>usuario_id</td>
                <td>titulo</td>
                <td>cuerpo</td>
                <td>postestado_id</td>
                <td>fechacreacion</td>
            </tr>
            
            
            <% for(Post p : Posts){ %>
            <tr>
                <td><a href="Profesor/buscar?id=<%=p.getId()%>"><img src="img/edit.png" /></a></td>
                <td><a href="Profesor/eliminar?id=<%=p.getId()%>"><img src="img/delete.png" /></a></td>
                <td><%=p.getId()%></td>
                <td><%=p.getUsuario_id()%></td>
                <td><%=p.getTitulo()%></td>
                <td><%=p.getCuerpo()%></td>
                <td><%=p.getPostedado_id()%></td>
                <td><%=p.getFechacreacion()%></td>
                
            </tr>
            
            <% } %>
        </table>
        
        <a href="index.jsp">Volver</a>
    </body>
</html>
