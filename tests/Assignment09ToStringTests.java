import java.util.Arrays;

/**
 * Since students may have slightly different spacing and trailing spaces and newlines, I though it would be easier
 * to simply perform visual analysis to see if the toString looks correct.
 */
public class Assignment09ToStringTests {
  A09Tree<Integer> tree;

  public Assignment09ToStringTests() {
    testToStringSingle();
    testToStringBasicLeft();
    testToStringBasicRight();
    testToStringBasicFull();
    testToStringLongLeft();
    testToStringLongRight();
    testToStringAlternatingAdd();
    testToStringLarge();
  }

  public void testToStringSingle() {
    tree = new A09Tree<Integer>();
    tree.add(1, lefts(""));
    compareToStrings("1\n", tree.toString());
  }


  public void testToStringBasicLeft() {
    tree = new A09Tree<Integer>();
    tree.add(15, lefts(""));
    tree.add(10, lefts("l"));
    compareToStrings("15\n    10\n", tree.toString());
  }


  public void testToStringBasicRight() {
    tree = new A09Tree<Integer>();
    tree.add(15, lefts(""));
    tree.add(20, lefts("r"));
    compareToStrings("15\n    20\n", tree.toString());
  }


  public void testToStringBasicFull() {
    tree = new A09Tree<Integer>();
    tree.add(15, lefts(""));
    tree.add(20, lefts("r"));
    tree.add(10, lefts("l"));
    compareToStrings("15\n    10\n    20\n", tree.toString());
  }


  public void testToStringLongLeft() {
    tree = new A09Tree<Integer>();
    tree.add(4, lefts(""));
    tree.add(3, lefts("l"));
    tree.add(2, lefts("l l"));
    tree.add(1, lefts("l l l"));
    compareToStrings("4\n    3\n        2\n            1\n", tree.toString());
  }


  public void testToStringLongRight() {
    tree = new A09Tree<Integer>();
    tree.add(1, lefts(""));
    tree.add(2, lefts("r"));
    tree.add(3, lefts("r r"));
    tree.add(4, lefts("r r r"));
    compareToStrings("1\n    2\n        3\n            4\n", tree.toString());
  }


  public void testToStringAlternatingAdd() {
    tree = new A09Tree<Integer>();
    tree.add(20, lefts(""));
    tree.add(15, lefts("l"));
    tree.add(25, lefts("r"));
    tree.add(10, lefts("l l"));
    tree.add(30, lefts("r r"));
    tree.add(12, lefts("l l r"));
    tree.add(28, lefts("r r l"));
    compareToStrings("20\n    15\n        10\n            12\n    25\n        30\n            28\n", tree.toString());
  }


  public void testToStringLarge() {
    tree = new A09Tree<Integer>();
    tree.add(20, lefts(""));
    tree.add(25, lefts("r"));
    tree.add(23, lefts("r l"));
    tree.add(30, lefts("r r"));
    tree.add(29, lefts("r r l"));
    tree.add(35, lefts("r r r"));
    tree.add(15, lefts("l"));
    tree.add(10, lefts("l l"));
    tree.add(12, lefts("l l r"));
    compareToStrings("20\n    15\n        10\n            12\n    25\n        23\n        30\n            29\n            35\n", tree.toString());
  }

  private void compareToStrings(String expected, String actual) {
    System.out.println("-----------------------------------------");
    System.out.format("expected\n%s\nactual\n%s\n", expected, actual);
    System.out.println("-----------------------------------------");
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

  public static void main(String[] args) {
    Assignment09ToStringTests visualTests = new Assignment09ToStringTests();
  }
}
