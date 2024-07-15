package _22_FileHandling;

import java.io.*;

public class Output1 {
    public static void main(String[] args) {
        //creating a file.
        try{
            File fo = new File("A:/DSA-IN-JAVA/src/_22_FileHandling/new-file.txt");
            fo.createNewFile();
        } catch(IOException e){
            System.out.println(e.getMessage());
        }

        //write in the file
        try {
            FileWriter fw = new FileWriter("A:/DSA-IN-JAVA/src/_22_FileHandling/new-file.txt");
            fw.write("Hello, Lav"); //this Hello, Lav will be written inside the new-file.txt
            fw.close(); // Close the FileWriter to release resources
        } catch(IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }

        //Reading from a file.
        try(BufferedReader br = new BufferedReader(new FileReader("A:/DSA-IN-JAVA/src/_22_FileHandling/new-file.txt"))){
            while (br.ready()){
                System.out.println(br.readLine());//ReadLine() - reads one line at a time
            }
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }


        //delete a file.
        try{
            File fo = new File("A:/DSA-IN-JAVA/src/_22_FileHandling/file.txt");
            fo.createNewFile();
        } catch(IOException e){
            System.out.println(e.getMessage());
        }

//        try{
//            File fo = new File("A:/DSA-IN-JAVA/src/_22_FileHandling/file.txt");
//            fo.createNewFile();
//        } catch(IOException e){
//            System.out.println(e.getMessage());
//        }

    }
}
