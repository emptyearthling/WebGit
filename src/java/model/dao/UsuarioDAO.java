/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.dto.Usuario;
import util.Conexion;

public class UsuarioDAO {

    Conexion con;

    public UsuarioDAO() {
          try{
             con = new Conexion();
        }catch(Exception ex){
            
        }
       
    }

    public void ingresar(Usuario u) {
          try{
              String n = u.getNombre();
              String a = u.getApellido();
              String us = u.getUser();
              String p = u.getPassword();
              String e = u.getEmail();
              String f = "24/05/17";
                
                
              String sql = "INSERT INTO Usuario VALUES (null,2,"+"' "+n+"',"+"'"+a+"',"+"'"+us+"',"+"'"+p+"',"+"'"+e+"',"+"'"+f+"');";
                           //String sql = "INSERT INTO Usuario (perfil_id, nombre, apellido, user, password, email, fechacreacion  ) VALUES (2,"+

            
                

        System.out.println(sql);
        con.update(sql);
        }catch(Exception ex){
            
        }
       
    }

    public void modificar(Usuario u, int id) {
  try{
               String sql = "UPDATE Usuario SET "
                
                + "nombre ="+"'" + u.getNombre()+ "'"+","
                + "apellido ="+"'" + u.getApellido()+ "'"+","
                + "user ="+"'" + u.getUser()+ "'"+","
                + "password ="+"'" + u.getPassword()+ "'"+","
                + "email ="+"'" + u.getEmail()+ "'"+ " WHERE id = "+id;
                
        
        System.out.println(sql);       
        con.update(sql);
        }catch(Exception ex){
            
        }
     
    }

    public ArrayList<Usuario> listar() {
        ArrayList<Usuario> Usuarios = new ArrayList<Usuario>();
        ResultSet datos = null;
        try {
            String sql = "SELECT * FROM Usuario";

            datos = con.query(sql);

            while (datos.next()) {
                Usuario u = new Usuario();

                u.setId(datos.getInt("id"));
                u.setPerfil_id(datos.getInt("perfil_id"));
                u.setNombre(datos.getString("nombre"));
                u.setApellido(datos.getString("apellido"));
                u.setEmail(datos.getString("email"));
                u.setFechacreacion(datos.getString("fechacreacion"));

                //agregar profesor a arraylist de profesores
                Usuarios.add(u);

            }
        } catch (SQLException ex) {
            Logger.getLogger(ComentarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Usuarios;

    }

    public void eliminar(int id) {
          try{
              String sql = "DELETE FROM Usuario WHERE id=" + id;
              con.update(sql);
        }catch(Exception ex){
            
        }
    
    }

    public Usuario buscar(int id) {
        try {
            String sql = "SELECT * FROM Usuario WHERE id = " + id;
            ResultSet datos = null;

            datos = con.query(sql);

            datos.next();

            Usuario u = new Usuario();
            u.setId(datos.getInt("id"));
            u.setPerfil_id(datos.getInt("perfil_id"));
            u.setNombre(datos.getString("nombre"));
            u.setApellido(datos.getString("apellido"));
            u.setEmail(datos.getString("email"));
            u.setFechacreacion("fechacreacion");

            return u;
        } catch (SQLException ex) {
            Logger.getLogger(ComentarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

}
