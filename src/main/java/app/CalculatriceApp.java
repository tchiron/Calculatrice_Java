package app;

import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class CalculatriceApp extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		URL fxml = Thread.currentThread().getContextClassLoader().getResource("fxml/CalculatricePanel.fxml");
		BorderPane root = FXMLLoader.load(fxml);
		Scene scene = new Scene(root);
		primaryStage.setTitle("TP - Calculatrice");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch();
	}
}
