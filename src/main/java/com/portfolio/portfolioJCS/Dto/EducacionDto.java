
package com.portfolio.portfolioJCS.Dto;

import jakarta.validation.constraints.NotBlank;


public class EducacionDto {
    
    @NotBlank
    private String eduNombre;
    @NotBlank
    private String eduDescripcion;
    @NotBlank
    private String eduImg;

    public EducacionDto() {
    }

    public EducacionDto(String eduNombre, String eduDescripcion, String eduImg) {
        this.eduNombre = eduNombre;
        this.eduDescripcion = eduDescripcion;
        this.eduImg = eduImg;
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
