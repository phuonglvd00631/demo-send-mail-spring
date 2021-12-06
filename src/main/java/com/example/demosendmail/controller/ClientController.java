package com.example.demosendmail.controller;

import com.example.demosendmail.dto.ClientSdi;
import com.example.demosendmail.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @PostMapping("/create")
    public ResponseEntity<Boolean> create (@RequestBody ClientSdi clientSdi){
        return ResponseEntity.ok(clientService.create(clientSdi));
    }
}
