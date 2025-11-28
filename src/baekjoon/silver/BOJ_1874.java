package baekjoon.silver;

import java.io.*;

public class BOJ_1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        ArrayStack stack = new ArrayStack(n);

        int counter = 1;
        int index = 1;
        stack.push(1); sb.append("+\n");
        int number = Integer.parseInt(br.readLine());
        while(true) {
            if(number == stack.peek()) {
                sb.append("-\n");
                int popNum = stack.pop();

                counter++;
                if(counter > n) {
                    System.out.println(sb);
                    break;
                }

                // 다음 숫자로 넘어감
                number = Integer.parseInt(br.readLine());
                // 입력값 검증
                if(number > n) {
                    System.out.println("NO");
                    break;
                }
            } else if(number > stack.peek()) {
                sb.append("+\n");
                stack.push(++index);
            } else if(number < stack.peek()) {
                System.out.println("NO");
                break;
            }
        }
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
