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
import model.dto.Administrador;
import util.Conexion;

public class AdministradorDAO {

    Conexion con;

    public AdministradorDAO() {
        try {
            con = new Conexion();
        } catch (Exception ex) {

        }

    }

    public void ingresar(Administrador a) {
        try {
            String sql = "INSERT INTO Administrador (nombre, apellido, email) VALUES ('" + a.getNombre() + "','" + a.getApellido() + "','" + a.getEmail() + "')";
            con.update(sql);
        } catch (Exception ex) {

        }

    }

    public void modificar(Administrador a, int id) {
        try {
            String sql = "update Administrador SET "
                    + "nombre = '" + a.getNombre() + "',"
                    + "apellido ='" + a.getApellido() + "'"
                    + " where id ='" + id + "'";
            con.update(sql);
        } catch (Exception ex) {

        }

    }

    public ArrayList<Administrador> listar() {
        ArrayList<Administrador> profesores = new ArrayList<Administrador>();
        ResultSet datos = null;
        try {
            String sql = "SELECT * FROM Administrador";

            datos = con.query(sql);

            while (datos.next()) {
                Administrador a = new Administrador();

                a.setNombre(datos.getString("name"));
                a.setApellido(datos.getString("apel"));
                a.setEmail(datos.getString("mail"));

                //agregar profesor a arraylist de profesores
                profesores.add(a);

            }
        } catch (SQLException ex) {
            Logger.getLogger(AdministradorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return profesores;

    }

    public void eliminar(int id) {
        try{
            String sql = "DELETE FROM Administrador WHERE id=" + id;
            con.update(sql);
        }catch(Exception ex){
            
        }
        
    }

    public Administrador buscar(int id) {
        try {
            String sql = "SELECT * FROM Administrador WHERE id = " + id;
            ResultSet datos = null;

            datos = con.query(sql);

            datos.next();

            Administrador a = new Administrador();
            a.setId(datos.getInt("id"));
            a.setNombre(datos.getString("name"));
            a.setApellido(datos.getString("apel"));
            a.setEmail(datos.getString("mail"));

            return a;
        } catch (SQLException ex) {
            Logger.getLogger(AdministradorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

}
