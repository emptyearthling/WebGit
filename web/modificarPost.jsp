<%@page import="model.dto.Post"%>
<%
    Post p = (Post) request.getAttribute("Post");
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
        <h3>Editar Post</h3>
        <%-- es para sacarlo del path de la consulta anterior
            vuelves el path a la raiz del sistema antes de hacer el nuevo request
            para subir un nivel en el arbol de directorio
        --%>
        <form action="${pageContext.request.contextPath}/Comentario/modificar" method="POST">
            <table border="0">
                <tr>
                    <td>Titulo</td>
                    <td><input type="text" name="Titulo" value="<%=p.getTitulo()%>" /></td>
                </tr>
                <tr>
                    <td>Cuerpo</td>
                    <td><input type="text" name="Cuerpo" value="<%=p.getTitulo()%>" /></td>
                </tr>
                <tr>

                    <td colspan="2"><input type="submit" value="Modificar" /></td>
                </tr>

            </table>
            <input type="hidden" name="txtId" value="<%=p.getId()%>" />
            <a href="index.jsp">Volver</a>
        </form>
    </body>
</html>
