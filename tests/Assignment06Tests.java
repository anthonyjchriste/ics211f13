
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Assignment06Tests {
  private Calculate c;

  @Before
  public void setup() {
    c = new Calculate();
  }

  @Test
  public void testSimpleAdd() {
    assertEquals(5, c.calculate("3 + 2"), 0);
  }

  @Test
  public void testSimpleSubtract() {
    assertEquals(3, c.calculate("5 - 2"), 0);
  }

  @Test
  public void testSimpleMultiply() {
    assertEquals(14, c.calculate("2 * 7"), 0);
  }

  @Test
  public void testSimpleDivide() {
    assertEquals(4, c.calculate("20 / 5"), 0);
  }

  @Test
  public void testFloatingAdd() {
    assertEquals(5.5, c.calculate("2.75 + 2.75"), .001);
  }

  @Test
  public void testFloatingSubtract() {
    assertEquals(5.5, c.calculate("10.75 - 5.25"), .001);
  }

  @Test
  public void testFloatingMultiply() {
    assertEquals(52.5, c.calculate("5.0 * 10.5"), .001);
  }

  @Test
  public void testFloatingDivide() {
    assertEquals(8, c.calculate("4 / 0.5"), 0);
  }

  @Test
  public void testComboLowPrecedence() {
    assertEquals(8, c.calculate("2 + 5 - 1 - 1 + 3"), 0);
  }

  @Test
  public void testComboHighPrecedence() {
    assertEquals(12, c.calculate("3 * 3 / 3 / 1 * 4"), 0);
  }

  @Test
  public void testComboLowHigh() {
    assertEquals(28, c.calculate("3 + 5 * 5"), 0);
  }

  @Test
  public void testComboHighLow() {
    assertEquals(20, c.calculate("3 * 5 + 5"), 0);
  }

  @Test
  public void testSandwichLow() {
    assertEquals(27, c.calculate("3 + 5 * 5 - 1"), 0);
  }

  @Test
  public void testSandwichHigh() {
    assertEquals(20, c.calculate("3 * 5 + 5 / 1"), 0);
  }

  @Test
  public void testMix() {
    assertEquals(10, c.calculate("2 * 3 + 5 * 5 * 2 / 10 - 1 * 1"), 0);
  }
}
