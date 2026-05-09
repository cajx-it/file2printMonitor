package application;
import java.io.IOException;

import application.docker.Docker;
import application.services.DirWatcher;
import application.settings.Settings;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application {
	
	@Override
	public void start(Stage Stage) throws IOException {
		
		Docker.setup();
		Settings.setup();
		DirWatcher.start();
		
		Parent root = FXMLLoader.load(getClass().getResource("views/live.fxml"));

		Scene scene = new Scene(root);
		Stage.setTitle("File2printMonitor");
		Stage.setScene(scene);
		Stage.setResizable(false);
		Stage.show();
		
		
		
	}

	public static void main(String[] args) {
		launch(args);
	}

}
