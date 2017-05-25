

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Forum</h1>
        <h3>Nuevo Post</h3>

        <form action="Post/ingresar" method="POST">
            <table border="0">
                <tr>
                    <td>Titulo</td>
                    <td><input type="text" name="Titulo" value="" /></td>
                </tr>
                <tr>
                    <td>Cuerpo</td>
                    <td><input type="text" name="Cuerpo" value="" /></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="Agregar" /></td>
                </tr>

            </table>
            <a href="index.html">Volver</a>
        </form>
    </body>
</html>
