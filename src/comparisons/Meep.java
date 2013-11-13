package comparisons;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Represents a meep object.
 *
 * A meep is a fluffy little animal that lives in burrows under the ground. Their social structure is determined by one
 * of three attributes, their name, their age, or their weight (depending on the day).
 */
public class Meep implements Comparable<Meep> {
  private String name;
  private Integer age;
  private Integer weight;

  public Meep(String name, Integer age, Integer weight) {
    this.name = name;
    this.age = age;
    this.weight = weight;
  }

  public String getName() {
    return this.name;
  }

  public Integer getAge() {
    return this.age;
  }

  public Integer getWeight() {
    return this.weight;
  }

  @Override
  public String toString() {
    return String.format("N: %s\tA: %d\tW: %d", this.name, this.age, this.weight);
  }

  /**
   * Provides natural ordering (by name/alphabetical order) over this collection of meeps.
   * @param o The other meep being compared to.
   * @return Negative if this meep has name less than the other meep.
   *         0 if this meep has the same name as the other meep.
   *         Positive if this meep has a name greater than the other meep.
   */
  @Override
  public int compareTo(Meep o) {
    // TODO
    return 0;
  }

  public static void main(String[] args) {
    List<Meep> meeps = new ArrayList<Meep>();

    meeps.add(new Meep("B", 21, 7));
    meeps.add(new Meep("D", 19, 4));
    meeps.add(new Meep("C", 5, 20));
    meeps.add(new Meep("A", 34, 1));

    // Sort the meeps by name using natural ordering
    Collections.sort(meeps);
    System.out.println("Sorted naturally by name:");
    for(Meep meep : meeps) {
      System.out.println(meep);
    }

    // Sort the meeps by age using AgeComparator
    Collections.sort(meeps, new AgeComparator());
    System.out.println("\nSorted by age:");
    for(Meep meep : meeps) {
      System.out.println(meep);
    }

    // Sort the meeps by weight using anonymous class
    Collections.sort(meeps, new Comparator<Meep>() {
      /**
       * Compares to meeps by their weight.
       * @param o1 The first meep.
       * @param o2 The second meep.
       * @return Negative is the first meep's weight is less than the second's.
       *         0 if the two meeps have the same weight.
       *         Positive if the first meep's weight is greater than the second's.
       */
      @Override
      public int compare(Meep o1, Meep o2) {
        // TODO
        return 0;
      }
    });
    System.out.println("\nSorted by weight:");
    for(Meep meep : meeps) {
      System.out.println(meep);
    }
  }
}
