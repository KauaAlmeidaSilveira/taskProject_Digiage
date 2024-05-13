package com.digiage.projectTask4.controllers;

import com.digiage.projectTask4.dto.ClientDTO;
import com.digiage.projectTask4.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    // Retorna a lista completa de todos os clientes.
    @GetMapping
    public ResponseEntity<List<ClientDTO>> getClients() {
        return ResponseEntity.ok(clientService.getAllClients());
    }

    // Retorna quantidade total de clientes, clientes masculinos e femininos.
    @GetMapping("/clientMascAndFem")
    public ResponseEntity<String> getQntClientMascAndFem() {
        return ResponseEntity.ok(clientService.getQntClientMascAndFem());
    }

}
