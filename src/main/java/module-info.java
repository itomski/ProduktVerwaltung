module de.lubowiecki.produktverwaltung {
    requires javafx.controls;
    requires javafx.fxml;


    opens de.lubowiecki.produktverwaltung to javafx.fxml;
    exports de.lubowiecki.produktverwaltung;
}