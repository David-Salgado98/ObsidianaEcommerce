package org.obisidiana.app.controller;

import org.obisidiana.app.entity.Carrito;
import org.obisidiana.app.entity.Clientes;
import org.obisidiana.app.entity.Product;
import org.obisidiana.app.service.CarritoService;
import org.obisidiana.app.service.CarritoServiceImpl;
import org.obisidiana.app.service.ClientesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CarritoController {
    @Autowired
    CarritoServiceImpl carritoService;

    @Autowired
    ClientesServiceImpl clientesService;

    @GetMapping("/carrito{clienteId}")
    public List<Carrito> getCarritoProductos(@RequestParam Long clienteId){
        System.out.println(clienteId);
        return  carritoService.getAllProductos(clienteId);
    }

}
