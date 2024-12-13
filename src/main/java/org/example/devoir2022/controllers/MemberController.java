package org.example.devoir2022.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.example.devoir2022.dao.impl.MembreDaoImpl;
import org.example.devoir2022.models.Membre;

public class MemberController {
    @FXML
    private TextField nomField, prenomField, emailField, phoneField;

    @FXML
    private Button insertBtn;

    private final MembreDaoImpl MembreDao = new MembreDaoImpl();

    @FXML
    public void initialize() {
        // Check if the fields are properly loaded
        if (nomField == null || prenomField == null || emailField == null || phoneField == null || insertBtn == null) {
            System.out.println("One or more FXML components are null! Check your fx:id bindings in the FXML file.");
        } else {
            System.out.println("All FXML components loaded successfully!");
        }
    }

    @FXML
    public void HandleInsertMembre() {
        if (nomField.getText().isEmpty() || prenomField.getText().isEmpty() || emailField.getText().isEmpty() || phoneField.getText().isEmpty()) {
            System.out.println("All fields must be filled in!");
        } else {
            // Create a new Membre object and populate it with data from the fields
            Membre Membre = new Membre();
            Membre.setNom(nomField.getText());
            Membre.setPrenom(prenomField.getText());
            Membre.setEmail(emailField.getText());
            Membre.setPhone(phoneField.getText());

            // Use the DAO to insert the Membre into the JSON file
            MembreDao.inserer(Membre);

            // Clear the fields after insertion
            nomField.clear();
            prenomField.clear();
            emailField.clear();
            phoneField.clear();

        }
    }
}