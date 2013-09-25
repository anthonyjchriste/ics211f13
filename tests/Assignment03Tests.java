import org.junit.Test;

import java.util.MissingResourceException;

import static org.junit.Assert.assertEquals;

public class Assignment03Tests {
    private ArraySearch<String> stringSearch = new ArraySearch<String>();
    private ArraySearch<Double> doubleSearch = new ArraySearch<Double>();

    private String[] strings = {"a", "b", "c", "d", "c", "d", "e"};
    private Double[] doubles = {1.0, 2.0, 3.0, 4.0, 3.0, 4.0, 5.0};
    private Double[] noDuplicates = {1.0, 2.0, 3.0};

    @Test(expected = MissingResourceException.class)
    public void testFindEmpty() {
        stringSearch.find(new String[0], "a");
    }

    @Test
    public void testFindFront() {
        assertEquals("test find string front", 0, stringSearch.find(strings, "a"));
        assertEquals("test find double front", 0, doubleSearch.find(doubles, new Double(1.0)));
    }

    @Test
    public void testFindMiddle() {
        assertEquals("test find string middle", 2, stringSearch.find(strings, "c"));
        assertEquals("test find double middle", 2, doubleSearch.find(doubles, new Double(3.0)));
    }

    @Test
    public void testFindEnd() {
        assertEquals("test find string end", 6, stringSearch.find(strings, "e"));
        assertEquals("test find double end", 6, doubleSearch.find(doubles, new Double(5.0)));
    }

    @Test(expected = MissingResourceException.class)
    public void testMissingResourceException() {
        stringSearch.find(strings, "f");
        doubleSearch.find(doubles, new Double(6.0));
    }

    @Test
    public void testFirstDuplicate() {
        assertEquals("test first duplicate strings", 4, stringSearch.first_duplicate(strings));
        assertEquals("test first duplicate doubles", 4, doubleSearch.first_duplicate(doubles));
    }

    @Test
    public void testNoDuplicates() {
        assertEquals("test no duplicates", -1, doubleSearch.first_duplicate(noDuplicates));
    }
}
