package ca.ciccc.typinggame.controller;

import ca.ciccc.typinggame.model.Word;
import ca.ciccc.typinggame.model.WordGenerator;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.util.Duration;

// publicclass TypingGameController implements Initializable {
public class TypingGameController implements Initializable {
  private static final int INITIAL_WORD_LENGTH = 2;
  private static final int DEFAULT_TIME = 60;
  private static final int TIMER_DURATION = 1;

  @FXML private TextFlow timeFrame;
  @FXML private TextFlow scoreFrame;
  @FXML private TextFlow wordFrame1;
  @FXML private TextFlow wordFrame2;
  @FXML private TextFlow wordFrame3;
  @FXML private ScrollPane inputScrollPane;
  @FXML private TextFlow inputFrame;
  private TextFlow[] wordFrames;
  private Text resultScore;
  private HBox resultBox1;
  private HBox resultBox2;
  private Group textGroup;
  private ImageView[] stars;

  //  private Player player;
  //  private Player[] players;
  // private int timeRemains
  private WordGenerator wordGenerator;
  private int wordLength;
  private int wordCount;
  private IntegerProperty timeRemains;
  private IntegerProperty score;
  private StringProperty[] words = new StringProperty[3];
  private LinkedList<Word> targetWords;
  private StringProperty currentInput;
  private Scene scene;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    try {
      wordGenerator = new WordGenerator(getClass().getResource("../../../../wordlist.txt").toURI());
    } catch (URISyntaxException e) {
      e.printStackTrace();
    }
    wordLength = INITIAL_WORD_LENGTH;
    wordCount = 0;
    timeRemains = new SimpleIntegerProperty(DEFAULT_TIME);
    score = new SimpleIntegerProperty(0);
    currentInput = new SimpleStringProperty("");
    Timeline timer =
        new Timeline(
            new KeyFrame(
                Duration.millis(TIMER_DURATION * 1000),
                new EventHandler<ActionEvent>() {
                  @Override
                  public void handle(ActionEvent event) {
                    updateTimeRemains(TIMER_DURATION);
                  }
                }));
    timer.setCycleCount(DEFAULT_TIME);
    timer.play();

    Text timeText = new Text();
    timeText.textProperty().bind(timeRemains.asString());
    timeFrame.getChildren().add(timeText);

    Text scoreText = new Text();
    scoreText.textProperty().bind(score.asString());
    scoreFrame.getChildren().add(scoreText);

    targetWords = new LinkedList<>();
    for (int i = 0; i < 3; i++) {
      targetWords.add(getNextWord());
    }

    wordFrames = new TextFlow[] {wordFrame1, wordFrame2, wordFrame3};
    for (int i = 0; i < 3; i++) {
      Text wordText = new Text();
      words[i] = new SimpleStringProperty(targetWords.get(i).getStr());
      wordText.textProperty().bind(words[i]);
      wordFrames[i].getChildren().add(wordText);
    }

    inputScrollPane.setHbarPolicy(ScrollBarPolicy.NEVER);
    inputScrollPane.setVbarPolicy(ScrollBarPolicy.NEVER);
    Text inputText = new Text();
    inputText.textProperty().bind(currentInput);
    inputFrame.getChildren().add(inputText);
  }

  public void pressNewGame() {
    // TODO: initialize the game and call setGameScene()
  }

  public void pressMainMenu() {
    // TODO: initialize the game and call setStartScene()
  }

  public Scene getScene() {
    // TODO: get the Scene
    return null;
  }

  public void updateTimeRemains(int duration) {
    timeRemains.set(timeRemains.get() - duration);
    if (timeRemains.get() <= 0) {
      timeRemains.set(0);
      scene.removeEventHandler(KeyEvent.KEY_PRESSED, keyPressedHandler);
      scene.removeEventHandler(KeyEvent.KEY_TYPED, keyTypedHandler);
      int finalScore = score.get();
      resultScore.setText(String.valueOf(finalScore));
      resultBox1.setVisible(true);
      resultBox2.setVisible(true);
      textGroup.setVisible(true);
      if (finalScore < 10) {
        resultBox2.getChildren().add(stars[0]);
      } else if (finalScore < 20) {
        resultBox2.getChildren().add(stars[1]);
      } else if (finalScore < 40) {
        resultBox2.getChildren().add(stars[2]);
      } else {
        resultBox2.getChildren().add(stars[3]);
      }
    }
  }

  public void setupEventListener(Scene scene) {
    this.scene = scene;
    scene.addEventHandler(KeyEvent.KEY_PRESSED, keyPressedHandler);
    scene.addEventHandler(KeyEvent.KEY_TYPED, keyTypedHandler);
  }

  private EventHandler<KeyEvent> keyPressedHandler =
      new EventHandler<KeyEvent>() {
        @Override
        public void handle(KeyEvent e) {
          keyPressed(e);
        }
      };

  private EventHandler<KeyEvent> keyTypedHandler =
      new EventHandler<KeyEvent>() {
        @Override
        public void handle(KeyEvent e) {
          keyTyped(e);
        }
      };

  private void keyPressed(KeyEvent e) {
    switch (e.getCode()) {
      case ENTER:
        if (targetWords.get(0).checkInput(currentInput.get())) {
          targetWords.add(getNextWord());
          targetWords.poll();
          score.set(score.get() + 1);
          for (int i = 0; i < 3; i++) {
            words[i].set(targetWords.get(i).getStr());
          }
        }
        currentInput.set("");
        break;
      case BACK_SPACE:
        String prevStr = currentInput.get();
        if (prevStr.length() > 0) {
          currentInput.set(prevStr.substring(0, prevStr.length() - 1));
        }
        break;
      default:
        break;
    }
  }

  private void keyTyped(KeyEvent e) {
    String typedChar = e.getCharacter().trim();
    if (typedChar.isEmpty()) {
      return;
    }
    currentInput.set(currentInput.get() + typedChar);
  }

  private Word getNextWord() {
    if (wordCount >= wordLength) {
      wordLength++;
      wordCount = 0;
    }
    wordCount++;
    return wordGenerator.generateWord(wordLength, wordCount);
  }

  public void setResultScore(Text resultScore) {
    this.resultScore = resultScore;
  }

  public void setResultBox(HBox rb1, HBox rb2) {
    resultBox1 = rb1;
    resultBox2 = rb2;
  }

  public void setTextGroup(Group g) {
    textGroup = g;
  }

  public void setStars(ImageView[] stars) {
    this.stars = stars;
  }

  public void hitKey() {
    // TODO: check the input value
  }

  public void setResult() {
    // TODO: set the result page
  }
}
