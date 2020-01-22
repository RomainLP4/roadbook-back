CREATE TABLE `Utilisateur` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`pseudo` VARCHAR(32) NOT NULL,
	`email` VARCHAR(50) NOT NULL,
	`password` VARCHAR(50) NOT NULL,
	`nom` VARCHAR(32),
	`prenom` VARCHAR(32),
	`telephone` VARCHAR(16),
	`niveau` VARCHAR(16),
	`ville` VARCHAR(32),
	`role` VARCHAR(32) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Moto` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`categorie` VARCHAR(32) NOT NULL,
	`marque` VARCHAR(32) NOT NULL,
	`modele` VARCHAR(32) NOT NULL,
	`annee` INT(4) NOT NULL,
	`id_proprietaire` INT NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Articles` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`titre` VARCHAR(255) NOT NULL,
	`tags` VARCHAR(255) NOT NULL,
	`description` VARCHAR(255) NOT NULL,
	`texte` VARCHAR(255) NOT NULL,
	`id_auteur` INT NOT NULL,
	`nb_vues` INT NOT NULL,
	`date_publication` DATE NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Services` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`nom` VARCHAR(255) NOT NULL,
	`categorie` VARCHAR(255) NOT NULL,
	`description` VARCHAR(255) NOT NULL,
	`nbr_place` INT,
	`note` INT NOT NULL,
	`id_region` INT NOT NULL,
	`id_utilisateur` INT NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Roadbook` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`nom` VARCHAR(32) NOT NULL,
	`id_region` INT NOT NULL,
	`description` VARCHAR(255) NOT NULL,
	`kilometrage` INT NOT NULL,
	`difficulte` VARCHAR(255) NOT NULL,
	`id_auteur` INT NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Evenements` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`nom` VARCHAR(255) NOT NULL,
	`type` VARCHAR(255) NOT NULL,
	`description` VARCHAR(255) NOT NULL,
	`id_region` INT NOT NULL,
	`date` DATE NOT NULL,
	`id_organisateur` INT NOT NULL,
	`id_roadbook` INT,
	PRIMARY KEY (`id`)
);

CREATE TABLE `PointConstruction` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`ordreEtape` INT NOT NULL UNIQUE,
	`latitude` FLOAT NOT NULL,
	`longitude` FLOAT NOT NULL,
	`is_etape` BOOLEAN NOT NULL,
	`type_etape` VARCHAR(255),
	`id_roadbook` INT NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Region` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`nom` VARCHAR(32) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Like` (
	`id_utilisateur` INT NOT NULL,
	`id_roadbook` INT,
	`id_evenement` INT
);

ALTER TABLE `Moto` ADD CONSTRAINT `Moto_fk0` FOREIGN KEY (`id_proprietaire`) REFERENCES `Utilisateur`(`id`);

ALTER TABLE `Articles` ADD CONSTRAINT `Articles_fk0` FOREIGN KEY (`id_auteur`) REFERENCES `Utilisateur`(`id`);

ALTER TABLE `Services` ADD CONSTRAINT `Services_fk0` FOREIGN KEY (`id_region`) REFERENCES `Region`(`id`);

ALTER TABLE `Services` ADD CONSTRAINT `Services_fk1` FOREIGN KEY (`id_utilisateur`) REFERENCES `Utilisateur`(`id`);

ALTER TABLE `Roadbook` ADD CONSTRAINT `Roadbook_fk0` FOREIGN KEY (`id_region`) REFERENCES `Region`(`id`);

ALTER TABLE `Roadbook` ADD CONSTRAINT `Roadbook_fk1` FOREIGN KEY (`id_auteur`) REFERENCES `Utilisateur`(`id`);

ALTER TABLE `Evenements` ADD CONSTRAINT `Evenements_fk0` FOREIGN KEY (`id_region`) REFERENCES `Region`(`id`);

ALTER TABLE `Evenements` ADD CONSTRAINT `Evenements_fk1` FOREIGN KEY (`id_organisateur`) REFERENCES `Utilisateur`(`id`);

ALTER TABLE `Evenements` ADD CONSTRAINT `Evenements_fk2` FOREIGN KEY (`id_roadbook`) REFERENCES `Roadbook`(`id`);

ALTER TABLE `PointConstruction` ADD CONSTRAINT `PointConstruction_fk0` FOREIGN KEY (`id_roadbook`) REFERENCES `Roadbook`(`id`);

ALTER TABLE `Like` ADD CONSTRAINT `Like_fk0` FOREIGN KEY (`id_utilisateur`) REFERENCES `Utilisateur`(`id`);

ALTER TABLE `Like` ADD CONSTRAINT `Like_fk1` FOREIGN KEY (`id_roadbook`) REFERENCES `Roadbook`(`id`);

ALTER TABLE `Like` ADD CONSTRAINT `Like_fk2` FOREIGN KEY (`id_evenement`) REFERENCES `Evenements`(`id`);
