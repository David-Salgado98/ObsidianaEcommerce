package org.obisidiana.app.service;

import org.obisidiana.app.entity.Clientes;
import org.obisidiana.app.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClientesServiceImpl implements ClientesService{

    @Autowired
    ClientesRepository clientesRepository;



    @Override
    public List<Clientes> findAllClientes() {
        return clientesRepository.findAll();
    }

    @Override
    public List<Clientes> findByEmail(String email) {
        return clientesRepository.findByEmail(email);
    }

    @Override
    public Clientes guardarCliente(Clientes clientes) {
        if ( existClientesByEmail(clientes.getEmail() ) )
            throw new IllegalStateException("The user already exists with email: " + clientes.getEmail());
        else if ( clientes.getEmail().length() > Clientes.FIELD_MAX_LENGTH )
            throw new IllegalStateException("Email length is greater than: " + Clientes.FIELD_MAX_LENGTH);

        //clientes.setId(0);

        return clientesRepository.save(clientes);
    }

    @Override
    public boolean existClientesByEmail(String email) {
        return clientesRepository.existsByEmail(email);
    }

    @Override
    public Clientes setCustomer(Clientes clientes) {
        if ( existClientesByEmail(clientes.getEmail() ) )
            throw new IllegalStateException("The user already exists with email: " + clientes.getEmail());
        else if ( clientes.getEmail().length() > Clientes.FIELD_MAX_LENGTH )
            throw new IllegalStateException("Email length is greater than: " + Clientes.FIELD_MAX_LENGTH);

        //clientes.setId(0);
        clientes.setPassword( clientes.getPassword());
        return clientesRepository.save(clientes);
    }

    @Override
    public Clientes getClienteById(Long clienteId) {
        return clientesRepository.getById(clienteId);
    }
}
