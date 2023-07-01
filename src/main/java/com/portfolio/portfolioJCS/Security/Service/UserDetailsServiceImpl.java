
package com.portfolio.portfolioJCS.Security.Service;

import com.portfolio.portfolioJCS.Security.Entity.Usuario;
import com.portfolio.portfolioJCS.Security.Entity.UsuarioPrincipal;
import com.portfolio.portfolioJCS.Security.Repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{//revisar diferencias
    @Autowired    
    IUsuarioRepository iusuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String nombreOrEmail) throws UsernameNotFoundException {
        Usuario usuario = iusuarioRepository.findByNombreUsuarioOrEmail(nombreOrEmail, nombreOrEmail).get();
        return UsuarioPrincipal.build(usuario);
    }       
}
