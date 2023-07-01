
package com.portfolio.portfolioJCS.Security.Repository;

import com.portfolio.portfolioJCS.Security.Entity.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer>{
    Optional<Usuario> findByNombreUsuario(String nombreUsuario);    
    Optional<Usuario> findByNombreUsuarioOrEmail(String nombreUsuario,String email);
   
    boolean existsByNombreUsuario(String nombreUsuario);
    boolean existsByEmail(String email); 
}
