package dev.hotel.entite;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseEntite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonIgnore // pour ne pas renvoyer les id dans le json renvoyé comme réponse à la requete
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}