package com.Desafio3ApiRestCRUD.service;

import com.Desafio3ApiRestCRUD.dto.ClientDTO;
import com.Desafio3ApiRestCRUD.entities.Client;
import com.Desafio3ApiRestCRUD.exceptions.ResourceNotFoundException;
import com.Desafio3ApiRestCRUD.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @Transactional(readOnly = true)
    public Page<ClientDTO> findAll(Pageable pageable) {
            Page<Client> clients = clientRepository.findAll(pageable);
            return clients.map(client -> new ClientDTO(client));
    }

    @Transactional
    public ClientDTO insert(ClientDTO clientDTO) {
        Client entity = new Client();
        copyDtoToEntity(clientDTO, entity);
        entity = clientRepository.save(entity);
        return new ClientDTO(entity);
    }

    private void copyDtoToEntity(ClientDTO clientDTO, Client entity) {
        entity.setName(clientDTO.getName());
        entity.setCpf(clientDTO.getCpf());
        entity.setBirthDate(clientDTO.getBirthDate());
        entity.setIncome(clientDTO.getIncome());
        entity.setChildren(clientDTO.getChildren());
    }
}
