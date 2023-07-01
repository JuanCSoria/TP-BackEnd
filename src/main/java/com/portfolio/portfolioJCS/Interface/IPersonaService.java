
package com.portfolio.portfolioJCS.Interface;

import com.portfolio.portfolioJCS.Entity.Persona;
import java.util.List;

public interface IPersonaService {
    //Traer una lista de personas
    public List<Persona> getPersona();
    
    //Guardar un objeto de tipo persona
    public void savePersona(Persona persona);
    
    //Eliminar un usuario buscado por Id
    public void deletePersona(int id);
    
    //Buscar una persona por ID
    public Persona findPersona(int id);
    
    //Mostrar una persona por Id
 
}
