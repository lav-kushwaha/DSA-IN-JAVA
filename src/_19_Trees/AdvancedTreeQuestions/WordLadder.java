package _19_Trees.AdvancedTreeQuestions;

import java.util.*;

public class WordLadder {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;

        Set<String> visited = new HashSet<>();//1
        Queue<String> queue = new LinkedList<>();//2 new begin word "hot".
        queue.offer(beginWord);
        visited.add(beginWord);//marked the beginning word visited.
        int length = 1;//2,3,4,5

        while (!queue.isEmpty()){
            int size = queue.size();//1
            length++;

            for(int i=0;i<size;i++){//0
                String current = queue.poll();
                for (int j=0;j<current.length();j++){//0,1,2

                    char[] temp = current.toCharArray(); //{'d','o','g'}
                    // Change character one by one and check if the new word is in wordSet
                    for(char ch = 'a';ch<='z';ch++){

                        temp[j] = ch;
                        String newWord = new String(temp);

                        if(newWord.equals(endWord)){//i.e, ait == cog
                            return length;
                        }

                        if(wordList.contains(newWord) && !visited.contains(newWord)){
                            queue.offer(newWord);
                            visited.add(newWord);
                        }
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String[] wordList = {"hot","dot","dog","lot","log","cog"};
        String beginWord = "hit";
        String endWord = "cog";
        System.out.println(ladderLength(beginWord,endWord, List.of(wordList)));
    }
}
