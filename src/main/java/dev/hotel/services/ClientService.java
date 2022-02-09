package dev.hotel.services;

import dev.hotel.entite.Client;
import dev.hotel.repositories.ClientRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
public class ClientService {
    private ClientRepository clientRepo;

    public ClientService(ClientRepository clientRepo) {
        this.clientRepo = clientRepo;
    }

//    // GET pageable
//    public List<Client> listerClients(Integer start, Integer size) {
//        return clientRepo.findAll(PageRequest.of(start, size, Sort.Direction.ASC,"numero"))
//                .toList();
//    }

//    // GET path variable
//    public Client clientByNum(String numero){
//        return clientRepo.findByNumero(numero);
//    }

    // POST
    @Transactional
    public Client creerClient(Client client) {
        client.setNumero(String.valueOf(UUID.randomUUID()));
        return clientRepo.save(client);
    }
}
