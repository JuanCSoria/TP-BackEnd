
package com.portfolio.portfolioJCS.Dto;

import jakarta.validation.constraints.NotBlank;


public class ProyectoDto {
    
    @NotBlank
    private String proyNombre;
    
    @NotBlank
    private String proyDescripcion;
    
    private String proyImg;

    public ProyectoDto() {
    }

    public ProyectoDto(String proyNombre, String proyDescripcion, String proyImg) {
        this.proyNombre = proyNombre;
        this.proyDescripcion = proyDescripcion;
        this.proyImg = proyImg;
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
