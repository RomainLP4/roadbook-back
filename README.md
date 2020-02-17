# Projet fil rouge

![](banniere.jpg)

Nous avons le plaisir de vous présenter RoadBook Ride, une application communautaire 100% dédiée aux motards !<br/>
RoadBook Ride vous permet de profiter de RoadBooks, d’articles, d’événements et autres services créés par la communauté.<br/>
ROADBOOKS MOTO : <br/>
Les motards partagent leurs roadbooks à travers toute la France et la communauté en profite. Et grâce à Robert (et aussi beaucoup grâce à Jean-Pierre et Thomas…), vous pourrez même vous géolocaliser !!!<br/>
ARTICLES : <br/>
Un fil d’actualités est mis à votre disposition pour échanger, publier et partager.<br/>
SERVICES :<br/>
Les motards partagent leurs compétences, proposent des services… Cette page peut être votre alliée au quotidien. <br/>
BALADES ET ÉVÉNEMENTS : <br/>
Tous les événements et balades sont ajoutés par les membres. Les utilisateurs situés à proximité du lieu de rendez-vous sont notifiés par email et notifications mobiles.<br/>

## Membres du projet :
Balcon Sophie<br/>
![](sophie.jpg)
Roussely Robert<br/>
![](robert.jpg)
Piveteau Olivier<br/>
![](olivier.jpg)
Gallard Romain<br/>
![](romain.jpg)
## Doc de synthèse des réunions

https://docs.google.com/document/d/1_GBlj-ltqSKCLcIOpHSGGh2gK36yKEEFBCuBlj5qUNU/edit

## Trello
https://trello.com/b/WpmMKhwL/commumoto

## Maquette
https://marvelapp.com/80i1ag5

## Projet Wordpress
https://wordpress-7068-0.cloudclusters.net/

## Description
Une application web qui permet aux motards utilisateurs de partager leurs expériences.<br/>

La page d'accueil se compose:
- D'un fil d'actualités sur lequel les articles sont présentés.
- Un lien de connexion utilisateurs.
- Un lien vers les roadbooks : consultation et création.
- Une barre de recherche
- Un lien vers la page événements
- Un lien vers la page services

## Répartition des taches :
Jusque la Sophie s'est occupée de la partie design du projet et de la maquette.<br/>
Olivier des uses cases.<br/>
Romain s'occupe du repo GitHub.<br/>
Et nous avons travaillé tous ensemble sur le MCD et les tables.

## API utilisées 
Nous allons utiliser OpenStreetMap comme API pour la carte.
Recherche en cours pour la création d'itinéraire.

## Description technique
(à venir)

## Notice
(à venir)

## Endpoints

(à venir)<br/>

## Use Cases

![](https://i.imgur.com/18DLzFj.png)

#### Scenarios des Use Cases

###### Scénario 1 : Un utilisateur (inscrit ou non) veut découvrir des itinéraires de balades dans sa région.

L'utilisateur lance l'application / se rends sur le site Roadbook-ride. Depuis le menu - barre de navigation - de la page d'accueil, il accède à la page des roadbooks.
Les roadbooks les plus populaires (toutes régions confondues) apparaissent à l'écran, sous la forme de fiche récapitulatives (nom, kilomètrage, temps estimé, nombre d'étapes... aperçu trajet ?)

Il clique sur la petite carte de France pour l'agrandir et sélectionner sa région.
Puis l'utilisateur clique sur sa région. La carte se réduit et la liste des roadbooks affichés se met à jour pour présenter les roadbooks les plus populaires parmi ceux localisés à proximité.

Il fait défiler la liste jusqu'à en trouver un dont le point de départ se trouve près de chez lui. Un rapide coup d'oeil sur la fiche récapitulative l'informe de la distance et du temps estimé (deux jours, parfait pour une sortie sur un week-end)

Ce roadbook ayant attiré son attention, il clique sur sa fiche pour accéder aux détails.

Il peut à tout moment revenir à la liste des Roadbooks.


###### Scénario 2 : Un utilisateur (inscrit) souhaite organiser un évènement.

L'utilisateur lance l'application / se rends sur le site Roadbook-ride. Au besoin, il se connecte avec ses identifiants.
Depuis le menu - barre de navigation - de la page d'accueil, il accède à la page des évènements.
En dessous de la liste des évènement, il clique sur 'ajouter un évènement', qui ouvre un formulaire.

Il remplit les champs obligatoires (nom, type d'évènement, description, date) et optionnels [ajouter ici comment se passe la sélection d'un RB] , et valide.

Le formulaire se referme, une notification l'informe que son évènement a bien été enregistré, il est renvoyé sur la page des évènements.

Il peut immédiatement vérifier que son évènement est bien listé en effectuant une recherche par nom sur cette même page.

## MCD

![](https://i.imgur.com/IjQ2IK7.png)


