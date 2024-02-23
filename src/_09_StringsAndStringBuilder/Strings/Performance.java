package _09_StringsAndStringBuilder.Strings;
public class Performance {
    public static void main(String[] args) {
     //code to print Ascii char.
        String series ="";
        //It is creating new object everytime like a then ab then abc then abcd til atoz.
        for(int i=0;i<26;i++){
            int num = 'a'+i;
            char ch =(char)('a'+i);
            series+=ch;
            System.out.print(num+" ");
            System.out.println(ch+" ");
        }
        System.out.println(series);
    }
}
