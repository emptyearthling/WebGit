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
public class Comentario {
    private int id;
    private int usuario_id;
    private int post_id;
    private String comentario;
    private int comentarioestado;
    private String fechacreacion;
    
    public Comentario() {
        this.id = 0;
        this.usuario_id = 0;
        this.post_id = 0;
        this.comentario = "";
        this.comentarioestado = 0;
        this.fechacreacion = null;        
    }

    public Comentario(int id, int usuario_id, int post_id, String comentario, int comentarioestado, String fechacreacion) {
        this.id = id;
        this.usuario_id = usuario_id;
        this.post_id = post_id;
        this.comentario = comentario;
        this.comentarioestado = comentarioestado;
        this.fechacreacion = fechacreacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    public int getPost_id() {
        return post_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getComentarioestado() {
        return comentarioestado;
    }

    public void setComentarioestado(int comentarioestado) {
        this.comentarioestado = comentarioestado;
    }

    public String getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(String fechacreacion) {
        this.fechacreacion = fechacreacion;
    }
    
    
}
