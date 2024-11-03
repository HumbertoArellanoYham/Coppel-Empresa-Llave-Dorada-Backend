package com.evaluacion.pruebatecnica.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrdenDeVenta {
    private Venta venta;

    List<DetalleVenta> listItems;

    public OrdenDeVenta(){}

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public List<DetalleVenta> getListItems() {
        return listItems;
    }

    public void setListItems(List<DetalleVenta> listItems) {
        this.listItems = listItems;
    }
}
