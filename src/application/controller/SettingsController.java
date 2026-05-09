package application.controller;

import java.io.IOException;

import application.Navigation.Navigation;
import application.docker.Docker;
import application.services.FileOpen;
import application.settings.Settings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class SettingsController {


	Navigation Navigate = new Navigation();

    @FXML
    private TextField donePath;

    @FXML
    private TextField rejectedPath;

    @FXML
    private Button saveBtn;

    @FXML
    private TextField soundPath;

    @FXML
    private TextField todoPath;
    @FXML
    private Button status;
    
    
    //NAVIGATION AND OPEN FOLDER
    public void todo(ActionEvent event) throws IOException {
    	Navigate.NavigateTodo(event);
    }
    
    public void reject(ActionEvent event) throws IOException {
    	Navigate.NavigateReject(event);
    }
    
    public void done(ActionEvent event) throws IOException {
    	Navigate.NavigateDone(event);
    }
    
    public void configure() {
    	FileOpen.open("src/application/settings/Config.properties");
    }
    
    
    public  void docker() {
    	
    	if(Docker.status == true) {
    		
    		Docker.stop();
    		Docker.status = false;
    		dockerInitialize();
    		System.out.println("docker off");
    	
   
    	}else if(Docker.status == false) {
    		
    		Docker.start();
    		Docker.status = true;
    		dockerInitialize();
    		System.out.println("docker on");
    		
    		
    		
    	}
    	
    }
    
    
    public  void dockerInitialize() {
    	
    	if(Docker.status == true) {
    		
    		status.setText("RUNNING");
    		status.setStyle(
    	            "-fx-background-color: transparent;" +
    	            "-fx-text-fill: #4fff1e;" +
    	            "-fx-font-size: 9px;" +
    	            "-fx-font-family: 'Courier New';" +
    	            "-fx-font-weight: bold;" +
    	            "-fx-border-color: #222222;" +
    	            "-fx-border-width: 1;" +
    	            "-fx-border-radius: 2;" +
    	            "-fx-background-radius: 2;" +
    	            "-fx-padding: 3 10 3 10;" +
    	            "-fx-cursor: hand;"
    	    );
    		
    		
    	}else if(Docker.status == false) {

    		
    		status.setText("NOT RUNNING");
    		status.setStyle(
    	            "-fx-background-color: transparent;" +
    	            "-fx-text-fill: #FF1900;" +
    	            "-fx-font-size: 9px;" +
    	            "-fx-font-family: 'Courier New';" +
    	            "-fx-font-weight: bold;" +
    	            "-fx-border-color: #222222;" +
    	            "-fx-border-width: 1;" +
    	            "-fx-border-radius: 2;" +
    	            "-fx-background-radius: 2;" +
    	            "-fx-padding: 3 10 3 10;" +
    	            "-fx-cursor: hand;"
    	    );
    		
    	}
    	
    }
	
    
	public void initialize() {
		
		dockerInitialize();
		Settings.CheckChanges();
		todoPath.setText("");
		donePath.setText("");
		rejectedPath.setText("");
		soundPath.setText("");
		todoPath.setPromptText(Settings.todo());
		donePath.setPromptText(Settings.done());
		rejectedPath.setPromptText(Settings.reject());
		soundPath.setPromptText(Settings.sound());
	}
}
