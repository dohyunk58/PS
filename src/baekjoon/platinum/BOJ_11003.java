package baekjoon.platinum;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_11003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Deque<Node> deque = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            int input = Integer.parseInt(st.nextToken());

            // 1. 입력값이 덱의 마지막 값보다 작거나 같은 경우 마지막 값 제거 (먼저 사라지는데 작지도 않으므로 최소값이 될 수 없음)
            while(!deque.isEmpty() && deque.getLast().value >= input) {
                deque.removeLast();
            }

            // 2. 입력값을 맨 뒤에 삽입
            deque.addLast(new Node(i, input));

            // 3. window의 크기를 벗어나는 요소 내보내기
            // i - index >= l => index <= i - l
            if(deque.getFirst().index <= i - l) {
                deque.removeFirst();
            }

            // 4. 최소값 출력하기
            bw.write(deque.getFirst().value + " ");
        }

        bw.flush();
        bw.close();
    }

    static class Node {
        public int index;
        public int value;

        Node(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
}
