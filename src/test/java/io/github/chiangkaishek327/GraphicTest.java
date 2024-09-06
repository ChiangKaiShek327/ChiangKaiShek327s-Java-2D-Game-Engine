package io.github.chiangkaishek327;

import static org.junit.jupiter.api.Assertions.fail;

import io.github.chiangkaishek327.animated.util.OtherUtil;
import io.github.chiangkaishek327.jge.graphics.MathUtil;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.property.DoubleProperty;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class GraphicTest extends Application {
    DoubleProperty angle, originX, originY;
    Point2D origin = new Point2D(300, 300), rel0ToOrigin = new Point2D(30, 100), rel1ToOrigin = new Point2D(-30, 100),
            rel2ToOrigin = new Point2D(-90, -100), rel3ToOrigin = new Point2D(30, -100);
    Line l0 = new Line(), l1 = new Line(), l2 = new Line(), l3 = new Line();
    double now = 0;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Rectangle rectangle = new Rectangle(100, 100, Paint.valueOf("#ff0000"));
        rectangle.setTranslateX(0);
        rectangle.setTranslateY(0);
        Pane pane = new Pane();
        pane.setPrefSize(400, 400);
        pane.getChildren().addAll(l0, l1, l2, l3, rectangle);

        new Thread() {

            public void run() {

                for (;;) {
                    OtherUtil.delayConviently(1);
                    now = now + 0.01;
                    Point2D p0 = MathUtil.getRotatedPoint(rel0ToOrigin, now, origin);
                    Point2D p1 = MathUtil.getRotatedPoint(rel1ToOrigin, now, origin);
                    Point2D p2 = MathUtil.getRotatedPoint(rel2ToOrigin, now, origin);
                    Point2D p3 = MathUtil.getRotatedPoint(rel3ToOrigin, now, origin);

                    Platform.runLater(() -> {
                        rectangle.setRotate(now * 45);
                        l0.setStartX(p0.getX());
                        l0.setStartY(p0.getY());
                        l1.setStartX(p1.getX());
                        l1.setStartY(p1.getY());
                        l2.setStartX(p2.getX());
                        l2.setStartY(p2.getY());
                        l3.setStartX(p3.getX());
                        l3.setStartY(p3.getY());

                        l0.setEndX(p1.getX());
                        l0.setEndY(p1.getY());
                        l1.setEndX(p2.getX());
                        l1.setEndY(p2.getY());
                        l2.setEndX(p3.getX());
                        l2.setEndY(p3.getY());
                        l3.setEndX(p0.getX());
                        l3.setEndY(p0.getY());
                    });
                }
            }
        }.start();
        primaryStage.setScene(new Scene(pane));
        primaryStage.show();
    }

    public static void mn(String[] args) {
        launch(args);
    }
}
