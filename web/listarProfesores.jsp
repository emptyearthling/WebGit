<%@page import="java.util.ArrayList"%>
<%@page import="model.dto.Profesor"%>
<%@page import="model.dao.ProfesorDAO"%>
<%
  ProfesorDAO profeDao = new ProfesorDAO();
  ArrayList<Profesor> profesores = profeDao.listar();
  
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Universidad</h1>
        <h3>Profesores</h3>
        
        <table>
            <tr>
                <td>Modificar</td>
                <td>Eliminar</td>
                <td>Id Profesor</td>
                <td>Nombres</td>
                <td>Apellidos</td>
                <td>Correo</td>
            </tr>
            
            <% for(Profesor p : profesores){ %>
            <tr>
                <td><a href="Profesor/buscar?id=<%=p.getIdProfesor() %>"><img src="img/edit.png" /></a></td>
                <td><a href="Profesor/eliminar?id=<%=p.getIdProfesor() %>"><img src="img/delete.png" /></a></td>
                <td><%=p.getIdProfesor() %></td>
                <td><%=p.getNombres() %></td>
                <td><%=p.getApellidos() %></td>
                <td><%=p.getCorreo() %></td>
            </tr>
            
            <% } %>
        </table>
        
        <a href="index.html">Volver</a>
    </body>
</html>
