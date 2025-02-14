package com.Desafio3ApiRestCRUD.service;

import com.Desafio3ApiRestCRUD.dto.ClientDTO;
import com.Desafio3ApiRestCRUD.entities.Client;
import com.Desafio3ApiRestCRUD.exceptions.ResourceNotFoundException;
import com.Desafio3ApiRestCRUD.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Transactional(readOnly = true)
    public ClientDTO findById(Long id) {
        Client client = clientRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado!"));
        return new ClientDTO(client);
    }
}
