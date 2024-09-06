package io.github.chiangkaishek327;

import io.github.chiangkaishek327.animated.util.OtherUtil;
import javafx.application.Application;
import javafx.event.EventType;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class PhysicsTest extends Application {
    public static void mn(String[] args) {
        launch(args);
    }

    double acdt = 1;
    double mass = 0.5;
    double downspeed = 0;
    double ground = 400;
    double bly;

    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane a = new AnchorPane();

        a.setPrefSize(500, 400);
        Circle circle = new Circle(10, Color.RED);
        circle.setLayoutX(30);
        circle.setLayoutY(400);
        new Thread(() -> {
            for (;;) {
                OtherUtil.delayConviently(20);
                bly = circle.getLayoutY();
                circle.setLayoutY(bly + downspeed);
                if (downspeed < 100 && downspeed > -100)
                    if (bly < ground)
                        downspeed = downspeed + (mass * acdt);
                    else {
                        if (downspeed > 0)
                            ;

                        // downspeed = -downspeed + 3;

                    }

                if (bly > ground) {
                    circle.setLayoutY(ground);
                    downspeed = 0;
                }

            }
        }).start();
        a.getChildren().addAll(circle);
        primaryStage.setScene(new Scene(a));
        primaryStage.getScene().setOnKeyPressed(e -> {
            KeyCode c = e.getCode();
            if (c == KeyCode.UP && circle.getLayoutY() >= ground) {

                downspeed = -10;
            }
            if (c == KeyCode.LEFT) {
                circle.setLayoutX(circle.getLayoutX() + 5);
            } else if (c == KeyCode.RIGHT) {

                circle.setLayoutX(circle.getLayoutX() - 5);
            }
        });
        primaryStage.setOnCloseRequest(e -> System.exit(0));
        primaryStage.show();

    }
}
