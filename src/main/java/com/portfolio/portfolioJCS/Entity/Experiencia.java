
package com.portfolio.portfolioJCS.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class Experiencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotNull
    private String expNombre;
    
    @NotNull
    private String expDescripcion;
    
    private String expImg;

    public Experiencia() {
    }

    public Experiencia(String expNombre, String expDescripcion, String expImg) {
        this.expNombre = expNombre;
        this.expDescripcion = expDescripcion;
        this.expImg = expImg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getExpNombre() {
        return expNombre;
    }

    public void setExpNombre(String expNombre) {
        this.expNombre = expNombre;
    }

    public String getExpDescripcion() {
        return expDescripcion;
    }

    public void setExpDescripcion(String expDescripcion) {
        this.expDescripcion = expDescripcion;
    }

    public String getExpImg() {
        return expImg;
    }

    public void setExpImg(String expImg) {
        this.expImg = expImg;
    }   
}
