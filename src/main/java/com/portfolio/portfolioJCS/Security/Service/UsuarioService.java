
package com.portfolio.portfolioJCS.Security.Service;

import com.portfolio.portfolioJCS.Security.Entity.Usuario;
import com.portfolio.portfolioJCS.Security.Repository.IUsuarioRepository;
import jakarta.transaction.Transactional;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UsuarioService {
   @Autowired
   IUsuarioRepository iusuarioRepository;
   
   public Optional<Usuario> getByNombreUsuario(String nombreUsuario){
       return iusuarioRepository.findByNombreUsuario(nombreUsuario);      
   }
   
   public Optional<Usuario> getByNombreUsuarioOrEmail(String nombreOrEmail){
       return iusuarioRepository.findByNombreUsuarioOrEmail(nombreOrEmail, nombreOrEmail);
   }
   
   public boolean existsByNombreUsuario(String nombreUsuario){
       return iusuarioRepository.existsByNombreUsuario(nombreUsuario);
   }
   
   public boolean existsByEmail(String email){
       return iusuarioRepository.existsByEmail(email);
   }
   
   public void save(Usuario usuario){
       iusuarioRepository.save(usuario);
   }
}
