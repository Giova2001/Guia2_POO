/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author STL User
 */
class Expediente {
    private int numeroConsulta;
    private String diagnostico;
    private LocalDateTime fechaHoraConsulta;
    private String veterinario;

    public Expediente() {
        // Constructor implícito
    }
    //setters
    public Expediente(int numeroConsulta, String diagnostico, LocalDateTime fechaHoraConsulta, String veterinario) {
        this.numeroConsulta = numeroConsulta;
        this.diagnostico = diagnostico;
        this.fechaHoraConsulta = fechaHoraConsulta;
        this.veterinario = veterinario;
    }
    
    //getters
    public int getNumeroConsulta() {
        return numeroConsulta;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public LocalDateTime getFechaHoraConsulta() {
        return fechaHoraConsulta;
    }

    public String getVeterinario() {
        return veterinario;
    }

    // imprimir en consola
    public void imprimirInformacionCita() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm");
        //define un formato específico para formatear fechas y horas en un formato legible por humanos.
        // sin ese cambio de formato, la fecha y hora se mostrarian asi 2023-08-15T16:26:15.295054100
        System.out.println("Información de la cita:");
        System.out.println("Número de consulta: " + numeroConsulta);
        System.out.println("Diagnóstico: " + diagnostico);
        System.out.println("Fecha y Hora: " + fechaHoraConsulta.format(formato));
        System.out.println("Veterinario: " + veterinario);
    }

    public void calcularCostoCita(Mascota mascota) {
        double costo = 0.00;

        if (mascota.getEdad() < 2) {
            costo = 10.00;
        } else if (mascota.getEdad() < 7) {
            costo = 25.00;
        } else {
            costo = 35.00;
        }

        System.out.println("Costo de la cita: $" + costo);
    }
}