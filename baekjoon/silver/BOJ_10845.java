package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        CircularQueue queue = new CircularQueue(n+1);

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if (command.equals("push")) {
                int num = Integer.parseInt(st.nextToken());
                queue.enqueue(num);
            } else if (command.equals("pop")) {
                if (queue.isEmpty()) {
                    sb.append("-1").append("\n");
                } else {
                    sb.append(queue.dequeue()).append("\n");
                }
            } else if (command.equals("size")) {
                sb.append(queue.getSize()).append("\n");
            } else if (command.equals("empty")) {
                if (queue.isEmpty()) {
                    sb.append("1").append("\n");
                } else sb.append("0").append("\n");
            } else if (command.equals("front")) {
                if (queue.isEmpty()) {
                    sb.append("-1").append("\n");
                } else {
                    sb.append(queue.getFront()).append("\n");
                }
            } else if (command.equals("back")) {
                if (queue.isEmpty()) {
                    sb.append("-1").append("\n");
                } else {
                    sb.append(queue.getBack()).append("\n");
                }
            }
        }

        System.out.print(sb);
    }

    static class CircularQueue {
        private int[] queue;
        private int front, rear;
        private int capacity;

        public CircularQueue(int size) {
            this.capacity = size;
            this.queue = new int[size];
            this.front = 0;
            this.rear = 0;
        }

        public void enqueue(int item) {
            if (isFull()) {
                System.out.println("Queue is Full");
                return;
            }
            rear = (rear + 1) % capacity; // 원형으로 회전
            queue[rear] = item;
        }

        public int dequeue() {
            if (isEmpty()) {
                System.out.println("Queue is Empty");
                return -1;
            }
            front = (front + 1) % capacity; // 원형으로 회전
            return queue[front];
        }

        public int getSize() {
            return (rear - front + capacity) % capacity;
        }

        public boolean isEmpty() {
            return front == rear;
        }

        public boolean isFull() {
            return (rear + 1) % capacity == front;
        }

        public int getFront() {
            return queue[(front + 1) % capacity];
        }

        public int getBack() {
            return queue[rear];
        }
    }
}
