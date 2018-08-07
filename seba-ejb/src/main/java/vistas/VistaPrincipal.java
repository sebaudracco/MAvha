/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import javax.swing.JButton;
import javax.swing.JTextField;
import presentadores.PresentadorPrincipal;

/**
 *
 * @author agu
 */
public class VistaPrincipal extends javax.swing.JFrame {
    private PresentadorPrincipal presentadorPrincipal;
    
    /**
     * Creates new form VistaPrincipal
     */
    public VistaPrincipal() {
        initComponents();
        
        PresentadorPrincipal presentador = new PresentadorPrincipal(this);
        
        this.presentadorPrincipal = presentador;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        nombreLabel = new javax.swing.JLabel();
        nombreTextField = new javax.swing.JTextField();
        apellidoLabel = new javax.swing.JLabel();
        apellidoTextField = new javax.swing.JTextField();
        dniLabel = new javax.swing.JLabel();
        dniTextField = new javax.swing.JTextField();
        guardarDatosButton = new javax.swing.JButton();
        mostrarInformacionButton = new javax.swing.JButton();
        separadorMedio = new javax.swing.JSeparator();
        busquedaTextField = new javax.swing.JTextField();
        buscarButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        EdadTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        nombreLabel.setText("Nombre:");

        apellidoLabel.setText("Apellido:");

        dniLabel.setText("DNI:");

        dniTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dniTextFieldActionPerformed(evt);
            }
        });

        guardarDatosButton.setText("Guardar datos");
        guardarDatosButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarDatosApretado(evt);
            }
        });

        mostrarInformacionButton.setText("Mostrar información");
        mostrarInformacionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMostrarInformacionApretado(evt);
            }
        });

        buscarButton.setText("Buscar");
        buscarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarApretado(evt);
            }
        });

        jLabel1.setText("Edad: ");

        EdadTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EdadTextFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(separadorMedio, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nombreLabel)
                        .addGap(18, 18, 18)
                        .addComponent(nombreTextField))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(mostrarInformacionButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                        .addComponent(guardarDatosButton))
                    .addComponent(busquedaTextField)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buscarButton)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(apellidoLabel)
                            .addComponent(dniLabel)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dniTextField)
                            .addComponent(apellidoTextField)
                            .addComponent(EdadTextField))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreLabel)
                    .addComponent(nombreTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(apellidoLabel)
                    .addComponent(apellidoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dniLabel)
                    .addComponent(dniTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(EdadTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mostrarInformacionButton)
                    .addComponent(guardarDatosButton))
                .addGap(18, 18, 18)
                .addComponent(separadorMedio, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(busquedaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buscarButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>                        

    private void botonGuardarDatosApretado(java.awt.event.ActionEvent evt) {                                           
        this.presentadorPrincipal.guardarDatos();
    }                                          

    private void botonMostrarInformacionApretado(java.awt.event.ActionEvent evt) {                                                 
        this.presentadorPrincipal.mostrarInformación();
    }                                                

    private void botonBuscarApretado(java.awt.event.ActionEvent evt) {                                     
        this.presentadorPrincipal.buscarPersona();
    }                                    

    private void EdadTextFieldActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
    }                                             

    private void dniTextFieldActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
    }                                            

    public JTextField getApellidoTextField() {
        return apellidoTextField;
    }

    public JTextField getBusquedaTextField() {
        return busquedaTextField;
    }

    public JTextField getDniTextField() {
        return dniTextField;
    }

    public JTextField getNombreTextField() {
        return nombreTextField;
    }
    
    // Variables declaration - do not modify                     
    private javax.swing.JTextField EdadTextField;
    private javax.swing.JLabel apellidoLabel;
    private javax.swing.JTextField apellidoTextField;
    private javax.swing.JButton buscarButton;
    private javax.swing.JTextField busquedaTextField;
    private javax.swing.JLabel dniLabel;
    private javax.swing.JTextField dniTextField;
    private javax.swing.JButton guardarDatosButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton mostrarInformacionButton;
    private javax.swing.JLabel nombreLabel;
    private javax.swing.JTextField nombreTextField;
    private javax.swing.JSeparator separadorMedio;
    // End of variables declaration                   
}
