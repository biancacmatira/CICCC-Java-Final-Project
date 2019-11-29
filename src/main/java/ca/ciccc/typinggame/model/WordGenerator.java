package ca.ciccc.typinggame.model;

import java.io.*;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class WordGenerator {
  private List<List<String>> wordList;

  public WordGenerator(URI location) {
    wordList = new ArrayList<List<String>>();
    File file = new File(location);
    if (!file.exists()) {
      System.out.println("File not found.");
    }
    try {
      FileReader fileReader = new FileReader(file);
      BufferedReader bufferedReader = new BufferedReader(fileReader);
      String line;
      while ((line = bufferedReader.readLine()) != null) {
        wordList.get(0).add(line);
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    //    System.out.println(wordList);
    //    this.wordList = wordList;
  }

  public Word generateWord(int length) {
    /**
     * TODO: read text file to load words list. add each word to wordList.
     *
     * @param length length of each word
     */
    return null;
  }
}
