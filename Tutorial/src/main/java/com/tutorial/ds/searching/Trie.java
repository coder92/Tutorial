package com.tutorial.ds.searching;

public class Trie {
    static int maxChildrenSize =26;
    static TrieNode root;

    /**
     *
     * @param key
     * @return true if inserted successfully else otherwise
     */
    public boolean insert(String key){

        int level;
        int length = key.length();
        int index;

        TrieNode pCrawl = root;

        for (level = 0; level < length; level++)
        {
            index = key.charAt(level) - 'a';
            if (pCrawl.children[index] == null)
                pCrawl.children[index] = new TrieNode();

            pCrawl = pCrawl.children[index];
        }

        // mark last node as leaf
        pCrawl.isEndOfWord = true;
        return true;
    }

    public boolean search(String key){
        int level;
        int length = key.length();
        int index;
        TrieNode pCrawl = root;

        for (level = 0; level < length; level++)
        {
            index = key.charAt(level) - 'a';

            if (pCrawl.children[index] == null)
                return false;

            pCrawl = pCrawl.children[index];
        }

        return (pCrawl != null && pCrawl.isEndOfWord);
    }

    /**
     * subNode method is for finding the childNode is present with the given data or not.
     * @param root
     * @param data
     * @return child node with given data
     */
    public TrieNode subNode(TrieNode root, char data){
        if(root!=null){
            for(int i=0;i<maxChildrenSize;i++){
                if(root.children[i].data==data){
                    return root.children[i];
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        String[] keys = {"the", "a", "there", "answer", "any", "by", "bye", "their"};

        root = new TrieNode();



    }
}

class TrieNode{
    TrieNode children[];
    boolean isEndOfWord;
    char data;

    public TrieNode(){
        children = new TrieNode[Trie.maxChildrenSize];
        isEndOfWord = false;

        for(int i=0;i<Trie.maxChildrenSize;i++){
            children[i] = null;
        }
    }
}
