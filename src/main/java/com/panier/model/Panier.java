package com.panier.model;

import java.util.HashMap;
import java.util.Map;

public class Panier {
    private final Client client;
    private final Map<TypeProduit, Integer> produits = new HashMap<>();

    public Panier(Client client) {
        this.client = client;
    }

    public void ajouterProduit(TypeProduit typeProduit, int quantite) {
        produits.merge(typeProduit, quantite, Integer::sum);
    }

    public double calculerTotal() {
        return produits.entrySet().stream()
                .mapToDouble(e -> e.getKey().getPrixPour(client) * e.getValue())
                .sum();
    }
}
