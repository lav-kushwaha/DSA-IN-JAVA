package Questions.Questions;

//https://leetcode.com/problems/counting-words-with-a-given-prefix/description/
//2185. Counting Words With a Given Prefix
class prefixCount {
    public int prefixCount(String[] words, String pref) {
        int count = 0;;
        int n = pref.length();
        for(String word : words){
            if(word.length()>=n && word.startsWith(pref)){
                count++;
            }
        }
        return count;
    }
}