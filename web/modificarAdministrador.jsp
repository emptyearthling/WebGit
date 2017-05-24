<%@page import="model.dto.Administrador"%>
<%
    Administrador a = (Administrador) request.getAttribute("Usuario");
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
        <h3>Editar Admin</h3>
        <%-- es para sacarlo del path de la consulta anterior
            vuelves el path a la raiz del sistema antes de hacer el nuevo request
            para subir un nivel en el arbol de directorio
        --%>
        <form action="${pageContext.request.contextPath}/Administrador/modificar" method="POST">
            <table border="0">
                <tr>
                    <td>Nombre</td>
                    <td><input type="text" name="Nombre" value="<%=a.getNombre()%>" /></td>
                </tr>
                <tr>
                    <td>Apellido</td>
                    <td><input type="text" name="Apellido" value="<%=a.getApellido()%>" /></td>
                </tr>
                                <tr>
                    <td>Email</td>
                    <td><input type="text" name="Email" value="<%=a.getEmail()%>" /></td>
                </tr>
                <tr>

                    <td colspan="2"><input type="submit" value="Modificar" /></td>
                </tr>

            </table>
            <input type="hidden" name="txtId" value="<%=a.getId()%>" />
            <a href="index.jsp">Volver</a>
        </form>
    </body>
</html>
