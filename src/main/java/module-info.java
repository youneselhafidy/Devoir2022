module org.example.devoir2022 {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;
    requires java.sql;

    // Export the controllers package to javafx.fxml
    exports org.example.devoir2022.controllers to javafx.fxml;

    // Export the models package to Jackson
    exports org.example.devoir2022.models to com.fasterxml.jackson.databind;

    // Open the models package to Jackson for reflective access
    opens org.example.devoir2022.models to com.fasterxml.jackson.databind;

    // Open the controllers package to javafx.fxml
    opens org.example.devoir2022.controllers to javafx.fxml;

    // Export your main package if required by other modules
    exports org.example.devoir2022;
}