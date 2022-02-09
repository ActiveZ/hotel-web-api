package dev.hotel;

import dev.hotel.entite.Client;
import dev.hotel.repositories.ClientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // désactive la db embraquée configurée dans pom.xml -> dependency h2
public class ClientRepoTest {

    @Autowired
    ClientRepository clientRepo;

    @Test
    @Sql("classpath:sql/client-repo-1.sql")
    void testFinByNumero() {
        Client client = clientRepo.findByNumero("M_2");
        assert(client.getNom()).equals("Honore");
        assert(client.getNumero()).equals("M02_2");
    }


}
