
package com.portfolio.portfolioJCS.Service;

import com.portfolio.portfolioJCS.Entity.Proyecto;
import com.portfolio.portfolioJCS.Repository.ProyectoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProyectoService {
    
    @Autowired
    ProyectoRepository proyectoRepository;
    
     public List<Proyecto> list(){
        return proyectoRepository.findAll();
    }
    public Optional<Proyecto> getOne(int id){
        return proyectoRepository.findById(id);
    }
    public Optional<Proyecto> getByProyNombre(String proyNombre){
        return proyectoRepository.findByProyNombre(proyNombre);
    }
    public void save(Proyecto proy){
        proyectoRepository.save(proy);
    }
    public void delete(int id){
        proyectoRepository.deleteById(id);
    }
    
    public boolean existsById(int id){
        return proyectoRepository.existsById(id);
    } 
    public boolean existByProyNombre(String proyNombre){
        return proyectoRepository.existsByProyNombre(proyNombre);
    }
}
