package ca.ciccc.typinggame.controller;

import ca.ciccc.typinggame.model.Word;
import java.net.URL;
import java.util.Deque;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.util.Duration;

public class TypingGameController implements Initializable {
  private static final int DEFAULT_TIME = 60;
  private static final int TIMER_DURATION = 1;
  //  private Player player;
  //  private Player[] players;
  private int timeRemains;
  private int score;
  private Deque<Word> targetWords;
  private String currentInput;
  private boolean isFinished;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    this.isFinished = false;
    this.timeRemains = DEFAULT_TIME;
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
    timeRemains -= duration;
    if (timeRemains < 0) {
      timeRemains = 0;
      // TODO: show result
    }
  }

  public void hitKey() {
    // TODO: check the input value
  }

  public void setResult() {
    // TODO: set the result page
  }
}
