package com.example.service;

import com.example.model.Salle;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SalleServiceTest {

    private static SalleService service;

    @BeforeAll
    static void init() {
        service = new SalleService();
    }

    @Test
    @Order(1)
    void testCreateSalle() {
        Salle s = new Salle("Salle Test", 20);
        service.create(s);
        assertNotNull(s);
    }

    @Test
    @Order(2)
    void testFindAllSalles() {
        List<Salle> list = service.findAll();
        assertFalse(list.isEmpty());
    }

    @Test
    @Order(3)
    void testUpdateSalle() {
        List<Salle> list = service.findAll();
        Salle s = list.get(0);
        s.setNom("Salle Modifiée");
        Salle updated = service.update(s);
        assertEquals("Salle Modifiée", updated.getNom());
    }

    @Test
    @Order(4)
    void testDeleteSalle() {
        List<Salle> list = service.findAll();
        if (!list.isEmpty()) {
            Long id = list.get(0).getId();
            service.delete(id);
            assertNull(service.findById(id));
        }
    }
}