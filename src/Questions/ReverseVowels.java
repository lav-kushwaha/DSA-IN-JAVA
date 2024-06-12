package Questions;

//https://www.geeksforgeeks.org/problems/reversing-the-vowels5304/0

class ReverseVowels
{
    static String modify(String s)
    {
         // your code here
        char[] chars = s.toCharArray();
        int i = 0, j = chars.length - 1;
        String vowels = "aeiouAEIOU";

        while (i < j) {
            while (i < j && !vowels.contains(chars[i] + ""))
                i++;
            while (i < j && !vowels.contains(chars[j] + ""))
                j--;

            if (i < j) {
                char temp = chars[i];
                chars[i] = chars[j];
                chars[j] = temp;
                i++;
                j--;
            }
        }
        return new String(chars); //return Sting 
    }

    public static void main(String[] args) {
        String ans = modify("Lavkushwaha");
        System.out.println(ans);

    }
}
