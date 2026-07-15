package dsa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayListTest {

    private ArrayList list;

    @BeforeEach
    void setup() {
        list = new ArrayList();
    }

    @Test
    public void newArrayListIsEmptyTest() {
        assertTrue(list.isEmpty());
    }

    @Test
    public void addX_newArraysListIsNotEmptyTest() {
        list.add("Ghost");
        assertFalse(list.isEmpty());
    }

    @Test
    public void addX_removeIndex0_listIsEmptyTest() {
        list.add("Ghost");
        list.remove(0);
        assertTrue(list.isEmpty());
    }

    @Test
    public void addXY_removeIndex0_listIsNotEmpty() {
        list.add("Ghost");
        list.add("Tommy");

        assertEquals(2, list.size());

        list.remove(0);
        assertFalse(list.isEmpty());
    }

    @Test
    public void addX_removeIndex0_returnsXTest() {
        list.add("Ghost");
        assertEquals("Ghost", list.remove(0));
    }

    @Test
    public void addXY_removeIndex0_removeIndex0_returnsXYTest() {
        list.add("Ghost");
        list.add("Tommy");

        assertEquals("Ghost", list.remove(0));
        assertEquals("Tommy", list.remove(0));
    }

    @Test
    public void addXY_removeIndex0Twice_returnsXY_addZ_getIndex0_returnsZTest() {
        list.add("Ghost");
        list.add("Tommy");

        assertEquals("Ghost", list.remove(0));
        assertEquals("Tommy", list.remove(0));

        list.add("Madam");
        assertEquals("Madam", list.get(0));
    }

    @Test
    public void addXInIndex0_getIndex0_returnsX() {
        list.add(0, "Ghost");
        assertEquals("Ghost", list.get(0));
    }

    @Test
    public void addXInIndexMinus1_throwsExceptionTest() {
        assertThrows(
                IllegalArgumentException.class,
                () -> list.add(-1, "Ghost")
        );
    }

    @Test
    public void addXInIndex1_throwsExceptionTest() {
        assertThrows(
                IllegalArgumentException.class,
                () -> list.add(1, "Ghost")
        );
    }

    @Test
    public void addXInIndex0_addYInIndex0_getIndex0_1_returnsY_X() {
        list.add(0, "Ghost");
        list.add(0, "Tommy");

        assertEquals("Tommy", list.get(0));
        assertEquals("Ghost", list.get(1));
    }

    @Test
    public void getIndexMinus1_throwsExceptionTest() {
        assertThrows(
                IllegalArgumentException.class,
                () -> list.get(-1)
        );
    }

    @Test
    public void addX_getIndex1_throwsExceptionTest() {
        list.add("Ghost");
        assertThrows(
                IllegalArgumentException.class,
                () -> list.get(-1)
        );
    }

    @Test
    public void addXY_addZInIndex1_getIndex_0_1_2_returns_XZYTest() {
        list.add("Ghost");
        list.add("Tommy");
        list.add(1, "Nicolas");

        assertEquals("Ghost", list.get(0));
        assertEquals("Nicolas", list.get(1));
        assertEquals("Tommy", list.get(2));
    }

    @Test
    public void addElevenTimes_getIndex10_returnsTheEleventhElementTest() {
        for (int index = 0; index < 11; index++)
            list.add("element" + index);

        assertEquals("element10", list.get(10));
    }

    @Test
    public void addXInIndex2_whenListIsFilled_getIndex2_returnXTest() {
        for (int index = 0; index < 10; index++)
            list.add("element" + index);

        list.add(2, "Ghost");
        assertEquals("Ghost", list.get(2));
    }

    @Test
    public void addX_setIndex0ToY_returnsXTest() {
        list.add("Ghost");
        assertEquals("Ghost", list.set(0, "Tommy"));
    }

    @Test
    public void addX_setIndex0ToY_getIndex0_returnsYTest() {
        list.add("Ghost");
        list.set(0, "Tommy");
        assertEquals("Tommy", list.get(0));
    }

    @Test
    public void setIndex0_inAnEmptyListToX_throwsExceptionTest() {
        assertThrows(
                IllegalArgumentException.class,
                () -> list.set(0, "Ghost")
        );
    }

    @Test
    public void add10Elements_clearList_listIsEmptyTest() {
        for (int index = 0; index < 10; index++)
            list.add("element" + index);

        list.clear();
        assertTrue(list.isEmpty());
    }

    @Test
    public void clearList_addX_getIndex0_returnsXTest() {
        for (int index = 0; index < 10; index++)
            list.add("element" + index);

        list.clear();
        list.add("Ghost");
        assertEquals("Ghost", list.get(0));
    }

    @Test
    public void addX_containsXReturnsTrueTest() {
        list.add("Ghost");
        assertTrue(list.contains("Ghost"));
    }

    @Test
    public void addX_removeX_containsXReturnsFalseTest() {
        list.add("Ghost");
        list.remove(0);
        assertFalse(list.contains("Ghost"));
    }

    @Test
    public void addX_indexOfX_returns0Test() {
        list.add("Ghost");
        assertEquals(0, list.indexOf("Ghost"));
    }

    @Test
    public void addX_addY_addZ_removeIndex1_indexOfZ_returns1Test() {
        list.add("Ghost");
        list.add("Tommy");
        list.add("Madam");
        list.remove(1);
        assertEquals(1, list.indexOf("Madam"));
    }

    @Test
    public void addX_removeX_indexOfXReturnsMinusOneTest() {
        list.add("Ghost");
        list.remove(0);
        assertEquals(-1, list.indexOf("Ghost"));
    }

    @Test
    public void addX_removeX_returnsTrueTest() {
        list.add("Ghost");
        assertTrue(list.remove("Ghost"));
    }

    @Test
    public void addX_removeIndex0_removeXReturnsFalseTest() {
        list.add("Ghost");
        list.remove(0);
        assertFalse(list.remove("Ghost"));
    }

    @Test
    public void arrayListWithInitialCapacityOf3_addFourElements_sizeReturns4Test() {
        ArrayList list = new ArrayList(3);
        list.add("Ghost");
        list.add("Tommy");
        list.add("Tasha");
        list.add("Messi");
        assertEquals(4, list.size());
    }
}