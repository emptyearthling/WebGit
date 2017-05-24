/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.dto.Post;
import util.Conexion;

public class PostDAO {

    Conexion con;

    public PostDAO() {
          try{
            con = new Conexion();
        }catch(Exception ex){
            
        }
        
    }

    public void ingresar(Post p) {
          try{
             String sql = "INSERT INTO Post VALUES(null,"+
                p.getUsuario_id()+",'"+
                p.getTitulo()+"','"+
                p.getCuerpo()+"',"+
                p.getPostedado_id()+",'"+
                p.getFechacreacion()+"')";
        
        System.out.println(sql);
        con.update(sql);
        }catch(Exception ex){
            
        }
       
    }

    public void modificar(Post cp, int id) {
        
          try{
             String sql = "UPDATE Post SET"
                + "usuario_id =" + cp.getUsuario_id() + ","
                + "titulo ='" + cp.getTitulo() + "',"
                + "cuerpo = '" + cp.getCuerpo()+ "',"
                + "postestado_id = " + cp.getPostedado_id()+ ","
                + "fechacreacion = '" + cp.getFechacreacion() +"'";
        
        con.update(sql);
        }catch(Exception ex){
            
        }
       
    }

    public ArrayList<Post> listar() {
        ArrayList<Post> Posts = new ArrayList<Post>();
        ResultSet datos = null;
        try {
            String sql = "SELECT * FROM Post";

            datos = con.query(sql);

            while (datos.next()) {
                Post p = new Post();

                p.setId(datos.getInt("id"));
                p.setUsuario_id(datos.getInt("usuario_id"));
                p.setTitulo(datos.getString("titulo"));
                p.setCuerpo(datos.getString("cuerpo"));
                p.setPostedado_id(datos.getInt("postedado_id"));
                p.setFechacreacion(datos.getString("fechacreacion"));

                Posts.add(p);

            }
        } catch (SQLException ex) {
            Logger.getLogger(ComentarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Posts;

    }

    public void eliminar(int id) {
          try{
              String sql = "DELETE FROM Post WHERE id=" + id;
              con.update(sql);
        }catch(Exception ex){
            
        }
       
    }

    public Post buscar(int id) {
        try {
            String sql = "SELECT * FROM Post WHERE id = " + id;
            ResultSet datos = null;

            datos = con.query(sql);

            datos.next();

            Post p = new Post();
            p.setId(datos.getInt("id"));
            p.setUsuario_id(datos.getInt("usuario_id"));
            p.setTitulo(datos.getString("titulo"));
            p.setCuerpo(datos.getString("cuerpo"));
            p.setPostedado_id(datos.getInt("postedado_id"));
            p.setFechacreacion(datos.getString("fechacreacion"));

            return p;
        } catch (SQLException ex) {
            Logger.getLogger(ComentarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

}
