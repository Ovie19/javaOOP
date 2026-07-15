package dsa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SetTest {

    private Set set;

    @BeforeEach
    void setup() {
        set = new Set();
    }

    @Test
    public void newSetIsEmptyTest() {
        assertTrue(set.isEmpty());
    }

    @Test
    public void addX_newSetIsNotEmptyTest() {
        set.add("Ghost");
        assertFalse(set.isEmpty());
    }

    @Test
    public void addX_removeX_setIsEmpty() {
        set.add("Ghost");
        set.remove("Ghost");
        assertTrue(set.isEmpty());
    }

    @Test
    public void addXY_removeX_setIsNotEmpty() {
        set.add("Ghost");
        set.add("Tommy");

        set.remove("Ghost");
        assertFalse(set.isEmpty());
    }

    @Test
    public void addX_addXAgain_returnsFalseTest() {
        set.add("Ghost");
        assertFalse(set.add("Ghost"));
    }

    @Test
    public void addXY_addXAgain_returnsFalse_sizeIs2Test() {
        set.add("Ghost");
        set.add("Tommy");
        assertFalse(set.add("Ghost"));
        assertEquals(2, set.size());
    }

    @Test
    public void addX_containsX_returnTrueTest() {
        set.add("Ghost");
        assertTrue(set.contains("Ghost"));
    }

    @Test
    public void addXY_addX_containsXReturnsFalseTest() {
        set.add("Ghost");
        set.add("Tommy");

        set.remove("Ghost");
        assertFalse(set.contains("Ghost"));
    }

    @Test
    public void addX_removeY_returnsFalseTest() {
        set.add("Ghost");
        assertFalse(set.remove("Pablo"));
    }

    @Test
    public void addX_add_Y_addZ_clearSet_setIsEmptyTest() {
        set.add("Ghost");
        set.add("Tommy");
        set.add("Pablo");
        set.clear();
        assertTrue(set.isEmpty());
    }
}