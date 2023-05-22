package org.obisidiana.app.service;

import org.obisidiana.app.entity.Clientes;

import java.util.List;

public interface ClientesService {
    public List<Clientes> findAllClientes();

    public  List<Clientes> findByEmail(String email);

    public Clientes guardarCliente(Clientes clientes);

    public boolean existClientesByEmail(String email);

    public Clientes setCustomer(Clientes clientes);

    public Clientes getClienteById(Long clienteId);


}
