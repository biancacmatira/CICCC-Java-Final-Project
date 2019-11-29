package ca.ciccc.typinggame.model;

import java.io.*;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WordGenerator {
  private List<List<String>> wordList;
  private final int INITIALIZE_NUM = 10;
  private String str;

  public WordGenerator(URI location) {
    wordList = new ArrayList<List<String>>();

    for (int i = 0; i < INITIALIZE_NUM; i++) {
      wordList.add(new ArrayList<String>());
    }

    File file = new File(location);
    if (!file.exists()) {
      System.out.println("File not found.");
    }
    try {
      FileReader fileReader = new FileReader(file);
      BufferedReader bufferedReader = new BufferedReader(fileReader);
      String line;
      while ((line = bufferedReader.readLine()) != null) {
        if (line.length() >= wordList.size()) {
          for (int i = line.length() - wordList.size(); i >= 0; i--) {
            wordList.add(new ArrayList<>());
          }
        }
        wordList.get(line.length()).add(line);
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    this.wordList = wordList;
  }

  public Word generateWord(int length) {
    /**
     * TODO: read text file to load words list. add each word to wordList.
     *
     * @param length length of each word
     */
    Random rand = new Random();
    for (int i = 0; i < length; i++) {
      if (wordList.get(length - i).size() != 0) {
        str = wordList.get(length - i).get(rand.nextInt(wordList.get(length - i).size()));
        break;
      }
    }
    Word word = new Word(str);
    return word;
  }
}
