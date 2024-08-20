package _25_KarpRabin;

//Karp-Rabin String Matching Algorithm

public class KarpRabin {

    private final int PRIME = 101;

    private long calculateHash(String str, int length) {
        long hash = 0;

        for (int i = 0; i < length; i++) {
            hash = (hash * PRIME + str.charAt(i)) % Long.MAX_VALUE;
        }

        return hash;
    }

    // One char removed and one char added.
    private long updateHash(long prevHash, char oldChar, char newChar, int patternLength) {
        long newHash = prevHash - oldChar * (long) Math.pow(PRIME, patternLength - 1);
        newHash = (newHash * PRIME + newChar) % Long.MAX_VALUE;

        if (newHash < 0) {
            newHash += Long.MAX_VALUE;
        }

        return newHash;
    }

    public void search(String text, String pattern) {
        
        if (pattern.length() > text.length() || pattern.isEmpty() || text.isEmpty()) {
            System.out.println("No valid pattern found.");
            return;
        }

        int patternLength = pattern.length();
        long patternHash = calculateHash(pattern, patternLength);
        long textHash = calculateHash(text, patternLength);

        for (int i = 0; i <= text.length() - patternLength; i++) {
            if (textHash == patternHash && text.substring(i, i + patternLength).equals(pattern)) {
                System.out.println("Pattern found at index: " + i);
            }
            if (i < text.length() - patternLength) {
                textHash = updateHash(textHash, text.charAt(i), text.charAt(i + patternLength), patternLength);
            }
        }
    }

    public static void main(String[] args) {
        KarpRabin karp = new KarpRabin();
        karp.search("kushwaha", "ush");
    }
}
