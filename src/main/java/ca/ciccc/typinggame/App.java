package ca.ciccc.typinggame;

import ca.ciccc.typinggame.model.WordGenerator;
import java.io.IOException;
import java.net.URISyntaxException;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class App extends Application {
  public static Stage primaryStage;

  public static void main(String[] args) {
    launch();
  }

  @Override
  public void start(Stage startStage) {
    primaryStage = startStage;
    primaryStage.setResizable(false);
    setStartScene();
    primaryStage.show();
  }

  public void setStartScene() {
    try {
      
      wordGenerator =
          new WordGenerator(getClass().getResource("../../../wordlist.txt").toURI());
    } catch (URISyntaxException e) {
      e.printStackTrace();
    }
    try {
      Parent root = FXMLLoader.load(getClass().getResource("../../../view/main.fxml"));
      Scene scene = new Scene(root, 640, 512);
      scene.getStylesheets().add("view/styles.css");
      primaryStage.setScene(scene);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void setGameScene() {
    try {
      Image time =
          new Image(getClass().getResource("../../../view/images/game-time.png").toString());
      ImageView ivTime = new ImageView(time);
      ivTime.setImage(time);
      ivTime.setFitWidth(140);
      ivTime.setPreserveRatio(true);
      ivTime.setTranslateX(20);
      ivTime.setTranslateY(-5);

      Image score =
          new Image(getClass().getResource("../../../view/images/game-score.png").toString());
      ImageView ivScore = new ImageView(score);
      ivScore.setImage(score);
      ivScore.setFitWidth(140);
      ivScore.setPreserveRatio(true);
      ivScore.setTranslateX(340);
      ivScore.setTranslateY(-5);

      Image sling1 = new Image("view/images/game-sling1.png");
      ImageView ivSling1 = new ImageView(sling1);
      ivSling1.setImage(sling1);
      ivSling1.setFitWidth(200);
      ivSling1.setPreserveRatio(true);
      ivSling1.setTranslateX(210);
      ivSling1.setTranslateY(328);

      Group gameGroup = new Group();
      HBox box = new HBox();
      box.getChildren().add(ivTime);
      box.getChildren().add(ivScore);
      gameGroup.getChildren().add(box);
      gameGroup.getChildren().add(ivSling1);

      AnchorPane root = FXMLLoader.load(getClass().getResource("../../../view/game.fxml"));
      root.getChildren().add(gameGroup);
      Scene scene = new Scene(root, 640, 512);
      scene.getStylesheets().add("view/styles.css");
      primaryStage.setScene(scene);

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void setHowToPlayScene() {
    try {
      Image howToPlayImage =
          new Image(getClass().getResource("../../../view/images/howtoplay.png").toString());
      ImageView ivHowToPlay = new ImageView(howToPlayImage);
      ivHowToPlay.setImage(howToPlayImage);
      ivHowToPlay.setFitWidth(640);
      ivHowToPlay.setPreserveRatio(true);

      Image mainMenu =
          new Image(
              getClass().getResource("../../../view/images/result-btn_mainmenu1.png").toString());

      ImageView ivMainMenu = new ImageView(mainMenu);
      ivMainMenu.setImage(mainMenu);
      ivMainMenu.setFitWidth(210);
      ivMainMenu.setPreserveRatio(true);

      Button mainMenuBtn = new Button();
      mainMenuBtn.setGraphic(ivMainMenu);
      mainMenuBtn.setStyle("-fx-background-color: transparent; -fx-text-fill: white;");
      mainMenuBtn.setPadding(Insets.EMPTY);
      mainMenuBtn.setTranslateX(210);
      mainMenuBtn.setTranslateY(335);
      mainMenuBtn.setOnAction(e -> setStartScene());
      Group howToPlayGroup = new Group();
      howToPlayGroup.getChildren().add(ivHowToPlay);
      howToPlayGroup.getChildren().add(mainMenuBtn);

      AnchorPane root = FXMLLoader.load(getClass().getResource("../../../view/main.fxml"));
      root.getChildren().add(howToPlayGroup);
      Scene scene = new Scene(root, 640, 512);
      scene.getStylesheets().add("view/styles.css");
      primaryStage.setScene(scene);

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void exit() {
    System.exit(0);
    Platform.exit();
  }
}
