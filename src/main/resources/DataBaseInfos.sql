CREATE TABLE membre (
                        identifiant VARCHAR(36) PRIMARY KEY, -- Identifiant unique pour chaque membre (String)
                        nom VARCHAR(100) NOT NULL,           -- Nom du membre (longueur max 100)
                        prenom VARCHAR(100) NOT NULL,        -- Prénom du membre (longueur max 100)
                        email VARCHAR(255),                  -- Adresse email (longueur max 255)
                        phone VARCHAR(20)                    -- Numéro de téléphone (longueur max 20)
);
CREATE TABLE incident (
                          reference VARCHAR(50) PRIMARY KEY, -- Référence unique de l'incident
                          memberId VARCHAR(50),
                          time TIMESTAMP NOT NULL,           -- Date et heure de l'incident
                          status VARCHAR(50) NOT NULL,       -- Statut de l'incident (par exemple : "En cours", "Clôturé")
                          fk_membre FOREIGN KEY (identifiant) REFERENCES membre(identifiant)
);