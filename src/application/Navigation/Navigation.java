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
	
	//MAIN NAVIGATION
    public void Navigate(ActionEvent event, int page) throws IOException {
    	
    	String todo = "../views/live.fxml";
    	String done = "../views/done.fxml";
    	String reject = "../views/rejected.fxml";
    	String settings = "../views/settings.fxml";
    	
    	Parent parent = null;
    	
    	if(page == 1) {
    		System.out.println("todo");
    		parent = FXMLLoader.load(getClass().getResource(todo));
    		//live
    	}else if(page == 2) {
    		System.out.println("done");
    		parent = FXMLLoader.load(getClass().getResource(done));
    		//done
    	}else if(page == 3) {
    		System.out.println("reject");
    		parent = FXMLLoader.load(getClass().getResource(reject));
    		//reject
    	}else if(page == 4) {
    		System.out.println("settings");
    		parent = FXMLLoader.load(getClass().getResource(settings));
    		//settings
    	}
    	
    	Scene scene = new Scene(parent);
    	//GET THE SAME WINDOW
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	window.setScene(scene);
    	window.show();
    }
	
 
    //OPEN FOLDER
    public static void NavigateOpenFolder(MouseEvent event) {
    	Button btn = (Button) event.getSource(); 
    	FileOpen.open(btn.getUserData().toString());
    }
    
    
    //DELETE FOLDER
    public static  void NavigationDeleteFolder(MouseEvent event) {
    	Button btn = (Button) event.getSource(); 
    	FileDelete.delete(btn.getUserData().toString());
    }

}
