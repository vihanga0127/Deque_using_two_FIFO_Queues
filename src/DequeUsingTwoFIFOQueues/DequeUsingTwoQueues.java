package DequeUsingTwoFIFOQueues;

import java.util.LinkedList;
import java.util.Queue;

public class DequeUsingTwoQueues {
    private Queue<Integer> frontQueue;
    private Queue<Integer> rearQueue;

    public DequeUsingTwoQueues() {
        frontQueue = new LinkedList<>();
        rearQueue = new LinkedList<>();
    }

    // Add an element to the front of the deque
    public void addFront(int element) {
        frontQueue.offer(element);
    }

    // Add an element to the rear of the deque
    public void addRear(int element) {
        rearQueue.offer(element);
    }

    // Remove and return the front element of the deque
    public int removeFront() {
        if (frontQueue.isEmpty()) {
            moveHalfToFrontQueue();
        }
        if (frontQueue.isEmpty()) {
            throw new RuntimeException("Deque is empty");
        }
        return frontQueue.poll();
    }

    // Remove and return the rear element of the deque
    public int removeRear() {
        if (rearQueue.isEmpty()) {
            moveHalfToRearQueue();
        }
        if (rearQueue.isEmpty()) {
            throw new RuntimeException("Deque is empty");
        }
        return rearQueue.poll();
    }

    // Helper method to move half of the rearQueue elements to frontQueue
    private void moveHalfToFrontQueue() {
        int size = rearQueue.size();
        for (int i = 0; i < size / 2; i++) {
            frontQueue.offer(rearQueue.poll());
        }
    }

    // Helper method to move half of the frontQueue elements to rearQueue
    private void moveHalfToRearQueue() {
        int size = frontQueue.size();
        for (int i = 0; i < size / 2; i++) {
            rearQueue.offer(frontQueue.poll());
        }
    }

    // Display the elements of the deque
    public void display() {
        System.out.println("Front Queue: " + frontQueue);
        System.out.println("Rear Queue: " + rearQueue);
    }

    public static void main(String[] args) {
        DequeUsingTwoQueues deque = new DequeUsingTwoQueues();
        deque.addFront(91);
        deque.addRear(7);
        deque.addFront(39);
        deque.addRear(41);

        System.out.println("Deque after adding elements:");
        deque.display();

        System.out.println("Removed from front: " + deque.removeFront());
        System.out.println("Removed from rear: " + deque.removeRear());

        System.out.println("Deque after removing elements:");
        deque.display();
    }
}
