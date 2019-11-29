package ca.ciccc.typinggame;

import java.awt.*;
import java.io.IOException;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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

      Image sling2 = new Image("view/images/game-sling2.png");
      ImageView ivSling2 = new ImageView(sling2);
      ivSling2.setImage(sling2);
      ivSling2.setFitWidth(171);
      ivSling2.setPreserveRatio(true);
      ivSling2.setTranslateX(225);
      ivSling2.setTranslateY(235);

      Image sling3 = new Image("view/images/game-sling3.png");
      ImageView ivSling3 = new ImageView(sling3);
      ivSling3.setImage(sling3);
      ivSling3.setFitWidth(171);
      ivSling3.setPreserveRatio(true);
      ivSling3.setTranslateX(225);
      ivSling3.setTranslateY(176);

      Image sling4 = new Image("view/images/game-sling4.png");
      ImageView ivSling4 = new ImageView(sling4);
      ivSling4.setImage(sling4);
      ivSling4.setFitWidth(171);
      ivSling4.setPreserveRatio(true);
      ivSling4.setTranslateX(225);
      ivSling4.setTranslateY(328);

      Image char1 = new Image("view/images/game-char1.png");
      ImageView ivChar1 = new ImageView(char1);
      ivChar1.setImage(char1);
      ivChar1.setFitWidth(160);
      ivChar1.setPreserveRatio(true);
      ivChar1.setTranslateX(230);
      ivChar1.setTranslateY(205);

      Image char2 = new Image("view/images/game-char2.png");
      ImageView ivChar2 = new ImageView(char2);
      ivChar2.setImage(char2);
      ivChar2.setFitWidth(160);
      ivChar2.setPreserveRatio(true);
      ivChar2.setTranslateX(230);
      ivChar2.setTranslateY(242);

      Image char3 = new Image("view/images/game-char3.png");
      ImageView ivChar3 = new ImageView(char3);
      ivChar3.setImage(char3);
      ivChar3.setFitWidth(160);
      ivChar3.setPreserveRatio(true);
      ivChar3.setTranslateX(230);
      ivChar3.setTranslateY(272);

      Image char4 = new Image("view/images/game-char4.png");
      ImageView ivChar4 = new ImageView(char4);
      ivChar4.setImage(char4);
      ivChar4.setFitWidth(171);
      ivChar4.setPreserveRatio(true);
      ivChar4.setTranslateX(227);
      ivChar4.setTranslateY(335);

      Image block1 = new Image("view/images/game-block1.png");
      ImageView ivBlock1 = new ImageView(block1);
      ivBlock1.setImage(block1);
      ivBlock1.setFitWidth(150);
      ivBlock1.setPreserveRatio(true);
      ivBlock1.setTranslateX(235);
      ivBlock1.setTranslateY(168);

      ImageView ivBlock2 = new ImageView(block1);
      ivBlock2.setImage(block1);
      ivBlock2.setFitWidth(150);
      ivBlock2.setPreserveRatio(true);
      ivBlock2.setTranslateX(235);
      ivBlock2.setTranslateY(132);

      ImageView ivBlock3 = new ImageView(block1);
      ivBlock3.setImage(block1);
      ivBlock3.setFitWidth(150);
      ivBlock3.setPreserveRatio(true);
      ivBlock3.setTranslateX(235);
      ivBlock3.setTranslateY(96);

      Image block2 = new Image("view/images/game-block2.png");
      ImageView ivBlockBroken1 = new ImageView(block2);
      ivBlockBroken1.setImage(block2);
      ivBlockBroken1.setFitWidth(150);
      ivBlockBroken1.setPreserveRatio(true);
      ivBlockBroken1.setTranslateX(235);
      ivBlockBroken1.setTranslateY(168);

      Image block3 = new Image("view/images/game-block3.png");
      ImageView ivBlockBroken2 = new ImageView(block3);
      ivBlockBroken2.setImage(block3);
      ivBlockBroken2.setFitWidth(150);
      ivBlockBroken2.setPreserveRatio(true);
      ivBlockBroken2.setTranslateX(235);
      ivBlockBroken2.setTranslateY(175);

      Group gameGroup = new Group();
      HBox box = new HBox();
      box.getChildren().add(ivTime);
      box.getChildren().add(ivScore);
      gameGroup.getChildren().add(box);
      //      gameGroup.getChildren().add(ivBlockBroken1);
      //      gameGroup.getChildren().add(ivBlockBroken2);
      gameGroup.getChildren().add(ivBlock1);
      gameGroup.getChildren().add(ivChar1);
      gameGroup.getChildren().add(ivBlock2);
      gameGroup.getChildren().add(ivBlock3);
      //      gameGroup.getChildren().add(ivChar2);
      //      gameGroup.getChildren().add(ivChar3);
      //      gameGroup.getChildren().add(ivChar4);
      gameGroup.getChildren().add(ivSling1);
      //      gameGroup.getChildren().add(ivSling2);
      //      gameGroup.getChildren().add(ivSling3);
      //      gameGroup.getChildren().add(ivSling4);

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
