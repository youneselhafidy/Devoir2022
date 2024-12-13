package org.example.devoir2022.models;

import lombok.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class Membre {
    private String identifiant = UUID.randomUUID().toString();
    private String nom;
    private String prenom;
    private String email;
    private String phone;
    private Set<Incident> incident;

    //Copy constructer
    Membre(Membre membre) {
        this.identifiant = membre.identifiant;
        this.nom = membre.nom;
        this.prenom = membre.prenom;
        this.email = membre.email;
        this.phone = membre.phone;
        this.incident = membre.incident;
    }
    Membre(String nom, String prenom, String email, String phone) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Membre)) return false;
        Membre that = (Membre) o;
        return this.identifiant.equals(that.identifiant);
    }
    @Override
    public int hashCode() {
        return identifiant.hashCode();
    }

    public static Set<Membre> chargerListeMembre(String nomFichier){
        Set<Membre> membres = null;
        try(FileReader reader = new FileReader(nomFichier)){
            BufferedReader bufferedReader = new BufferedReader(reader);
            membres = new HashSet<Membre>();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] fileds = line.split(",");
                Membre membre = new Membre(fileds[0],fileds[1],fileds[2],fileds[3]);
                membres.add(membre);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return membres;
    }
}
