/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaz;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author STL User
 */
public class MainWindowListenerSecundary extends WindowAdapter {
        public void windowClosingSecundary(WindowEvent e) {
        // Cierra solo la ventana secundaria
        e.getWindow().dispose();
    }
}
