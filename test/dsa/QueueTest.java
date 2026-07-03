package dsa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QueueTest {

    private Queue queue;

    @BeforeEach
    void setUp() {
        queue = new Queue(5);
    }

    @Test
    public void addX_returnsTrueTest() {
        assertTrue(queue.add("Ghost"));
    }

    @Test
    public void addX_remove_returnXTest() {
        queue.add("Ghost");
        assertEquals("Ghost", queue.remove());
    }

    @Test
    public void addX_poll_returnsXTest() {
        queue.add("Ghost");
        assertEquals("Ghost", queue.poll());
    }

    @Test
    public void addXY_removeTwice_returnsXYTest() {
        queue.add("Ghost");
        queue.add("Tommy");

        assertEquals("Ghost", queue.remove());
        assertEquals("Tommy", queue.remove());
    }

    @Test
    public void addXY_pollTwice_returnsXYTest() {
        queue.add("Ghost");
        queue.add("Tommy");

        assertEquals("Ghost", queue.poll());
        assertEquals("Tommy", queue.poll());
    }

    @Test
    public void addXY_removeThrice_throwExceptionTest() {
        queue.add("Ghost");
        queue.add("Tommy");

        queue.remove();
        queue.remove();

        assertThrows(IllegalArgumentException.class, () -> queue.remove());
    }

    @Test
    public void addXY_pollThrice_returnsNullTest() {
        queue.add("Ghost");
        queue.add("Tommy");

        queue.poll();
        queue.poll();
        assertNull(queue.poll());
    }

    @Test
    public void addABCDE_removeThrice_returnsABC_addABC_removeFiveTimes_returnsDEABCTest() {
        queue.add("Ghost");
        queue.add("Tommy");
        queue.add("Alicia");
        queue.add("Rebeka");
        queue.add("Abigail");

        assertEquals("Ghost", queue.remove());
        assertEquals("Tommy", queue.remove());
        assertEquals("Alicia", queue.remove());

        queue.add("Ghost");
        queue.add("Tommy");
        queue.add("Alicia");

        assertEquals("Rebeka", queue.remove());
        assertEquals("Abigail", queue.remove());
        assertEquals("Ghost", queue.remove());
        assertEquals("Tommy", queue.remove());
        assertEquals("Alicia", queue.remove());
    }

    @Test
    public void addABCDE_pollThrice_returnsABC_addABC_pollFiveTimes_returnsDEABCTest() {
        queue.add("Ghost");
        queue.add("Tommy");
        queue.add("Alicia");
        queue.add("Rebeka");
        queue.add("Abigail");

        assertEquals("Ghost", queue.poll());
        assertEquals("Tommy", queue.poll());
        assertEquals("Alicia", queue.poll());

        queue.add("Ghost");
        queue.add("Tommy");
        queue.add("Alicia");

        assertEquals("Rebeka", queue.poll());
        assertEquals("Abigail", queue.poll());
        assertEquals("Ghost", queue.poll());
        assertEquals("Tommy", queue.poll());
        assertEquals("Alicia", queue.poll());
    }

    @Test
    public void addMoreElementsThanQueueSizeThrowsExceptionTest() {
        Queue queue = new Queue(3);

        queue.add("Ghost");
        queue.add("Tommy");
        queue.add("Alicia");

        assertThrows(IllegalArgumentException.class, () -> queue.add("Niklaus"));
    }

    @Test
    public void offerX_returnsTrueTest() {
        assertTrue(queue.offer("Sacrifice"));
    }

    @Test
    public void offerX_remove_returnsXTest() {
        queue.offer("Ghost");
        assertEquals("Ghost", queue.remove());
    }

    @Test
    public void offerXY_removeTwice_returnsXYTest() {
        queue.offer("Ghost");
        queue.offer("Tommy");

        assertEquals("Ghost", queue.remove());
        assertEquals("Tommy", queue.remove());
    }

//    @Test
//    public void offerMoreElementsThanQueueSizeThrowsExceptionTest() {}

    @Test
    public void addX_element_retrieveXValueTest() {
        queue.add("Ghost");
        assertEquals("Ghost", queue.element());
    }

    @Test
    public void addXY_element_retrieveXValue_remove_element_retrieveYValueTest() {
        queue.add("Ghost");
        queue.add("Tommy");

        assertEquals("Ghost", queue.element());
        queue.remove();
        assertEquals("Tommy", queue.element());
    }

    @Test
    public void addXYZ_element_retrieveXValue_removeTwice_element_retrieveZValueTest() {
        queue.add("Ghost");
        queue.add("Tommy");
        queue.add("Alicia");

        assertEquals("Ghost", queue.element());
        queue.remove();
        queue.remove();

        assertEquals("Alicia", queue.element());
    }

    @Test
    public void elementOnEmptyQueueThrowsExceptionTest() {
        assertThrows(IllegalArgumentException.class, () -> queue.element());
    }

    @Test
    public void addX_peek_retrieveXValueTest() {
        queue.add("Ghost");
        assertEquals("Ghost", queue.peek());
    }

    @Test
    public void addXY_peek_retrieveXValue_remove_peek_retrieveYValueTest() {
        queue.add("Ghost");
        queue.add("Tommy");

        assertEquals("Ghost", queue.peek());
        queue.remove();
        assertEquals("Tommy", queue.peek());
    }

    @Test
    public void addXYZ_peek_retrieveXValue_removeTwice_peek_retrieveZValueTest() {
        queue.add("Ghost");
        queue.add("Tommy");
        queue.add("Alicia");

        assertEquals("Ghost", queue.peek());
        queue.remove();
        queue.remove();

        assertEquals("Alicia", queue.peek());
    }
}
