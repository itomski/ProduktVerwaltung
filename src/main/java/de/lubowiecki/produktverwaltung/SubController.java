package de.lubowiecki.produktverwaltung;

import javafx.fxml.FXML;

import java.io.IOException;

public class SubController {

    @FXML
    public void changeView() throws IOException {
        ProductsApplication.setRoot("main-view");
    }
}
