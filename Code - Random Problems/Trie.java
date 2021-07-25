import java.util.*;

class Node {
    Map<Character, Node> children;
    boolean isWord;

    public Node() {
        children = new HashMap<Character, Node>();
        isWord = false;
    }
}

class Trie {
    private Node root;

    // Initialize your data structure here.
    public Trie() {
        root = new Node();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            Node temp = curr.children.get(word.charAt(i));
            if (temp == null) {
                temp = new Node();
                curr.children.put(word.charAt(i), temp);
            }
            curr = temp;
        }
        curr.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node curr = root; 
        for (int i = 0; i < word.length(); i++) {
            curr = curr.children.get(word.charAt(i));
            if (curr == null) {
                return false;
            }
        }
        return curr.isWord;
    }
    
    public Node search(Node trieNode, char c) {
        return trieNode.children.get(c);
    }

    /** Returns if there is any word in the trie that starts w ith the given prefix. */
    public boolean startsWith(String prefix) {
        Node curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            curr = curr.children.get(prefix.charAt(i));
            if (curr == null) {
                return false;
            }
        }
        return true;
    }
}