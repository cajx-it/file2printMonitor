package application.services;
//import application.settings.Settings;
import java.nio.file.*;
import static java.nio.file.StandardCopyOption.*;


public class FileMover {
	

	
	public static void move(String src, String dest) {
		
        Path source = Paths.get(src);
        Path target = Paths.get(dest);

        try {
            
            Files.move(source, target, REPLACE_EXISTING);
            System.out.println("Directory moved successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}
