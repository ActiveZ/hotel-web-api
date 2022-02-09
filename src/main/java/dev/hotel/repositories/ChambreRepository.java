package dev.hotel.repositories;

import dev.hotel.entite.Chambre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChambreRepository extends JpaRepository<Chambre, Integer> {
    Chambre findByCode(String code);
}