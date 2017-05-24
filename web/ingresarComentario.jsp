

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Forum</h1>
        <h3>Nuevo Comentario</h3>

        <form action="Comentario/ingresar" method="POST">
            <table border="0">
                <tr>
                    <td>Comentario</td>
                    <td><input type="text" name="Comentario" value="" /></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="Agregar" /></td>
                </tr>

            </table>
            <a href="index.jsp">Volver</a>
        </form>
    </body>
</html>
