package com.jsm.scaler.intermediate.StacksAndQueues;

import java.util.EmptyStackException;

public class BalancedParenthesesWithOwnStack {
    static class Node<T> {
        T value;
        Node<T> next;

        Node(T value) {
            this.value = value;
        }
    }

    static class MyStack<T> {
        private Node<T> head;
        private int size = 0;

        public void push(T value) {
            Node<T> node = new Node<>(value);
            node.next = head;
            head = node;
            size += 1;
        }

        public T peek() {
            return head.value;
        }

        public T pop() {
            if (head == null) throw new EmptyStackException();
            Node<T> peek = head;
            head = head.next;
            size -= 1;
            return peek.value;
        }

        public boolean isEmpty() {
            return head == null;
        }

        public int size() {
            return size;
        }
    }

    public static int solve(String A) {
        MyStack<Character> s = new MyStack<>();
        for (Character c : A.toCharArray()) {
            if (c == '{' || c == '(' || c == '[') {
                s.push(c);
                continue;
            }
            if (s.isEmpty()) return 0;
            if (c == '}' && s.pop() != '{') return 0;
            if (c == ')' && s.pop() != '(') return 0;
            if (c == ']' && s.pop() != '[') return 0;
        }
        return s.isEmpty() ? 1 : 0;
    }

    public static void main(String[] args) {
        String A="{([])}";
        System.out.println(solve(A));
    }
}
