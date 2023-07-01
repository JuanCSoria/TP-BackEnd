
package com.portfolio.portfolioJCS.Repository;

import com.portfolio.portfolioJCS.Entity.Experiencia;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienciaRepository extends JpaRepository<Experiencia,Integer>{
     public Optional<Experiencia> findByExpNombre(String expNombre);
     public boolean existsByExpNombre(String expNombre);
}
