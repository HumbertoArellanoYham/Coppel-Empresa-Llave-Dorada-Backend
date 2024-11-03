package com.evaluacion.pruebatecnica.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "detalle_ventas", schema = "public")
public class DetalleVenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer idDetalle_venta;

    @Column
    private Integer id_venta;

    @Column
    private Integer id_producto;

    @Column(name = "cantidad_producto")
    private Integer cantidad_producto;

    @Column
    private Double precio_unitario;

    @Column
    private LocalDate fecha_registro;

    public DetalleVenta() {
    }

    public Integer getIdDetalle_venta() {
        return idDetalle_venta;
    }

    public void setIdDetalle_venta(Integer idDetalle_venta) {
        this.idDetalle_venta = idDetalle_venta;
    }

    public Integer getId_venta() {
        return id_venta;
    }

    public void setId_venta(Integer id_venta) {
        this.id_venta = id_venta;
    }

    public Integer getId_producto() {
        return id_producto;
    }

    public void setId_producto(Integer id_producto) {
        this.id_producto = id_producto;
    }

    public Integer getCantidad_producto() {
        return cantidad_producto;
    }

    public void setCantidad_producto(Integer catidad_producto) {
        this.cantidad_producto = catidad_producto;
    }

    public Double getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(Double precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public LocalDate getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(LocalDate fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    @Override
    public String toString() {
        return "DetalleVenta{" +
                "idDetalle_venta=" + idDetalle_venta +
                ", id_venta=" + id_venta +
                ", id_producto=" + id_producto +
                ", catidad_producto=" + cantidad_producto +
                ", precio_unitario=" + precio_unitario +
                ", fecha_registro=" + fecha_registro +
                '}';
    }
}
