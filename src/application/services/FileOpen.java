package application.services;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class FileOpen {
    public static void open(String path) {
        File folder = new File(path); 
        try {
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(folder);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
