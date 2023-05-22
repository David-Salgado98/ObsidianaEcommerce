package org.obisidiana.app.controller;

import org.obisidiana.app.entity.Clientes;
import org.obisidiana.app.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoginController {

    @Autowired
    ClientesRepository clientesRepository;

    @RequestMapping("/user")
    public Clientes getUserDetailsAfterLogin(Authentication authentication) {
        List<Clientes> clientesLista = clientesRepository.findByEmail(authentication.getName());
        if (clientesLista.size() > 0) {
            return clientesLista.get(0);
        } else {
            return null;
        }
    }
}