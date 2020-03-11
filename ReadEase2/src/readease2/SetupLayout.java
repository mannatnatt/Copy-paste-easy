/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readease2;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import static readease2.ListNavigation.page;
import static readease2.CreateList.response;

/**
 *
 * @author Mannat Natt
 */
public class SetupLayout{

    static Pane root = new Pane();

    public SetupLayout() {
        response = "Waiting for response";

        Button add = new Button("Add");
        add.setLayoutX(70);
        add.setLayoutY(10);

        Label pagen = new Label("" + page);
        pagen.setLayoutX(100);
        pagen.setLayoutY(75);

        Label res = new Label("" + response);
        res.setLayoutX(30);
        res.setLayoutY(45);

        Button prev = new Button("Previous");
        prev.setLayoutX(10);
        prev.setLayoutY(75);
        ListNavigation ln = new ListNavigation();
        prev.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                ln.back();
                pagen.setText("" + page);

            }
        });

        Button next = new Button("Next");
        next.setLayoutX(120);
        next.setLayoutY(75);
        next.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                ln.forward();
                pagen.setText("" + page);
            }
        });

        add.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                CreateList cl = new CreateList();
                pagen.setText("" + page);
                res.setText(response);

            }
        });

        root.getChildren().addAll(add, prev, next, res, pagen);

    }
}
