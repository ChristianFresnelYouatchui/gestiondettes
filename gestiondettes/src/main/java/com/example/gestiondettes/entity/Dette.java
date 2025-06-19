package com.example.gestiondettes.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Dette {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String date;
    private Double montantDette;

    private Double montantPaye = 0.0;
    // Removed montantRestant field as it is not used

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToMany(mappedBy = "dette", cascade = CascadeType.ALL)
    private List<Paiement> paiements = new ArrayList<>();

    @PrePersist
    @PreUpdate
    public void calculerMontants() {
        montantPaye = paiements.stream().mapToDouble(Paiement::getMontant).sum();
    }

    public Double getMontantRestant() {
        return montantDette - montantPaye;
    }

    // Getters & Setters

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    public Double getMontantDette() {
        return montantDette;
    }
    public void setMontantDette(Double montantDette) {
        this.montantDette = montantDette;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }
    public List<Paiement> getPaiements() {
        return paiements;
    }
    public void setPaiements(List<Paiement> paiements) {
        this.paiements = paiements;
    }
    public Double getMontantPaye() {
        return montantPaye;
    }
    public void setMontantPaye(Double montantPaye) {
        this.montantPaye = montantPaye;
    }
    @Override
    public String toString() {
        return "Dette{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", montantDette=" + montantDette +
                ", montantPaye=" + montantPaye +
                ", client=" + (client != null ? client.getId() : "null") +
                ", paiements=" + paiements.size() +
                '}';
    }
}



