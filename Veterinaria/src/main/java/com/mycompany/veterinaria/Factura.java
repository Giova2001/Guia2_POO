/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.veterinaria;

/**
 *
 * @author STL User
 */
public class Factura {
    private String idFactura;
    private double costoConsulta;
    private double costoMedicamentos;
    private Paciente paciente;
    
    public Factura(Paciente paciente, double costoMedicamentos){
        this.paciente = paciente;
        this.costoMedicamentos = costoMedicamentos;
        double costoTotal = calcularCostoCita(paciente);
        this.costoConsulta = costoTotal;
        this.idFactura = generarCodigoFactura(paciente, costoTotal);
    }

    /**
     * @return the idFactura
     */
    public String getIdFactura() {
        return idFactura;
    }

    /**
     * @param idFactura the idFactura to set
     */
    public void setIdFactura(String idFactura) {
        this.idFactura = idFactura;
    }

    /**
     * @return the costoConsulta
     */
    public double getCostoConsulta() {
        return costoConsulta;
    }

    /**
     * @param costoConsulta the costoConsulta to set
     */
    public void setCostoConsulta(double costoConsulta) {
        this.costoConsulta = costoConsulta;
    }

    /**
     * @return the costoMedicamentos
     */
    public double getCostoMedicamentos() {
        return costoMedicamentos;
    }

    /**
     * @param costoMedicamentos the costoMedicamentos to set
     */
    public void setCostoMedicamentos(double costoMedicamentos) {
        this.costoMedicamentos = costoMedicamentos;
    }
    
    public double calcularCostoCita(Paciente paciente) {
        double costo = 0.00;

        if (paciente.getEdad() < 2) {
            costo = 10.00;
        } else if (paciente.getEdad() < 7) {
            costo = 25.00;
        } else {
            costo = 35.00;
        }

        return (costo + getCostoMedicamentos());
    }
    
    public String generarCodigoFactura(Paciente paciente, double costoCita) {
        // Obtén el NIU del paciente
        String NIU = paciente.getNIU();

        // Combina el NIU del paciente y el número aleatorio para formar el código de factura
        String codigoFactura = " " + costoCita;

        return codigoFactura;
    }
    
    public void metodoPago(){
        //aqui el metodo de pago sin definir aun?
    }
}
