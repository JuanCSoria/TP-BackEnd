
package com.portfolio.portfolioJCS.Controller;

import com.portfolio.portfolioJCS.Entity.Persona;
import com.portfolio.portfolioJCS.Interface.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/persona")
@CrossOrigin(origins = "http://localhost:4200")

    public class PersonaController {
    @Autowired
    IPersonaService ipersonaService;
    
    @GetMapping("/listar")
    public List<Persona> getPersona(){
        return ipersonaService.getPersona();
    }
        
    @PostMapping("/crear")
    public String createPersona(@RequestBody Persona persona){
        ipersonaService.savePersona(persona);
        return "La persona fue creada correctamente";
    }
    
    @DeleteMapping("/borrar/{id}")
    public String deletePersona(@PathVariable int id ){
        ipersonaService.deletePersona(id);
        return "La persona fue eliminada correctamente";
    }
    
    @PutMapping("/editar/{id}")
    public Persona editPersona(@PathVariable int id,
            @RequestParam("nombre")String nuevoNombre,
            @RequestParam("titulo")String nuevoTitulo,
            @RequestParam("acercaDe")String nuevoAcercaDe,
            @RequestParam("imgPerfil")String nuevoImgPerfil){
        
        Persona persona = ipersonaService.findPersona(id);
        
        persona.setNombre(nuevoNombre);
        persona.setTitulo(nuevoTitulo);
        persona.setAcercaDe(nuevoAcercaDe);
        persona.setImgPerfil(nuevoImgPerfil);
                
        ipersonaService.savePersona(persona);
        return persona;
    }
    
    @GetMapping("/listar/perfil")
    public Persona findPersona(){
        return ipersonaService.findPersona((int) 1);        
    }
}