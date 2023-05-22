package org.obisidiana.app.service;

import lombok.RequiredArgsConstructor;
import org.obisidiana.app.entity.Carrito;
import org.obisidiana.app.entity.Confirm;
import org.obisidiana.app.entity.Product;
import org.obisidiana.app.repository.CarritoRepository;
import org.obisidiana.app.repository.ConfirmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CarritoServiceImpl implements CarritoService {

    @Autowired
    CarritoRepository carritoRepository;

    @Autowired
    ConfirmRepository confirmRepository;

    @Override
    public List<Carrito> getAllProductos(Long clienteId) {
        System.out.println(clienteId);
        Confirm confirm = confirmRepository.findByClientesId(clienteId);
        return carritoRepository.findByCarritoId(confirm.getCarritoId());
    }
}
