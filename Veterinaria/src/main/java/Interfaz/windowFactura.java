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
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

/**
 *
 * @author STL User
 */
public class windowFactura extends JPanel implements ActionListener{
    private BaseDatos baseDatos;
    private Paciente paciente;
    private Cita cita;
    private Vacuna vacuna;

    private JLabel label1;
    private JTextArea facturaTxt;
    private JLabel label2;
    private JComboBox<String> metodoPago;
    private JButton pagar;
    
    
    public windowFactura(BaseDatos baseDatos, Paciente paciente, Cita cita, Vacuna vacuna){
        this.baseDatos = baseDatos;
        this.paciente = paciente;
        this.cita = cita;
        this.vacuna = vacuna;
        setLayout(new GridLayout(4, 2)); // Diseño de la ventana con 4 filas y 2 columnas

        label1 = new JLabel("Factura");
        label1.setFont(new Font("Arial", Font.BOLD, 18));
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        
        // Agregar el texto al componente facturaTxt
        facturaTxt = new JTextArea(); // Inicializar facturaTxt
        facturaTxt.setEditable(false);
        
        // Supongo que pacienteNiu es la variable que contiene el NIU
        double costoConsulta = 50.0; // Supongamos que el costo de la consulta es 50.0 (puedes cambiarlo según tus datos)
        double costoMedicamentos = 25.0; // Supongamos que el costo de los medicamentos es 25.0 (puedes cambiarlo)

        // Crear el texto de la factura
        String factura = "Factura\n";
        factura += "NIU del paciente: " + paciente.getNIU() + "\n";
        factura += "Costo de medicamentos: $" + costoMedicamentos + "\n";
        factura += "Costo de la consulta: $" + costoConsulta + "\n";

        
        JScrollPane facturaScrollPane = new JScrollPane(facturaTxt);
        facturaScrollPane.setPreferredSize(new Dimension(400, 200)); // Ajusta el tamaño del área de texto

        label2 = new JLabel("Seleccione el método de pago:");
        metodoPago = new JComboBox<>(new String[]{"Efectivo", "Tarjeta de crédito", "Cheque"});

        pagar = new JButton("Pagar");
        pagar.addActionListener(this);
        pagar.setFont(new Font("Arial", Font.PLAIN, 16));

        // Agregar los componentes al panel
        add(label1); // Fila 1, Columna 1
        add(new Label(" "));  // Fila 1, Columna 2
        
        add(facturaScrollPane);// Fila 2, Columna 1

        add(label2); // Fila 2, Columna 2

        metodoPago.setFont(new Font("Arial", Font.PLAIN, 16));
        add(metodoPago); // Espaciador, Fila 3, Columna 1

        add(new JLabel()); // Fila 3, Columna 2

        add(pagar); // Fila 4, Columna 1 
    
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object fuente = e.getSource();
        
        if (fuente == pagar) {
            boolean pagoExitoso = realizarPago();
            
            if (pagoExitoso) { 
                Factura newFactura = new Factura(paciente, 20);
                baseDatos.setFacturas(newFactura);
                
                mostrarMensajeExito("Pago realizado con éxito." + newFactura.getIdFactura());
                
                JFrame frame = new JFrame("Generar Expediente");
                // Crear automáticamente un nuevo expediente
                windowExpediente expedienteWindow = new windowExpediente(baseDatos, paciente, cita, newFactura, vacuna);
                
                // Agregar la ventana de expediente a un JFrame o a otro contenedor principal
                // Supongamos que tienes un JFrame llamado "frame" como contenedor principal
                frame.add(expedienteWindow);

                // Configurar el JFrame y mostrar la ventana
                frame.setSize(400, 300);  // Establece el tamaño adecuado
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Configura la operación de cierre
                frame.setVisible(true); 

                // Mostrar un mensaje de éxito
                
                //cerrar ventana
                frame = (JFrame) SwingUtilities.getWindowAncestor(this);
                frame.dispose();
            } else {
                mostrarMensajeError("El pago no se ha realizado correctamente.");
            }
        }
    }
    
    private boolean realizarPago() {
        //sin definir aun
        return true;
    }

    private void mostrarMensajeExito(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }

    private void mostrarMensajeError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
