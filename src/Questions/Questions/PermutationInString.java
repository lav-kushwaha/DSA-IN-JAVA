package Questions.Questions;

//https://leetcode.com/problems/permutation-in-string/description/
//567. Permutation in String

class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int [] arr1 = new int[26];

        for(int i=0;i<n;i++){
            arr1[s1.charAt(i) - 'a']++;
        }

        for(int i=0;i<=m-n;i++){
            int [] arr2 = new int[26];
            for(int j=0;j<n;j++){
                arr2[s2.charAt(i+j) - 'a']++;
            }
            if(isMatch(arr1,arr2)) 
            return true;
        }
        return false;
    }

    public boolean isMatch(int[] arr1, int[] arr2){
        for(int i=0;i<26;i++){
            if(arr1[i]!=arr2[i]){
                return false;
            }
        }
        return true;
    }
}
