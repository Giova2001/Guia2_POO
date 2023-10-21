/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaz;

import com.mycompany.veterinaria.BaseDatos;
import com.mycompany.veterinaria.Cita;
import com.mycompany.veterinaria.Paciente;
import com.mycompany.veterinaria.Vacuna;
import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author STL User
 */
public class windowVacunas extends JPanel implements ActionListener{
    private Label label1;
    private Label label2;
    private Label label3;
    private Label label4;
    private Label label5;
    private TextField nombreVacuna;
    private TextField fechaVacuna;
    private TextField horaVacuna;
    private TextField pacientetxt;
    private JButton guardar;
    private JButton cancelar;
    private BaseDatos baseDatos;
    private Paciente paciente;
    private Vacuna newVacuna;
    private Cita cita;
    
    
    public windowVacunas(BaseDatos baseDatos, String NIU , Cita cita){
        this.baseDatos = baseDatos;
        this.paciente = baseDatos.buscarPacientePorId(NIU);;
        this.cita = cita;

        // Establecer el diseño del panel principal
        setLayout(new GridLayout(6, 2)); // 8 filas y 2 columnas

        label1 = new Label("Tomar datos de la vacuna");
        label5 = new Label("Nombre de la vacuna: ");
        nombreVacuna = new TextField();
        label2 = new Label("Fecha de la Vacuna (dd/MM/aaaa): ");
        fechaVacuna = new TextField();
        label3 = new Label("Hora de la Vacuna (formato de 24 horas): ");
        horaVacuna = new TextField();
        label4 = new Label("Paciente (NIU): ");
        pacientetxt = new TextField();

        // Espaciado
        add(label1);
        add(new Label(" "));

        // Agregar los componentes al panel principal
        add(label5);
        add(nombreVacuna);
        add(label2);
        add(fechaVacuna);
        add(label3);
        add(horaVacuna);
        add(label4);
        add(pacientetxt);

        guardar = new JButton("Guardar datos");
        cancelar = new JButton("Cancelar");

        add(guardar);
        add(cancelar);

        guardar.addActionListener(this);
        cancelar.addActionListener(this);
    }

     @Override
    public void actionPerformed(ActionEvent e) {
        Object fuente = e.getSource();

        if (fuente == guardar) {
            if (validarCampos()) {
                // Los campos son válidos, procede a guardar la vacuna
                guardarVacuna();
                cerrarVentana();
                ventanaFactura();
            }
        } else if (fuente == cancelar) {
            cerrarVentana();
        }
    }

    private boolean validarCampos() {
        String nombre = nombreVacuna.getText();
        String fechaStr = fechaVacuna.getText();
        String horaStr = horaVacuna.getText();

        if (nombre.isEmpty() || fechaStr.isEmpty() || horaStr.isEmpty()) {
            mostrarMensajeError("Todos los campos son obligatorios.");
            return false;
        }

        // Validar la fecha
        try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            formatoFecha.setLenient(false);
            Date fecha = formatoFecha.parse(fechaStr);
            // Puedes almacenar la fecha en el objeto Vacuna si es necesario
        } catch (ParseException ex) {
            mostrarMensajeError("El formato de fecha ingresado es incorrecto (dd/MM/yyyy).");
            return false;
        }

        // Validar la hora (formato de 24 horas)
        try {
            SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm");
            formatoHora.setLenient(false);
            Date hora = formatoHora.parse(horaStr);
            // Puedes almacenar la hora en el objeto Vacuna si es necesario
        } catch (ParseException ex) {
            mostrarMensajeError("El formato de hora ingresado es incorrecto (HH:mm).");
            return false;
        }

        // Puedes agregar más validaciones aquí si es necesario.

        return true;
    }

    private void guardarVacuna() {
        if (validarCampos()) {
            // Convierte la fecha y la hora en tipos de datos adecuados
            String nombre = nombreVacuna.getText();
            String fechaStr = fechaVacuna.getText();
            String horaStr = horaVacuna.getText();

            // Parsea la fecha
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            Date fecha = null;

            try {
                fecha = formatoFecha.parse(fechaStr);
            } catch (ParseException ex) {
                mostrarMensajeError("Error al parsear la fecha.");
                return; // Sale de la función si la fecha no es válida
            }

            // Parsea la hora (LocalTime)
            LocalTime hora = LocalTime.parse(horaStr);

            // Crea una instancia de la clase Vacuna con los datos validados
            newVacuna = new Vacuna(paciente, nombre, fecha, hora);
            
            //agregamos el objeto vacuna en la base de datos
            baseDatos.setVacunas(newVacuna);            

            mostrarMensajeExito("Vacuna guardada con éxito.");
        }
    }

    private void mostrarMensajeExito(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }

    private void mostrarMensajeError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    public void cerrarVentana(){
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        frame.dispose();
    }
    
    public void ventanaFactura(){               
            windowFactura ventanaFactura = new windowFactura(baseDatos, paciente, cita, newVacuna);

            // Crear un JFrame para mostrar la ventana
            JFrame frame = new JFrame("Datos para la Cita");
            frame.addWindowListener(new MainWindowListenerSecundary()); // Ajusta la operación de cierre según tus necesidades
            frame.add(ventanaFactura); // Agrega la instancia de la ventana a la ventana principal
            frame.pack(); // Ajusta el tamaño del JFrame automáticamente
            frame.setVisible(true);
    }
}