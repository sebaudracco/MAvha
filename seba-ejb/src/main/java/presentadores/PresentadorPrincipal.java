/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentadores;


import javax.swing.JOptionPane;
import mavha.examen.seba.model.Persona;
import repositorios.RepositorioPersona;
import vistas.VistaPrincipal;



public class PresentadorPrincipal {
    private VistaPrincipal vistaPrincipal;
    
    private RepositorioPersona repositorioPersona;
    
    public PresentadorPrincipal(VistaPrincipal vistaPrincipal) {
        this.vistaPrincipal = vistaPrincipal;
        
        this.repositorioPersona = new RepositorioPersona();
    }
    
    public void mostrarInformación()
    {
        String mensaje = "";
        
        for (Persona persona : this.repositorioPersona.obtenerPersona()) {
            mensaje += "Nombre: " + persona.getNombre() +
                        ", Apellido: " + persona.getApellido() +
                        ", DNI: " + persona.getDni() + "\n" +
                        ", Edad: " + persona.getEdad() + "\n";
        }
        
        JOptionPane.showMessageDialog(this.vistaPrincipal, mensaje);
    }
    
    public void guardarDatos()
    {
        //Obtener los datos
        String nombre = this.vistaPrincipal.getNombreTextField().getText();
        String apellido = this.vistaPrincipal.getApellidoTextField().getText();
        String dni = this.vistaPrincipal.getDniTextField().getText();
        
        
          
        //Limpiar pantallas
        this.vistaPrincipal.getNombreTextField().setText("");
        this.vistaPrincipal.getApellidoTextField().setText("");
        this.vistaPrincipal.getDniTextField().setText("");
        
        
        //Indicarle al usuario que se guardó correctamente
        JOptionPane.showMessageDialog(this.vistaPrincipal, "Persona Guardada !");
    }
    
    public void buscarPersona()
    {
        String busqueda = this.vistaPrincipal.getBusquedaTextField().getText();
        
        Persona personaEncontrado = this.repositorioPersona.buscarPersona(busqueda);
        
        if (personaEncontrado == null) {
            JOptionPane.showMessageDialog(this.vistaPrincipal, 
                    "No se encontró la persona");
        } else {
            String mensaje = "Nombre: " + personaEncontrado.getNombre() + 
                            "\nApellido: " + personaEncontrado.getApellido() + 
                            "\nDNI: " + personaEncontrado.getDni() +
                            "\nEdad: " + personaEncontrado.getEdad();

            
            JOptionPane.showMessageDialog(this.vistaPrincipal, mensaje);
        }
    }
}
