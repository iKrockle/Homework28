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
        String expectedVal = "Hello";
        String actualVal = stringList.add("Hello");
        assertEquals(expectedVal,actualVal);
    }

    @org.junit.jupiter.api.Test
    void testAddWithIdx() {
        String expectedVal = "World";
        stringList.add("Hello");
        String actualVal = stringList.add(1,"World");
        assertEquals(expectedVal,actualVal);
    }

    @org.junit.jupiter.api.Test
    void testSet() {
        String expectedVal = "World";
        stringList.add("Hello");
        String actualVal = stringList.set(0,"World");
        assertEquals(expectedVal,actualVal);
    }

    @org.junit.jupiter.api.Test
    void testSetIOBException() {
        String expectedVal = "Указанный индекс не существует";
        Exception exception = assertThrows(IndexOutOfBoundsException.class,
                () -> stringList.set(10,"World"));
        assertEquals(expectedVal,exception.getMessage());
    }

    @org.junit.jupiter.api.Test
    void testRemoveByItem() {
        String expectedVal = "World";
        stringList.add("Hello");
        stringList.add("World");
        String actualVal = stringList.remove("World");
        assertEquals(expectedVal,actualVal);
    }

    @org.junit.jupiter.api.Test
    void testRemoveByIdx() {
        String expectedVal = "Hello";
        stringList.add("Hello");
        stringList.add("World");
        String actualVal = stringList.remove(0);
        assertEquals(expectedVal,actualVal);
    }

    @org.junit.jupiter.api.Test
    void testRemoveByItemItemNotFoundException() {
        String expectedVal = "Указанный элемент не найден";
        stringList.add("Hello");
        Exception exception = assertThrows(ItemNotFoundException.class,
                () -> stringList.remove("Ghost"));
        assertEquals(expectedVal,exception.getMessage());
    }

    @org.junit.jupiter.api.Test
    void testRemoveByIdxIOBException() {
        String expectedVal = "Указанный индекс не существует";
        stringList.add("Hello");
        Exception exception = assertThrows(IndexOutOfBoundsException.class,
                () -> stringList.remove(2));
        assertEquals(expectedVal,exception.getMessage());
    }

    @org.junit.jupiter.api.Test
    void containsTest() {
        Boolean expectedVal = true;
        stringList.add("Hello");
        stringList.add("World");
        Boolean actualVal = stringList.contains("Hello");
        assertEquals(expectedVal,actualVal);
    }

    @org.junit.jupiter.api.Test
    void indexOfTest() {
        int expectedVal = 1;
        stringList.add("Hello");
        stringList.add("World");
        stringList.add("World");
        int actualVal = stringList.indexOf("World");
        assertEquals(expectedVal,actualVal);
    }

    @org.junit.jupiter.api.Test
    void lastIndexOfTest() {
        int expectedVal = 2;
        stringList.add("Hello");
        stringList.add("World");
        stringList.add("World");
        int actualVal = stringList.lastIndexOf("World");
        assertEquals(expectedVal,actualVal);
    }

    @org.junit.jupiter.api.Test
    void getTest() {
        String expectedVal = "World";
        stringList.add("Hello");
        stringList.add("World");
        stringList.add("World");
        String actualVal = stringList.get(2);
        assertEquals(expectedVal,actualVal);
    }

    @org.junit.jupiter.api.Test
    void getTestIOBException() {
        String expectedVal = "Указанный индекс не существует";
        stringList.add("Hello");
        Exception exception = assertThrows(IndexOutOfBoundsException.class,
                () -> stringList.get(2));
        assertEquals(expectedVal,exception.getMessage());
    }

    @org.junit.jupiter.api.Test
    void equalsTest() {
        stringList.add("Hello");
        stringList.add("World");
        StringListImpl scndStringList  = new StringListImpl(1);
        scndStringList.add("Hello");
        scndStringList.add("World");
        Boolean expectedVal = true;
        Boolean actualVal = stringList.equals(scndStringList);
        assertEquals(expectedVal,actualVal);
    }

    @org.junit.jupiter.api.Test
    void sizeTest() {
        int expectedVal = 3;
        stringList.add("Hello");
        stringList.add("World");
        stringList.add("World");
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
        stringList.add("Hello");
        stringList.add("World");
        stringList.add("World");
        stringList.clear();
        Boolean actualVal = stringList.isEmpty();
        assertEquals(expectedVal,actualVal);
    }

    @org.junit.jupiter.api.Test
    void toArray() {
        String[] expectedVal = {"Hello","World","World"};
        stringList.add("Hello");
        stringList.add("World");
        stringList.add("World");
        String[] actualVal = stringList.toArray();
        assertArrayEquals(expectedVal,actualVal);
    }
}