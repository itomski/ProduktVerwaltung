package de.lubowiecki.produktverwaltung;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class ProductsApplication extends Application {

    private static Scene scene;
    private static ResourceBundle bundle;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("main-view"));
        //bundle = ResourceBundle.getBundle("de.lubowiecki.produktverwaltung.ui");
        stage.setTitle(bundle.getString("app.title"));
        stage.setScene(scene);
        stage.show();
    }

    public static void setRoot(String fxmlFile) throws IOException {
        scene.setRoot(loadFXML(fxmlFile));
    }

    private static Parent loadFXML(String fxmlFile) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ProductsApplication.class.getResource(fxmlFile + ".fxml"), bundle);
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.GERMAN);
        bundle = ResourceBundle.getBundle("de.lubowiecki.produktverwaltung.ui");
        launch();
    }
}