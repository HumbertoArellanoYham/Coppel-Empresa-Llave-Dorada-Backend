package com.evaluacion.pruebatecnica.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "productos", schema = "public")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProducto;

    @Column(name = "des_Producto")
    private String des_Producto;

    @Column(name = "precio")
    private Double precio;

    @Column
    private Integer existencia;

    @Column
    private LocalDate fecha_registro;

    @Column
    private Integer id_categoria;

    public Producto(){};

    //Getters and setter

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getDes_Producto() {
        return des_Producto;
    }

    public void setDes_Producto(String des_Producto) {
        this.des_Producto = des_Producto;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getExistencia() {
        return existencia;
    }

    public void setExistencia(Integer existencia) {
        this.existencia = existencia;
    }

    public LocalDate getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(LocalDate fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public Integer getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(Integer id_categoria) {
        this.id_categoria = id_categoria;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "idProducto=" + idProducto +
                ", des_Producto='" + des_Producto + '\'' +
                ", precio=" + precio +
                ", existencia=" + existencia +
                ", fecha_registro=" + fecha_registro +
                ", id_categoria=" + id_categoria +
                '}';
    }
}
