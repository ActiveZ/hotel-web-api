package dev.hotel.services;

import dev.hotel.entite.Chambre;
import dev.hotel.repositories.ChambreRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChambreService {
    private ChambreRepository chambreRepo;

    public ChambreService(ChambreRepository chambreRepo) {
        this.chambreRepo = chambreRepo;
    }

    public List<Chambre> listerChanmbres() {
        return chambreRepo.findAll();
    }
}
