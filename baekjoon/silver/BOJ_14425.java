package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14425 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Trie trie = new Trie();

        for (int i = 0; i < n; i++) {
            trie.insert(br.readLine());
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            if(trie.search(br.readLine())) count++;
        }

        System.out.print(count);
    }

    static class Node {
        Node[] child = new Node[26];
        boolean endOfWord = false;
    }

    public static class Trie {
        Node root;

        public Trie(){
            this.root = new Node();
        }

        public void insert(String str) {
            Node now = this.root;

            for (int c : str.toCharArray()) {
                int idx = c - 'a'; // 소문자 a-z 를 0-25 매핑

                // 자식 노드(배열)에 동일한 문자가 없으면 넣기
                if (now.child[idx] == null) {
                    now.child[idx] = new Node();
                }
                now = now.child[idx];
            }
            now.endOfWord = true;
        }

        public boolean search(String str) {
            Node now = this.root;

            for (int c : str.toCharArray()) {
                int idx = c - 'a';

                if (now.child[idx] == null) {
                    return false;
                }
                now = now.child[idx];
            }
            // 끝까지 탐색한 경우 단어의 끝인지 여부를 반환
            return now.endOfWord;
        }
    }
}
