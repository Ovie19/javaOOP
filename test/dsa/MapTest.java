package dsa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MapTest{

    private Map map;

    @BeforeEach
    void setup() {
        map = new Map();
    }

    @Test
    public void newMapIsEmptyTest() {
        assertTrue(map.isEmpty());
    }

    @Test
    public void putKeyValue_mapIsNotEmptyTest() {
        map.put("Name", "Ghost");
        assertFalse(map.isEmpty());
    }

    @Test
    public void putKeyValue_removeKey_mapIsEmptyTest() {
        map.put("Name", "Ghost");
        map.remove("Name");
        assertTrue(map.isEmpty());
    }

    @Test
    public void putKey1Value1_putKey2Value2_removeKey1_mapIsNotEmptyTest() {
        map.put("Name", "Ghost");
        map.put("Age", "37");
        map.remove("Name");
        assertFalse(map.isEmpty());
    }

    @Test
    public void putKey1Value1_getKey1_returnsValue1Test() {
        map.put("Name", "Ghost");
        assertEquals("Ghost", map.get("Name"));
    }

    @Test
    public void putKey1Value1_putKey2Value2_getKey2_returnsValue2Test() {
        map.put("Name", "Ghost");
        map.put("Age", "37");
        assertEquals("37", map.get("Age"));
    }

    @Test
    public void getInvalidKeyReturnsNullTest() {
        assertNull(map.get("Name"));
    }

    @Test
    public void putKeyValue_removeKey_returnsValueTest() {
        map.put("Name", "Ghost");
        assertEquals("Ghost", map.remove("Name"));
    }

    @Test
    public void putKey1Value1_putKey2Value2_removeKey2_returnsValue2Test() {
        map.put("Name", "Ghost");
        map.put("Age", "37");
        assertEquals("37", map.remove("Age"));
    }

    @Test
    public void putKey1Value1_putKey2Value2_removeKey2_sizeIs1Test() {
        map.put("Name", "Ghost");
        map.put("Age", "37");
        map.remove("Age");
        assertEquals(1, map.size());
    }

    @Test
    public void putKey1Value1_putKey2Value2_removeKey1_returnsValue1Test() {
        map.put("Name", "Ghost");
        map.put("Age", "37");
        assertEquals("Ghost", map.remove("Name"));
    }

    @Test
    public void putKey1Value1_putKey2Value2_removeKey1_getKey2_returnsValue2Test() {
        map.put("Name", "Ghost");
        map.put("Age", "37");
        map.remove("Name");
        assertEquals("37", map.get("Age"));
    }

    @Test
    public void putKey1Value1_removeKey1_removeKey1AgainReturnsNullTest() {
        map.put("Name", "Ghost");
        map.remove("Name");
        assertNull(map.remove("Name"));
    }

    @Test
    public void putKey1Value1_putKey1Value2_returnsValue1_getKey1_returnsValue2Test() {
        map.put("Name", "Ghost");
        String oldValue = map.put("Name", "Nicolas");
        assertEquals("Ghost", oldValue);
        assertEquals("Nicolas", map.get("Name"));
    }

    @Test
    public void putKey1Value1_containsKey1_returnsTrueTest() {
        map.put("Name", "Ghost");
        assertTrue(map.containsKey("Name"));
    }

    @Test
    public void putKey1Value1_removeKey1_containsKey1_returnsFalseTest() {
        map.put("Name", "Ghost");
        map.remove("Name");
        assertFalse(map.containsKey("Name"));
    }

    @Test
    public void putKey1Value1_containsValue1_returnsTrueTest() {
        map.put("Name", "Ghost");
        assertTrue(map.containsValue("Ghost"));
    }

    @Test
    public void putKey1Value1_removeKey1_containsValue1_returnsFalseTest() {
        map.put("Name", "Ghost");
        map.remove("Name");
        assertFalse(map.containsValue("Ghost"));
    }

    @Test
    public void putKey1Value1_putKey2Value2_putKey3Value3_clearMap_isEmptyReturnsTrueTest() {
        map.put("Name", "Ghost");
        map.put("Age", "37");
        map.put("Hobby", "Sleeping");

        map.clear();
        assertTrue(map.isEmpty());
    }

}