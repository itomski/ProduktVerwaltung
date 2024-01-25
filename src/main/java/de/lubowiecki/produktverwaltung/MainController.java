package de.lubowiecki.produktverwaltung;

import javafx.beans.value.ObservableDoubleValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

// Initializable deklariert eine Methode, die beim Starten des Controller automatisch ausgeführt wird
public class MainController implements Initializable {

    private List<Product> products = new ArrayList<>();

    @FXML // Das Element ist für FXML sichtbar
    private TextField name;

    @FXML
    private TextField amount;

    @FXML
    private TextField price;

    @FXML
    private TableView<Product> productTbl;

    @FXML
    private TableColumn<Product, String> c1;

    @FXML
    private TableColumn<Product, Integer> c2;

    @FXML
    private TableColumn<Product, Double> c3;

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
            //showProducts();
            showProductsInTble();
        }
    }

    private void showProductsInTble() {
        productTbl.setItems(FXCollections.observableList(products)); // Sendet die Daten der Liste in die TableView
    }

    @FXML
    public void changeView() throws IOException {
        ProductsApplication.setRoot("sub-view");
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
            //name.getStyleClass().add("rot");
            save();
        }
        /*else if (event.getCode() == KeyCode.SHIFT) {
            name.getStyleClass().remove("rot");
        }*/
    }

    /*
    // Anzeige der Produlkte im Label
    private void showProducts() {
        StringBuilder sb = new StringBuilder();
        for (Product p : products) {
            sb.append(p.getName()).append(", ")
                    .append(p.getAmount()).append(", ")
                    .append(p.getPrice()).append("\n");
        }
        output.setText(sb.toString());
    }
    */

    // Leert die Formularfelder
    private void clearFields() {
        name.clear();
        amount.clear();
        price.clear();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        c1.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
        c2.setCellValueFactory(new PropertyValueFactory<Product, Integer>("amount"));
        c3.setCellValueFactory(new PropertyValueFactory<Product, Double>("price"));
        // Aufgaben ausführen
        System.out.println("Init");
    }
}