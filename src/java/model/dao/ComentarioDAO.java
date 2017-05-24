/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.dto.Comentario;
import util.Conexion;

public class ComentarioDAO {

    Conexion con;

    public ComentarioDAO() {
        con = new Conexion();
    }

    public void ingresar(Comentario c) {
        try {
            String sql = "INSERT INTO Comentario VALUES(null,"
                    + c.getUsuario_id() + ","
                    + c.getPost_id() + ",'"
                    + c.getComentario() + "',"
                    + c.getComentarioestado() + ",'"
                    + c.getFechacreacion() + "')";

            System.out.println(sql);
            con.update(sql);
        } catch (Exception ex) {

        }

    }

    public void modificar(Comentario c, int id) {
        try {
            String sql = "UPDATE Comentario SET"
                    + "usuario_id =" + c.getUsuario_id() + ","
                    + "post_id =" + c.getPost_id() + ","
                    + "comentario = '" + c.getComentario() + "',"
                    + "comentarioestado_id = " + c.getComentarioestado() + ","
                    + "fechacreacion = '" + c.getFechacreacion() + "'";
            con.update(sql);
        } catch (Exception ex) {

        }

    }

    public ArrayList<Comentario> listar() {
        ArrayList<Comentario> Comentarios = new ArrayList<Comentario>();
        ResultSet datos = null;
        try {
            String sql = "SELECT * FROM Comentario";

            datos = con.query(sql);

            while (datos.next()) {
                Comentario c = new Comentario();

                c.setId(datos.getInt("id"));
                c.setUsuario_id(datos.getInt("usuario_id"));
                c.setPost_id(datos.getInt("post_id"));
                c.setComentario(datos.getString("comentario"));
                c.setComentarioestado(datos.getInt("comentarioestado"));
                c.setFechacreacion(datos.getString("fechacreacion"));

                //agregar profesor a arraylist de profesores
                Comentarios.add(c);

            }
        } catch (SQLException ex) {
            Logger.getLogger(ComentarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Comentarios;

    }

    public void eliminar(int id) {
        try {
            String sql = "DELETE FROM Comentario WHERE id=" + id;
            con.update(sql);
        } catch (Exception ex) {

        }

    }

    public Comentario buscar(int id) {
        try {
            String sql = "SELECT * FROM Comnentario WHERE id = " + id;
            ResultSet datos = null;

            datos = con.query(sql);

            datos.next();

            Comentario c = new Comentario();
            c.setId(datos.getInt("id"));
            c.setUsuario_id(datos.getInt("usuario_id"));
            c.setPost_id(datos.getInt("post_id"));
            c.setComentario(datos.getString("comentario"));
            c.setComentarioestado(datos.getInt("comentarioestado"));
            c.setFechacreacion(datos.getString("fechacreacion"));

            return c;
        } catch (SQLException ex) {
            Logger.getLogger(ComentarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

}
