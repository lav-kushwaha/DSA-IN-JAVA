package _24_Intro_To_HashMap_And_HashTable.KarpRabin;

//KarbRabin String Matching Algorithm
public class KarpRabin {
    private final int PRIME = 101;

    private long calculateHash(String str){
        long hash = 0;

        for(int i=0;i<str.length();i++){
            hash = (long) (hash + str.charAt(i) * Math.pow(PRIME,i));
        }

        return hash;
    }

}
