package com.evaluacion.pruebatecnica.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tipo_cliente", schema = "public")
public class TipoCliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id_tipo_cliente;

    @Column
    private String des_tipoCliente;

    @Column
    private LocalDate fecha_registro;

    public TipoCliente(){}

    // Getters and setter

    public Integer getId_tipoCliente() {
        return id_tipo_cliente;
    }

    public void setId_tipoCliente(Integer id_tipoCliente) {
        this.id_tipo_cliente = id_tipoCliente;
    }

    public String getDes_tipoCliente() {
        return des_tipoCliente;
    }

    public void setDes_tipoCliente(String des_tipoCliente) {
        this.des_tipoCliente = des_tipoCliente;
    }

    public LocalDate getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(LocalDate fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    @Override
    public String toString() {
        return "TipoCliente{" +
                "id_tipoCliente=" + id_tipo_cliente +
                ", des_tipoCliente='" + des_tipoCliente + '\'' +
                ", fecha_registro=" + fecha_registro +
                '}';
    }
}
