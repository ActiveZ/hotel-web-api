package dev.hotel.services;

import dev.hotel.dto.ReservationDto;
import dev.hotel.entite.Reservation;
import dev.hotel.repositories.ReservationRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ReservationService {
    private ReservationRepository reservationRepo;

    public ReservationService(ReservationRepository reservationRepo) {
        this.reservationRepo = reservationRepo;
    }


    @Transactional
    public void reserver(ReservationDto resaDto) {

    }
}
