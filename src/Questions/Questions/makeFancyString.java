package Questions.Questions;

//https://leetcode.com/problems/delete-characters-to-make-fancy-string/
//1957. Delete Characters to Make Fancy String

class makeFancyString {
    public String makeFancyString(String s) {
       StringBuilder str = new StringBuilder();
       str.append(s.charAt(0));
       int count = 1;
       for(int i=1;i<s.length();i++){
          if(s.charAt(i)==str.charAt(str.length()-1)){
            count++;
            if(count<=2){
                str.append(s.charAt(i));
            }
          }else{
            count = 1;
            str.append(s.charAt(i));
          }
       }
       return str.toString();
    }
}
