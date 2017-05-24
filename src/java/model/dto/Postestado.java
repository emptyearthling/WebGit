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
public class Postestado {

    private int id;
    private String detalle;

    public Postestado() {
        this.id = 0;
        this.detalle = "";
    }

    public Postestado(int id, String detalle) {
        this.id = id;
        this.detalle = detalle;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public int getId() {
        return id;
    }

    public String getDetalle() {
        return detalle;
    }

}
