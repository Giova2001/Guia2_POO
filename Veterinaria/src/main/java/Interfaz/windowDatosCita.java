/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaz;

import com.mycompany.veterinaria.BaseDatos;
import com.mycompany.veterinaria.Cita;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author STL User
 */
public class windowDatosCita extends JPanel implements ActionListener{
    private BaseDatos baseDatos;
    private Label label1;
    private Label label2;
    private Label label3;
    private Label label4;
    private Label label5;
    private TextField fechaCita;
    private TextField horaCita;
    private TextField paciente;
    private TextField motivoCita;
    private JButton agendarCita;
    private JButton menuAnterior;
    private String mensajeExitoso;

    public windowDatosCita(BaseDatos baseDatos) {
        this.baseDatos = baseDatos;
        setLayout(new GridLayout(7, 2)); // Diseño de la ventana

        label1 = new Label("Tomar datos para la cita");
        label1.setFont(new Font("Arial", Font.BOLD, 18));
        label1.setAlignment(Label.CENTER);

        label2 = new Label("Fecha de la cita (dd/MM/aaaa):");
        fechaCita = new TextField(2);
        label3 = new Label("Hora de la cita (formato de 24 horas HH:mm):");
        horaCita = new TextField(2);
        label4 = new Label("Paciente (NIU):");
        paciente = new TextField(2);
        label5 = new Label("Motivo de la cita:");
        motivoCita = new TextField(2);
        agendarCita = new JButton("Agendar una cita");
        menuAnterior = new JButton("Regresar al menú de citas");

        add(label1);
        add(new Label(" "));
        add(label2);
        add(fechaCita);
        add(label3);
        add(horaCita);
        add(label4);
        add(paciente);
        add(label5);
        add(motivoCita);

        agendarCita.addActionListener(this);
        agendarCita.setFont(new Font("Arial", Font.PLAIN, 16));
        menuAnterior.addActionListener(this);
        menuAnterior.setFont(new Font("Arial", Font.PLAIN, 16));

        add(agendarCita);
        add(menuAnterior);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object fuente = e.getSource();
        
        if (fuente == agendarCita) {
            agendarCita();
            cerrarVentana();
        } else if (fuente == menuAnterior){
            cerrarVentana();
        }
    }
    
     private boolean validarCampos() {
        if (fechaCita.getText().isEmpty() || horaCita.getText().isEmpty() ||
            paciente.getText().isEmpty() || motivoCita.getText().isEmpty()) {
            return false; // Al menos un campo está vacío
        }
        try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            formatoFecha.setLenient(false);
            formatoFecha.parse(fechaCita.getText());
            LocalTime.parse(horaCita.getText()); // Comprueba el formato de la hora
        } catch (ParseException | DateTimeParseException ex) {
            return false; // Los datos tienen un formato incorrecto
        }
        return true; // Todos los campos están completos y tienen el formato correcto
    }
     
    private void mostrarMensajeExito(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }

    private void mostrarMensajeError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void agendarCita(){
        boolean pasar = validarCampos();
        if(pasar != false){
        try {
            // Obtener los valores de los campos de texto
            String pacienteNiu = paciente.getText();
            String fecha = fechaCita.getText();
            String hora = horaCita.getText();
            String motivo = motivoCita.getText();

            // Convierte la fecha y la hora en los tipos de datos adecuados
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            Date fechaCita = formatoFecha.parse(fecha);

            LocalTime horaCita = LocalTime.parse(hora);

            // Crea una nueva cita
            Cita newCita = new Cita(pacienteNiu, fechaCita, horaCita, motivo);
            mensajeExitoso = "Cita agendada con éxito. el id de la cita es: " + newCita.getIdCita();    
            // Agrega la cita a la base de datos
            baseDatos.setCitas(newCita);
        } catch (ParseException ex) {
            Logger.getLogger(windowDatosCita.class.getName()).log(Level.SEVERE, null, ex);
        }
        mostrarMensajeExito(mensajeExitoso);
        } else {
            mostrarMensajeError("Por favor, complete todos los campos correctamente.");
        }
    }
    
    public void cerrarVentana(){
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        frame.dispose();
    }
}