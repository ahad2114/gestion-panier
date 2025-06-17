package com.panier;

import com.panier.model.*;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PanierTest {

    @Test
    void testParticulier() {
        ClientParticulier client = new ClientParticulier("C0011", "Ndiaye", "Abdou");
        Panier panier = new Panier(client);
        panier.ajouterProduit(TypeProduit.HAUT_DE_GAMME, 1);
        panier.ajouterProduit(TypeProduit.MILIEU_DE_GAMME, 2);
        assertEquals(3100.0, panier.calculerTotal());
    }

    @Test
    void testProPetitCA() {
        ClientProfessionnel client = new ClientProfessionnel("PRO1", "SUARL Abdou", Optional.empty(), "123456789", 5000000);
        Panier panier = new Panier(client);
        panier.ajouterProduit(TypeProduit.HAUT_DE_GAMME, 1);
        panier.ajouterProduit(TypeProduit.LAPTOP, 2);
        assertEquals(3150.0, panier.calculerTotal());
    }

    @Test
    void testProGrandCA() {
        ClientProfessionnel client = new ClientProfessionnel("PRO2", "SA", Optional.of("FR789"), "987654321", 20_000_000);
        Panier panier = new Panier(client);
        panier.ajouterProduit(TypeProduit.LAPTOP, 3);
        assertEquals(2700.0, panier.calculerTotal());
    }
}
