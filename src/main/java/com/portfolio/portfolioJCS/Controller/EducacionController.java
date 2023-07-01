
package com.portfolio.portfolioJCS.Controller;

import com.portfolio.portfolioJCS.Dto.EducacionDto;
import com.portfolio.portfolioJCS.Entity.Educacion;
import com.portfolio.portfolioJCS.Security.Controller.Mensaje;
import com.portfolio.portfolioJCS.Service.EducacionService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/educacion")
@CrossOrigin(origins = "http://localhost:4200")
public class EducacionController {
    
    @Autowired            
    EducacionService educacionService;
    
    @GetMapping("/listar")
	public ResponseEntity<List<Educacion>> list(){
		List<Educacion> list = educacionService.list();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@PostMapping("/crear")
	public ResponseEntity<?> create(@RequestBody EducacionDto educacionDto){
		if(StringUtils.isBlank(educacionDto.getEduNombre()))
			return new ResponseEntity<>(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
		
		if(educacionService.existByEduNombre(educacionDto.getEduNombre()))
			return new ResponseEntity<>( new Mensaje("Ya existe ese nombre"),HttpStatus.BAD_REQUEST);
		
		Educacion educacion = new Educacion(
			educacionDto.getEduNombre(),
			educacionDto.getEduDescripcion(),
			educacionDto.getEduImg());
		
		educacionService.save(educacion);
		
		return new ResponseEntity<>(new Mensaje("Educación agregada"), HttpStatus.OK);
	} 
	
	@PutMapping("/editar/{id}")
	public ResponseEntity<?> modificar(@PathVariable("id") int id, @RequestBody EducacionDto eduDto){
		if(!educacionService.existsById(id))
			return new ResponseEntity<>(new Mensaje("El ID no existe"), HttpStatus.NOT_FOUND);
		
		if(educacionService.existByEduNombre(eduDto.getEduNombre()) && educacionService.getByEduNombre(eduDto.getEduNombre()).get().getId() != id)
			return new ResponseEntity<>(new Mensaje("Ya existe ese nombre"), HttpStatus.BAD_REQUEST);
		
		if(StringUtils.isBlank(eduDto.getEduNombre()))
			return new ResponseEntity<>(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
		
		Educacion educacion = educacionService.getOne(id).get();
		
		educacion.setEduNombre(eduDto.getEduNombre());
		educacion.setEduDescripcion(eduDto.getEduDescripcion());
        educacion.setEduImg(eduDto.getEduImg());
		
		educacionService.save(educacion);
		return new ResponseEntity<>(new Mensaje("Educación actualizada"), HttpStatus.OK);
	}
        
	@DeleteMapping("/borrar/{id}")
	public ResponseEntity<?> borrar(@PathVariable("id") int id){
		if(!educacionService.existsById(id))
			return new ResponseEntity<>(new Mensaje("El id no existe"),HttpStatus.NOT_FOUND);
		educacionService.delete(id);
		return new ResponseEntity<>(new Mensaje("Educación eliminada"), HttpStatus.OK);
	}
	
	@GetMapping("/detalles/{id}")
	public ResponseEntity<Educacion> getById(@PathVariable("id") int id){
		if(!educacionService.existsById(id))
			return new ResponseEntity(new Mensaje("El id no existe"),HttpStatus.BAD_REQUEST);
		Educacion educacion = educacionService.getOne(id).get();
		return new ResponseEntity(educacion, HttpStatus.OK);
	}
	
}
