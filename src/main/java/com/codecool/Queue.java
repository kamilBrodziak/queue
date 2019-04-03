package com.codecool;

public class Queue {
    private class Node {
        private String value;
        private Node nextNode;

        public Node(String value) {
            this.value = value;
        }

        public void setNextNode(Node node) {
            this.nextNode = node;
        }

        public Node getNextNode() {
            return nextNode;
        }

        public String getValue() {
            return value;
        }
    }
    private int queueSize = 0;

    public boolean isEmpty() {
        return queueSize == 0;
    }

    public int getQueueSize() {
        return queueSize;
    }

    private Node head;
    private Node tail;


    public void enqueue(String value) {
        if(head == null) {
            head = new Node(value);
            head.setNextNode(tail);
        } else if(head != null && tail == null) {
            tail = head;
            tail.setNextNode(null);
            head = new Node(value);
            head.setNextNode(tail);
        } else {
            Node node = new Node(value);
            node.setNextNode(head);
            head = node;
        }
        queueSize++;
    }

    public String dequeue() {
        if(isEmpty()) {
            return "";
        } else if(queueSize == 1) {
            String value = head.getValue();
            head = null;
            queueSize--;
            return value;
        } else if(queueSize == 2) {
            String value = tail.getValue();
            tail = null;
            queueSize--;
            return value;
        }
        String value = tail.getValue();
        Node curr = head;
        while(curr.getNextNode() != tail) {
            curr = curr.getNextNode();
        }
        tail = curr;
        tail.setNextNode(null);
        queueSize--;
        return value;
    }

    public String peek() {
        if(isEmpty()) {
            return "";
        } else if(queueSize == 1) {
            return head.getValue();
        } else {
            return tail.getValue();
        }
    }

}
