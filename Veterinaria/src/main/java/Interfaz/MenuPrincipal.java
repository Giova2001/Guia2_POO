/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaz;

import com.mycompany.veterinaria.BaseDatos;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author STL User
 */
public class MenuPrincipal extends Frame implements ActionListener {
    private Label label;
    //conectando a la base de datos
    private BaseDatos baseDatos;

    public MenuPrincipal(BaseDatos baseDatos) {
        this.baseDatos = baseDatos;
        setTitle("Veterinaria Vet-Pet");
        setSize(400, 300);
        setLayout(new GridLayout(2, 1)); // 2 filas y 1 columna

        label = new Label("MENU PRINCIPAL");
        label.setFont(new Font("Arial", Font.BOLD, 18));
        label.setAlignment(Label.CENTER);

        BotonesPrincipal botonesPanel = new BotonesPrincipal(baseDatos);
        add(botonesPanel);

        add(label);
        add(botonesPanel);

        addWindowListener(new MainWindowListener());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}