package application.services;

import java.io.File;
import java.util.Arrays;

public class FileList {

    public static File[] list(String path) {

        File dir = new File(path);
        File[] subfolders = dir.listFiles(File::isDirectory);

        
        Arrays.sort(subfolders, (a, b) -> 
            Long.compare(a.lastModified(), b.lastModified())
        );

        return subfolders;
    }
}