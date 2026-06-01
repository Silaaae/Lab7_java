# Lab 7 — Galerie de Stars : RecyclerView, Animations et Filtrage

**Auteure : Nisrine Gorfti — EMSI**


## Description
Application Android affichant une galerie de célébrités avec RecyclerView, animations d'entrée et filtrage par SearchView.

## Fonctionnalités
- Liste de stars avec nom, catégorie et note (RatingBar)
- Animation slide-in à l'apparition de chaque carte
- Filtrage en temps réel par nom ou catégorie via SearchView
- Design avec CardView et élévation

## Structure
```
app/src/main/
├── java/com/example/galeriestars/
│   ├── MainActivity.java     # Activité principale + filtrage
│   ├── StarAdapter.java      # Adaptateur RecyclerView + animations
│   └── Star.java             # Modèle de données
└── res/layout/
    ├── activity_main.xml     # SearchView + RecyclerView
    └── item_star.xml         # Carte d'une star (CardView)
```

## Dépendances
```
implementation 'androidx.recyclerview:recyclerview:1.3.0'
implementation 'androidx.cardview:cardview:1.0.0'
```
<img width="252" height="531" alt="image" src="https://github.com/user-attachments/assets/3e9cdb54-8cc1-4aca-8e8d-26aea5fea821" />
