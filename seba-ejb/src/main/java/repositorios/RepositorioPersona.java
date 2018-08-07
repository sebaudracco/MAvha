/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorios;

import java.util.ArrayList;
import mavha.examen.seba.model.Persona;



public class RepositorioPersona {
    private final ArrayList<Persona> persona;

    public RepositorioPersona() {
        this.persona = new ArrayList<>();
    }
    
    public void guardar(Persona persona)
    {
        this.persona.add(persona);
    }
    
    public Persona[] obtenerPersona()
    {
        return this.persona.
                toArray(new Persona[this.persona.size()]);
    }
    
    public Persona buscarPersona(String busqueda) 
    {
        for (Persona persona : this.obtenerPersona()) {
            if (
                    persona.getNombre().contains(busqueda) ||
                    persona.getApellido().contains(busqueda)) {
                
                return persona;
            }
        }
        
        return null;
    }
            
}

