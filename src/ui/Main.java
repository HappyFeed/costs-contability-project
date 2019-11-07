package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application{
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("ordenes.fxml"));
		
		Scene scene = new Scene(root);
	    stage.setTitle("Proyecto de Contabilidad");
		stage.getIcons().add(new Image("file:icon.png"));

		stage.getIcons().add(new Image("/ui/icon.jpg"));
		stage.setScene(scene);
		stage.show();
	}
}

