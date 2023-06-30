package com.example.carrental.api.client;

import com.example.carrental.domain.client.Client;

public record ClientDto(
        Long id,
        String name,
        String surname,
        String email,
        String phoneNumber
) {

    public static ClientDto fromDomain(Client client) {
        return new ClientDto(
                client.getId(),
                client.getName(),
                client.getSurname(),
                client.getEmail(),
                client.getPhoneNumber());
    }

}
