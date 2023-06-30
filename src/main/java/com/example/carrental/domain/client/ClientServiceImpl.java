package com.example.carrental.domain.client;

import com.example.carrental.infrastructure.ClientRepository;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client registerNewClient(Client client) {
        return clientRepository.save(client);
    }
}
