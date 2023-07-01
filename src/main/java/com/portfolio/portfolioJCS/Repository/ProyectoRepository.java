
package com.portfolio.portfolioJCS.Repository;

import com.portfolio.portfolioJCS.Entity.Proyecto;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyectoRepository extends JpaRepository<Proyecto,Integer>{
    public Optional<Proyecto> findByProyNombre(String proyNombre);
     public boolean existsByProyNombre(String proyNombre);
}
