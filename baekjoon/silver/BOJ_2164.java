package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        CircularQueue queue = new CircularQueue(n+1); // 6개 넣으려면 7칸 필요함

        // 1부터 순서대로 큐에 삽입
        for(int i = 0; i < n; i++) {
            queue.enqueue(i+1);
        }

        while(queue.size() > 1) {
            queue.dequeue();
            queue.enqueue(queue.dequeue());
        }

        System.out.println(queue.peek());
    }

    static class CircularQueue {
        int front;
        int rear;
        int capacity;
        int[] queue;

        public CircularQueue(int size) {
            this.front = this.rear = 0;
            this.capacity = size;
            queue = new int[capacity];
        }

        public boolean isEmpty() {
            return rear == front;
        }

        public boolean isFull() {
            return (rear + 1) % capacity == front;
        }

        public void enqueue(int value) {
            if (isFull()) {
                return;
            }
            rear = (rear + 1) % capacity;
            queue[rear] = value;
        }

        public int dequeue() {
            if(isEmpty()) {
                return -1;
            }
            front = (front + 1) % capacity;
            return queue[front];
        }

        public int peek() {
            if(isEmpty()) {
                return -1;
            }
            return queue[(front + 1) % capacity];
        }

        public int size() {
            return (rear - front + capacity) % capacity;
        }
    }
}
