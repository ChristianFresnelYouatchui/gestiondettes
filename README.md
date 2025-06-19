# Gestion Dettes - Spring Boot

## Description

Gestion Dettes est une application REST développée avec Spring Boot pour gérer des clients, leurs dettes, et les paiements associés.  
La base de données utilisée est H2 en mode fichier pour assurer la persistance des données entre les redémarrages.

---

## Fonctionnalités

- Ajouter un client (nom, téléphone, adresse)  
- Ajouter une ou plusieurs dettes à un client  
- Lister les dettes d’un client avec pagination et filtrage par téléphone  
- Ajouter un paiement à une dette  
- Consulter l’historique des paiements et dettes d’un client avec pagination et filtres (téléphone client, numéro de dette)  
- Console H2 accessible pour visualiser la base et faire des requêtes SQL

---

## Technologies

- Java 17  
- Spring Boot 3.x  
- Spring Data JPA  
- Base de données H2 en mode fichier  
- Maven

---

## Prérequis

- Java JDK 17 ou supérieur  
- Maven (optionnel : wrapper Maven `mvnw` inclus)  
- Postman ou un client HTTP pour tester l’API (optionnel)

---

## Installation & Lancement

1. Cloner le projet :

```bash
git clone <URL_DU_REPO>
cd gestiondettes

3. Utiliser Git Bash ou un autre terminal
Le wrapper fonctionne mieux dans Git Bash (installé avec Git)

Accéder à l’API via http://localhost:8080/api
Accéder à la console H2 via http://localhost:8080/h2-console
JDBC URL : jdbc:h2:file:./data/gestiondettesdb
Username : sa
Password : (laisser vide)



Structure du projet
entity : classes métier (Client, Dette, Paiement)
repository : interfaces Spring Data JPA
controller : API REST exposée
dto : objets de transfert pour filtrage, pagination, etc.
resources/application.properties : configuration H2 en mode fichier

Notes
Les données sont persistées dans ./data/gestiondettesdb.mv.db
Supprimez ce fichier pour réinitialiser la base
Le projet utilise Lombok (pensez à activer le support dans votre IDE)



Remarques
Les données sont sauvegardées dans un fichier H2 local (./data/gestiondettesdb.mv.db)
Pour réinitialiser la base, supprimez ce fichier puis redémarrez l’application.
