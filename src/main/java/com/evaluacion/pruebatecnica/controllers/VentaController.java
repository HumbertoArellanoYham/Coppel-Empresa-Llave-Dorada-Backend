package com.evaluacion.pruebatecnica.controllers;

import com.evaluacion.pruebatecnica.entities.*;
import com.evaluacion.pruebatecnica.repositories.DetalleVentaRepository;
import com.evaluacion.pruebatecnica.service.ClienteService;
import com.evaluacion.pruebatecnica.service.ProductoServiceImpl;
import com.evaluacion.pruebatecnica.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/venta")
public class VentaController {

    @Autowired
    private VentaService ventaService;

    @Autowired
    private DetalleVentaRepository detalleVentaRepository;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ProductoServiceImpl productoService;

    @PostMapping("/crear")
    public ResponseEntity<?> saveVenta(@RequestBody OrdenDeVenta ordenDeVenta) {
        Venta ventaNueva = new Venta();
        ventaNueva.setId_cliente(ordenDeVenta.getVenta().getId_cliente());
        ventaNueva.setTotal(ordenDeVenta.getVenta().getTotal());
        ventaNueva.setFecha_venta(ordenDeVenta.getVenta().getFecha_venta());

        Venta ventaGuardada = ventaService.saveVentaReady(ventaNueva);
        List<DetalleVenta> listaDeDetalles = ordenDeVenta.getListItems();

        boolean haySuficienteExistencia = true;

        // Validar existencia y guardar cada detalle
        for (DetalleVenta item : listaDeDetalles) {
            item.setId_venta(ventaGuardada.getIdVenta()); // Establecer el ID de la venta

            Optional<Producto> productoOpt = productoService.findById(item.getId_producto());

            // Validar existencia
            if (productoOpt.isPresent()) {
                Producto producto = productoOpt.get();
                if (producto.getExistencia() >= item.getCantidad_producto()) {
                    // Reducir existencia y actualizar el producto
                    producto.setExistencia(producto.getExistencia() - item.getCantidad_producto());
                    productoService.updateProduct(producto);

                    detalleVentaRepository.save(item);
                } else {
                    haySuficienteExistencia = false;
                    break;
                }
            } else {
                haySuficienteExistencia = false;
                break;
            }
        }

        if (!haySuficienteExistencia) {
            // Eliminar la venta si no hay suficiente inventario
            detalleVentaRepository.deleteById(ventaGuardada.getIdVenta());
            ventaService.deleteVenta(ventaGuardada.getIdVenta());
            return new ResponseEntity<>("No hay suficiente inventario para completar la venta", HttpStatus.BAD_REQUEST);
        }

        // Actualizar historial del cliente
        Optional<Cliente> clienteUpdateHistorial = clienteService.findById(ordenDeVenta.getVenta().getId_cliente());
        if (clienteUpdateHistorial.isPresent()) {
            Cliente cliente = getCliente(ordenDeVenta, clienteUpdateHistorial);

            clienteService.updateClient(cliente);
        }

        return new ResponseEntity<>(ventaGuardada, HttpStatus.CREATED);
    }

    private static Cliente getCliente(OrdenDeVenta ordenDeVenta, Optional<Cliente> clienteUpdateHistorial) {
        Cliente cliente = clienteUpdateHistorial.get();
        double nuevoHistorial = cliente.getHistorial_cliente() + ordenDeVenta.getVenta().getTotal();
        cliente.setHistorial_cliente(nuevoHistorial);

        // Actualizar el tipo de cliente según el historial
        if (nuevoHistorial > 50000.0 && nuevoHistorial < 150000.0) {
            cliente.setId_tipoCliente(2);
        } else if (nuevoHistorial >= 150000.0) {
            cliente.setId_tipoCliente(3);
        }
        return cliente;
    }

    @GetMapping("/ventastodas")
    private ResponseEntity<List<Venta>> allVentas(){
        List<Venta> listVentas = ventaService.findAllVentas();

        return listVentas.isEmpty()? new ResponseEntity<>(HttpStatus.NO_CONTENT):
                new ResponseEntity<>(listVentas, HttpStatus.OK);
    }

    @GetMapping("/fecha/{fecha}")
    public ResponseEntity<List<Venta>> allVentasByDate(@PathVariable(name = "fecha") String fecha) {
        try {
            LocalDate fechaVenta = LocalDate.parse(fecha);
            List<Venta> listVentas = ventaService.getByFecha(fechaVenta);

            return listVentas.isEmpty()
                    ? ResponseEntity.noContent().build()
                    : ResponseEntity.ok(listVentas);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Venta> ventasById(@PathVariable Integer id) {
        Optional<Venta> ventaId = ventaService.findVentaById(id);

        return ventaId.map(venta -> new ResponseEntity<>(venta, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.OK));
    }
}
