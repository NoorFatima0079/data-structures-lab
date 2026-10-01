// Task 1: Stack and Queue using Linked List

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// ---------- STACK (LIFO) ----------
class Stack {
    private Node top;

    boolean isEmpty() {
        return top == null;
    }

    void push(int value) {
        Node n = new Node(value);
        n.next = top;
        top = n;
        System.out.println(value + " pushed to stack");
    }

    void pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow (empty)");
            return;
        }
        System.out.println(top.data + " popped from stack");
        top = top.next;
    }

    void peek() {
        if (isEmpty()) System.out.println("Stack is empty");
        else System.out.println("Top element: " + top.data);
    }

    void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        System.out.print("Stack (top -> bottom): ");
        for (Node c = top; c != null; c = c.next)
            System.out.print(c.data + " ");
        System.out.println();
    }
}

// ---------- QUEUE (FIFO) ----------
class Queue {
    private Node front, rear;

    boolean isEmpty() {
        return front == null;
    }

    void enqueue(int value) {
        Node n = new Node(value);
        if (rear == null) {
            front = rear = n;
        } else {
            rear.next = n;
            rear = n;
        }
        System.out.println(value + " enqueued");
    }

    void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow (empty)");
            return;
        }
        System.out.println(front.data + " dequeued");
        front = front.next;
        if (front == null) rear = null;
    }

    void peek() {
        if (isEmpty()) System.out.println("Queue is empty");
        else System.out.println("Front element: " + front.data);
    }

    void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.print("Queue (front -> rear): ");
        for (Node c = front; c != null; c = c.next)
            System.out.print(c.data + " ");
        System.out.println();
    }
}

public class StackQueueLinkedList {
    public static void main(String[] args) {
        System.out.println("===== STACK using Linked List =====");
        Stack s = new Stack();
        s.push(10);
        s.push(20);
        s.push(30);
        s.display();
        s.peek();
        s.pop();
        s.display();

        System.out.println("\n===== QUEUE using Linked List =====");
        Queue q = new Queue();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.display();
        q.peek();
        q.dequeue();
        q.display();
    }
}
