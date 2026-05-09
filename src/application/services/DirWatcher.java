package application.services;

import java.nio.file.*;
import application.controller.LiveController;
import application.settings.Settings;
import javafx.application.Platform;
import java.io.IOException;

public class DirWatcher {

    private static Thread thread;
    
    public static void start() {
    	

        thread = new Thread(() -> {
        	
      
            try (WatchService watchService = FileSystems.getDefault().newWatchService()) {

                Path folder = Paths.get(Settings.todo());
                folder.register(watchService,
                    StandardWatchEventKinds.ENTRY_CREATE,
                    StandardWatchEventKinds.ENTRY_DELETE
                );

                while (true) {
                    WatchKey key = watchService.take(); 

                    for (WatchEvent<?> event : key.pollEvents()) {
                        WatchEvent.Kind<?> kind = event.kind();
                        String name = event.context().toString(); 

                        if (kind == StandardWatchEventKinds.ENTRY_CREATE) {
                        	
                            Platform.runLater(() ->
                              {
                            	  LiveController.instance.refresh();
                            	  Notif.play();
                            	 
                              });
                            System.out.println("CREATED: " + name);

                        }else if(kind == StandardWatchEventKinds.ENTRY_DELETE) {
                        	Platform.runLater(() ->
                            
                        	LiveController.instance.refresh()
                        );
                        	System.out.println("DELETED: " + name);
                        }
                    }

                    key.reset();
                }

            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread.setDaemon(true);
        thread.start();
    }
    
    public static void stop() {
    
    	thread.interrupt();
    }
    
}