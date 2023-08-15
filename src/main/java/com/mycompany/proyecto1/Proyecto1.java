/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyecto1;
import java.time.LocalDateTime;

/**
 *
 * @author STL User
 */
public class Proyecto1 {
    public static void main(String[] args) {          
        Mascota animal = new Mascota(7, 10.0, 20.0, "perico");
        Expediente datos = new Expediente(500, "Platica Mucho", LocalDateTime.now(), "Dr. Juancho");

        animal.imprimirInformacionMascota();
        datos.imprimirInformacionCita();
        datos.calcularCostoCita(animal);
    }
}