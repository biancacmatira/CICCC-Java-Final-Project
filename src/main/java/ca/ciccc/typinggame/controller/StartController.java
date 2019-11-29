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
  @FXML private Button creditsButton; // id
  @FXML private javafx.scene.control.Button exitButton; // id

  @FXML
  public void pressStart(ActionEvent actionEvent) {
    startButton.getEventDispatcher();
    new App().setGameScene();
  }

  //  startButton.setOnAction(new EventHandler()) {
  //    @Override
  //    public void handle(ActionEvent actionEvent) {
  //      app.setGameScene();
  //    }
  //  });

  @FXML
  public void pressCredits() {
    // TODO: go to credits page
  }

  @FXML
  private void pressExit() {
    Platform.exit();
    System.exit(0);
  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    startButton = new Button();
    creditsButton = new Button();
    exitButton = new Button();
  }
}
