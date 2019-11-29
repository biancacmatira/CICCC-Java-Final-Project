package ca.ciccc.typinggame;

import java.io.IOException;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
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

      Group gameGroup = new Group();
      HBox box = new HBox();
      box.getChildren().add(ivTime);
      box.getChildren().add(ivScore);
      gameGroup.getChildren().add(box);

      AnchorPane root = FXMLLoader.load(getClass().getResource("../../../view/game.fxml"));
      root.getChildren().add(gameGroup);
      Scene scene = new Scene(root, 640, 512);
      scene.getStylesheets().add("view/styles.css");
      primaryStage.setScene(scene);

      //      Scene scene1 = new Scene(timeScore, 640, 512);
      //      scene1.setFill(Color.TRANSPARENT);
      //      startStage.setScene(scene1);
      //      startStage.show();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void exit() {
    Platform.exit();
    System.exit(0);
  }
}
