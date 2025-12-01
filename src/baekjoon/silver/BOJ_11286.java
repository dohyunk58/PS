package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        AbsMinHeap absMinHeap = new AbsMinHeap(n);
        for(int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());

            if(input == 0) {
                int output = absMinHeap.delete();
                sb.append(output+"\n");
            } else {
                absMinHeap.insert(input);
            }
        }

        System.out.println(sb);
    }

    static class AbsMinHeap {
        private int capacity;
        private int size; // 요소 개수
        private int[] heap;

        public AbsMinHeap(int capacity) {
            this.capacity = capacity;
            this.size = 0;
            this.heap = new int[capacity + 1];
        }

        public void insert(int value) {
            if(size >= capacity) {
                return;
            }

            heap[++size] = value;

            int current = size;
            while(current > 1) {
                int parent = current / 2;

                // parent가 current보다 더 큰 수를 갖고 있다 = 더 낮은 우선순위 => 둘을 바꾸기
                if(compare(parent, current) > 0) {
                    swap(parent, current);
                    current = parent;
                } else {
                    break;
                }
            }
        }

        public int delete() {
            if(size == 0) return 0;

            // 루트 노드를 저장하고 마지막 노드를 루트 노드로 가져옴
            int root = heap[1];
            heap[1] = heap[size];
            heap[size] = 0;
            size--;

            // 마지막 노드를 root로 옮겼으니 이를 다시 정렬
            int current = 1;
            while(current * 2 <= size) {
                int leftChild = current * 2;
                int rightChild = current * 2 + 1;
                int smallerChild = leftChild;

                // 오른쪽 자식이 있을 때, 오른쪽이 왼쪽보다 더 크면 더 작은 쪽과 비교해야 함
                // 왼쪽이 더 큰 수(더 낮은 우선도)이면 변경
                if(rightChild <= size && compare(leftChild, rightChild) > 0) {
                    smallerChild = rightChild;
                }

                // 부모가 (작은)자식보다 크면 교환
                if(compare(current, smallerChild) > 0) {
                    swap(current, smallerChild);
                    current = smallerChild; // 자식으로 인덱스 이동
                } else {
                    break;
                }
            }

            return root;
        }

        private void swap(int a, int b) {
            int temp = heap[a];
            heap[a] = heap[b];
            heap[b] = temp;
        }

        public void printHeap() {
            for (int i = 1; i <= size; i++) {
                System.out.print(heap[i] + " ");
            }
            System.out.println();
        }

        private int compare(int index1, int index2) {
            int abs1 = Math.abs(heap[index1]);
            int abs2 = Math.abs(heap[index2]);

            if(abs1 != abs2) { // abs1이 더 크면 양수 작으면 음수
                return abs1 - abs2;
            }

            // 둘의 절대값이 같으면 index1이 더 큰수면 양수 작으면 음수
            return heap[index1] - heap[index2];
        }
    }
}
