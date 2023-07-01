
package com.portfolio.portfolioJCS.Repository;

import com.portfolio.portfolioJCS.Entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonaRepository extends JpaRepository<Persona, Integer>{
    
}
