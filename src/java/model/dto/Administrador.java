/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dto;

import java.util.Date;

/**
 *
 * @author kwolfenden
 */
public class Administrador {

    private int id;
    private int perfil_id;
    private String nombre;
    private String apellido;
    private String user;
    private String pass;
    private String email;
    private Date fechacreacion;
    private String detalle;

    public Administrador() {
        this.id = 0;
        this.perfil_id = 0;
        this.nombre = "";
        this.apellido = "";
        this.user = "";
        this.pass = "";
        this.email = "";
        this.fechacreacion = null;
        this.detalle = "";
    }

    public Administrador(int id, String nombre, String apellido, String userm, String pass, String email, Date fechacreaion, String detalle) {
        this.id = id;
        this.perfil_id = 1;
        this.nombre = nombre;
        this.apellido = apellido;
        this.user = user;
        this.pass = pass;
        this.email = email;
        this.fechacreacion = fechacreaion;
        this.detalle = detalle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPerfil_id() {
        return perfil_id;
    }

    public void setPerfil_id(int perfil_id) {
        this.perfil_id = perfil_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(Date fechacreaion) {
        this.fechacreacion = fechacreaion;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
}
