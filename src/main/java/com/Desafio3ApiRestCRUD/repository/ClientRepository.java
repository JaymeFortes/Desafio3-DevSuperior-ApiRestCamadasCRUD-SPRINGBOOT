package com.Desafio3ApiRestCRUD.repository;

import com.Desafio3ApiRestCRUD.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
