/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.veterinaria;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Paciente extends Dueño {
    private String nombrePaciente;
    private String categoriaPaciente;
    private String razaPaciente;
    private String tipoPelaje;
    private String sexo;
    private String NIU;
    private Date fechaNacimiento;
    private Date fechaRegistro;
    private int edad;
    private double peso;
    private double altura;

    public Paciente(String nombrePaciente, String sexo, String dui, String nombreDueño,
            String categoriaPaciente,String razaPaciente,
             String tipoPelaje, Date fechaNacimiento,
        int edad, double peso, double altura) {
        super(dui, nombreDueño);
        this.nombrePaciente = nombrePaciente;
        this.sexo = sexo;
        this.categoriaPaciente = categoriaPaciente;
        this.razaPaciente = razaPaciente;
        this.tipoPelaje = tipoPelaje;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaRegistro = new Date();
        this.edad = edad;
        this.peso = peso;
        this.altura = altura;
        String codigo = generarCodigoIdentificador( categoriaPaciente, razaPaciente, nombrePaciente,  fechaRegistro);
        this.NIU = codigo;
    }

    /**
     * @return the nombrePaciente
     */
    public String getNombrePaciente() {
        return nombrePaciente;
    }

    /**
     * @param nombrePaciente the nombrePaciente to set
     */
    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    /**
     * @return the categoriaPaciente
     */
    public String getCategoriaPaciente() {
        return categoriaPaciente;
    }

    /**
     * @param categoriaPaciente the categoriaPaciente to set
     */
    public void setCategoriaPaciente(String categoriaPaciente) {
        this.categoriaPaciente = categoriaPaciente;
    }

    /**
     * @return the razaPaciente
     */
    public String getRazaPaciente() {
        return razaPaciente;
    }

    /**
     * @param razaPaciente the razaPaciente to set
     */
    public void setRazaPaciente(String razaPaciente) {
        this.razaPaciente = razaPaciente;
    }

    /**
     * @return the tipoPelaje
     */
    public String getTipoPelaje() {
        return tipoPelaje;
    }

    /**
     * @param tipoPelaje the tipoPelaje to set
     */
    public void setTipoPelaje(String tipoPelaje) {
        this.tipoPelaje = tipoPelaje;
    }

    /**
     * @return the fechaNacimiento
     */
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * @param fechaNacimiento the fechaNacimiento to set
     */
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * @return the fechaRegistro
     */
    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    /**
     * @param fechaRegistro the fechaRegistro to set
     */
    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    /**
     * @return the edad
     */
    public int getEdad() {
        return edad;
    }

    /**
     * @param edad the edad to set
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * @return the peso
     */
    public double getPeso() {
        return peso;
    }

    /**
     * @param peso the peso to set
     */
    public void setPeso(double peso) {
        this.peso = peso;
    }

    /**
     * @return the altura
     */
    public double getAltura() {
        return altura;
    }

    /**
     * @param altura the altura to set
     */
    public void setAltura(double altura) {
        this.altura = altura;
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
        
    /**
     * @return the sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
    public String generarCodigoIdentificador(String categoriaPaciente, String razaPaciente, String nombrePaciente, Date fechaIngreso) {
        // Obtén el mes y el año a partir de la fecha de ingreso
        SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
        String mesAño = dateFormat.format(fechaIngreso);

        // Obtén la primera letra de cada variable y conviértelas a mayúsculas
        String primeraLetraCategoria = categoriaPaciente.substring(0, 1).toUpperCase();
        String primeraLetraRaza = razaPaciente.substring(0, 1).toUpperCase();
        String primeraLetraNombre = nombrePaciente.substring(0, 1).toUpperCase();

        // Combina todas las partes para formar el código identificador
        String codigoIdentificador = primeraLetraCategoria + primeraLetraRaza + primeraLetraNombre + mesAño;

        return codigoIdentificador;
    } 
}