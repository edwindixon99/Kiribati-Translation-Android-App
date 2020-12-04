package file;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.*;

public class ReadFile {
    public static void main(String[] args) {
        try {
            String path = System.getProperty("user.dir");
            String whole_path = path + "/src/file/pop phrases.txt";
            System.out.println(whole_path);
            System.out.println("/home/cosc/student/ejd83/IdeaProjects/Kiri_subtitles/src/file" + "/pop phrases.txt");
            File file1 = new File(whole_path);


            if (!file1.exists()) {
                System.out.println("System couldnt file source file!");
                System.out.println("Application will explode");
            } else {
                Deque<String> deque
                        = new LinkedList<String>();

                File myObj = new File(whole_path);
                Scanner myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
//                    System.out.println(data);
                    if (!data.equals("")) {
                        deque.add(data);
                    }
                }
                System.out.println(deque);
                myReader.close();
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}