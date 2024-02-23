package _09_StringsAndStringBuilder.Strings.Questions;

public class Pallindrome {
    public static void main(String[] args) {
        String str= "MAAM";
        String reverse = "";
        for (int i=str.length()-1;i>=0;i--){
            reverse+=str.charAt(i);
        }
        if(str.equals(reverse)){ //equals will be check the values.
            System.out.println("It is pallindrome");
        }
        else{
            System.out.println("It is not pallindrome");
        }

    }
}
