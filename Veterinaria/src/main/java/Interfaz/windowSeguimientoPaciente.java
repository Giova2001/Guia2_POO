/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaz;

import com.mycompany.veterinaria.BaseDatos;
import com.mycompany.veterinaria.Cita;
import com.mycompany.veterinaria.Paciente;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author STL User
 */
public class windowSeguimientoPaciente extends JPanel implements ActionListener {
    private BaseDatos baseDatos;
    private Label label1;
    private JButton modificarDatosPacientes;
    private JButton citaAgendada;
    private JButton borrarPaciente;
    private JButton salir;
    
    public windowSeguimientoPaciente(BaseDatos baseDatos){
        this.baseDatos = baseDatos;
        setLayout(new GridLayout(5, 1)); // Diseño de la ventana, 5 filas y 1 columna

        JLabel label1 = new JLabel("OPCIONES");
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        label1.setFont(new Font("Arial", Font.BOLD, 18));

        modificarDatosPacientes = new JButton("Modificar Datos de un Paciente ya registrado");
        citaAgendada = new JButton("Buscar Cita Agendada");
        borrarPaciente = new JButton("Borrar del sistema a un paciente");
        salir = new JButton("Regresar al menú principal");

        // Agregar espaciadores para mejorar la presentación
        add(label1);
        add(new JLabel()); // Espaciador
        add(modificarDatosPacientes);
        add(citaAgendada);
        add(borrarPaciente);
        add(salir);

        // Alinear y dar formato a los botones
        modificarDatosPacientes.setHorizontalAlignment(SwingConstants.LEFT);
        citaAgendada.setHorizontalAlignment(SwingConstants.LEFT);
        borrarPaciente.setHorizontalAlignment(SwingConstants.LEFT);
        salir.setHorizontalAlignment(SwingConstants.LEFT);

        modificarDatosPacientes.setFont(new Font("Arial", Font.PLAIN, 16));
        citaAgendada.setFont(new Font("Arial", Font.PLAIN, 16));
        borrarPaciente.setFont(new Font("Arial", Font.PLAIN, 16));
        salir.setFont(new Font("Arial", Font.PLAIN, 16));

        // Agregar ActionListener a los botones
        modificarDatosPacientes.addActionListener(this);
        citaAgendada.addActionListener(this);
        borrarPaciente.addActionListener(this);
        salir.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object fuente = e.getSource();
        
        if (fuente == modificarDatosPacientes) {
            modificarPacinete();
        } else if (fuente == citaAgendada){
            citaAgendada();
        } else if (fuente == borrarPaciente){
            borrarPaciente();
        }else if (fuente == salir){
            MenuPrincipal MP = new MenuPrincipal(baseDatos);
            MP.setVisible(true);
            cerrarVentana();
        }
    }
    
    public Paciente encontrarPaciente(){
        String niuInput = JOptionPane.showInputDialog(null, "Ingrese el NIU del paciente:");
        Paciente pacienteEncontrado = baseDatos.buscarPacientePorId(niuInput);

        if (pacienteEncontrado != null) {
            return pacienteEncontrado;
        } else {
            // Si no se encuentra el paciente, muestra un mensaje de error
            JOptionPane.showMessageDialog(null, "Paciente no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    public Cita encontrarCita(){
        String IDcita = JOptionPane.showInputDialog(null, "Ingrese el ID de la cita del paciente:");
        
        Cita citaEncontrada = baseDatos.buscarCitaPorId(IDcita);
        if (citaEncontrada != null) {
            return citaEncontrada;
        } else {
            // Si no se encuentra el paciente, muestra un mensaje de error
            JOptionPane.showMessageDialog(null, "no tiene cita agendada o no se encontro la cita", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public void modificarPacinete(){
        Paciente pacienteLocalizado = encontrarPaciente();

        if (pacienteLocalizado != null){
            windowModificarPaciente ventanaModificarPaciente = new windowModificarPaciente(pacienteLocalizado);

            // Crear un JFrame para mostrar la ventana
            JFrame frame = new JFrame("Modificar Paciente");
            frame.addWindowListener(new MainWindowListenerSecundary()); // Ajusta la operación de cierre
            frame.add(ventanaModificarPaciente); // Agrega la instancia de la ventana a la ventana principal
            frame.pack(); // Ajusta el tamaño del JFrame automáticamente
            frame.setVisible(true); // Haz visible el JFrame y, por lo tanto, la ventana de modificación del paciente
        }
    }

    public void citaAgendada(){
        Cita citaEncontrada = encontrarCita();

        if (citaEncontrada != null){
            JFrame frame = new JFrame("Area de consulta(Vacunas)");
            frame.addWindowListener(new MainWindowListenerSecundary());

            // Crear la ventana principal de tu aplicación
            windowVacunas wVacunas = new windowVacunas(baseDatos,citaEncontrada.getNIU(), citaEncontrada);

            // Agregar la ventana principal al marco
            frame.getContentPane().add(wVacunas);
            frame.pack();
            frame.setVisible(true);    
        }
    }
    
    public void borrarPaciente(){
        Paciente pacienteLocalizado = encontrarPaciente();

        if (pacienteLocalizado != null){
            baseDatos.eliminarPacientePorId(pacienteLocalizado.getNIU());
            JOptionPane.showMessageDialog(
            null, // Componente padre (null para centrar en la pantalla)
            "El elemento ha sido eliminado con éxito.", // Mensaje
            "Eliminación Exitosa", // Título de la ventana de diálogo
            JOptionPane.INFORMATION_MESSAGE); // Icono de información
        }
    }

    public void cerrarVentana(){
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        frame.dispose();
    }
}
