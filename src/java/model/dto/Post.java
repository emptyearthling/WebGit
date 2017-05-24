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
public class Post {

    private int id;
    private int usuario_id;
    private String titulo;
    private String cuerpo;
    private int postedado_id;
    private String fechacreacion;

    public Post() {
        this.id = 0;
        this.usuario_id = 0;
        this.titulo = "";
        this.cuerpo = "";
        this.postedado_id = 0;
        this.fechacreacion = null;
    }

    public Post(int id, int usuario_id, String titulo, String cuerpo, int postedado_id, String fechacreacion) {
        this.id = id;
        this.usuario_id = usuario_id;
        this.titulo = titulo;
        this.cuerpo = cuerpo;
        this.postedado_id = postedado_id;
        this.fechacreacion = fechacreacion;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }

    public void setPostedado_id(int postedado_id) {
        this.postedado_id = postedado_id;
    }

    public void setFechacreacion(String fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    public int getId() {
        return id;
    }

    public int getUsuario_id() {
        return usuario_id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public int getPostedado_id() {
        return postedado_id;
    }

    public String getFechacreacion() {
        return fechacreacion;
    }

}
