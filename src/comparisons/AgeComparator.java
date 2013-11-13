package comparisons;

import java.util.Comparator;

/**
 * Compares two meeps by their age.
 */
public class AgeComparator implements Comparator<Meep> {
  /**
   * Compares to meeps by their age.
   * @param o1 The first meep.
   * @param o2 The second meep.
   * @return Negative is the first meep's age is less than the second's.
   *         0 if the two meeps have the same age.
   *         Positive if the first meep's age is greater than the second's.
   */
  @Override
  public int compare(Meep o1, Meep o2) {
    // TODO
    return 0;
  }
}
