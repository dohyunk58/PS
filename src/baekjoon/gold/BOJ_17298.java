package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        ArrauStack stack = new ArrauStack(n);

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = new int[n];
        for(int i = 0; i < n; i++) {
            int number = arr[i]; // 이번 회차에 비교할 숫자

            // 스택이 비어있거나 스택 top에 해당하는 숫자가 더 크다면 이번 숫자를 스택에 넣음
            if(stack.isEmpty() || arr[stack.peek()] >= number) {
                stack.push(i);
            } else if(arr[stack.peek()] < number) { // 오큰수를 찾음
                // 스택 top에 해당하는 숫자가 비교하는 숫자와 작으면 비교하는 숫자가 오큰수이므로 스택 내에 동일한 조건의 수를 모두 처리함
                while(!stack.isEmpty() && arr[stack.peek()] < number) {
                    // 오큰수를 찾으면 인덱스를 반환받아서 결과 배열 해당 인덱스에 비교하는 수를 넣음
                    int index = stack.pop();
                    result[index] = number;
                }

                // 다 끝났다면 number의 인덱스를 stack에 넣는다
                stack.push(i);
            }
        }

        // 반복이 다 끝나고 여전히 스택에 남아있는 인덱스는 오큰수가 없으므로 -1을 저장한다.
        while(!stack.isEmpty()) {
            int index = stack.pop();
            result[index] = -1;
        }

        for(int i = 0; i < n; i++) {
            sb.append(result[i] + " ");
        }
        System.out.println(sb);
    }

    static class ArrauStack {
        int top;
        int size;
        int[] stack;

        public ArrauStack(int size) {
            this.size = size;
            this.top = -1;
            stack = new int[size];
        }

        public void push(int e) {
            stack[++top] = e;
        }

        public int pop() {
            int number = stack[top];
            stack[top--] = 0;
            return number;
        }

        public int peek() {
            if(top < 0) {
                return -1;
            } else {
                return stack[top];
            }
        }

        public boolean isEmpty() {
            return (top < 0);
        }
    }
}
