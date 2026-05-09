package application.services;

import java.io.File;

public class FileDelete {

    public static void delete(String path) {

        File file = new File(path);

        deleteRecursively(file);

        System.out.println("Deleted: " + path);
    }

    private static void deleteRecursively(File file) {
    	
        if (file.isDirectory()) {
            File[] files = file.listFiles();

            if (files != null) {
                for (File f : files) {
                    deleteRecursively(f); 
                }
            }
        }

        file.delete(); 
    }
}