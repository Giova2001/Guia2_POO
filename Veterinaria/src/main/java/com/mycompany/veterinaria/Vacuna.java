/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.veterinaria;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

/**
 *
 * @author STL User
 */
public class Vacuna {
    private String nombreVacuna;
    private String idVacuna;
    private Date fechaVacuna;
    private LocalTime horaVacuna;
    private Paciente paciente;
    
    public Vacuna(Paciente paciente, String nombreVacuna,
            Date fechaVacuna,LocalTime horaVacuna){
        this.paciente = paciente;
        this.nombreVacuna = nombreVacuna;
        this.fechaVacuna = fechaVacuna;
        this.horaVacuna = horaVacuna;
        this.idVacuna = generarCodigoVacuna();
    }

    /**
     * @return the nombreVacuna
     */
    public String getNombreVacuna() {
        return nombreVacuna;
    }

    /**
     * @param nombreVacuna the nombreVacuna to set
     */
    public void setNombreVacuna(String nombreVacuna) {
        this.nombreVacuna = nombreVacuna;
    }

    /**
     * @return the idVacuna
     */
    public String getIdVacuna() {
        return idVacuna;
    }

    /**
     * @param idVacuna the idVacuna to set
     */
    public void setIdVacuna(String idVacuna) {
        this.idVacuna = idVacuna;
    }

    /**
     * @return the fechaVacuna
     */
    public Date getFechaVacuna() {
        return fechaVacuna;
    }

    /**
     * @param fechaVacuna the fechaVacuna to set
     */
    public void setFechaVacuna(Date fechaVacuna) {
        this.fechaVacuna = fechaVacuna;
    }

    /**
     * @return the horaVacuna
     */
    public LocalTime getHoraVacuna() {
        return horaVacuna;
    }

    /**
     * @param horaVacuna the horaVacuna to set
     */
    public void setHoraVacuna(LocalTime horaVacuna) {
        this.horaVacuna = horaVacuna;
    }

    /**
     * @return the paciente
     */
    public Paciente getPaciente() {
        return paciente;
    }

    /**
     * @param paciente the paciente to set
     */
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    
    public String generarCodigoVacuna() {

        // Obtén la primera letra del nombre de la vacuna
        String primeraLetraNombreVacuna = nombreVacuna.substring(0, 1);

        // Formatea la fecha en el formato día/mes/año
        SimpleDateFormat dateFormat = new SimpleDateFormat("ddMM");
        String fechaFormateada = dateFormat.format(getFechaVacuna());

        // Combina el NIU, la primera letra del nombre de la vacuna y la fecha formateada
        String codigoVacuna = primeraLetraNombreVacuna + fechaFormateada;

        return codigoVacuna;
    }
}