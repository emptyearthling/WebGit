

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Usuario</h1>

        <form action="Usuario/ingresar" method="POST">
            <table border="0">
                <h3>Que deseas hacer?</h3>
                <tr>
                <input type="radio" name="crud" value="create" />crear<br>
                <input type="radio" name="crud" value="reed" />listar<br>
                <input type="radio" name="crud" value="update" />actualizar<br>
                <input type="radio" name="crud" value="delete" />borrar<br><br>
                </tr>
                <tr>
                    <td>Nombre</td>
                    <td><input type="text" name="name" value="" /></td>
                </tr>
                <tr>
                    <td>Apellido</td>
                    <td><input type="text" name="apel" value="" /></td>
                </tr>
                <tr>
                    <td>nombre de usuario</td>
                    <td><input type="text" name="user" value="" /></td>
                </tr>
                <tr>
                    <td>contraseña</td>
                    <td><input type="password" name="pass" value="" /></td>
                </tr>
                <tr>
                    <td>correo</td>
                    <td><input type="text" name="mail" value="" /></td>
                </tr>
                <tr>

                    <td colspan="2"><input type="submit" value="Agregar" /></td>
                </tr>

            </table>
            <a href="index.jsp">Volver</a>
        </form>
    </body>
</html>
