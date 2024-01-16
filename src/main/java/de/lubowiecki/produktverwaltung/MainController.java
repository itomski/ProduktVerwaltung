package de.lubowiecki.produktverwaltung;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MainController {

    private List<Product> products = new ArrayList<>();

    @FXML // Das Element ist für FXML sichtbar
    private TextField name;

    @FXML
    private TextField amount;

    @FXML
    private TextField price;

    @FXML
    private Label output;

    @FXML
    private void save() {

        //System.out.println(name.getText());
        //output.setText(name.getText()); // Schreibt ins Label
        //products.add(name.getText());
        //name.clear(); // Leert das Textfeld

        Optional<Product> opt = createProduct();
        if(opt.isPresent()) {
            products.add(opt.get());
            clearFields();
            showProducts();
        }
    }

    private Optional<Product> createProduct() {
        try {
            String name = this.name.getText();
            int amount = Integer.parseInt(this.amount.getText());
            double price = Double.parseDouble(this.price.getText());
            return Optional.of(new Product(name, amount, price));
        }
        catch(RuntimeException e) {
            // TODO Ausgabe in die GUI vornehmen
            System.out.println("Fehler");
        }

        return Optional.empty();
    }

    @FXML
    private void handleKey(KeyEvent event) {
        if(event.getCode() == KeyCode.ENTER) {
            save();
        }
    }

    private void showProducts() {
        StringBuilder sb = new StringBuilder();
        for (Product p : products) {
            sb.append(p.getName()).append(", ")
                    .append(p.getAmount()).append(", ")
                    .append(p.getPrice()).append("\n");
        }
        output.setText(sb.toString());
    }

    // Leert die Formularfelder
    private void clearFields() {
        name.clear();
        amount.clear();
        price.clear();
    }
}