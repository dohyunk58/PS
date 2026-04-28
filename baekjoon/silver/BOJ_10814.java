package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Node[] people = new Node[n];

        StringTokenizer st;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            people[i] = new Node(age, name);
        }

        Arrays.sort(people);

        for(int i = 0; i < n; i++) {
            sb.append(people[i].age).append(" ").append(people[i].name).append("\n");
        }

        System.out.print(sb);
    }

    public static class Node implements Comparable<Node> {
        int age;
        String name;

        public Node(int age, String name) {
            this.age = age;
            this.name = name;
        }

        // 객체의 age 값 차를 반환
        @Override
        public int compareTo(Node o) {
            // this: 객체 자신
            // o: 비교대상
            return this.age - o.age;
        }
    }
}
