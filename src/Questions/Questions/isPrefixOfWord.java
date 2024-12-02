package Questions.Questions;

//https://leetcode.com/problems/check-if-a-word-occurs-as-a-prefix-of-any-word-in-a-sentence/description/
//1455. Check If a Word Occurs As a Prefix of Any Word in a Sentence
class isPrefixOfWord {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] arr = sentence.split(" ");               
        int n=arr.length;
        
        for(int i=0; i<n; i++){
            if(arr[i].startsWith(searchWord)){                
                return i+1;
            }
        }
        return -1;
    }
}