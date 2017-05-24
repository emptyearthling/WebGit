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
public class Perfil {

    private Integer id;
    private String detalle;

    public Perfil() {
        this.id = 0;
        this.detalle = "";
    }

    public Perfil(Integer id, String detalle) {
        this.id = id;
        this.detalle = detalle;
    }

    public Integer getId() {
        return id;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

}
