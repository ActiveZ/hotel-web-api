package dev.hotel.dto;

import java.io.Serializable;
import java.util.Objects;

public class HotelDto implements Serializable {
    private final String nom;
    private final Integer nombreEtoiles;

    public HotelDto(String nom, Integer nombreEtoiles) {
        this.nom = nom;
        this.nombreEtoiles = nombreEtoiles;
    }

    public String getNom() {
        return nom;
    }

    public Integer getNombreEtoiles() {
        return nombreEtoiles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HotelDto entity = (HotelDto) o;
        return Objects.equals(this.nom, entity.nom) &&
                Objects.equals(this.nombreEtoiles, entity.nombreEtoiles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, nombreEtoiles);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "nom = " + nom + ", " +
                "nombreEtoiles = " + nombreEtoiles + ")";
    }
}
