/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.veterinaria;

/**
 *
 * @author STL User
 */
public class Expediente {
    private String diagnostico;
    private String medicamentosRecetados;
    private String idExpediente;
    private Paciente paciente;
    private Cita cita;
    private Vacuna vacuna;
    private Factura factura;
    
    public Expediente(Paciente paciente, Cita cita, Vacuna vacuna,Factura factura,
            String Diagnostico, String medicamentosRecetados){
        this.paciente = paciente;
        this.cita = cita;
        this.vacuna = vacuna;
        this.factura = factura;
        this.diagnostico = Diagnostico;
        this.medicamentosRecetados = medicamentosRecetados;
        this.idExpediente = generarIdExpediente(paciente, cita, vacuna, factura);
    }

    /**
     * @return the diagnostico
     */
    public String getDiagnostico() {
        return diagnostico;
    }

    /**
     * @param diagnostico the diagnostico to set
     */
    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    /**
     * @return the medicamentosRecetados
     */
    public String getMedicamentosRecetados() {
        return medicamentosRecetados;
    }

    /**
     * @param medicamentosRecetados the medicamentosRecetados to set
     */
    public void setMedicamentosRecetados(String medicamentosRecetados) {
        this.medicamentosRecetados = medicamentosRecetados;
    }

    /**
     * @return the idExpediente
     */
    public String getIdExpediente() {
        return idExpediente;
    }

    /**
     * @param idExpediente the idExpediente to set
     */
    public void setIdExpediente(String idExpediente) {
        this.idExpediente = idExpediente;
    }
    
     public String generarIdExpediente(Paciente paciente, Cita cita, Vacuna vacuna, Factura factura) {
        // Obtiene los IDs de los objetos pasados como parámetros
        String idPaciente = paciente.getNIU();
        String idCita = cita.getIdCita();
        String idVacuna = vacuna.getIdVacuna();
        String idFactura = factura.getIdFactura();

        // Combina los IDs en una cadena
        String idExpediente = idPaciente + idCita + idVacuna + idFactura;

        return idExpediente;
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

    /**
     * @return the cita
     */
    public Cita getCita() {
        return cita;
    }

    /**
     * @param cita the cita to set
     */
    public void setCita(Cita cita) {
        this.cita = cita;
    }

    /**
     * @return the vacuna
     */
    public Vacuna getVacuna() {
        return vacuna;
    }

    /**
     * @param vacuna the vacuna to set
     */
    public void setVacuna(Vacuna vacuna) {
        this.vacuna = vacuna;
    }

    /**
     * @return the factura
     */
    public Factura getFactura() {
        return factura;
    }

    /**
     * @param factura the factura to set
     */
    public void setFactura(Factura factura) {
        this.factura = factura;
    }
     
     
}
