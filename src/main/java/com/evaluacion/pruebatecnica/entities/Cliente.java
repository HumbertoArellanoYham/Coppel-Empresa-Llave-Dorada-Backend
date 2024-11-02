package com.evaluacion.pruebatecnica.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "clientes", schema = "public")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCliente;

    @Column
    private String nombre;

    @Column
    private String apellidoPaterno;

    @Column
    private String apellidoMaterno;

    @Column
    private LocalDate fecha_nacimiento;

    @Column
    private String domicilio;

    @Column
    private LocalDate fecha_registro;

    @Column
    private Integer id_tipoCliente;

    @Column
    private Double historial_cliente;

    public Cliente(){};

    // Getters and setter


    public Integer getId_cliente() {
        return idCliente;
    }

    public void setId_cliente(Integer id_cliente) {
        this.idCliente = id_cliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public LocalDate getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(LocalDate fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public Integer getId_tipoCliente() {
        return id_tipoCliente;
    }

    public void setId_tipoCliente(Integer id_tipoCliente) {
        this.id_tipoCliente = id_tipoCliente;
    }

    public Double getHistorial_cliente() {
        return historial_cliente;
    }

    public void setHistorial_cliente(Double historial_cliente) {
        this.historial_cliente = historial_cliente;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id_cliente=" + idCliente +
                ", nombre='" + nombre + '\'' +
                ", apellidoPaterno='" + apellidoPaterno + '\'' +
                ", apellidoMaterno='" + apellidoMaterno + '\'' +
                ", fecha_nacimiento=" + fecha_nacimiento +
                ", domicilio='" + domicilio + '\'' +
                ", fecha_registro=" + fecha_registro +
                ", id_tipoCliente=" + id_tipoCliente +
                ", historial_cliente=" + historial_cliente +
                '}';
    }
}
