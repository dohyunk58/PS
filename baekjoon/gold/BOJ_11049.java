package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11049 {
    static Matrix[] M;
    static int[][] d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 행렬 개수
        M = new Matrix[n+1]; // 행렬 저장
        d = new int[n+1][n+1]; // d[i][j]: i부터 j까지의 행렬을 곱했을 때 최소 비용
        for (int i = 0; i < n+1; i++) { // 초기값 -1
            for (int j = 0; j < n+1; j++) {
                d[i][j] = -1;
            }
        }

        // 행렬 저장
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            M[i] = new Matrix(r, c);
        }

        System.out.print(find(1, n));
    }

    // 점화식으로 s부터 e까지 행렬 곱 비용의 최소값 구하기
    static int find(int s, int e) {
        int result = Integer.MAX_VALUE;
        if (d[s][e] != -1) { // 계산한 영역은 넘어감
            return d[s][e];
        } else if (s == e) { // 행렬 1개의 곱 연산 수 = 0
            return 0;
        } else if (s == (e - 1)) { // 행렬 2개 곱연산 횟수 = r1 x c1(=r2) x c2
            return M[s].x * M[s].y * M[e].y;
        } else { // 3개 이상 행렬 곱셈 연산 횟수 = 칸막이를 한 칸씩 나눠 작은 수를 선택하기
            for (int i = s; i < e; i++) {
                // s~i을 곱한 행렬과, i+1~e을 곱한 행렬, 두 행렬의 곱셈 연산 횟수
                result = Math.min(result, M[s].x * M[i].y * M[e].y + find(s, i) + find(i+1, e));
            }
        }
        return d[s][e] = result;
    }

    static class Matrix {
        int x;
        int y;
        Matrix(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
