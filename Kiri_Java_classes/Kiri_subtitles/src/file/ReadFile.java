package file;

import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.*;

public class ReadFile {
    public static String getFullPath(String filename) {
        String path = System.getProperty("user.dir");
        String whole_path = path + "/src/file/" + filename;
//        System.out.println(whole_path);
//        System.out.println("/home/cosc/student/ejd83/IdeaProjects/Kiri_subtitles/src/file" + "/pop phrases.txt");
        return whole_path;
    }


    public static Deque<String> getNewPhrases() {
        Deque<String> deque
                = new LinkedList<String>();
        try {
            String path = System.getProperty("user.dir");
            String whole_path = getFullPath("pop phrases.txt");
            File myObj = new File(whole_path);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
//                    System.out.println(data);
                if (!data.equals("")) {
                    deque.add(data);
                }
            }
    //                System.out.println(deque);
            myReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return deque;
    }

    public static String getPhrase() {
        Deque<String> phrases = getNewPhrases();
        return phrases.pop();
    }

    public static void writePhrase(String engPhrase, String kirPhrase, Boolean newPhrase) {
        try {
            String filepath = getFullPath("bl_phrases.txt");
            if (newPhrase) filepath = getFullPath("new_phrases.txt");

            FileWriter myWriter = new FileWriter(filepath, true);
            myWriter.write(engPhrase + " : " + kirPhrase + "\n\n");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();

        }
    }

    public static void main(String[] args) {
        Deque<String> phrases = getNewPhrases();
        System.out.println(phrases);
        System.out.println(getPhrase());
        writePhrase("hi", "hi", Boolean.TRUE);
        writePhrase("hi", "hi", Boolean.FALSE);
    }

}