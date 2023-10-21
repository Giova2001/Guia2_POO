package Interfaz;

import Interfaz.MainWindowListenerSecundary;
import com.mycompany.veterinaria.Paciente;
import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class windowModificarPaciente extends JPanel implements ActionListener {
    private Paciente paciente;
    private Label label1;
    private JButton[] buttons;
    private JButton GuardarCambios;
    private JButton Cancelar;

    public windowModificarPaciente(Paciente paciente) {
        this.paciente = paciente;
        setLayout(new GridLayout(0, 1)); // Diseño de la ventana

        label1 = new Label("Modificar Paciente");
        label1.setFont(new Font("Arial", Font.BOLD, 18));
        label1.setAlignment(Label.CENTER);

        buttons = new JButton[] {
            new JButton("Modificar Nombre"),
            new JButton("Modificar Edad"),
            new JButton("Modificar Categoría"),
            new JButton("Modificar Raza"),
            new JButton("Modificar Sexo"),
            new JButton("Modificar Altura"),
            new JButton("Modificar Peso"),
            new JButton("Modificar Pelaje"),
            new JButton("Modificar Fecha de Nacimiento")
        };
        
        GuardarCambios = new JButton("Guardar Cambios");
        Cancelar = new JButton("Cancelar");

        add(label1);

        for (JButton button : buttons) {
            button.addActionListener(this);
            button.setFont(new Font("Arial", Font.PLAIN, 16));
            add(button);
        }

        GuardarCambios.addActionListener(this);
        GuardarCambios.setFont(new Font("Arial", Font.PLAIN, 16));
        add(GuardarCambios);

        Cancelar.addActionListener(this);
        Cancelar.setFont(new Font("Arial", Font.PLAIN, 16));
        add(Cancelar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < buttons.length; i++) {
            if (e.getSource() == buttons[i]) {
                handleModification(i);
                return;
            }
        }

        if (e.getSource() == GuardarCambios) {
            saveChanges();
            cerrarVentana();
        } else if (e.getSource() == Cancelar) {
            cerrarVentana();
        }
    }

    private void handleModification(int index) {
        String[] prompts = {
            "Ingresa el nuevo nombre:",
            "Ingresa el nuevo nombre:",
            "Ingresa la nueva categoría del paciente:",
            "Ingresa la nueva raza del paciente:",
            "Ingresa el sexo del paciente:",
            "Ingresa la nueva altura:",
            "Ingresa el nuevo peso:",
            "Ingresa el pelaje del paciente:",
            "Ingresa la nueva fecha de nacimiento:"
        };
        String inputValue = JOptionPane.showInputDialog(prompts[index]);

        if (inputValue == null || inputValue.isEmpty()) {
            showErrorMessage("No se ingresó ningún dato.");
            return;
        }

        switch (index) {
            case 1: // Modificar Nombre
                // Actualizar el nombre del paciente
                paciente.setNombrePaciente(inputValue);
                break;
            case 2: // Modificar Edad
                try {
                    int newEdad = Integer.parseInt(inputValue);
                    paciente.setEdad(newEdad);
                } catch (NumberFormatException ex) {
                    showErrorMessage("El valor ingresado no es un número válido.");
                }
                break;
            case 3: // Modificar Categoría
                // Actualizar la categoría del paciente
                paciente.setCategoriaPaciente(inputValue);
                break;
            case 4: // Modificar Raza
                // Actualizar la raza del paciente
                paciente.setRazaPaciente(inputValue);
                break;
            case 5: // Modificar Sexo
                // Actualizar el sexo del paciente
                paciente.setSexo(inputValue);
                break;
            case 6: // Modificar Altura
                try {
                    double newAltura = Double.parseDouble(inputValue);
                    paciente.setAltura(newAltura);
                } catch (NumberFormatException ex) {
                    showErrorMessage("El valor ingresado no es un número válido.");
                }
                break;
            case 7: // Modificar Peso
                try {
                    double newPeso = Double.parseDouble(inputValue);
                    paciente.setPeso(newPeso);
                } catch (NumberFormatException ex) {
                    showErrorMessage("El valor ingresado no es un número válido.");
                }
                break;
            case 8: // Modificar Pelaje
                // Actualizar el pelaje del paciente
                paciente.setTipoPelaje(inputValue);
                break;
            case 9: // Modificar Fecha de Nacimiento
                try {
                    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                    formato.setLenient(false); // No permitir fechas inválidas
                    Date fechaNacimiento = formato.parse(inputValue);
                    paciente.setFechaNacimiento(fechaNacimiento);
                } catch (ParseException ex) {
                    showErrorMessage("El formato de fecha ingresado es incorrecto.");
                }
                break;
        }

    }

    private void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    private void saveChanges() {
        JOptionPane.showMessageDialog(null, "Datos guardados.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }

    public void cerrarVentana(){
        // Cierra la ventana principal
        Window mainWindow = SwingUtilities.getWindowAncestor(this);
        if (mainWindow != null) {
            mainWindow.dispose();
        }
    }
}
