package dev.hotel.repositories;

import dev.hotel.entite.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {

    // recherche du client par son numéro
    Client findByNumero(String numero);
}