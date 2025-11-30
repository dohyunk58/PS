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

                if(!isSmallerAbs(parent, current)) {
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
                if(rightChild <= size && !isSmallerAbs(leftChild, rightChild)) {
                    smallerChild = rightChild;
                }

                // 부모가 (작은)자식보다 크면 교환
                if(!isSmallerAbs(current, smallerChild)) {
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

        // 왼쪽 요소의 절대값이 더 작은지 반환
        // 만약 절대값이 같은 경우 왼쪽 요소의 값이 더 작은지 반환
        private boolean isSmallerAbs(int left, int right) {
            if(Math.abs(heap[left]) == Math.abs(heap[right])) {
                return isSmaller(left, right);
            } else {
                return Math.abs(heap[left]) < Math.abs(heap[right]);
            }
        }

        private boolean isSmaller(int left, int right) {
            return heap[left] < heap[right];
        }
    }
}
