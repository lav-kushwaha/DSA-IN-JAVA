package Questions.Questions;

class check {
    Boolean check(String s) {
        // your code here
        for(int i=0;i<s.length()-1;i++){
            if((s.charAt(i))!=(s.charAt(0))) 
            return false;
        }
        return true;
    }
}