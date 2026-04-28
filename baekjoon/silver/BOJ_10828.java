package baekjoon.silver;

import java.io.*;
import java.util.*;

public class BOJ_10828 {
    static class ArrayStack {
        int top;
        int size;
        int [] stack;

        public ArrayStack(int size) {
            this.size = size;
            stack = new int[size];
            top = -1;
        }

        public void push(int item) {
            stack[++top] = item;
        }

        public int pop() {
            int pop = stack[top];
            stack[top--] = 0;
            return pop;
        }

        public int peek() {
            return stack[top];
        }

        public boolean isEmpty() {
            return top == -1;
        }

        public int size() {
            return top + 1;
        }
    }

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        ArrayStack stack = new ArrayStack(n);

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if(command.equals("push")) {
                int num = Integer.parseInt(st.nextToken());
                stack.push(num);
            } else if(command.equals("pop")) {
                int result = 0;
                if(stack.isEmpty()) {
                    result = -1;
                } else {
                    result = stack.pop();
                }
                System.out.println(result);
            } else if(command.equals("size")) {
                System.out.println(stack.size());
            } else if(command.equals("empty")) {
                boolean empty = stack.isEmpty();
                System.out.println(empty ? "1" : "0");
            } else if(command.equals("top")) {
                int result = 0;
                if(stack.isEmpty()) {
                    result = -1;
                } else {
                    result = stack.peek();
                }
                System.out.println(result);
            }
        }
    }
}
