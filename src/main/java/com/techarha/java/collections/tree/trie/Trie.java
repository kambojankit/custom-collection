package com.techarha.java.collections.tree.trie;

import java.util.HashMap;

import static java.util.Objects.isNull;

public class Trie {

    public static class TrieNode {
        private static int NUMBER_OF_CHARS = 26;
        TrieNode[] children = new TrieNode[NUMBER_OF_CHARS];
        boolean isCompleteWord;
        int size;

        private static int getCharIndex(char c) {
            return c - 'a';
        }

        private TrieNode getNode(char c) {
            return children[getCharIndex(c)];
        }

        private void setNode(char c, TrieNode trieNode) {
            children[getCharIndex(c)] = trieNode;
        }

        public void add(String s) {
            add(s, 0);
        }

        public void add(String s, int index) {
            size++;
            if(index == s.length()) return;

            char current = s.charAt(index);
            int charCode = getCharIndex(current);

            TrieNode childNode = children[charCode];

            if(isNull(childNode)) {
                childNode = new TrieNode();
                setNode(current, childNode);
            }
            childNode.add(s, index+1);
        }

        public int findCount(String s, int index) {
            if(s.length() == index) {
                return size;
            }

            TrieNode child = getNode(s.charAt(index));
            if(isNull(child)) return 0;

            return child.findCount(s, index + 1);
        }
    }
}
