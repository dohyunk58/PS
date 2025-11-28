package baekjoon.silver;

import java.io.*;

public class BOJ_1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        ArrayStack stack = new ArrayStack(n);

        int index = 1;
        stack.push(1); sb.append("+\n");
        int number;
        for(int i = 0; i < n; i++) {

            number = Integer.parseInt(br.readLine());

            if(number > stack.peek()) {
                // number를 추가할 때까지 push
                while(number > index) {
                    sb.append("+\n");
                    stack.push(++index);
                }
            } else if(number < stack.peek()) {
                System.out.println("NO");
                return;
            }

            // peek 값이 찾는 값인 경우
            sb.append("-\n");
            stack.pop();
        }
        System.out.println(sb);
    }

    static class ArrayStack {
        int top;
        int size;
        int[] stack;

        public ArrayStack(int size){
            this.top = -1;
            this.size = size;
            this.stack = new int[size];
        }

        public void push(int e) {
            stack[++top] = e;
        }

        public int pop() {
            int popItem = stack[top];
            stack[top--] = 0;
            return popItem;
        }

        public int peek() {
            if(top < 0) {
                return 0;
            } else {
                return stack[top];
            }
        }
    }
}
