package com.portfolio.portfolioJCS.Controller;

import com.portfolio.portfolioJCS.Dto.ExperienciaDto;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.portfolioJCS.Entity.Experiencia;
import com.portfolio.portfolioJCS.Security.Controller.Mensaje;
import com.portfolio.portfolioJCS.Service.ExperienciaService;
import org.springframework.web.bind.annotation.DeleteMapping;



@RestController
@RequestMapping("explaboral")
@CrossOrigin(origins = "http://localhost:4200")
public class ExperienciaController {
	
	@Autowired
	ExperienciaService experienciaService;
	
	@GetMapping("/lista")
	public ResponseEntity<List<Experiencia>> list(){
		List<Experiencia> list = experienciaService.list();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@PostMapping("/crear")
	public ResponseEntity<?> create(@RequestBody ExperienciaDto experienciaDto){
		if(StringUtils.isBlank(experienciaDto.getExpNombre()))
			return new ResponseEntity<>(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
		
		if(experienciaService.existByExpNombre(experienciaDto.getExpNombre()))
			return new ResponseEntity<>( new Mensaje("Esa experiencia ya existe"),HttpStatus.BAD_REQUEST);
		
		Experiencia experiencia = new Experiencia(experienciaDto.getExpNombre(), experienciaDto.getExpDescripcion(), experienciaDto.getExpImg());
		experienciaService.save(experiencia);
		
		return new ResponseEntity<>(new Mensaje("Experiencia agregada"), HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody ExperienciaDto experDto){
		if(!experienciaService.existsById(id))
			return new ResponseEntity<>(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
		
		if(experienciaService.existByExpNombre(experDto.getExpNombre()) && experienciaService.getByExpNombre(experDto.getExpNombre()).get().getId() != id)
			return new ResponseEntity<>(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
		
		if(StringUtils.isBlank(experDto.getExpNombre()))
			return new ResponseEntity<>(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
		
		Experiencia experiencia = experienciaService.getOne(id).get();
		experiencia.setExpNombre(experDto.getExpNombre());
		experiencia.setExpDescripcion(experDto.getExpDescripcion());
		experiencia.setExpImg(experDto.getExpImg());
                        
		experienciaService.save(experiencia);
		return new ResponseEntity<>(new Mensaje("Experiencia actualizada"), HttpStatus.OK);
	}
        
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id){
		if(!experienciaService.existsById(id))
			return new ResponseEntity<>(new Mensaje("El id no existe"),HttpStatus.OK);
		experienciaService.delete(id);
		return new ResponseEntity<>(new Mensaje("Experiencia eliminada"), HttpStatus.OK);
	}
}
