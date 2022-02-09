package dev.hotel.controllers;

import dev.hotel.entite.Client;
import dev.hotel.repositories.ClientRepository;
import dev.hotel.services.ClientService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clients") // url
public class ClientCtrl {
    private ClientService clientService;
    private ClientRepository clientRepo;

    public ClientCtrl(ClientService clientService) {
        this.clientService = clientService;
    }

    ////////////////// GET //////////////////
    // GET pageable
    @GetMapping()
    public List<Client> listerParams(@RequestParam Integer start, @RequestParam Integer size) { // recupération de la liste des clients avec requete GET
        return clientRepo.findAll(PageRequest.of(start, size, Sort.Direction.ASC,"numero"))
                .toList();
//        return clientService.listerClients(start, size); // si utilisation par clientService
    }

    //GET path variable: recherche d'un client par son numéro
    @GetMapping("{numero}")
    public ResponseEntity<?> listerPathVariable(@PathVariable String numero) {
//        Client res = clientService.clientByNum(numero); // si utilisation par clientService
        Client res = clientRepo.findByNumero(numero);
        Integer status = (res == null) ? 418 : 200; // pour le fun :)
        return ResponseEntity
                .status(status)
                .body(res);
    }


    ///////////////// POST /////////////////
    // POST
    @PostMapping()
    public ResponseEntity<?> creer(@RequestBody Client client) { // creation d'un client avec requete POST
        Client res = null;
        Integer status = 400;

        if (client.getNom().length() > 1 && client.getPrenoms().length() > 1) {
            status = 200;
            res = clientService.creerClient(client);
        }
        return ResponseEntity
                .status(status)
                .body(res);
    }
}
