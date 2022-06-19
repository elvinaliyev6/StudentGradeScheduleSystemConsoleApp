package az.orient.course.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class MainUtil {




    public static boolean login(String username, String password, String filePath) throws Exception {
        File file=new File(FileUtility.folderPath);
        if(!file.exists()){
            file.mkdir();
        }
        FileReader fr = new FileReader(filePath);
        BufferedReader br = new BufferedReader(fr);
        while (br.ready()) {
            String[] arr = br.readLine().split(" ");
            if (username.equalsIgnoreCase(arr[0]) && password.equalsIgnoreCase(password)) {
                return true;
            }
        }
        return false;
    }






}
