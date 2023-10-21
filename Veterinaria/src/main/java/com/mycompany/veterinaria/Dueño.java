/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.veterinaria;

/**
 *
 * @author STL User
 */
public class Dueño {
    public String DUI;
    public String nombreDueño;
    
    public Dueño(String dui, String nombre){
        this.DUI = dui;
        this.nombreDueño = nombre;
    } 

    /**
     * @return the DUI
     */
    public String getDUI() {
        return DUI;
    }

    /**
     * @param DUI the DUI to set
     */
    public void setDUI(String DUI) {
        this.DUI = DUI;
    }

    /**
     * @return the nombre
     */
    public String getNombreDueño() {
        return nombreDueño;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombreDueño(String nombre) {
        this.nombreDueño = nombre;
    }
}
