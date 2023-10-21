/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaz;

import com.mycompany.veterinaria.Paciente;
import com.mycompany.veterinaria.BaseDatos;
import com.mycompany.veterinaria.Cita;
import com.mycompany.veterinaria.Expediente;
import com.mycompany.veterinaria.Factura;
import com.mycompany.veterinaria.Vacuna;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Window;
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
public class BotonesPrincipal extends JPanel implements ActionListener {
    private BaseDatos baseDatos;
    private JButton nuevoPaciente;
    private JButton seguimientoPaciente;
    private JButton agendarCita;
    private JButton buscarExpediente;
    private JButton salir;
    
    public BotonesPrincipal(BaseDatos baseDatos) {
        this.baseDatos = baseDatos;
        setLayout(new GridLayout(0, 1)); // 0 filas y 1 columna (tantas filas como sean necesarias)

        add(new Label("Gestión de Pacientes"));
        nuevoPaciente = new JButton("Nuevo Paciente");
        nuevoPaciente.addActionListener(this);
        add(nuevoPaciente);
        
        seguimientoPaciente = new JButton("Seguimiento Paciente");
        seguimientoPaciente.addActionListener(this);
        add(seguimientoPaciente);

        add(new Label("Gestión de Citas"));
        agendarCita = new JButton("Agendar Cita");
        agendarCita.addActionListener(this);
        add(agendarCita);

        buscarExpediente = new JButton("Buscar Expediente");
        buscarExpediente.addActionListener(this);
        add(buscarExpediente);

        salir = new JButton("Salir");
        salir.addActionListener(this);
        add(salir);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object fuente = e.getSource();
        
        if (fuente == nuevoPaciente) {
            nuevoPaciente();
            cerrarVentana();
        }else if (fuente == seguimientoPaciente){
            seguimientoPaciente();
            cerrarVentana();
        }else if (fuente == agendarCita){
            agendarCita();
            cerrarVentana();
        }else if (fuente == buscarExpediente) {
            buscarExpediente();
        }else if (fuente == salir) {
            cerrarVentana();
        }
    }
    
    public void nuevoPaciente(){
        // Crear un JFrame (ventana principal)
        JFrame frame = new JFrame("Datos del paciente");

        // Crear una instancia de la ventana windowNuevoPaciente
        windowNuevoPaciente nuevoPaciente = new windowNuevoPaciente(baseDatos);

        // Agregar la ventana al JFrame
        frame.add(nuevoPaciente);

        // Configurar el JFrame
        frame.addWindowListener(new MainWindowListenerSecundary());
        frame.setSize(400, 300);
        frame.setVisible(true);
    }
    
    public void seguimientoPaciente(){
        // Crear un JFrame (ventana Secundaria de segumiento paciente)
        JFrame frame = new JFrame("2. Seguimiento Paciente");

        // Crear una instancia de la ventana windowSeguimientoPaciente
        windowSeguimientoPaciente seguimientoPaciente = new windowSeguimientoPaciente(baseDatos);

        // Agregar la ventana al JFrame
        frame.add(seguimientoPaciente);

        // Configurar el JFrame
        frame.addWindowListener(new MainWindowListenerSecundary());
        frame.setSize(400, 300);
        frame.setVisible(true);
    }

    public void agendarCita(){
        // Crear un JFrame (ventana Secundaria)
            JFrame frame = new JFrame("Opciones para citas");

            // Crear una instancia de la ventana windowCitas
            windowCitas citas = new windowCitas(baseDatos);

            // Agregar la ventana al JFrame
            frame.add(citas);

            // Configurar el JFrame
            frame.addWindowListener(new MainWindowListenerSecundary());
            frame.setSize(400, 300);
            frame.setVisible(true);
    }

    public void buscarExpediente(){
        String niuInput = JOptionPane.showInputDialog(null, "Ingrese el NIU del paciente:");
        Paciente pacienteEncontrado = baseDatos.buscarPacientePorId(niuInput);

        if (pacienteEncontrado != null) {
            
            for(Expediente expediente: baseDatos.getExpedientes()){
                if (expediente.getPaciente() == pacienteEncontrado){
                    //Expediente expedienteEncontrado = baseDatos.buscarExpedientePorId(expediente.getIdExpediente());

                    StringBuilder mensaje = new StringBuilder("Datos del paciente:\n");
                    mensaje.append("Nombre: ").append(expediente.getPaciente().getNombrePaciente()).append("\n");
                    mensaje.append("Categoría: ").append(expediente.getPaciente().getCategoriaPaciente()).append("\n");

                    if (expediente.getCita() != null) {
                        Cita cita = expediente.getCita();
                        Vacuna vacuna = expediente.getVacuna();
                        mensaje.append("Día de la Cita: ").append(cita.getDiaCita()).append("\n");
                        mensaje.append("Motivo de Consulta: ").append(cita.getMotivoCita()).append("\n");
                        mensaje.append("Nombre de la Vacuna: ").append(vacuna.getNombreVacuna()).append("\n");
                    } else {
                        mensaje.append("Este paciente no tiene citas registradas.\n");
                    }

                    if (expediente.getFactura() != null) {
                        Factura factura = expediente.getFactura();
                        mensaje.append("Costo Total de la Consulta: $").append(factura.getCostoConsulta()).append("\n");
                        // Puedes agregar más detalles de la factura aquí si es necesario
                    } else {
                        mensaje.append("No hay información de factura para este paciente.\n");
                    }

                    JOptionPane.showMessageDialog(null, mensaje.toString(), "Datos del Paciente", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        // Si no se encuentra el paciente, muestra un mensaje de error
                        JOptionPane.showMessageDialog(null, "Paciente no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
                    }
            }
        } 
    }
    
    public void cerrarVentana(){
        // Cierra la ventana principal
        Window mainWindow = SwingUtilities.getWindowAncestor(this);
        if (mainWindow != null) {
            mainWindow.dispose();
        }
    }
}