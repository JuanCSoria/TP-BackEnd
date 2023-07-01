
package com.portfolio.portfolioJCS.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class Educacion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotNull
    private String eduNombre;
    
    @NotNull
    private String eduDescripcion;
    
    private String eduImg;

    public Educacion() {
    }

    public Educacion(String eduNombre, String eduDescripcion, String eduImg) {
        this.eduNombre = eduNombre;
        this.eduDescripcion = eduDescripcion;
        this.eduImg = eduImg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEduNombre() {
        return eduNombre;
    }

    public void setEduNombre(String eduNombre) {
        this.eduNombre = eduNombre;
    }

    public String getEduDescripcion() {
        return eduDescripcion;
    }

    public void setEduDescripcion(String eduDescripcion) {
        this.eduDescripcion = eduDescripcion;
    }

    public String getEduImg() {
        return eduImg;
    }

    public void setEduImg(String eduImg) {
        this.eduImg = eduImg;
    }
       
}
