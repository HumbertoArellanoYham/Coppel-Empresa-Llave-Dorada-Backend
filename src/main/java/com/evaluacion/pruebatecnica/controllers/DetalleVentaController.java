package com.evaluacion.pruebatecnica.controllers;

import com.evaluacion.pruebatecnica.entities.DetalleVenta;
import com.evaluacion.pruebatecnica.repositories.DetalleVentaRepository;
import com.evaluacion.pruebatecnica.service.DetalleVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/detalleventa")
public class DetalleVentaController {
    @Autowired
    private DetalleVentaService detalleVentaService;

    @GetMapping("/all")
    public ResponseEntity<List<DetalleVenta>> allDetalleVentas(){
        List<DetalleVenta> allDetalles = detalleVentaService.findAll();

        return allDetalles.isEmpty()?  new ResponseEntity<>(HttpStatus.OK):
                new ResponseEntity<>(allDetalles, HttpStatus.OK);
    }

    @GetMapping("/{idventa}")
    public ResponseEntity<List<DetalleVenta>> allDetalleVentas(@PathVariable("idventa") Integer idventa){
        List<DetalleVenta> allDetallesByIdVenta = detalleVentaService.findDetallesByVentaId(idventa);

        return allDetallesByIdVenta.isEmpty() ? new ResponseEntity<>(HttpStatus.NO_CONTENT):
                new ResponseEntity<>(allDetallesByIdVenta, HttpStatus.OK);
    }
}
