package csci2320;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class WordCount {
  public static void main(String[] args) {
    try {
      try (FileInputStream fis = new FileInputStream("something.txt"); Scanner sc = new Scanner(fis)) {
        StringBuilder sb = new StringBuilder();
        while (sc.hasNextLine()) {
          sb.append(sc.nextLine());
          sb.append(" ");
        }
        String allWords = sb.toString();
        String[] words = allWords.split("[,.!?]? +");
        java.util.Map<String, Integer> counts = new HashMap<>();
        for (String word : words) {
          String lword = word.toLowerCase();
          counts.put(lword, counts.getOrDefault(lword, 0)+1);
        }
        System.out.println(counts);
      }
    }
    catch (IOException ex) {
      System.out.println(ex);
    }
  }
}
