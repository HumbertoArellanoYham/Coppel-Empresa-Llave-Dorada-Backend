package com.evaluacion.pruebatecnica.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "ventas", schema = "public")
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer idVenta;

    @Column
    private Integer id_cliente;

    @Column
    private Double total;

    @Column
    private LocalDate fecha_venta;

    public Venta(){}

    public Integer getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Integer idVenta) {
        this.idVenta = idVenta;
    }

    public Integer getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Integer id_cliente) {
        this.id_cliente = id_cliente;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public LocalDate getFecha_venta() {
        return fecha_venta;
    }

    public void setFecha_venta(LocalDate fecha_venta) {
        this.fecha_venta = fecha_venta;
    }

    @Override
    public String toString() {
        return "Venta{" +
                "idVenta=" + idVenta +
                ", id_cliente=" + id_cliente +
                ", total=" + total +
                '}';
    }
}
