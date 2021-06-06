-- 1. utilisateur
INSERT INTO `mpd_oc_escalade`.`utilisateur`
(`id`,
`nom`,
`prenom`,
`numeroTel`,
`adresse`,
`codePostal`,
`email`,
`pseudo`,
`motDePasse`,
`membreAssoY_N`)
VALUES
(1, "Perry", "Bianca", "0107255630", "Ap #905-6985 Magnis St.", "24054", "bperry@gmail.com", "bperry", "perry84", 1),
(2, "Ortega", "Levi", "0595719869", "5036 Cras Rd.", "15032", "lorega@gmail.com", "lortega", "ortega85", 0),
(3, "Mufutau", "Joyner", "0407677992", "504-880 Aliquet Street", "14209", "mjoyner@gmail.com", "jmufutau", "mufutau75", 0);


-- 2. site
INSERT INTO `mpd_oc_escalade`.`site`
(`id`,
`libelle`,
`hauteur`,
`tagY_N`,
`ville`,
`pays`)
VALUES
(1,"Bourgogne",1217,"1","Mâcon","France"),
(2,"Basse-Normandie",1933,"0","Lisieux","France"),
(3,"Picardie",20,"0","Compiègne","France"),
(4,"Île-de-France",88,"0","Champigny-sur-Marne","France"),
(5,"Auvergne",1066,"1","Aurillac","France");


-- 3. cotation 
INSERT INTO `mpd_oc_escalade`.`cotation`
(`id`,
`libelle`)
VALUES
(1,"3a"),(2,"3b"),(3,"3c"),
(4,"4a"),(5,"4b"),(6,"4c");


-- 4. statut_topo
INSERT INTO `mpd_oc_escalade`.`statut_topo`
(`id`,
`libelle`)
VALUES
(1,"disponible"),
(2,"indisponible"),
(3,"en attente");


-- 5. secteur
INSERT INTO `mpd_oc_escalade`.`secteur`
(`id`,
`libelle`,
`site_id`)
VALUES
(1,"Nord",1),
(2,"Sud",2),
(3,"Est",3),
(4,"Nord",4),
(5,"Ouest",5);


-- 6.voie
INSERT INTO `mpd_oc_escalade`.`voie`
(`id`,
`equipeeY_N`,
`cotation_id`,
`secteur_id`)
VALUES
(1,1,1,1),
(2,0,2,2),
(3,1,3,3),
(4,0,4,4),
(5,1,5,5);


-- 7. longueur
INSERT INTO `mpd_oc_escalade`.`longueur`
(`id`,
`relaiY_N`,
`cotation_id`,
`voie_id`)
VALUES
(1,1,1,1),
(2,1,2,2),
(3,0,3,3),
(4,1,4,4),
(5,0,5,5);

-- 8. topo
INSERT INTO `mpd_oc_escalade`.`topo`
(`id`,
`nom`,
`description`,
`date_parution`,
`statut_topo_id`,
`proprietaire_id`,
`emprunteur_id`,
`site_id`)
VALUES
(1,"Mâcon","Topo officiel Bourgogne",CURDATE(),1,1,null,1),
(2,"Lisieux","Topo officiel Basse-Normandie",CURDATE(),1,1,null,2),
(3,"Compiègne","Topo officiel Picardie",CURDATE(),1,2,null,3),
(4,"Champigny-sur-Marne","Topo officiel Île-de-France",CURDATE(),1,2,null,4),
(5,"Aurillac","Topo officiel Auvergne",CURDATE(),1,3,null,5);


-- 9. commentaire
INSERT INTO `mpd_oc_escalade`.`commentaire`
(`id`,
`contenu`,
`utilisateur_id`,
`site_id`)
VALUES
(1,"Très dur à terminer!",1,1),
(2,"Les roches sont glissantes, attention.",1,2),
(3,"Site assez peu équipé, pour grimpeurs aguerris",2,3),
(4,"Parfait pour débuter!",2,4),
(5,"Un vrai challenge",3,5);
