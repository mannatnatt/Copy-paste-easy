/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readease2;

import java.util.ArrayList;
import static java.util.Collections.list;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import static readease2.SetupLayout.root;

/**
 *
 * @author Mannat Natt
 */
public class ReadEase2 extends Application {

    static Stage primaryStage = new Stage(StageStyle.TRANSPARENT);
    double initX;
    double initY;

    @Override
    public void start(Stage primaryStages) {

        primaryStage.setAlwaysOnTop(true);
        primaryStage.setResizable(false);
        primaryStage.setOpacity(0.7);
        javafx.scene.shape.Rectangle rs = new javafx.scene.shape.Rectangle(180, 120);
        rs.setArcHeight(20);
        rs.setArcWidth(20);

        SetupLayout sl = new SetupLayout();
        sl.root.setClip(rs);
        root.setOnMousePressed((MouseEvent me) -> {
            initX = me.getScreenX() - primaryStage.getX();
            initY = me.getScreenY() - primaryStage.getY();
        });

        root.setOnMouseDragged((MouseEvent me) -> {
            primaryStage.setX(me.getScreenX() - initX);
            primaryStage.setY(me.getScreenY() - initY);
        });

        Scene scene = new Scene(root, 180, 120);
        scene.setFill(null);
        scene.getStylesheets().add(ReadEase2.class.getResource("/readease2/front.css").toExternalForm());
        primaryStage.setTitle("DoItEasy");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
