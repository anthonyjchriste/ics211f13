package io;

import java.util.LinkedList;
import java.util.List;

public class IOExamples {
  public static List<String> readFile(String filePath) {
    // TODO
    return null;
  }

  public static void writeFile(String filePath, List<String> lines) {
    // TODO
  }

  private static List<String> replaceJabberwock(List<String> lines) {
    List<String> replacedLines = new LinkedList<String>();
    for(String line : lines) {
      replacedLines.add(line.replace("Jabberwock", ":-D"));
    }
    return replacedLines;
  }

  public static void main(String[] args) {
    // Read file using first command line argument as file path
    List<String> lines = readFile("");

    // Write to file name specified by second command line argument
    writeFile("", replaceJabberwock(lines));
  }
}
