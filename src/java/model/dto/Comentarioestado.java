/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dto;

/**
 *
 * @author kwolfenden
 */
public class Comentarioestado {

    private int id;
    private String detalle;

    public Comentarioestado() {
        this.id = 0;
        this.detalle = "";
    }

    public Comentarioestado(int id, String detalle) {
        this.id = id;
        this.detalle = detalle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

}
