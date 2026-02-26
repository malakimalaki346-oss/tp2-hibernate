package com.example.service;

import com.example.model.Utilisateur;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UtilisateurServiceTest {

    private static UtilisateurService service;

    @BeforeAll
    static void init() {
        service = new UtilisateurService();
    }

    @Test
    @Order(1)
    void testCreateUtilisateur() {
        Utilisateur u = new Utilisateur("Test User", "testuser@email.com");
        service.create(u);
        assertNotNull(u);
    }

    @Test
    @Order(2)
    void testFindAllUtilisateurs() {
        List<Utilisateur> list = service.findAll();
        assertFalse(list.isEmpty());
    }

    @Test
    @Order(3)
    void testUpdateUtilisateur() {
        List<Utilisateur> list = service.findAll();
        Utilisateur u = list.get(0);
        u.setNom("Nom Modifié");
        Utilisateur updated = service.update(u);
        assertEquals("Nom Modifié", updated.getNom());
    }

    @Test
    @Order(4)
    void testDeleteUtilisateur() {
        List<Utilisateur> list = service.findAll();
        if (!list.isEmpty()) {
            Long id = list.get(0).getId();
            service.delete(id);
            assertNull(service.findById(id));
        }
    }
}