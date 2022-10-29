package recursion;

import java.io.File;
import java.io.IOException;

public class FindAllFilesRecursive {

    public static void findAllFilesInDirectory(File startDirectory) {
        try {
            File[] files = startDirectory.listFiles();
            for (File file : files) {
                if (file.isDirectory()) {
                    System.out.println("directory:" + file.getCanonicalPath());
                    findAllFilesInDirectory(file);
                } else {
                    System.out.println("     file:" + file.getCanonicalPath());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
