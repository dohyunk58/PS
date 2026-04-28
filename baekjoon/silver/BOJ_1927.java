package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_1927 {
    static MinHeap minHeap;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        minHeap = new MinHeap();

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                sb.append(minHeap.delete()).append("\n");
            } else {
                minHeap.add(num);
            }
        }

        System.out.print(sb);
    }

    static class MinHeap {
        private static ArrayList<Integer> heap;

        public MinHeap() {
            heap = new ArrayList<>();
            heap.add(0);
        }

        public void add(int x) {
            // 1. 맨 뒤에 삽입
            heap.add(x);
            // 2. 위치(힙 사이즈) 계산 후 부모와 비교
            int addPosition = heap.size() - 1;

            // 범위 이내로, 자식이 부모보다 작은 경우 swap
            while (addPosition > 1 && heap.get(addPosition / 2) > heap.get(addPosition)) {
                int temp = heap.get(addPosition / 2);
                heap.set(addPosition / 2, heap.get(addPosition));
                heap.set(addPosition, temp);
                addPosition /= 2;
            }
        }

        public int delete() {
            if (heap.size() == 1) return 0;

            // 1. 최상위 노드를 빼고 최하위 노드를 최상단으로 이동
            int top = heap.get(1);
            heap.set(1, heap.get(heap.size() - 1));
            heap.remove(heap.size() - 1);

            // 2. top을 자식과 비교하며 자식이 더 작은 경우 swap
            int pos = 1;
            while (pos * 2 < heap.size()) {
                // 자식 중 작은 자식을 선택
                int min = heap.get(pos * 2);
                int minPos = pos * 2;
                if (pos * 2 + 1 < heap.size() && heap.get(pos * 2 + 1) < heap.get(pos * 2)) {
                    min = heap.get(pos * 2 + 1);
                    minPos = pos * 2 + 1;
                }

                // 부모가 자식보다 큰 경우 swap
                if (heap.get(pos) > min) {
                    int temp = heap.get(pos);
                    heap.set(pos, min);
                    heap.set(minPos, temp);

                    pos = minPos;
                } else break; // 두 자식이 더 크면 더이상 비교하지 않음
            }

            return top;
        }
    }
}
