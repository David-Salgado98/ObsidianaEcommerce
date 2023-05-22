package org.obisidiana.app.service;

import org.obisidiana.app.entity.Carrito;
import org.obisidiana.app.entity.Product;

import java.util.List;

public interface CarritoService {
    List<Carrito> getAllProductos(Long clienteId);
}
