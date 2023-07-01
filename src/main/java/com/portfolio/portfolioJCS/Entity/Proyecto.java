
package com.portfolio.portfolioJCS.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Proyecto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotBlank
    private String proyNombre;
    
    @NotBlank
    private String proyDescripcion;
    
    private String proyImg;

    public Proyecto() {
    }

    public Proyecto(String proyNombre, String proyDescripcion, String proyImg) {
        this.proyNombre = proyNombre;
        this.proyDescripcion = proyDescripcion;
        this.proyImg = proyImg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProyNombre() {
        return proyNombre;
    }

    public void setProyNombre(String proyNombre) {
        this.proyNombre = proyNombre;
    }

    public String getProyDescripcion() {
        return proyDescripcion;
    }

    public void setProyDescripcion(String proyDescripcion) {
        this.proyDescripcion = proyDescripcion;
    }

    public String getProyImg() {
        return proyImg;
    }

    public void setProyImg(String proyImg) {
        this.proyImg = proyImg;
    }    
}
