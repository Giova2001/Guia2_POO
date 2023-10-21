/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaz;

import com.mycompany.veterinaria.BaseDatos;
import com.mycompany.veterinaria.Paciente; // Importa la clase Paciente
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class windowNuevoPaciente extends JPanel implements ActionListener {
    private Label label1;
    private JLabel nombreLabel;
    private JTextField nombreTextField;
    private JLabel edadLabel;
    private JTextField edadTextField;
    private JLabel categoriaLabel;
    private JTextField categoriaTextField;
    private JLabel razaLabel;
    private JTextField razaTextField;
    private JLabel sexoLabel;
    private JTextField sexoTextField;
    private JLabel pelajeLabel;
    private JTextField pelajeTextField;
    private JLabel pesoLabel;
    private JTextField pesoTextField;
    private JLabel alturaLabel;
    private JTextField alturaTextField;
    private JLabel fechaNacimientoLabel;
    private JTextField fechaNacimientoTextField;
    
    private JLabel nombreDueño;
    private JTextField nombreDueñoText;
    private JLabel DUI;
    private JTextField Duid;
    
    private JButton guardar;
    private JButton salir;
    private BaseDatos baseDatos;

    public windowNuevoPaciente(BaseDatos baseDatos) {
        this.baseDatos = baseDatos;
        
        setLayout(new GridLayout(13, 2)); // Diseño de la ventana

        label1 = new Label("Ingrese los datos del nuevo paciente");
        nombreLabel = new JLabel("Nombre:");
        nombreTextField = new JTextField(20);
        edadLabel = new JLabel("Edad:");
        edadTextField = new JTextField(3);
        categoriaLabel = new JLabel("Categoría:");
        categoriaTextField = new JTextField(10);
        razaLabel = new JLabel("Raza:");
        razaTextField = new JTextField(15);
        sexoLabel = new JLabel("Sexo (M/F): ");
        sexoTextField = new JTextField(1);
        pelajeLabel = new JLabel("Pelaje:");
        pelajeTextField = new JTextField(15);
        pesoLabel = new JLabel("Peso (Kg):");
        pesoTextField = new JTextField(5);
        alturaLabel = new JLabel("Altura (metros): ");
        alturaTextField = new JTextField(5);
        fechaNacimientoLabel = new JLabel("Fecha de Nacimiento (dd/MM/yyyy):");
        fechaNacimientoTextField = new JTextField(10);
        nombreDueño = new JLabel("nombre del dueño");
        nombreDueñoText = new JTextField(30);
        DUI = new JLabel("DUI del dueño sin -");
        Duid = new JTextField(9);
        
        guardar = new JButton("Registrar Nuevo paciente");
        salir = new JButton("Regresar al menú principal");

        add(label1);
        add(new JLabel());
        add(nombreLabel);
        add(nombreTextField);
        add(edadLabel);
        add(edadTextField);
        add(categoriaLabel);
        add(categoriaTextField);
        add(razaLabel);
        add(razaTextField);
        add(sexoLabel);
        add(sexoTextField);
        add(pelajeLabel);
        add(pelajeTextField);
        add(pesoLabel);
        add(pesoTextField);
        add(alturaLabel);
        add(alturaTextField);
        add(fechaNacimientoLabel);
        add(fechaNacimientoTextField);
        add(nombreDueño);
        add(nombreDueñoText);
        add(DUI);
        add(Duid);
        add(guardar);
        add(salir);

        guardar.addActionListener(this);
        salir.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object fuente = e.getSource();

        if (fuente == guardar) {
            if (validarCampos()) {
                // Obtener los datos ingresados por el usuario
                String nombre = nombreTextField.getText();
                int edad = Integer.parseInt(edadTextField.getText());
                String categoria = categoriaTextField.getText();
                String raza = razaTextField.getText();
                String sexo = sexoTextField.getText();
                String pelaje = pelajeTextField.getText();
                double peso = Double.parseDouble(pesoTextField.getText());
                double altura = Double.parseDouble(alturaTextField.getText());
                String fechaNacimientoStr = fechaNacimientoTextField.getText();
                String nombreDueno = nombreDueño.getText();
                String duiDueno = Duid.getText();

                // Parsear la fecha de nacimiento
                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                formato.setLenient(false);
                Date fechaNacimiento;
                try {
                    fechaNacimiento = formato.parse(fechaNacimientoStr);
                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(this, "El formato de fecha ingresado es incorrecto.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Crear un nuevo objeto Paciente con los datos ingresados
                Paciente nuevoPaciente = new Paciente(nombre, sexo, duiDueno, nombreDueno, categoria, raza, pelaje, fechaNacimiento, edad, peso, altura);


                // Agregar el nuevo paciente a la base de datos
                baseDatos.setPacientes(nuevoPaciente);

                // Mostrar un mensaje de confirmación
                JOptionPane.showMessageDialog(this, "Nuevo paciente registrado con éxito. \n su NIU es: " + nuevoPaciente.getNIU(), "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                // Mostrar un mensaje de error si faltan campos o hay datos incorrectos
                JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos correctamente.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (fuente == salir) {
            MenuPrincipal MP = new MenuPrincipal(baseDatos);
            MP.setVisible(true);
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
            frame.dispose();
        }
    }

    private boolean validarCampos() {
        // Validar que todos los campos estén completos y tengan el formato adecuado
        if (nombreTextField.getText().isEmpty() ||
            edadTextField.getText().isEmpty() ||
            categoriaTextField.getText().isEmpty() ||
            razaTextField.getText().isEmpty() ||
            sexoTextField.getText().isEmpty() ||
            pelajeTextField.getText().isEmpty() ||
            pesoTextField.getText().isEmpty() ||
            alturaTextField.getText().isEmpty() ||
            fechaNacimientoTextField.getText().isEmpty() ||
            nombreDueño.getText().isEmpty()||
            Duid.getText().isEmpty()) {
            return false; // Al menos un campo está vacío
        }else{
            String sexo = sexoTextField.getText();
            String dui = Duid.getText();

            if (!(sexo.equals("F") || sexo.equals("M")) || dui.length() != 9) {
                // El sexo no es "F" o "M", o la longitud del DUI no es 9
                return false;
            }
        }
        try {
            Integer.parseInt(edadTextField.getText());
            Double.parseDouble(pesoTextField.getText());
            Double.parseDouble(alturaTextField.getText());
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            formato.setLenient(false);
            formato.parse(fechaNacimientoTextField.getText());
        } catch (NumberFormatException | ParseException ex) {
            return false; // Los datos tienen un formato incorrecto
        }
        return true; // Todos los campos están completos y tienen el formato correcto
    }
}
