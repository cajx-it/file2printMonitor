package application.controller;

import java.io.File;
import java.io.IOException;

import application.Navigation.Navigation;
import application.docker.Docker;
import application.services.FileList;
import application.settings.Settings;
import application.ui_components.reject_rows;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;


public class RejectController {
	
	Navigation Navigate = new Navigation();
	//STORE SELF SO WE CAN RUN NON STATIC METHOD
	private static RejectController instance;
    @FXML
    private  VBox table;
    @FXML
    private Button refresh;
    @FXML
    private Button open;
    @FXML 
    private Button todo;
    @FXML 
    private Button done;
    @FXML
    private Button status;
    
    
    //NAVIGATION AND OPEN FOLDER
    public void todo(ActionEvent event) throws IOException {
    	Navigate.NavigateTodo(event);
    }
    
    public void settings(ActionEvent event) throws IOException {
    	Navigate.NavigateSettings(event);
    }
    
    public void done(ActionEvent event) throws IOException {
    	Navigate.NavigateDone(event);
    }
    
    public static  void OpenFolder(MouseEvent event) {
    	Navigation.NavigateOpenFolder(event);
    }
    
    public static  void DeleteFolder(MouseEvent event) {
    	Navigation.NavigationDeleteFolder(event);
    	instance.initialize();
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
	
    
    public  void initialize() {
    	
    	instance = this;
    	
    	dockerInitialize();
    	
    	Settings.CheckChanges();
    	
    	table.getChildren().clear();
   
    	File[] dir = FileList.list(Settings.reject());
    	
    	for(File fol : dir) {
    		
    		
    		VBox vb = reject_rows.build(fol.getName(), fol.getPath());
    		
    		table.getChildren().add(vb);
    	}
    	
    	
    	
    }
}
