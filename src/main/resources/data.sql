INSERT INTO roadbookride.utilisateur (id, pseudo, email, password, nom, prenom, telephone, niveau, ville, role) VALUES (1, 'Speufy', 'speufy31@gmail.com', 'Toulouse*31', 'Gallard', 'Romain', '0652755749', 'Intermédiaire', 'Toulouse', 'Admin');
INSERT INTO roadbookride.utilisateur (id, pseudo, email, password, nom, prenom, telephone, niveau, ville, role) VALUES (2, 'RobTheBear', 'robert@gmail.com', 'Robear', 'Roussely', 'Robert', '0606056006', 'Expert', 'Monaco', 'Moderateur');
INSERT INTO roadbookride.utilisateur (id, pseudo, email, password, nom, prenom, telephone, niveau, ville, role) VALUES (3, 'Sof', 'sophie.balcon@gmail.com', 'fzr', 'Balcon', 'Sophie', '0620458598', 'Confirmé', 'Saint-Nazaire', 'User');

INSERT INTO roadbookride.moto (id, categorie, marque, modele, annee, id_proprietaire) VALUES (1, 'Roadster', 'KTM', '790 Duke', 2018, 1);
INSERT INTO roadbookride.moto (id, categorie, marque, modele, annee, id_proprietaire) VALUES (2, 'Trail', 'KTM', '1290 Super Adventure', 2015, 2);
INSERT INTO roadbookride.moto (id, categorie, marque, modele, annee, id_proprietaire) VALUES (3, 'Sportive', 'Yamaha', '1000 FZR', 1989, 3);

INSERT INTO roadbookride.region (id, nom) VALUES (1, 'Occitanie');
INSERT INTO roadbookride.region (id, nom) VALUES (2, 'Pays de la loire');
INSERT INTO roadbookride.region (id, nom) VALUES (3, 'Ile de France');

INSERT INTO roadbookride.article (id, titre, tag, description, texte, id_utilisateur, nb_vue, date_publication) VALUES (1, 'La moto pour les nulles', 'nulle', 'On vous explique la moto', 'alors une moto n''est pas un scooter !!!!c''est beaucoup mieux', 2, 2, '2020-01-21');
INSERT INTO roadbookride.article (id, titre, tag, description, texte, id_utilisateur, nb_vue, date_publication) VALUES (2, 'Bien choisir son équipement', 'equipement', 'Les équipement moto', 'Pour bien choisir son équipement il faut bien connaitre son corps et surtout la taille qu''il vous faut !!', 1, 5, '2020-01-08');

INSERT INTO roadbookride.service (id, nom, categorie, description, nbr_place, note, id_region, utilisateurs_id) VALUES (1, 'au dodo', 'hotel', 'une chambre chez l''habitant', 5, 2, 1, 1);
INSERT INTO roadbookride.service (id, nom, categorie, description, nbr_place, note, id_region, utilisateurs_id) VALUES (2, 'jojo la bricol', 'mecanique', 'je répare vos moto a domicile', 1, 5, 3, 2);

INSERT INTO roadbookride.roadbook (id, nom, id_region, description, kilometrage, difficulte, id_utilisateur,likes) VALUES (2, 'la route du vin', 1, 'on va boire un coup', 200, 'facil', 2, 5);
INSERT INTO roadbookride.roadbook (id, nom, id_region, description, kilometrage, difficulte, id_utilisateur,likes) VALUES (3, 'au louvre', 3, 'visite du louvre', 25, 'expert', 1, 9);

INSERT INTO roadbookride.pointconstruction (id, ordre_etape, latitude, longitude, is_etape, type_etape, id_roadbook) VALUES (4, 1, 0, 1, 1, 'depart', 2);
INSERT INTO roadbookride.pointconstruction (id, ordre_etape, latitude, longitude, is_etape, type_etape, id_roadbook) VALUES (5, 2, 0, 0, 1, 'point de passage', 2);

INSERT INTO roadbookride.evenement (id, nom, type, description, id_region, date, id_utilisateur, id_roadbook) VALUES (1, 'Les vieilles moto', 'Concentration', 'RDV le 12/12/12 a Montreuil', 3, '1970-01-08', 2, null);
INSERT INTO roadbookride.evenement (id, nom, type, description, id_region, date, id_utilisateur, id_roadbook) VALUES (2, 'Enchère sur Paris', 'Vente', 'RDV a la salle des ventes', 1, '2023-01-19', 1, null);

