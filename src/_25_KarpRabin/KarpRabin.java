package _25_KarpRabin;

public class KarpRabin {
    private final int PRIME = 101;
    private final long MOD = 1_000_000_007; // A large prime modulus to prevent overflow

    //Computes a hash value for a given string str.
    private long calculateHash(String str) {
        long hash = 0;
        for (int i = 0; i < str.length(); i++) {
            hash = (hash * PRIME + str.charAt(i)) % MOD;
        }
        return hash;
    }

    //Updates the hash value when sliding the window over the text.
    private long updateHash(long prevHash, char oldChar, char newChar, long primePower) {
        long newHash = (prevHash - oldChar * primePower) % MOD;
        newHash = (newHash * PRIME + newChar) % MOD;

        if (newHash < 0) {
            newHash += MOD; // Make sure the hash is non-negative
        }

        return newHash;
    }

    public void search(String text, String pattern) {
        int patternLength = pattern.length();

        if (patternLength > text.length() || pattern.isEmpty() || text.isEmpty()) {
            System.out.println("No valid pattern found.");
            return;
        }

        long primePower = 1;
        for (int i = 0; i < patternLength - 1; i++) {
            primePower = (primePower * PRIME) % MOD;
        }

        long patternHash = calculateHash(pattern);
        long textHash = calculateHash(text.substring(0, patternLength));

        for (int i = 0; i <= text.length() - patternLength; i++) {
            if (textHash == patternHash && text.substring(i, i + patternLength).equals(pattern)) {
                System.out.println("Pattern found at index " + i);
            }

            if (i < text.length() - patternLength) {
                textHash = updateHash(textHash, text.charAt(i), text.charAt(i + patternLength), primePower);
            }
        }
    }

    public static void main(String[] args) {
        KarpRabin karp = new KarpRabin();
        karp.search("lavkushwaha", "waha");
        karp.search("abracadabra", "abra");
        karp.search("aaaaaaaa", "aa");
        karp.search("hello world", "world");
        karp.search("abcde", "fgh");
    }
}
