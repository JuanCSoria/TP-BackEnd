
package com.portfolio.portfolioJCS.Controller;

import com.portfolio.portfolioJCS.Dto.ProyectoDto;
import com.portfolio.portfolioJCS.Entity.Proyecto;
import com.portfolio.portfolioJCS.Security.Controller.Mensaje;
import com.portfolio.portfolioJCS.Service.ProyectoService;
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
@RequestMapping("proyect")
@CrossOrigin(origins =  "http://localhost:4200")
public class ProyectoController {
    
    @Autowired
    ProyectoService proyectoService;
    
    @GetMapping("/listar")
	public ResponseEntity<List<Proyecto>> list(){
		List<Proyecto> list = proyectoService.list();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@PostMapping("/crear")
	public ResponseEntity<?> create(@RequestBody ProyectoDto proyectoDto){
		if(StringUtils.isBlank(proyectoDto.getProyNombre()))
			return new ResponseEntity<>(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
		
		if(proyectoService.existByProyNombre(proyectoDto.getProyNombre()))
			return new ResponseEntity<>( new Mensaje("Ya existe"),HttpStatus.BAD_REQUEST);
		
		Proyecto proyecto = new Proyecto(proyectoDto.getProyNombre(), proyectoDto.getProyDescripcion(), proyectoDto.getProyImg());
		proyectoService.save(proyecto);
		
		return new ResponseEntity<>(new Mensaje("Proyecto agregado"), HttpStatus.OK);
	}
	
	@PutMapping("/modificar/{id}")
	public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody ProyectoDto proyDto){
		if(!proyectoService.existsById(id))
			return new ResponseEntity<>(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
		
		if(proyectoService.existByProyNombre(proyDto.getProyNombre()) && proyectoService.getByProyNombre(proyDto.getProyNombre()).get().getId() != id)
			return new ResponseEntity<>(new Mensaje("Ese proyecto ya existe"), HttpStatus.BAD_REQUEST);
		
		if(StringUtils.isBlank(proyDto.getProyNombre()))
			return new ResponseEntity<>(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
		
		Proyecto proyecto = proyectoService.getOne(id).get();
		proyecto.setProyNombre(proyDto.getProyNombre());
		proyecto.setProyDescripcion(proyDto.getProyDescripcion());
		proyecto.setProyImg(proyDto.getProyImg());
                        
		proyectoService.save(proyecto);
		return new ResponseEntity<>(new Mensaje("Proyecto actualizado"), HttpStatus.OK);
	}
        
	@DeleteMapping("/borrar/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id){
		if(!proyectoService.existsById(id))
			return new ResponseEntity<>(new Mensaje("El id no existe"),HttpStatus.OK);
		proyectoService.delete(id);
		return new ResponseEntity<>(new Mensaje("Proyecto eliminado"), HttpStatus.OK);
	}
}
