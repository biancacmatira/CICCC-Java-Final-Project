package ca.ciccc.typinggame.model;

import java.io.*;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WordGenerator {
  private List<List<String>> wordList;
  private final int INITIALIZE_NUM = 10;

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

  public Word generateWord(int length, int count) {
    Random rand = new Random();
    String str = "";

    if (length >= wordList.size() || wordList.get(length).size() < count) {
      int i;
      do {
        i = rand.nextInt(wordList.size());
      } while (wordList.get(i).size() == 0);
      str = wordList.get(i).get(rand.nextInt(wordList.get(i).size()));
    } else {
      str = wordList.get(length).get(rand.nextInt(wordList.get(length).size()));
    }

    Word word = new Word(str);
    return word;
  }
}
