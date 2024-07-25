package trie_pattern;

import java.util.HashMap;

public class Trie {

    public static class TrieNode {
        public HashMap<Character, TrieNode> children;
        public boolean isEnd;

        public TrieNode() {
            children = new HashMap<>();
            isEnd = false;
        }
    }
    
    public TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
  
    public void insert(String word) {
        TrieNode cur = root;
        for (Character c : word.toCharArray()) {
            if (!cur.children.containsKey(c)) {
               cur.children.put(c, new TrieNode());
            }

            cur = cur.children.get(c);
        }

        cur.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode cur = root;
        for (Character c : word.toCharArray()) {
            if (!cur.children.containsKey(c)) {
                return false;
            }
            cur = cur.children.get(c);
        }
        return cur.isEnd;
    }

    public boolean startsWith(String word) {
        TrieNode cur = root;
        for (Character c : word.toCharArray()) {
            if (!cur.children.containsKey(c)) {
                return false;
            }

            cur = cur.children.get(c);
        }
        return true;
    }
}




