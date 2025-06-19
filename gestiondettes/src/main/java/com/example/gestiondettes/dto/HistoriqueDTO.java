package com.example.gestiondettes.dto;

public class HistoriqueDTO {
    private String type; // DETTE ou PAIEMENT
    private String date;
    private Double montant;
    private Long id;

    public HistoriqueDTO(String type, String date, Double montant, Long id) {
        this.type = type;
        this.date = date;
        this.montant = montant;
        this.id = id;
    }

    // Getters & Setters
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
