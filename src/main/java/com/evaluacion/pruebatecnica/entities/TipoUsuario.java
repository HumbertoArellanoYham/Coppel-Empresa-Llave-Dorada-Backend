package com.evaluacion.pruebatecnica.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tipos_usuarios", schema = "public")
public class TipoUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer idTipo_Usuario;

    @Column
    private String des_tipo_usuario;

    @Column
    private LocalDate fecha_registro;

    public TipoUsuario(){}

    // Getters and setters

    public Integer getIdTipo_Usuario() {
        return idTipo_Usuario;
    }

    public void setIdTipo_Usuario(Integer idTipo_Usuario) {
        this.idTipo_Usuario = idTipo_Usuario;
    }

    public String getDes_tipo_usuario() {
        return des_tipo_usuario;
    }

    public void setDes_tipo_usuario(String des_tipo_usuario) {
        this.des_tipo_usuario = des_tipo_usuario;
    }

    public LocalDate getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(LocalDate fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    @Override
    public String toString() {
        return "TipoUsuario{" +
                "idTipo_Usuario=" + idTipo_Usuario +
                ", des_tipo_usuario='" + des_tipo_usuario + '\'' +
                ", fecha_registro=" + fecha_registro +
                '}';
    }
}
