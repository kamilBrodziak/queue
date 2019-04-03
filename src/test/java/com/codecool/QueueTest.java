package com.codecool;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {
    private Queue queue;

    @BeforeEach
    void setUp() {
        queue = new Queue();
    }

    @Test
    void testIfQueueSizeIsIncreasedAfterEnqueue() {
        assertTrue(queue.isEmpty());
        queue.enqueue("dupa");
        assertEquals(1, queue.getQueueSize());
        queue.enqueue("dupka");
        assertEquals(2, queue.getQueueSize());
        queue.enqueue("dupeczka");
        assertEquals(3, queue.getQueueSize());
    }

    @Test
    void testIfFirstValueAddedIsReturned() {
        queue.enqueue("dupa");
        assertEquals("dupa", queue.dequeue());
        queue.enqueue("dupka");
        queue.enqueue("dupeczka");
        assertEquals("dupka", queue.dequeue());
        queue.enqueue("dupeczeczka");
        queue.enqueue("dupeczeczeczka");
        assertEquals("dupeczka", queue.dequeue());
    }

    @Test
    void testIfQueueSizeIsDecreasedAfterDequeue() {
        queue.enqueue("dupa");
        queue.dequeue();
        assertTrue(queue.isEmpty());
    }

    @Test
    void testIfPeekReturnFirstElementAddedWithoutDeleting() {
        queue.enqueue("dupa");
        queue.enqueue("dupeczka");
        queue.enqueue("dupenienia");
        assertEquals("dupa", queue.peek());
        assertEquals(3, queue.getQueueSize());
    }
}