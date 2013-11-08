import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class Assignment09Tests {
  private A09Tree<Integer> tree;

  @Before
  public void setup() {
    tree = new A09Tree<Integer>();
  }

  @Test
  public void testToListEmpty() {
    assertEquals(0, tree.toList().size());
  }

  @Test
  public void testToListSingle() {
    tree.add(10, lefts(""));
    assertEquals(10, (int) tree.toList().get(0));
  }

  @Test
  public void testToListBasicLeft() {
    tree.add(15, lefts(""));
    tree.add(10, lefts("l"));
    assertEquals(Arrays.asList(10, 15), tree.toList());
  }

  @Test
  public void testToListBasicRight() {
    tree.add(15, lefts(""));
    tree.add(20, lefts("r"));
    assertEquals(Arrays.asList(15, 20), tree.toList());
  }

  @Test
  public void testToListBasicFull() {
    tree.add(15, lefts(""));
    tree.add(20, lefts("r"));
    tree.add(10, lefts("l"));
    assertEquals(Arrays.asList(10, 15, 20), tree.toList());
  }

  @Test
  public void testToListLongLeft() {
    tree.add(4, lefts(""));
    tree.add(3, lefts("l"));
    tree.add(2, lefts("l l"));
    tree.add(1, lefts("l l l"));
    assertEquals(Arrays.asList(1, 2, 3, 4), tree.toList());
  }

  @Test
  public void testToListLongRight() {
    tree.add(1, lefts(""));
    tree.add(2, lefts("r"));
    tree.add(3, lefts("r r"));
    tree.add(4, lefts("r r r"));
    assertEquals(Arrays.asList(1, 2, 3, 4), tree.toList());
  }

  @Test
  public void testToListAlternatingAdd() {
    tree.add(20, lefts(""));
    tree.add(15, lefts("l"));
    tree.add(25, lefts("r"));
    tree.add(10, lefts("l l"));
    tree.add(30, lefts("r r"));
    tree.add(12, lefts("l l r"));
    tree.add(28, lefts("r r l"));

    assertEquals(Arrays.asList(10, 12, 15, 20, 25, 28, 30), tree.toList());
  }

  @Test
  public void testToListLarge() {
    tree.add(20, lefts(""));
    tree.add(25, lefts("r"));
    tree.add(23, lefts("r l"));
    tree.add(30, lefts("r r"));
    tree.add(29, lefts("r r l"));
    tree.add(35, lefts("r r r"));
    tree.add(15, lefts("l"));
    tree.add(10, lefts("l l"));
    tree.add(12, lefts("l l r"));

    assertEquals(Arrays.asList(10, 12, 15, 20, 23, 25, 29, 30, 35), tree.toList());
  }

  @Test(expected = ArrayIndexOutOfBoundsException.class)
  public void testAddSmallArray() {
    tree.add(1, lefts(""));
    tree.add(2, lefts("l"));
    tree.add(3, lefts("l"));
  }

  @Test
  public void testAddLargeArray() {
    tree.add(2, lefts(""));
    tree.add(1, lefts("l l r l"));
    assertEquals(Arrays.asList(1, 2), tree.toList());
  }

  private boolean[] lefts(String dirs) {
    if(dirs.equals("")) {
      return new boolean[0];
    }

    String[] splitDirs = dirs.split(" ");
    boolean[] lefts = new boolean[splitDirs.length];

    for(int i = 0; i < splitDirs.length; i++) {
      lefts[i] = splitDirs[i].equals("l") ? true : false;
    }
    return lefts;
  }
}
