<%@page import="java.util.ArrayList"%>
<%@page import="model.dto.Administrador"%>
<%@page import="model.dao.AdministradorDAO"%>
<%
  AdministradorDAO AdminDAO = new AdministradorDAO();
  ArrayList<Administrador> Admins = AdminDAO.listar();
  
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
        <h3>Administrador</h3>
        
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
            
            
            <% for(Administrador a : Admins){ %>
            <tr>
                <td><a href="Profesor/buscar?id=<%=a.getId()%>"><img src="img/edit.png" /></a></td>
                <td><a href="Profesor/eliminar?id=<%=a.getId()%>"><img src="img/delete.png" /></a></td>
                <td><%=a.getId()%></td>
                <td><%=a.getPerfil_id()%></td>
                <td><%=a.getNombre()%></td>
                <td><%=a.getApellido()%></td>
                <td><%=a.getUser()%></td>
                <td><%=a.getPass()%></td>
                <td><%=a.getEmail()%></td>
                <td><%=a.getFechacreacion()%></td>
                
            </tr>
            
            <% } %>
        </table>
        
        <a href="index.html">Volver</a>
    </body>
</html>
