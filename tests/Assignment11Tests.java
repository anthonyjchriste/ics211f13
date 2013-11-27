import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class Assignment11Tests {
  private Hash211<String, Integer> table;

  @Before
  public void setup() {
    table = new Hash211<String, Integer>(10, false);
  }

  @Test
  public void testPutUniqueReturnsNull() {
    assertNull(table.put("a", 1));
  }

  @Test
  public void testPutDupReturnsOld() {
    table.put("a", 1);
    assertEquals((Integer) 1, table.put("a", 2));
  }

  @Test(expected = NullPointerException.class)
  public void testPutNullFirst() {
    table.put(null, 1);
  }

  @Test(expected = NullPointerException.class)
  public void testPutNullSecond() {
    table.put("a", null);
  }

  @Test(expected = NullPointerException.class)
  public void testPutNullBoth() {
    table.put(null, null);
  }

  @Test
  public void testGetEmpty() {
    assertNull(table.get("a"));
  }

  @Test
  public void testGetNotFound() {
    table.put("a", 1);
    table.put("b", 2);
    assertNull(table.get("c"));
  }

  @Test(expected = NullPointerException.class)
  public void testGetNull() {
    table.get(null);
  }

  @Test
  public void testGetSingle() {
    table.put("a", 1);
    assertEquals((Integer) 1, table.get("a"));
  }

  @Test
  public void testGetMultiple() {
    table.put("a", 1);
    table.put("b", 2);
    table.put("c", 3);
    assertEquals((Integer) 1, table.get("a"));
    assertEquals((Integer) 2, table.get("b"));
    assertEquals((Integer) 3, table.get("c"));
  }

  @Test
  public void testGetAfterUpdate() {
    table.put("b", 2);
    table.put("c", 3);
    table.put("b", 4);
    assertEquals((Integer) 4, table.get("b"));
  }

  @Test
  public void testMix() {
    table.put("a", 1);
    table.put("b", 2);
    assertEquals((Integer) 1, table.get("a"));
    table.put("c", 3);
    assertEquals((Integer) 2, table.get("b"));
    assertEquals((Integer) 3, table.get("c"));
    table.put("a", 5);
    assertEquals((Integer) 5, table.get("a"));
  }
  
}
