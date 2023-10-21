package com.mycompany.veterinaria;

import java.util.ArrayList;

public class BaseDatos {
    private ArrayList<Paciente> Pacientes;
    private ArrayList<Dueño> Dueños;
    private ArrayList<Cita> Citas;
    private ArrayList<Vacuna> Vacunas;
    private ArrayList<Factura> Facturas;
    private ArrayList<Expediente> Expedientes;

    public BaseDatos() {
        Pacientes = new ArrayList<>();
        Dueños = new ArrayList<>();
        Citas = new ArrayList<>();
        Vacunas = new ArrayList<>();
        Facturas = new ArrayList<>();
        Expedientes = new ArrayList<>();
    }

    public ArrayList<Paciente> getPacientes() {
        return Pacientes;
    }

    public void setPacientes(Paciente paciente) {
        Pacientes.add(paciente);
    }

    public ArrayList<Dueño> getDueños() {
        return Dueños;
    }

    public void setDuenos(Dueño dueño) {
        Dueños.add(dueño);
    }

    public ArrayList<Cita> getCitas() {
        return Citas;
    }

    public void setCitas(Cita cita) {
        Citas.add(cita);
    }

    public ArrayList<Vacuna> getVacunas() {
        return Vacunas;
    }

    public void setVacunas(Vacuna vacuna) {
        Vacunas.add(vacuna);
    }

    public ArrayList<Factura> getFacturas() {
        return Facturas;
    }

    public void setFacturas(Factura factura) {
        Facturas.add(factura);
    }

    public ArrayList<Expediente> getExpedientes() {
        return Expedientes;
    }

    public void setExpedientes(Expediente expediente) {
        Expedientes.add(expediente);
    }
    
    //*****************************************************************
    
   public Paciente buscarPacientePorId(String idPaciente) {
        for (Paciente paciente : Pacientes) {
            if (paciente.getNIU().equals(idPaciente)) {
                return paciente;
            }
        }
        return null; // Si no se encuentra un paciente con el ID especificado
    }

    public boolean eliminarPacientePorId(String idPaciente) {
        Paciente paciente = buscarPacientePorId(idPaciente);
        if (paciente != null) {
            Pacientes.remove(paciente);
            return true; // Objeto encontrado y eliminado
        }
        return false; // Objeto no encontrado
    }
    
    public Dueño buscarDuenoPorId(String idDueno) {
        for (Dueño dueño : Dueños) {
            if (dueño.getDUI().equals(idDueno)) {
                return dueño;
            }
        }
        return null; // Si no se encuentra un dueño con el ID especificado
    }

    public boolean eliminarDuenoPorId(String idDueno) {
        Dueño dueno = buscarDuenoPorId(idDueno);
        if (dueno != null) {
            Dueños.remove(dueno);
            return true; // Objeto encontrado y eliminado
        }
        return false; // Objeto no encontrado
    }
    
    public Cita buscarCitaPorId(String idCita) {
        for (Cita cita : Citas) {
            if (cita.getIdCita().equals(idCita)) {
                return cita;
            }
        }
        return null; // Si no se encuentra una cita con el ID especificado
    }

    public boolean eliminarCitaPorId(String idCita) {
        Cita cita = buscarCitaPorId(idCita);
        if (cita != null) {
            Citas.remove(cita);
            return true; // Objeto encontrado y eliminado
        }
        return false; // Objeto no encontrado
    }
    
    public Vacuna buscarVacunaPorId(String idVacuna) {
        for (Vacuna vacuna : Vacunas) {
            if (vacuna.getIdVacuna().equals(idVacuna)) {
                return vacuna;
            }
        }
        return null; // Si no se encuentra una vacuna con el ID especificado
    }

    public boolean eliminarVacunaPorId(String idVacuna) {
        Vacuna vacuna = buscarVacunaPorId(idVacuna);
        if (vacuna != null) {
            Vacunas.remove(vacuna);
            return true; // Objeto encontrado y eliminado
        }
        return false; // Objeto no encontrado
    }
    
    public Factura buscarFacturaPorId(String idFactura) {
        for (Factura factura : Facturas) {
            if (factura.getIdFactura().equals(idFactura)) {
                return factura;
            }
        }
        return null; // Si no se encuentra una factura con el ID especificado
    }

    public boolean eliminarFacturaPorId(String idFactura) {
        Factura factura = buscarFacturaPorId(idFactura);
        if (factura != null) {
            Facturas.remove(factura);
            return true; // Objeto encontrado y eliminado
        }
        return false; // Objeto no encontrado
    }
    
    public Expediente buscarExpedientePorId(String idExpediente) {
        for (Expediente expediente : Expedientes) {
            if (expediente.getIdExpediente().equals(idExpediente)) {
                return expediente;
            }
        }
        return null; // Si no se encuentra un expediente con el ID especificado
    }

    public boolean eliminarExpedientePorId(String idExpediente) {
        Expediente expediente = buscarExpedientePorId(idExpediente);
        if (expediente != null) {
            Expedientes.remove(expediente);
            return true; // Objeto encontrado y eliminado
        }
        return false; // Objeto no encontrado
    }
    
    //*******************************************************************************
    public void modificarPaciente(String idPaciente, Paciente nuevoPaciente) {
        for (int i = 0; i < Pacientes.size(); i++) {
            Paciente paciente = Pacientes.get(i);
            if (paciente.getNIU().equals(idPaciente)) {
                Pacientes.set(i, nuevoPaciente);
                break; // Terminar la búsqueda una vez que se encuentre el paciente
            }
        }
    }
    
    public void modificarDueno(String idDueno, Dueño nuevoDueno) {
        for (int i = 0; i < Dueños.size(); i++) {
            Dueño dueño = Dueños.get(i);
            if (dueño.getDUI().equals(idDueno)) {
                Dueños.set(i, nuevoDueno);
                break;
            }
        }
    }
    
    public void modificarCita(String idCita, Cita nuevaCita) {
        for (int i = 0; i < Citas.size(); i++) {
            Cita cita = Citas.get(i);
            if (cita.getIdCita().equals(idCita)) {
                Citas.set(i, nuevaCita);
                break;
            }
        }  
    }
    
    public void modificarVacuna(String idVacuna, Vacuna nuevaVacuna) {
        for (int i = 0; i < Vacunas.size(); i++) {
            Vacuna vacuna = Vacunas.get(i);
            if (vacuna.getIdVacuna().equals(idVacuna)) {
                Vacunas.set(i, nuevaVacuna);
                break;
            }
        }
    }
    
    public void modificarFactura(String idFactura, Factura nuevaFactura) {
        for (int i = 0; i < Facturas.size(); i++) {
            Factura factura = Facturas.get(i);
            if (factura.getIdFactura().equals(idFactura)) {
                Facturas.set(i, nuevaFactura);
                break;
            }
        }
    }
    
    public void modificarExpediente(String idExpediente, Expediente nuevoExpediente) {
        for (int i = 0; i < Expedientes.size(); i++) {
            Expediente expediente = Expedientes.get(i);
            if (expediente.getIdExpediente().equals(idExpediente)) {
                Expedientes.set(i, nuevoExpediente);
                break;
            }
        }
    }
}