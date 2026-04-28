package baekjoon.silver;

import java.io.*;
import java.util.*;

public class BOJ_6236 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 인출 기간
        int m = Integer.parseInt(st.nextToken()); // 인출 목표 횟수
        int[] requests = new int[n]; // 각 날짜에 사용할 금액
        int sum = 0;
        int max = 0;

        for (int i = 0; i < n; i++) {
            requests[i] = Integer.parseInt(br.readLine());
            sum += requests[i];
            max = Math.max(max, requests[i]);
        }

        int low = max; // 인출할 최소 금액(한 번 인출할 때 모든 돈을 입금 후 인출하기 때문에 요구 금액의 최대 값만큼은 인출할 수 있어야 함. 잔액이 최대 요구갑만큼 남지는 않기 때문)
        int high = sum; // 인출할 최대 금액
        int lowestWithDrawAmount = sum; // 결과값

        while (low <= high) {
            int mid = (low + high) / 2; // 인출할 금액
            int balance = 0;
            int withdrawCnt = 0;

            for (int i = 0; i < n; i++) {
                if (balance >= requests[i]) { // 남은 돈이 요구치를 충족하는 경우
                    balance -= requests[i];
                } else {
                    balance = mid;
                    withdrawCnt++;
                    balance -= requests[i];
                }
            }

            if (withdrawCnt <= m) { // 인출한 날이 목표한 날보다 같거나 적은 경우, 인출 금액을 더 줄여보기
                lowestWithDrawAmount = Math.min(lowestWithDrawAmount, mid);
                high = mid - 1;
            } else { // 너무 적게 인출해서 인출한 날이 목표한 날보다 많은 경우 인출 금액을 늘리기
                low = mid + 1;
            }
        }

        System.out.print(lowestWithDrawAmount);
    }
}

/*
M회를 맞추기 위해 돈이 남더라도 인출할 수 있음
=> 잔액이 요구치보다 많은 날에도 인출을 할 수 있음(선택적)
=> 인출한 날이 목표일보다 적은 작은 경우에도 여유로운 날을 합친 것이 더 많다면 해당 인출 금액을 고려한다.
ex. 요구 2 1, 잔액 3일때, 인출일 0, 인출하지 않은 날 2일. 목표일이 1일때 이틀 째에서 인출하는 경우 가능
=> 따라서 인출한 날이 적더라도 목표한 인출 일수를 모두 채울 수 있음(1 <= M <= N)
 */