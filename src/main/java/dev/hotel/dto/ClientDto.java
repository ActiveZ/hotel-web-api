package dev.hotel.dto;

import java.io.Serializable;
import java.util.Objects;

public class ClientDto implements Serializable {
    private final String numero;
    private final String nom;
    private final String prenoms;

    public ClientDto(String numero, String nom, String prenoms) {
        this.numero = numero;
        this.nom = nom;
        this.prenoms = prenoms;
    }

    public String getNumero() {
        return numero;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenoms() {
        return prenoms;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientDto entity = (ClientDto) o;
        return Objects.equals(this.numero, entity.numero) &&
                Objects.equals(this.nom, entity.nom) &&
                Objects.equals(this.prenoms, entity.prenoms);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero, nom, prenoms);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "numero = " + numero + ", " +
                "nom = " + nom + ", " +
                "prenoms = " + prenoms + ")";
    }
}
