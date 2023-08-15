/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1;

/**
 *
 * @author STL User
 */
class Mascota {
    private int edad;
    private double peso;
    private double altura;
    private String tipo;

    public Mascota() {
        // Constructor implícito
    }
    
    //setters
    public Mascota(int edad, double peso, double altura, String tipo) {
        this.edad = edad;
        this.peso = peso;
        this.altura = altura;
        this.tipo = tipo;
    }
    
    //getters
    public int getEdad() {
        return edad;
    }

    public double getPeso() {
        return peso;
    }

    public double getAltura() {
        return altura;
    }

    public String getTipo() {
        return tipo;
    }

    // imprimir en consola
    public void imprimirInformacionMascota() {
        System.out.println("Información de la mascota:");
        System.out.println("Tipo: " + tipo);
        System.out.println("Edad: " + edad);
        System.out.println("Peso: " + peso);
        System.out.println("Altura: " + altura);
    }
}