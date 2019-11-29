package ca.ciccc.typinggame.model;

public class Word {
  private String str;

  public Word(String str) {
    this.str = str;
  }

  public String getStr() {
    return str;
  }

  public boolean checkInput(String str) {
    return this.str.equals(str);
  }
}
