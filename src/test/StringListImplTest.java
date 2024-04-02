import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

public class StringListImplTest {
    private StringListImpl stringList;

    @BeforeEach
    public void restoreService() {
        stringList = new StringListImpl(1);
    }
    @org.junit.jupiter.api.Test
    void testAdd() {
        Integer expectedVal = 21;
        Integer actualVal = stringList.add(21);
        assertEquals(expectedVal,actualVal);
    }

    @org.junit.jupiter.api.Test
    void testAddWithIdx() {
        Integer expectedVal = 23;
        stringList.add(21);
        Integer actualVal = stringList.add(1,23);
        assertEquals(expectedVal,actualVal);
    }

    @org.junit.jupiter.api.Test
    void testSet() {
        Integer expectedVal = 23;
        stringList.add(21);
        Integer actualVal = stringList.set(0,23);
        assertEquals(expectedVal,actualVal);
    }

    @org.junit.jupiter.api.Test
    void testSetIOBException() {
        String expectedVal = "Указанный индекс не существует";
        Exception exception = assertThrows(IndexOutOfBoundsException.class,
                () -> stringList.set(10,23));
        assertEquals(expectedVal,exception.getMessage());
    }

    @org.junit.jupiter.api.Test
    void testRemoveByItem() {
        Integer expectedVal = 23;
        stringList.add(21);
        stringList.add(23);
        Integer a = 23;
        Integer actualVal = stringList.remove(a);
        assertEquals(expectedVal,actualVal);
    }

    @org.junit.jupiter.api.Test
    void testRemoveByIdx() {
        Integer expectedVal = 21;
        stringList.add(21);
        stringList.add(23);
        Integer actualVal = stringList.remove(0);
        assertEquals(expectedVal,actualVal);
    }

    @org.junit.jupiter.api.Test
    void testRemoveByItemItemNotFoundException() {
        String expectedVal = "Указанный элемент не найден";
        stringList.add(21);
        Exception exception = assertThrows(ItemNotFoundException.class,
                () -> stringList.remove((Integer) 222));
        assertEquals(expectedVal,exception.getMessage());
    }

    @org.junit.jupiter.api.Test
    void testRemoveByIdxIOBException() {
        String expectedVal = "Указанный индекс не существует";
        stringList.add(21);
        Exception exception = assertThrows(IndexOutOfBoundsException.class,
                () -> stringList.remove(2));
        assertEquals(expectedVal,exception.getMessage());
    }

    @org.junit.jupiter.api.Test
    void containsTest() {
        Boolean expectedVal = true;
        stringList.add(21);
        stringList.add(23);
        Boolean actualVal = stringList.contains(21);
        assertEquals(expectedVal,actualVal);
    }

    @org.junit.jupiter.api.Test
    void indexOfTest() {
        int expectedVal = 1;
        stringList.add(21);
        stringList.add(23);
        stringList.add(23);
        int actualVal = stringList.indexOf(23);
        assertEquals(expectedVal,actualVal);
    }

    @org.junit.jupiter.api.Test
    void lastIndexOfTest() {
        int expectedVal = 2;
        stringList.add(21);
        stringList.add(23);
        stringList.add(23);
        int actualVal = stringList.lastIndexOf(23);
        assertEquals(expectedVal,actualVal);
    }

    @org.junit.jupiter.api.Test
    void getTest() {
        Integer expectedVal = 23;
        stringList.add(21);
        stringList.add(23);
        stringList.add(23);
        Integer actualVal = stringList.get(2);
        assertEquals(expectedVal,actualVal);
    }

    @org.junit.jupiter.api.Test
    void getTestIOBException() {
        String expectedVal = "Указанный индекс не существует";
        stringList.add(21);
        Exception exception = assertThrows(IndexOutOfBoundsException.class,
                () -> stringList.get(2));
        assertEquals(expectedVal,exception.getMessage());
    }

    @org.junit.jupiter.api.Test
    void equalsTest() {
        stringList.add(21);
        stringList.add(23);
        StringListImpl scndStringList  = new StringListImpl(1);
        scndStringList.add(21);
        scndStringList.add(23);
        Boolean expectedVal = true;
        Boolean actualVal = stringList.equals(scndStringList);
        assertEquals(expectedVal,actualVal);
    }

    @org.junit.jupiter.api.Test
    void sizeTest() {
        int expectedVal = 3;
        stringList.add(21);
        stringList.add(23);
        stringList.add(23);
        int actualVal = stringList.size();
        assertEquals(expectedVal,actualVal);
    }

    @org.junit.jupiter.api.Test
    void isEmptyTest() {
        Boolean expectedVal = true;
        Boolean actualVal = stringList.isEmpty();
        assertEquals(expectedVal,actualVal);
    }

    @org.junit.jupiter.api.Test
    void clearTest() {
        Boolean expectedVal = true;
        stringList.add(21);
        stringList.add(23);
        stringList.add(23);
        stringList.clear();
        Boolean actualVal = stringList.isEmpty();
        assertEquals(expectedVal,actualVal);
    }

    @org.junit.jupiter.api.Test
    void toArray() {
        Integer[] expectedVal = {21,23,23};
        stringList.add(21);
        stringList.add(23);
        stringList.add(23);
        Integer[] actualVal = stringList.toArray();
        assertArrayEquals(expectedVal,actualVal);
    }
}