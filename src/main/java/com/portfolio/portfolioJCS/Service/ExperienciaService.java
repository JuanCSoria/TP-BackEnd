
package com.portfolio.portfolioJCS.Service;

import com.portfolio.portfolioJCS.Entity.Experiencia;
import com.portfolio.portfolioJCS.Repository.ExperienciaRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ExperienciaService {
    
    @Autowired            
    ExperienciaRepository experienciaRepository;
    
    public List<Experiencia> list(){
        return experienciaRepository.findAll();
    }
    public Optional<Experiencia> getOne(int id){
        return experienciaRepository.findById(id);
    }
    public Optional<Experiencia> getByExpNombre(String expNombre){
        return experienciaRepository.findByExpNombre(expNombre);
    }
    public void save(Experiencia exper){
        experienciaRepository.save(exper);
    }
    public void delete(int id){
        experienciaRepository.deleteById(id);
    }
    
    public boolean existsById(int id){
        return experienciaRepository.existsById(id);
    } 
    public boolean existByExpNombre(String expNombre){
        return experienciaRepository.existsByExpNombre(expNombre);
    }
}
