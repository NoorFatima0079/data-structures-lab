// Task 2: 2D Array and Circular Queue using Array
import java.util.Scanner;

// ---------- CIRCULAR QUEUE ----------
class CircularQueue {
    private final int[] arr;
private final int size;
private int front, rear, count;

    CircularQueue(int size) {
        this.size = size;
        arr = new int[size];
        front = 0;
        rear = -1;
        count = 0;
    }

    boolean isEmpty() {
        return count == 0;
    }

    boolean isFull() {
        return count == size;
    }

    void enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue Overflow (full)");
            return;
        }
        rear = (rear + 1) % size;
        arr[rear] = value;
        count++;
        System.out.println(value + " enqueued");
    }

    void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow (empty)");
            return;
        }
        System.out.println(arr[front] + " dequeued");
        front = (front + 1) % size;
        count--;
    }

    void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.print("Queue (front -> rear): ");
        int idx = front;
        for (int i = 0; i < count; i++) {
            System.out.print(arr[idx] + " ");
            idx = (idx + 1) % size;
        }
        System.out.println();
    }
}

public class ArrayCircularQueue {

    // ---------- 2D ARRAY ----------
    static void demo2DArray() {
        Scanner sc = new Scanner(System.in);
        final int ROWS = 3, COLS = 3;
        int[][] arr = new int[ROWS][COLS];

        System.out.println("Enter " + (ROWS * COLS) + " elements for the 3x3 array:");
        for (int i = 0; i < ROWS; i++)
            for (int j = 0; j < COLS; j++)
                arr[i][j] = sc.nextInt();

        System.out.println("\nThe 2D array is:");
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++)
                System.out.print(arr[i][j] + "\t");
            System.out.println();
        }

        // Row sums
        for (int i = 0; i < ROWS; i++) {
            int sum = 0;
            for (int j = 0; j < COLS; j++) sum += arr[i][j];
            System.out.println("Sum of row " + i + " = " + sum);
        }

        // Column sums
        for (int j = 0; j < COLS; j++) {
            int sum = 0;
            for (int i = 0; i < ROWS; i++) sum += arr[i][j];
            System.out.println("Sum of column " + j + " = " + sum);
        }
        sc.close();
    }

    public static void main(String[] args) {
        System.out.println("===== 2D ARRAY =====");
        demo2DArray();

        System.out.println("\n===== CIRCULAR QUEUE using Array =====");
        CircularQueue cq = new CircularQueue(5);
        cq.enqueue(10);
        cq.enqueue(20);
        cq.enqueue(30);
        cq.enqueue(40);
        cq.enqueue(50);
        cq.enqueue(60);   // overflow
        cq.display();
        cq.dequeue();
        cq.dequeue();
        cq.enqueue(60);   // wraps around
        cq.enqueue(70);   // wraps around
        cq.display();
    }
}