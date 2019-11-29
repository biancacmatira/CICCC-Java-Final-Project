package ca.ciccc.typinggame;

import ca.ciccc.typinggame.model.WordGenerator;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URISyntaxException;

public class App extends Application {
  public static void main(String[] args) {
    launch();
  }

  @Override
  public void start(Stage startStage) {
    try {
      WordGenerator wordGenerator =
          new WordGenerator(getClass().getResource("../../../wordlist.txt").toURI());
    } catch (URISyntaxException e) {
      e.printStackTrace();
    }
    try {
      Parent root = FXMLLoader.load(getClass().getResource("../../../view/main.fxml"));
      Scene scene = new Scene(root, 640, 512);
      scene.getStylesheets().add("view/styles.css");
      startStage.setScene(scene);
      startStage.show();
    } catch (IOException e) {

    }
  }

  public void displayStartScene() {
    Stage startStage = new Stage();
    StackPane root = new StackPane();
    root.setId("start-bg");
    Scene scene = new Scene(root, 640, 512);
    scene.getStylesheets().addAll(this.getClass().getResource("view/style.css").toExternalForm());
    startStage.setScene(scene);
    startStage.show();
  }

  public void displayGameScene() {
    try {
      Stage gameStage = new Stage();
      Parent root = FXMLLoader.load(getClass().getResource("../../../view/game.fxml"));
      Scene scene = new Scene(root, 640, 512);
      scene.getStylesheets().add("view/styles.css");
      gameStage.setScene(scene);
      gameStage.show();
    } catch (IOException e) {

    }
  }

  public void exit() {
    Platform.exit();
    System.exit(0);
  }
}
