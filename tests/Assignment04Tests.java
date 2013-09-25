import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;


public class Assignment04Tests {
  private OrderedLinkedList<Integer> list;

  @Before
  public void init() {
    list = new OrderedLinkedList<Integer>();
  }

  @Test
  public void testSizeEmptyList() {
    assertTrue(list.size() == 0);
  }

  @Test
  public void testSizeAfterAddToEmpty() {
    list.add("a", 55);
    assertEquals(1, list.size());
  }

  @Test
  public void testSizeAfterAddToFront() {
    list.add("b", 63);
    list.add("a", 91);
    assertEquals(2, list.size());
  }

  @Test
  public void testSizeAfterAddToEnd() {
    list.add("b", 63);
    list.add("a", 91);
    list.add("c", 0);
    assertEquals(3, list.size());
  }

  @Test
  public void testSizeAfterAddToMiddle() {
    list.add("b", 63);
    list.add("c", 91);
    list.add("a", 0);
    assertEquals(3, list.size());
  }

  @Test
  public void testSizeAfterAddWhichUpdates() {
    list.add("d", 99);
    list.add("c", 42);
    list.add("d", 101);
    assertEquals(2, list.size());
  }

  @Test
  public void testAddAndGetToEmpty() {
    assertNull(list.add("z", 23));
    assertEquals((Integer) 23, list.get(0));
  }

  @Test
  public void testAddAndGetToFront() {
    assertNull(list.add("z", 23));
    assertNull(list.add("b", 19));
    assertEquals((Integer) 19, list.get(0));
  }

  @Test
  public void testAddAndGetToEnd() {
    assertNull(list.add("z", 23));
    assertNull(list.add("b", 19));
    assertNull(list.add("zz", 0));
    assertEquals((Integer) 0, list.get(2));
  }

  @Test
  public void testAddAndGetToMiddle() {
    assertNull(list.add("z", 23));
    assertNull(list.add("b", 19));
    assertNull(list.add("f", 1));
    assertEquals((Integer) 1, list.get(1));
  }

  @Test
  public void testAddUpdateAndGet() {
    assertNull(list.add("z", 23));
    assertNull(list.add("a", 77));
    assertNull(list.add("b", 19));
    assertNull(list.add("r", 72));
    assertEquals((Integer) 19, list.add("b", 814));
    assertEquals((Integer) 814, list.get(1));
  }

  @Test
  public void testGetEmpty() {
    assertNull(list.get(0));
  }

  @Test
  public void testGeInvalidIndex() {
    assertNull(list.get(-1));
    list.add("g", 17);
    assertNull(list.get(22));
  }

  @Test
  public void testFindEmpty() {
    assertNull(list.find("abc"));
  }

  @Test
  public void testFindNotFound() {
    list.add("a", 1);
    list.add("B", 54);
    list.add("c", 22);
    assertNull(list.find("abc"));
  }

  @Test
  public void testFindOnly() {
    list.add("abc", 1);
    assertEquals((Integer) 1, list.find("abc"));
  }

  @Test
  public void testFindFront() {
    list.add("a", 1);
    list.add("b", 2);
    assertEquals((Integer) 1, list.find("a"));
  }

  @Test
  public void testFindBack() {
    list.add("a", 1);
    list.add("b", 2);
    assertEquals((Integer) 2, list.find("b"));
  }

  @Test
  public void testFindMiddle() {
    list.add("aa", 1);
    list.add("bb", 2);
    list.add("cc", 3);
    assertEquals((Integer) 2, list.find("bb"));
  }

  @Test
  public void testFindIgnoreCase() {
    list.add("aa", 1);
    assertEquals((Integer) 1, list.find("AA"));
  }
}
