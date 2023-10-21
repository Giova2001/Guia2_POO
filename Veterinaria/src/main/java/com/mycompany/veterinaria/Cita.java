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
public class Cita {
    private Date diaCita;
    private LocalTime horaCita;
    private String motivoCita;
    private String NIU;
    private String idCita;
    
    public Cita(String NIU, Date diaCita, LocalTime horaCita, String motivoCita){
        this.NIU = NIU;
        this.diaCita = diaCita;
        this.horaCita = horaCita;
        this.motivoCita = motivoCita;
        String codigoCita = generarCodigoCita(getNIU(), getDiaCita(), getHoraCita());
        this.idCita = codigoCita;
    }

    /**
     * @return the diaCita
     */
    public Date getDiaCita() {
        return diaCita;
    }

    /**
     * @param diaCita the diaCita to set
     */
    public void setDiaCita(Date diaCita) {
        this.diaCita = diaCita;
    }

    /**
     * @return the horaCita
     */
    public LocalTime getHoraCita() {
        return horaCita;
    }

    /**
     * @param horaCita the horaCita to set
     */
    public void setHoraCita(LocalTime horaCita) {
        this.horaCita = horaCita;
    }

    /**
     * @return the motivoCita
     */
    public String getMotivoCita() {
        return motivoCita;
    }

    /**
     * @param motivoCita the motivoCita to set
     */
    public void setMotivoCita(String motivoCita) {
        this.motivoCita = motivoCita;
    }

    /**
     * @return the NIU
     */
    public String getNIU() {
        return NIU;
    }

    /**
     * @param NIU the NIU to set
     */
    public void setNIU(String NIU) {
        this.NIU = NIU;
    }
    
    public void nuevoPaciente(){
        //llamar ventana para paciente
    }
    
    /**
     * @return the idCita
     */
    public String getIdCita() {
        return idCita;
    }

    /**
     * @param idCita the idCita to set
     */
    public void setIdCita(String idCita) {
        this.idCita = idCita;
    }
    
    public String generarCodigoCita(String NIU, Date fechaCita, LocalTime horaCita) {
        // Formatear la fecha de la cita en un formato específico
        SimpleDateFormat dateFormat = new SimpleDateFormat("ddMM");
        String fechaCitaFormateada = dateFormat.format(fechaCita);

        // Formatear la hora de la cita en un formato específico
        String horaCitaFormateada = horaCita.format(java.time.format.DateTimeFormatter.ofPattern("HHmm"));

        // Combina NIU, fecha y hora en un código de cita
        String codigoCita = fechaCitaFormateada + horaCitaFormateada;

        return codigoCita;
    }
}