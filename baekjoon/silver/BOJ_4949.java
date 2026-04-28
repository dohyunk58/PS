package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_4949 {
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String str = br.readLine();
            if (str.equals(".")) break;

            Stack<Boolean> stack = new Stack<>(); // ( true [ false

            char[] chars = str.toCharArray();
            boolean isBalanced = true;
            for (char c : chars) {
                if (c == '(') {
                    stack.add(true);
                } else if (c == '[') {
                    stack.add(false);
                } else if (c == ')') {
                    if (stack.isEmpty() || stack.pop() != true) { // 마지막이 (가 아닌 경우
                        isBalanced = false;
                        break;
                    }
                } else if (c == ']') {
                    if (stack.isEmpty() || stack.pop() != false) { // 마지막이 [가 아닌 경우
                        isBalanced = false;
                        break;
                    }
                }
            }

            if (stack.isEmpty() && isBalanced) sb.append("yes").append("\n");
            else sb.append("no").append("\n");
        }
        br.close();
        System.out.print(sb);
    }
}
