package _22_FileHandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileHandling {
    public static void main(String[] args) {
        //INPUT STREAM :
        // We are taking data in byte stream and putting it out in char stream
//        try(InputStreamReader isr = new InputStreamReader(System.in)){
//            System.out.print("Enter some letters:");
//            int letters = isr.read();//we are taking int here because read() method returns int.
//            while(isr.ready()){
//                System.out.println((char)letters);
//                letters = isr.read(); // The read() method reads one character or byte at a time. It is found in classes like InputStream and Reader.
//            }
//            System.out.println();
//        }
//        catch(IOException e){
//            System.out.println(e.getMessage());
//        }

        //CHAR STREAM :
        //This code is intended to read characters from a file and print them to the console.

        //Replace with the absolute path to your note.txt file.
        //String filePath = "A:\\path\\to\\your\\note.txt"; // For Windows

        String filePath = "A:/DSA-IN-JAVA/src/_22_FileHandling/note.txt"; // Using forward slashes in the path

        try (FileReader fr = new FileReader(filePath)) {
            int letters;
            //fr.read() assign to letters.
            while ((letters = fr.read()) != -1) { // reads one character at a time
                System.out.print((char) letters);
            }
            System.out.println();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

//        //BUFFER READER :
//        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));//for fast input and output in java for competitive programing use this line.
//        //byte to char stream and then reading char stream.
//        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
//            System.out.println("Enter something: ");
//            System.out.println("You typed: "+ br.readLine());//ReadLine() - reads one line at a time
//        } catch (IOException e){
//            System.out.println(e.getMessage());
//        }
//
//        //you can add any reader type used in BUFFER READER.
//        try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
//            while (br.ready()){ //ready() means, Tells whether this stream is ready to be read.
//                System.out.println(br.readLine());//ReadLine() - reads one line at a time
//            }
//        }
//        catch (IOException e){
//            System.out.println(e.getMessage());
//        }

    }
}
