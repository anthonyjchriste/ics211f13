package io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class IOExamples {
  public static List<String> readFile(String filePath) {
    List<String> lines = new LinkedList<String>();
    Scanner in;

    try {
      in = new Scanner(new File(filePath));
      while(in.hasNextLine()) {
        lines.add(in.nextLine());
      }
    }
    catch (FileNotFoundException e) {
      System.err.format("Error: File [%s] not found.\n", filePath);
    }

    return lines;
  }

  public static void writeFile(String filePath, List<String> lines) {
    BufferedWriter out;

    try {
      out = new BufferedWriter(new FileWriter(new File(filePath)));
      for(String line : lines) {
        out.write(line + "\n");
      }
      out.close();
    }
    catch (IOException e) {
      System.err.format("Error writing to file %s\n", filePath);
    }
  }

  private static List<String> replaceJabberwock(List<String> lines) {
    List<String> replacedLines = new LinkedList<String>();
    for(String line : lines) {
      replacedLines.add(line.replace("Jabberwock", ":-D"));
    }
    return replacedLines;
  }

  public static void main(String[] args) {
    if(args.length != 2) {
      System.out.format("Incorrect number of parameters [%d] need 2.\n", args.length);
      System.out.println("Usage: java IOExamples file_in file_out");
      System.exit(0);
    }

    // Read file using first command line argument as file path
    List<String> lines = readFile(args[0]);

    // Write to file name specified by second command line argument
    writeFile(args[1], replaceJabberwock(lines));
  }
}
