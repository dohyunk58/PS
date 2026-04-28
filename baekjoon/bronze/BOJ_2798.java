package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] numbers = new int[n];
        for(int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int answer = find(numbers, n, m);
        System.out.println(answer);
    }

    private static int find (int[] numbers, int n, int m) {
        int answer = 0;
        for(int i = 0; i < n-2; i++) {
            if(numbers[i] >= m) continue;

            for(int j = i + 1; j < n-1; j++) {
                if(numbers[i] + numbers[j] >= m) continue;

                for(int k = j  + 1; k < n; k++) {
                    int sum = numbers[i] + numbers[j] + numbers[k];

                    if(sum == m) {
                        return sum;
                    } else if (sum < m && answer < sum) {
                        answer = sum;
                    }
                }
            }
        }
        return answer;
    }
}
