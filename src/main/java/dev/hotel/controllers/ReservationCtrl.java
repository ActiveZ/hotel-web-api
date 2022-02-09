package dev.hotel.controllers;

import dev.hotel.dto.ReservationDto;
import dev.hotel.entite.Chambre;
import dev.hotel.entite.Client;
import dev.hotel.entite.Reservation;
import dev.hotel.repositories.ChambreRepository;
import dev.hotel.repositories.ClientRepository;
import dev.hotel.services.ReservationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("reservations")
public class ReservationCtrl {

    private ReservationService reservationService;
    private ClientRepository clientRepository;
    private ChambreRepository chambreRepository;

    public ReservationCtrl(ReservationService reservationService,
                           ClientRepository clientRepository,
                           ChambreRepository chambreRepository) {
        this.reservationService = reservationService;
        this.clientRepository = clientRepository;
        this.chambreRepository = chambreRepository;
    }

    //    Creation d'une réservation avec méthode POST
    @PostMapping()
    public ResponseEntity<?> reserver(@RequestBody ReservationDto resaDto) {
        System.out.println("resaDto = " + resaDto); // debug

        Reservation myReservation = new Reservation();

        ////////// recupération des dates /////////////////
        myReservation.setDateDebut(resaDto.getDateDebut());
        myReservation.setDateFin(resaDto.getDateFin());

        ////////// récupération du client /////////////////
        Client client = clientRepository.findByNumero(resaDto.getNumeroClient());
        System.out.println("client = " + client); // debug
        if (client == null) {
            return ResponseEntity
                    .status(400)
                    .body("Numéro client non trouvé");
        }
        myReservation.setClient(client); // client ok

        /////////// récupération des chambres ///////////////
        for(String codeChambre: resaDto.getChambres()) {
            Chambre chambre = chambreRepository.findByCode(codeChambre);
            if (chambre == null) {
                return ResponseEntity
                        .status(400)
                        .body("la chambre " +  chambre.getCode() + " n'existe pas");
            }
            myReservation.getChambres().add(chambre);
        }

        System.out.println("myReservation = " + myReservation); // debug

        ////////// Ajout des données dans la db ///////////


        reservationService.reserver(resaDto);
        return ResponseEntity
                .status(200)
                .body(resaDto);
    }
}
