package _22_FileHandling;

import java.io.*;

class Output {
    static void output() {
        //OUTPUT STREAM : - An OutputStreamWriter is a bridge from character streams to byte streams:
//        OutputStreamWriter osw = new OutputStreamWriter(System.out); //ending with writer mean it take charByte
//        osw.write(😊);//range is exceeded
//        try(OutputStreamWriter osw1 = new OutputStreamWriter(System.out)){
//            osw1.write("Hello world");//Hello world
//            osw1.write('\n');
//            osw1.write(97);//a
//            osw1.write(10);
//            osw1.write('A');//A
//            char[] arr = "Hello world".toCharArray();
//            osw1.write(arr);
//        } catch (IOException e){
//            System.out.println(e.getMessage());
//        }

        //FILE WRITER :
//        String filePath1 = "A:/DSA-IN-JAVA/src/_22_FileHandling/note.txt"; // Using forward slashes in the path
//        try(FileWriter fw = new FileWriter(filePath1)){
//            fw.write("Hello world this should be appended");
//        } catch (IOException e){
//            System.out.println(e.getMessage());
//        }

        //BUFFER WRITER :
        String filePath2 = "A:/DSA-IN-JAVA/src/_22_FileHandling/note.txt"; // Using forward slashes in the path
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(filePath2))){
            bw.write("Hare Krishna");
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        output();
    }
}