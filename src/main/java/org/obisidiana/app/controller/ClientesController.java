package org.obisidiana.app.controller;

import org.obisidiana.app.entity.Clientes;
import org.obisidiana.app.service.ClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("cli")

public class ClientesController {
    @Autowired
    private ClientesService clientesService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping(value = "pages/clientes" ,method = RequestMethod.GET)
    public List<Clientes> allClientes(){
        return clientesService.findAllClientes();
    }

    @RequestMapping(value = "pages/nuevocliente" ,method = RequestMethod.POST)
    public ResponseEntity<?> guardar(@RequestBody Clientes clientes, BindingResult result) {

        Clientes savedCustomer = null;
        ResponseEntity response = null;
        try {

            List<Clientes> busca;

            if(clientes != null){

                busca = clientesService.findByEmail(clientes.getEmail());
                if(!busca.isEmpty()){

                    String hashPwd = passwordEncoder.encode(clientes.getPassword());
                    clientes.setPassword(hashPwd);
                    savedCustomer = clientesService.guardarCliente(clientes);

                    if (savedCustomer.getId() > 0) {
                        response = ResponseEntity
                                .status(HttpStatus.CREATED)
                                .body("Given user details are successfully registered");
                    }


                }


            }

        } catch (Exception ex) {
            response = ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An exception occured due to " + ex.getMessage());
        }
        return response;


    }


}
