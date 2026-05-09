package application.Navigation;

import java.io.IOException;

import application.services.FileDelete;
import application.services.FileOpen;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Navigation {
	
    public void NavigateTodo(ActionEvent event) throws IOException {
    	System.out.println("todo");
    	Parent done = FXMLLoader.load(getClass().getResource("../views/live.fxml"));
    	Scene scene = new Scene(done);
    	
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	window.setScene(scene);
    	window.show();
    }
    
    public void NavigateDone(ActionEvent event) throws IOException {
    	
    	System.out.println("done");
    	Parent done = FXMLLoader.load(getClass().getResource("../views/done.fxml"));
    	Scene scene = new Scene(done);
    	
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	window.setScene(scene);
    	window.show();
    }
    
    public void NavigateReject(ActionEvent event) throws IOException {
    	
    	System.out.println("reject");
    	Parent done = FXMLLoader.load(getClass().getResource("../views/rejected.fxml"));
    	Scene scene = new Scene(done);
    	
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	window.setScene(scene);
    	window.show();
    }
    
    public void NavigateSettings(ActionEvent event) throws IOException {
    	
    	System.out.println("settings");
    	Parent done = FXMLLoader.load(getClass().getResource("../views/settings.fxml"));
    	Scene scene = new Scene(done);
    	
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	window.setScene(scene);
    	window.show();
    }
    
    public static void NavigateOpenFolder(MouseEvent event) {
    	Button btn = (Button) event.getSource(); 
    	FileOpen.open(btn.getUserData().toString());
    }
    
    public static  void NavigationDeleteFolder(MouseEvent event) {
    	Button btn = (Button) event.getSource(); 
    	FileDelete.delete(btn.getUserData().toString());
    }

}
