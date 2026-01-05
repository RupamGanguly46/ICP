package dec31;
import java.util.*;
public class TrieClass {
    public static class Trie{
        static class Node{
            Node[] next;
            boolean end;
        }

        private Node root;

        public Trie(){
            root = new Node();
        }

        public void insert(String word){
            Node cur = root;
            for(char c: word.toCharArray()){
                int idx = c - 'a';

                if(cur.next[idx]==null) cur.next[idx] = new Node();
                cur = cur.next[idx];
            }

            cur.end = true;
        }

        public boolean startWith(String word){
            Node curr = root;
            for(char c: word){
                int idx = c - 'a';
                if(curr.next[idx]) return false;
            }
        }
    }
    public static void main(String[] args) {
        Trie t = new Trie();
    }

}

// Used in string compression, eg. size compression of pdfs
// O(n * m) -> O(log m) where m is max length of string
