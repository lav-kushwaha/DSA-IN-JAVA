package Questions.Questions;

//https://www.geeksforgeeks.org/problems/vowel-or-not0831/0
//Vowel or Not

class VowelorNot {
    static String isVowel(char c){
        // code here
        String x="";
        if(c=='A'||c=='E'||c=='I'||c=='O'||c=='U'||c=='a'||c=='e'||c=='i'||c=='o'||c=='u')//aeiou
        {
          x="YES";
        }
        else{
            x="NO";
        }
        return x;
    }

    public static void main(String[] args) {
        String ans = isVowel('l'); //calling a method
        System.out.println(ans); //print vowels or not
    }
}
