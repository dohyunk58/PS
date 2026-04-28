package swea.d2;

import java.io.*;
import java.util.StringTokenizer;

public class swea_1859 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            int day = Integer.parseInt(br.readLine());
            int[] numbers = new int[day];
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < day; j++) {
                numbers[j] = Integer.parseInt(st.nextToken());
            }

            long profit = 0;
            int maxNumber = numbers[day-1];
            for(int j = day-1; j >= 0; j--) { // 뒤에서부터 비교
                // max보다 크면 max에 값을 저장하고 그 날은 안파니까 넘어감
                if(numbers[j] > maxNumber) {
                    maxNumber = numbers[j];
                    continue;
                }
                profit += maxNumber - numbers[j]; // 이전 날이 max보다 작으면 파니까 금액에 추가
            }

            System.out.println("#"+(i+1)+" "+profit);
        }
    }
}
