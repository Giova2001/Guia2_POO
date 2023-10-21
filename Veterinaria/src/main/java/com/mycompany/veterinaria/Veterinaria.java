/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.veterinaria;

import Interfaz.MenuPrincipal;

/**
 *
 * @author STL User
 */
public class Veterinaria {

    public static void main(String[] args) {
        BaseDatos baseDatos = new BaseDatos();
        MenuPrincipal MP = new MenuPrincipal(baseDatos);
        MP.setVisible(true);
    }
}
