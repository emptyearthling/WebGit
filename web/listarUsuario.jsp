<%@page import="java.util.ArrayList"%>
<%@page import="model.dto.Usuario"%>
<%@page import="model.dao.UsuarioDAO"%>
<%
  UsuarioDAO UsDAO = new UsuarioDAO();
  ArrayList<Usuario> Usuarios = UsDAO.listar();
  
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
        <h3>Usuario</h3>
        
        <table>
            <tr>
                <td>Modificar</td>
                <td>Eliminar</td>
                <td>Id Usuario</td>
                <td>perfil_id</td>
                <td>nombre</td>
                <td>apellido</td>
                <td>user</td>
                <td>password</td>
                <td>email</td>
                <td>fechacreacion</td>
            </tr>
            
            
            <% for(Usuario u : Usuarios){ %>
            <tr>
                <td><a href="Usuario/buscar?id=<%=u.getId()%>"><img src="img/edit.png" /></a></td>
                <td><a href="Usuario/eliminar?id=<%=u.getId()%>"><img src="img/delete.png" /></a></td>
                <td><%=u.getId()%></td>
                <td><%=u.getPerfil_id()%></td>
                <td><%=u.getNombre()%></td>
                <td><%=u.getApellido()%></td>
                <td><%=u.getUser()%></td>
                <td><%=u.getPassword()%></td>
                <td><%=u.getEmail()%></td>
                <td><%=u.getFechacreacion()%></td>
                
                
            </tr>
            
            <% } %>
        </table>
        
        <a href="index.html">Volver</a>
    </body>
</html>
