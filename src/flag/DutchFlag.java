package flag;

import java.util.Arrays;

public class DutchFlag {

  private static final int RED = 1;
  private static final int WHITE = 2;
  private static final int BLUE = 3;

  private static void swap(int[] a, int i, int j) {
    int tmp = a[i];
    a[i] = a[j];
    a[j] = tmp;
  }

  private static void makeDutchFlag(int[] colors) {
    int bottom = 0;
    int top = colors.length - 1;
    int middle = 0;

    while(middle <= top) {
      if(colors[middle] == RED) {
        swap(colors, middle, bottom);
        bottom++;
        middle++;
      }
      else if(colors[middle] == BLUE) {
        swap(colors, middle, top);
        top--;
      }
      else {
        middle++;
      }
    }
  }


  public static void main(String[] args) {
    int[] colors = {2,1,2,1,3,3,3,3,3,1,2,1,2,1,2,1,1,2,3,2,1,3,1,2,3,3,2,1,1,2,3,1,2};
    makeDutchFlag(colors);
    System.out.println(Arrays.toString(colors));
  }
}
