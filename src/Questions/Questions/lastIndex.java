package Questions.Questions;

class lastIndex {
    public int lastIndex(String s) {
        
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if(ch == '1') return i;

        }
        return -1;
    }
}