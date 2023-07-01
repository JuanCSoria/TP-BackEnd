
package com.portfolio.portfolioJCS.Service;

import com.portfolio.portfolioJCS.Entity.Educacion;
import com.portfolio.portfolioJCS.Repository.EducacionRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class EducacionService {
    
    @Autowired
    EducacionRepository educacionRepository;
    
    public List<Educacion> list(){
        return educacionRepository.findAll();
    }
    public Optional<Educacion> getOne(int id){
        return educacionRepository.findById(id);
    }
    public Optional<Educacion> getByEduNombre(String eduNombre){
        return educacionRepository.findByEduNombre(eduNombre);
    }
    public void save(Educacion educ){
        educacionRepository.save(educ);
    }
    public void delete(int id){
        educacionRepository.deleteById(id);
    }
    
    public boolean existsById(int id){
        return educacionRepository.existsById(id);
    } 
    public boolean existByEduNombre(String eduNombre){
        return educacionRepository.existsByEduNombre(eduNombre);
    }
}
