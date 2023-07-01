
package com.portfolio.portfolioJCS.Repository;

import com.portfolio.portfolioJCS.Entity.Educacion;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducacionRepository extends JpaRepository<Educacion, Integer
        >{
   public Optional<Educacion> findByEduNombre(String eduNombre);
     public boolean existsByEduNombre(String eduNombre); 
}
