package com.evaluacion.pruebatecnica.controllers;

import com.evaluacion.pruebatecnica.entities.Cliente;
import com.evaluacion.pruebatecnica.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> searchById(@PathVariable(name = "id") Integer id){
        Optional<Cliente> cliente = clienteService.findById(id);

        return cliente.map(clienteItem -> new ResponseEntity<>(clienteItem, HttpStatus.OK)).orElseGet(() ->
                new ResponseEntity<>(HttpStatus.NO_CONTENT)
        );
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Cliente>> clientsList(){
        List<Cliente> lista = clienteService.findAllClients();

        return lista.isEmpty()? new ResponseEntity<>(HttpStatus.NO_CONTENT):
                new ResponseEntity<>(lista, HttpStatus.OK);
    }

   /*
   * Guardará un cliente, pero solo si el cliente se encuentra esto se validará en el formulario
   * del lado del frontend para que se envie al cliente solo si no existe ningún error en los campos.
   *
   * @param recibe un @RequestBody cliente
   * @Return una entidad cliente si se guardó correctamente
   */
    @PostMapping("/savecliente")
    public ResponseEntity<Cliente> saveCliente(@RequestBody Cliente cliente){
        Cliente isSave = clienteService.saveCliente(cliente);

        return new ResponseEntity<>(isSave, HttpStatus.CREATED);
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<?> removeCliente(@PathVariable(name = "id") Integer id){
        clienteService.deleteClienteById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/remove")
    public ResponseEntity<?> removeCliente(@RequestBody Cliente cliente){
        clienteService.deleteCliente(cliente);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/update")
    public ResponseEntity<Cliente> updateCliente(@RequestBody Cliente cliente) {
        Cliente isUpdate = clienteService.updateClient(cliente);

        return new ResponseEntity<>(isUpdate, HttpStatus.ACCEPTED);
    }

}
