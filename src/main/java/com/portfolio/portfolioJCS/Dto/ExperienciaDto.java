package com.portfolio.portfolioJCS.Dto;


import jakarta.validation.constraints.NotBlank;

public class ExperienciaDto {
	
		@NotBlank
		private String expNombre;
		
		@NotBlank
		private String expDescripcion;
		
		private String expImg;
		
		public ExperienciaDto() {
		}

		public ExperienciaDto(String expNombre, String expDescripcion, String expImg) {
			this.expNombre = expNombre;
			this.expDescripcion = expDescripcion;
			this.expImg = expImg;
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
