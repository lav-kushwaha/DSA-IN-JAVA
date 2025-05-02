package Questions.Questions;

import java.util.HashSet;

class findUnion {
    public static int findUnion(int a[], int b[]) {
        // code here
        //Your code here
         HashSet<Integer> s = new HashSet<Integer>();
        for(int i=0;i<a.length;i++) { 
            s.add(a[i]);
        }
        for(int i=0;i<b.length;i++) {
            s.add(b[i]);
        }
        return s.size();
    }
}