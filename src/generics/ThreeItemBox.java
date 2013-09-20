package generics;

import java.util.ArrayList;
import java.util.Collections;

public class ThreeItemBox<T extends Comparable> {
  private T first;
  private T second;
  private T third;

  public ThreeItemBox(T first, T second, T third) {
    this.setFirst(first);
    this.setSecond(second);
    this.setThird(third);
  }

  public T getFirst() {
    return first;
  }

  public void setFirst(T first) {
    this.first = first;
  }

  public T getSecond() {
    return second;
  }

  public void setSecond(T second) {
    this.second = second;
  }

  public T getThird() {
    return third;
  }

  public void setThird(T third) {
    this.third = third;
  }

  public ArrayList<T> getSortedItems() {
    ArrayList<T> sortedItems = new ArrayList<T>();
    sortedItems.add(first);
    sortedItems.add(second);
    sortedItems.add(third);
    Collections.sort(sortedItems);
    return sortedItems;
  }

  public static void main(String[] args) {
    ThreeItemBox<Integer> intBox = new ThreeItemBox<Integer>(9, 5, 1);
    ThreeItemBox<Double> doubleBox = new ThreeItemBox<Double>(8.5, 100.0, 2.0);
    ThreeItemBox<String> stringBox = new ThreeItemBox<String>("poke", "ono", "ahi");

    System.out.format("%s\n%s\n%s\n", intBox.getSortedItems(), doubleBox.getSortedItems(), stringBox.getSortedItems());
  }
}
