package ca.ciccc.typinggame;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;

public class App extends Application {
  public static void main(String[] args) {
    launch();
  }

  @Override
  public void start(Stage startStage) {
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

      //    Image sling1 = new Image("view/images/game-sling1.png");
      //    ImageView iv1 = new ImageView(sling1);
      //    iv1.setImage(sling1);
      //    iv1.setFitWidth(200);
      //    iv1.setPreserveRatio(true);
      //    iv1.setTranslateX(210);
      //    iv1.setTranslateY(328);
      //
      //    HBox hbox = new HBox(iv1);
      //
      //    Scene scene = new Scene(hbox, 640, 512);
      //    startStage.setScene(scene);
      //    startStage.show();

      Image time = new Image(new FileInputStream("src/main/view/images/game-time.png"));
      ImageView ivTime = new ImageView(time);
      ivTime.setImage(time);
      ivTime.setFitWidth(140);
      ivTime.setPreserveRatio(true);
      ivTime.setTranslateX(20);
      ivTime.setTranslateY(-5);

      Image score = new Image(new FileInputStream("src/main/view/images/game-score.png"));
      ImageView ivScore = new ImageView(score);
      ivScore.setImage(score);
      ivScore.setFitWidth(140);
      ivScore.setPreserveRatio(true);
      ivScore.setTranslateX(340);
      ivScore.setTranslateY(-5);

      Group gameGroup = new Group();
      HBox box = new HBox();
      box.getChildren().add(ivTime);
      box.getChildren().add(ivScore);
      gameGroup.getChildren().add(root);
      gameGroup.getChildren().add(box);
      Scene scene = new Scene(gameGroup, 640, 512);
      scene.getStylesheets().add("view/styles.css");

      gameStage.setScene(scene);
      gameStage.show();

      //      Scene scene1 = new Scene(timeScore, 640, 512);
      //      scene1.setFill(Color.TRANSPARENT);
      //      startStage.setScene(scene1);
      //      startStage.show();
    } catch (IOException e) {

    }
  }

  public void exit() {
    Platform.exit();
    System.exit(0);
  }
}
