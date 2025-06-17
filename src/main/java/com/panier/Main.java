package com.panier;

import com.panier.model.*;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Client client = new ClientProfessionnel("PRO1", "MaBoite", Optional.of("FR123"), "123456789", 12_000_000);
        Panier panier = new Panier(client);

        panier.ajouterProduit(TypeProduit.HAUT_DE_GAMME, 2);
        panier.ajouterProduit(TypeProduit.LAPTOP, 1);
        panier.ajouterProduit(TypeProduit.MILIEU_DE_GAMME,6);

        System.out.println("Total du panier : " + panier.calculerTotal() + " €");
    }
}
