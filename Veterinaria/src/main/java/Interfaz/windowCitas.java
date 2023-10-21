/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaz;

import com.mycompany.veterinaria.BaseDatos;
import com.mycompany.veterinaria.Cita;
import com.mycompany.veterinaria.Paciente;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author STL User
 */
public class windowCitas extends JPanel implements ActionListener{
    private BaseDatos baseDatos;
    private Cita citaEncontrada;
    private Paciente pacienteEncontrado;
    private Label label1;
    private JButton agendarCita;
    private JButton modificarCita;
    private JButton cancelarCita;
    private JButton RegresarMP;
    private String idCitaONIU;
    
    public windowCitas(BaseDatos baseDatos){
        this.baseDatos = baseDatos;
        setLayout(new GridLayout(5, 1)); // Diseño de la ventana

        label1 = new Label("Opciones para citas");
        label1.setFont(new Font("Arial", Font.BOLD, 18));
        label1.setAlignment(Label.CENTER);

        agendarCita = new JButton("Agendar una cita");
        modificarCita = new JButton("Modificar cita");
        cancelarCita = new JButton("Eliminar cita");
        RegresarMP = new JButton("Regresar al menú principal");

        add(label1);

        agendarCita.addActionListener(this);
        agendarCita.setFont(new Font("Arial", Font.PLAIN, 16));
        add(agendarCita);

        modificarCita.addActionListener(this);
        modificarCita.setFont(new Font("Arial", Font.PLAIN, 16));
        add(modificarCita);

        cancelarCita.addActionListener(this);
        cancelarCita.setFont(new Font("Arial", Font.PLAIN, 16));
        add(cancelarCita);

        RegresarMP.addActionListener(this);
        RegresarMP.setFont(new Font("Arial", Font.PLAIN, 16));
        add(RegresarMP);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object fuente = e.getSource();
        
        if (fuente == agendarCita) {
            agendarCita();
        } else if (fuente == modificarCita){
            modificarCita();
        } else if (fuente == cancelarCita){
            cancelarCita();
        }else if (fuente == RegresarMP){
            MenuPrincipal MP = new MenuPrincipal(baseDatos);
            MP.setVisible(true);
            regresarMP();
        }
    }
    
    private boolean buscarCita() {
        idCitaONIU = JOptionPane.showInputDialog(this, "Ingrese ID de Cita o NIU del paciente:");
        if (idCitaONIU != null && !idCitaONIU.isEmpty()) {
            citaEncontrada = baseDatos.buscarCitaPorId(idCitaONIU);
            pacienteEncontrado = baseDatos.buscarPacientePorId(idCitaONIU);
            
            if (citaEncontrada != null || pacienteEncontrado != null) {
                mostrarMensajeExito("Cita encontrada\n");
                return true;
            } else {
                mostrarMensajeError("No se encontró ninguna cita con el ID de Cita o NIU proporcionado.");
            }
        }
        return false; // Debes devolver un valor por defecto en caso de que no se cumplan las condiciones anteriores
    }

    private void mostrarMensajeExito(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }

    private void mostrarMensajeError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    public void agendarCita(){
        // Crear una instancia de la clase windowDatosCita
        windowDatosCita ventanaDatosCita = new windowDatosCita(baseDatos);

        // Crear un JFrame para mostrar la ventana
        JFrame frame = new JFrame("Datos para la Cita");
        frame.addWindowListener(new MainWindowListenerSecundary()); // Ajusta la operación de cierre según tus necesidades
        frame.add(ventanaDatosCita); // Agrega la instancia de la ventana a la ventana principal
        frame.pack(); // Ajusta el tamaño del JFrame automáticamente
        frame.setVisible(true); // Haz visible el JFrame y, por lo tanto, la ventana de datos de la cita
    }

    public void modificarCita(){
        boolean pasar = buscarCita();

        if (pasar){
            // Crear una instancia de la clase windowDatosCita
            windowModificacionesCitas ventanaModificacionesCita = new windowModificacionesCitas(baseDatos, citaEncontrada);

            // Crear un JFrame para mostrar la ventana
            JFrame frame = new JFrame("Datos para la Cita");
            frame.addWindowListener(new MainWindowListenerSecundary()); // Ajusta la operación de cierre según tus necesidades
            frame.add(ventanaModificacionesCita); // Agrega la instancia de la ventana a la ventana principal
            frame.pack(); // Ajusta el tamaño del JFrame automáticamente
            frame.setVisible(true); // Haz visible el JFrame y, por lo tanto, la ventana de datos de la cita
        }
    }

    public void cancelarCita(){
        boolean eliminar = buscarCita();
        if (eliminar){ 
            baseDatos.eliminarCitaPorId(idCitaONIU);
            mostrarMensajeExito("Cita eliminada");
        }
    }

    public void regresarMP(){
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        frame.dispose();
    }
}