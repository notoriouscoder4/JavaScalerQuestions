package com.jsm.scaler.advance.Queues;

public class DequeUsingDLL {

    // Node of a doubly linked list
    private static class Node {
        public int data;
        public Node prev;
        public Node next;

        static Node getNode(int data) {
            Node newNode = new Node();
            newNode.data = data;
            newNode.prev = newNode.next = null;
            return newNode;
        }
    }

    // A structure to represent a deque
    private static class Deque {
        Node front;
        Node rear;
        int size;

        Deque() {
            front = rear = null;
            size = 0;
        }

        // Function to check whether deque is empty or not
        boolean isEmpty() {
            return front == null;
        }

        // Function to return the number of elements in the deque
        int size() {
            return size;
        }

        // Function to insert an element at the front end
        void insertFront(int data) {
            Node newNode = Node.getNode(data);
            // If true then new element cannot be added, and it is an 'Overflow' condition
            if (newNode == null)
                System.out.print("Overflow\n");
            else {
                // If deque is empty
                if (front == null)
                    rear = front = newNode;
                    // Inserts node at the front end
                else {
                    newNode.next = front;
                    front.prev = newNode;
                    front = newNode;
                }
                // Increments count of elements by 1
                size++;
            }
        }

        // Function to insert an element at the rear end
        void insertRear(int data) {
            Node newNode = Node.getNode(data);
            // If true then new element cannot be added, and it is an 'Overflow' condition
            if (newNode == null)
                System.out.print("Overflow\n");
            else {
                // If deque is empty
                if (rear == null)
                    front = rear = newNode;
                    // Inserts node at the rear end
                else {
                    newNode.prev = rear;
                    rear.next = newNode;
                    rear = newNode;
                }
                size++;
            }
        }

        // Function to delete the element from the front end
        void deleteFront() {
            // If deque is empty then 'Underflow' condition
            if (isEmpty())
                System.out.print("Underflow\n");
                // Deletes the node from the front end and makes the adjustment in the links
            else {
                Node temp = front;
                front = front.next;

                // If only one element was present
                if (front == null)
                    rear = null;
                else
                    front.prev = null;

                // Decrements count of elements by 1
                size--;
            }
        }

        // Function to delete the element from the rear end
        void deleteRear() {
            // If deque is empty then 'Underflow' condition
            if (isEmpty())
                System.out.print("Underflow\n");
                // Deletes the node from the rear end and makes the adjustment in the links
            else {
                Node temp = rear;
                rear = rear.prev;

                // If only one element was present
                if (rear == null)
                    front = null;
                else
                    rear.next = null;

                // Decrements count of elements by 1
                size--;
            }
        }

        // Function to return the element at the front end
        int getFront() {
            // If deque is empty, then returns garbage value
            if (isEmpty())
                return -1;

            return front.data;
        }

        // Function to return the element at the rear end
        int getRear() {
            // If deque is empty, then returns garbage value
            if (isEmpty())
                return -1;
            return rear.data;
        }

        // Function to delete all the elements from Deque
        void erase() {
            rear = null;
            while (front != null) {
                Node temp = front;
                front = front.next;
            }
            size = 0;
        }
    }

    public static void main(String[] args) {
        Deque dq = new Deque();
        System.out.print(
                "Insert element '5' at rear end\n");
        dq.insertRear(5);

        System.out.print(
                "Insert element '10' at rear end\n");
        dq.insertRear(10);
        System.out.print("Rear end element: " + dq.getRear()
                + "\n");
        dq.deleteRear();
        System.out.print(
                "After deleting rear element new rear"
                        + " is: " + dq.getRear() + "\n");

        System.out.print(
                "Inserting element '15' at front end \n");
        dq.insertFront(15);
        System.out.print(
                "Front end element: " + dq.getFront() + "\n");

        System.out.print("Number of elements in Deque: "
                + dq.size() + "\n");

        dq.deleteFront();
        System.out.print("After deleting front element new "
                + "front is: " + dq.getFront()
                + "\n");
    }
}
