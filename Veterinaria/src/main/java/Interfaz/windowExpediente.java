/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaz;

import com.mycompany.veterinaria.BaseDatos;
import com.mycompany.veterinaria.Cita;
import com.mycompany.veterinaria.Expediente;
import com.mycompany.veterinaria.Factura;
import com.mycompany.veterinaria.Paciente;
import com.mycompany.veterinaria.Vacuna;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

/**
 *
 * @author STL User
 */
public class windowExpediente extends JPanel implements ActionListener{
    private BaseDatos baseDatos;
    private Paciente paciente;
    private Cita cita;
    private Vacuna vacuna;
    private Factura factura;

    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private TextField diagnostico;
    private TextField medicamentos;
    private JButton generarExpediente;
    
    
    public windowExpediente(BaseDatos baseDatos,Paciente paciente, Cita cita, Factura factura, Vacuna vacuna){
        this.baseDatos = baseDatos;
        this.paciente = paciente;
        this.cita = cita;
        this.vacuna = vacuna;
        this.factura = factura;

        setLayout(new GridLayout(4, 2)); // Diseño de la ventana con 4 filas y 2 columnas

        label1 = new JLabel("Generando Expediente");
        label1.setFont(new Font("Arial", Font.BOLD, 18));
        label1.setHorizontalAlignment(SwingConstants.CENTER);

        label2 = new JLabel("Diagnóstico:");
        diagnostico = new TextField();

        label3 = new JLabel("Medicamentos Recetados:");
        medicamentos = new TextField();

        generarExpediente = new JButton("Generar Expediente");

        // Agregar los componentes al panel
        add(label1); // Fila 1, Columna 1

        add(new JLabel()); // Espaciador, Fila 1, Columna 2

        add(label2); // Fila 2, Columna 1
        add(diagnostico); // Fila 2, Columna 2

        add(label3); // Fila 3, Columna 1
        add(medicamentos); // Fila 3, Columna 2

        add(new JLabel()); // Espaciador, Fila 4, Columna 1
        add(generarExpediente); // Fila 4, Columna 2

        generarExpediente.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object fuente = e.getSource();
        if (fuente == generarExpediente) {
            Expediente newExpediente = new Expediente(paciente, cita, vacuna, factura, diagnostico.getText(), medicamentos.getText());
            
            //almacenar expediente en la base de datos
            baseDatos.setExpedientes(newExpediente);
            
            // Obtener el ID del expediente
            String idExpediente = newExpediente.getIdExpediente();

            // Mostrar un mensaje de éxito que incluya el ID del expediente
            mostrarMensajeExito("Expediente guardado con éxito. ID del expediente: " + idExpediente);
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
            frame.dispose();
        }
    }
    
    private void mostrarMensajeExito(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }
}
