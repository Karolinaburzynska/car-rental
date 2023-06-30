package com.example.carrental.api.client;

import com.example.carrental.domain.client.Client;
import com.example.carrental.domain.client.ClientServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.carrental.api.client.ClientController.BASE_PATH_CLIENT;

@RestController
@RequestMapping(BASE_PATH_CLIENT)
public class ClientController {

    static final String BASE_PATH_CLIENT = "/clients";

    private final ClientServiceImpl clientService;

    public ClientController(ClientServiceImpl clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public ResponseEntity<Client> registerNewClient(@RequestBody Client client) {
        Client newClient = clientService.registerNewClient(client);
        return ResponseEntity.status(HttpStatus.CREATED).body(newClient);
    }
}
