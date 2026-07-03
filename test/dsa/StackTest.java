package dsa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StackTest {

    private Stack stack;

    @BeforeEach
    void setUp() {
        stack = new Stack(7);
    }

    @Test
    public void newStack_isEmptyTest() {
        assertTrue(stack.isEmpty());
    }

    @Test
    public void pushX_stackIsNotEmptyTest() {
        stack.push("Ghost");
        assertFalse(stack.isEmpty());
    }

    @Test
    public void pushX_PopX_stackIsEmptyTest() {
        stack.push("Ghost");
        assertFalse(stack.isEmpty());

        stack.pop();
        assertTrue(stack.isEmpty());
    }

    @Test
    public void pushXY_popY_stackIsNotEmptyTest() {
        stack.push("Ghost");
        stack.push("Patrick");

        stack.pop();
        assertFalse(stack.isEmpty());
    }

    @Test
    public void pushXY_popY_returnsYTest() {
        stack.push("Ghost");
        stack.push("Patrick");

        assertEquals("Patrick", stack.pop());
    }

    @Test
    public void pushXY_popYX_returnsYXTest() {
        stack.push("Ghost");
        stack.push("Patrick");

        assertEquals("Patrick", stack.pop());
        assertEquals("Ghost", stack.pop());
    }

    @Test
    public void pushXY_popThriceThrowExceptionTest() {
        stack.push("Ghost");
        stack.push("Patrick");

        stack.pop();
        stack.pop();
        assertThrows(IllegalArgumentException.class, () -> stack.pop());
    }

    @Test
    public void pushMoreThanStackSizeThrowExceptionTest() {
        Stack stack = new Stack(5);

        stack.push("Ghost");
        stack.push("Tommy");
        stack.push("Patrick");
        stack.push("Tasha");
        stack.push("Tariq");

        assertThrows(IllegalArgumentException.class, () -> stack.push("Nigga"));
    }

    @Test
    public void pushXY_peekStack_returnsYTest() {
        stack.push("Ghost");
        stack.push("Patrick");

        assertEquals("Patrick", stack.peek());
    }
}
