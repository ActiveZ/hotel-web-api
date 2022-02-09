package dev.hotel;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import javax.transaction.Transactional;

@SpringBootTest
@Transactional // rollback automatic
class HotelWebApiApplicationTests {

    @Test
    void contextLoads() {
    }

    @Sql("classpath:sql/jdd-1.sql")
    @Test
    void jdd1() {
    }
}
