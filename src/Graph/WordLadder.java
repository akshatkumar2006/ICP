package Graph;

import java.util.*;

public class WordLadder {
	
	class Solution {
	    // private boolean isOneLetterDiff(String a, String b) {
	    //     int diff = 0;
	    //     for (int i = 0; i < a.length(); i++) {
	    //         if (a.charAt(i) != b.charAt(i)) {
	    //             diff++;
	    //             if (diff > 1) return false;
	    //         }
	    //     }
	    //     return diff == 1;
	    // }

	    // public int ladderLength(String beginWord, String endWord, List<String> wordList) {

	    //     if (!wordList.contains(endWord)) return 0;

	    //     HashMap<String, List<String>> graph = new HashMap<>();

	    //     for (String word : wordList) {
	    //         graph.put(word, new ArrayList<>());
	    //     }
	    //     graph.put(beginWord, new ArrayList<>());

	    //     // connect wordList words
	    //     for (int i = 0; i < wordList.size(); i++) {
	    //         for (int j = i + 1; j < wordList.size(); j++) {
	    //             String w1 = wordList.get(i);
	    //             String w2 = wordList.get(j);

	    //             if (isOneLetterDiff(w1, w2)) {
	    //                 graph.get(w1).add(w2);
	    //                 graph.get(w2).add(w1);
	    //             }
	    //         }
	    //     }

	    //     // connect beginWord
	    //     for (String word : wordList) {
	    //         if (isOneLetterDiff(beginWord, word)) {
	    //             graph.get(beginWord).add(word);
	    //         }
	    //     }

	    //     // BFS
	    //     Queue<String> q = new LinkedList<>();
	    //     Set<String> visited = new HashSet<>();

	    //     q.add(beginWord);
	    //     visited.add(beginWord);
	    //     int level = 1;

	    //     while (!q.isEmpty()) {
	    //         int size = q.size();

	    //         for (int i = 0; i < size; i++) {
	    //             String curr = q.poll();

	    //             if (curr.equals(endWord)) return level;

	    //             for (String neigh : graph.get(curr)) {
	    //                 if (!visited.contains(neigh)) {
	    //                     visited.add(neigh);
	    //                     q.add(neigh);
	    //                 }
	    //             }
	    //         }
	    //         level++;
	    //     }

	    //     return 0;
	    // }
	    
	    public int ladderLength(String beginWord, String endWord, List<String> wordList) { // O(N . L^2)––––
	        HashSet<String> set = new HashSet<>(wordList); // O(N)

	        if (!set.contains(endWord))
	            return 0;

	        if (beginWord == endWord)
	            return 0;

	        Queue<String> q = new LinkedList<>();
	        q.offer(beginWord);

	        int level = 1;

	        while(!q.isEmpty()){ // O(N)
	            int size = q.size();

	            for(int i = 0; i < size; i++){
	                String curr = q.poll();

	                if(curr.equals(endWord)) return level;

	                char[] a = curr.toCharArray(); // O(L)
	                int len = a.length;
	                for(int j = 0; j < len; j++){ // O(L)
	                    char ch = a[j];

	                    for(char temp = 'a'; temp <= 'z'; temp++){ // O(26)
	                        a[j] = temp;

	                        String nCurr = new String(a); // O(L)

	                        if(set.contains(nCurr)){
	                            q.offer(nCurr);
	                            set.remove(nCurr);
	                        }
	                    }

	                    a[j] = ch;
	                }
	            }

	            level++;
	        }

	        return 0;
	    }

	    // public int ladderLength(String beginWord, String endWord, List<String> wordList) {
	    //     HashSet<String> set = new HashSet<>(wordList);

	    //     if (!set.contains(endWord))
	    //         return 0;

	    //     if (beginWord == endWord)
	    //         return 0;

	    //     HashMap<String, List<String>> map = new HashMap<>();

	    //     for (String word : set) {
	    //         for (int i = 0; i < word.length(); i++) {
	    //             String pattern = word.substring(0, i) + "*" + word.substring(i + 1);
	    //             map.computeIfAbsent(pattern, k -> new ArrayList<>()).add(word);
	    //         }
	    //     }

	    //     Queue<String> q = new LinkedList<>();
	    //     q.offer(beginWord);

	    //     HashSet<String> visited = new HashSet<>();
	    //     visited.add(beginWord);

	    //     int level = 1;

	    //     while(!q.isEmpty()){
	    //         int size = q.size();

	    //         for (int i = 0; i < size; i++) {
	    //             String curr = q.poll();

	    //             if (curr.equals(endWord)) return level;

	    //             for (int j = 0; j < curr.length(); j++) {
	    //                 String pattern = curr.substring(0, j) + "*" + curr.substring(j + 1);

	    //                 for (String next : map.getOrDefault(pattern, new ArrayList<>())) {
	    //                     if (!visited.contains(next)) {
	    //                         visited.add(next);
	    //                         q.offer(next);
	    //                     }
	    //                 }
	    //             }
	    //         }
	    //         level++;
	    //     }

	    //     return 0;
	    // }
	}
}
