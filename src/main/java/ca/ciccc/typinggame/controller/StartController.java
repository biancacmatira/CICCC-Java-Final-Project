package ca.ciccc.typinggame.controller;

import ca.ciccc.typinggame.App;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class StartController implements Initializable {
  @FXML private Button startButton; // id
  @FXML private Button howToPlayButton; // id
  @FXML private javafx.scene.control.Button exitButton; // id

  @FXML
  public void pressStart() {
    startButton.getEventDispatcher();
    new App().setGameScene();
  }

  @FXML
  public void pressHowToPlay() {
    howToPlayButton.getEventDispatcher();
    // TODO: App().HowToPlayScene();
  }

  @FXML
  private void pressExit() {
    exitButton.getEventDispatcher();
    new App().exit();
  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    startButton = new Button();
    howToPlayButton = new Button();
    exitButton = new Button();
  }
}
