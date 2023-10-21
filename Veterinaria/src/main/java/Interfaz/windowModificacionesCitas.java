/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaz;

import com.mycompany.veterinaria.BaseDatos;
import com.mycompany.veterinaria.Cita;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Date;
import javax.swing.*;

public class windowModificacionesCitas extends JPanel implements ActionListener {
    private BaseDatos baseDatos;
    private Cita citaHecha;
    private Label label1;
    private JButton cambiarDia;
    private JButton cambiarHora;
    private JButton cambiarMotivoCita;
    private JButton guardarCambios;
    private JButton salir;

    public windowModificacionesCitas(BaseDatos baseDatos, Cita citaHecha) {
        this.baseDatos = baseDatos;
        this.citaHecha = citaHecha;
        setLayout(new GridLayout(6, 2)); // Diseño de la ventana

        label1 = new Label("Opciones de modificación");
        label1.setFont(new Font("Arial", Font.BOLD, 18));
        label1.setAlignment(Label.CENTER);

        cambiarDia = new JButton("Cambiar día de la cita (dd/MM/aaaa)");
        cambiarHora = new JButton("Cambiar hora (HH:mm:ss)");
        cambiarMotivoCita = new JButton("Cambiar motivo de la cita");
        guardarCambios = new JButton("Guardar cambios");
        salir = new JButton("Salir");

        add(label1);

        cambiarDia.addActionListener(this);
        add(cambiarDia);

        cambiarHora.addActionListener(this);
        add(cambiarHora);

        cambiarMotivoCita.addActionListener(this);
        add(cambiarMotivoCita);

        guardarCambios.addActionListener(this);
        guardarCambios.setFont(new Font("Arial", Font.PLAIN, 16));
        add(guardarCambios);

        salir.addActionListener(this);
        salir.setFont(new Font("Arial", Font.PLAIN, 16));
        add(salir);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object fuente = e.getSource();

        if (fuente == cambiarDia) {
            cambiarDia();
        } else if (fuente == cambiarHora) {
            cambiarHora();
        } else if (fuente == cambiarMotivoCita) {
            cambiarMotivo();
        } else if (fuente == guardarCambios) {
            guardarCambios();
            cerrarVentana();
        } else if (fuente == salir) {
            cerrarVentana();
        }
    }
    
    public void cambiarDia(){
        String nuevoDiaStr = JOptionPane.showInputDialog("Ingrese el nuevo día (dd/MM/yyyy):");
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date nuevoDia = dateFormat.parse(nuevoDiaStr);
            citaHecha.setDiaCita(nuevoDia);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un día válido en formato dd/MM/yyyy.");
        }
    }

    public void cambiarHora(){
        String nuevaHoraStr = JOptionPane.showInputDialog("Ingrese la nueva hora (HH:mm):");
        try {
            LocalTime nuevaHora = LocalTime.parse(nuevaHoraStr);
            // Realizar la acción de cambiar la hora usando 'nuevaHora'
            citaHecha.setHoraCita(nuevaHora);
        } catch (DateTimeParseException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese una hora válida en formato HH:mm:ss.");
        }
    }

    public void cambiarMotivo(){
        // Recopilar datos para cambiar el motivo de la cita
        String nuevoMotivo = JOptionPane.showInputDialog("Ingrese el nuevo motivo de la cita:");
        // Realizar validaciones
        if (nuevoMotivo != null && !nuevoMotivo.isEmpty()) {
            citaHecha.setMotivoCita(nuevoMotivo);
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un motivo válido.");
        }
    }
    
    public void guardarCambios(){
        JOptionPane.showMessageDialog(this, "¡Guardado exitoso!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        baseDatos.setCitas(citaHecha);
    }

    public void cerrarVentana(){
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        frame.dispose();
    }
}