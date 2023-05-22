package org.obisidiana.app.repository;

import org.obisidiana.app.entity.Carrito;
import org.obisidiana.app.entity.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarritoRepository extends JpaRepository<Carrito,Long> {
    public List<Carrito> findByCarritoId(Long carritoId);
}
