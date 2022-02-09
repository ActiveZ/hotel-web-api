package dev.hotel.dto;

import java.time.LocalDate;
import java.util.List;

public class ReservationDto {
    private  LocalDate dateDebut;
    private  LocalDate dateFin;
    private  String numeroClient;
    private  List<String> chambres;


    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public String getNumeroClient() {
        return numeroClient;
    }

    public List<String> getChambres() {
        return chambres;
    }
}
