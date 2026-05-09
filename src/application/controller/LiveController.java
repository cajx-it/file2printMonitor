package application.controller;

import java.io.File;
import java.io.IOException;

import application.Navigation.Navigation;
import application.docker.Docker;
import application.services.*;
import application.services.FileList;
import application.settings.Settings;
import application.ui_components.live_rows;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;



public class LiveController {
	
	Navigation Navigate = new Navigation();
	
	public static LiveController  instance;
    @FXML
    private  VBox table;
    @FXML
    private Button refresh;
    @FXML
    private Button open;
    @FXML
    private Button done;
    @FXML
    private Button reject;
    @FXML
    private Button MarkDone;
    @FXML
    private Button MarkReject;
    @FXML
    private Button status;
    
    
    

   
    //NAVIGATION AND OPEN FOLDER
    public void done(ActionEvent event) throws IOException {
    	Navigate.NavigateDone(event);
    }
    
    public void reject(ActionEvent event) throws IOException {
    	Navigate.NavigateReject(event);
    }
    
    public void settings(ActionEvent event) throws IOException {
    	Navigate.NavigateSettings(event);
    }
    
    public static  void OpenFolder(MouseEvent event) {
    	Navigation.NavigateOpenFolder(event);
    }
    
    
    public static void MarkDone(MouseEvent event) {
    	Button btn = (Button) event.getSource(); 
    	
    	String src = Settings.todo().concat("\\" + btn.getUserData().toString());
    	String des = Settings.done().concat("\\" + btn.getUserData().toString());
    	
    	FileMover.move(src, des);
    }
    
    public static void MarkReject(MouseEvent event) {
    	
    	Button btn = (Button) event.getSource(); 
    	
    	String src = Settings.todo().concat("\\" + btn.getUserData().toString());
    	String des = Settings.reject().concat("\\" + btn.getUserData().toString());
    	
    	FileMover.move(src, des);
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
    
    
    
    public  void refresh() {
    	
    	System.out.println("refresh");
    	Settings.CheckChanges();
    	
    	dockerInitialize();
    	
    	table.getChildren().clear();
   
    	File[] dir = FileList.list(Settings.todo());
    	
    	for(File fol : dir) {
    		
    		VBox vb = live_rows.build(fol.getName(), fol.getPath());
    		
    		table.getChildren().add(vb);
    	}
    	
    	
    }
    
    public  void initialize() {
    	
    	Settings.CheckChanges();
    	
    	dockerInitialize();
    	
    	instance = this;
    	table.getChildren().clear();
   
    	File[] dir = FileList.list(Settings.todo());
    	
    	for(File fol : dir) {
    		
    		
    		VBox vb = live_rows.build(fol.getName(), fol.getPath());
    		
    		table.getChildren().add(vb);
    	}
    	
    	
    }

}