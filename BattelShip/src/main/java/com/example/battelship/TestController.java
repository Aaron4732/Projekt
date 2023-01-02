package com.example.battelship;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

public class TestController extends Application {

    static int width = 800;
    static int hight = 500;
    static int playerHeight = 100;
    static int playerWidth = 15;
    static double ballRadios = 15;
    static int ballSpeedX = 1;
    static int ballSpeedY = 1;
    double playerOnePosY = hight /2;
    double playerTwoPosY = hight /2;
    double ballPosX = width /2;
    double getBallPosY = width /2;
    int scorePlayer1 = 0;
    int ScorePlayer2 = 0;
    boolean gameStarted;
    int playerOnePosX = 0;
    int playerTwoPosX = width - playerWidth;



    public void start(Stage stage) throws Exception {
        stage.setTitle("PONG");
        Canvas canvas = new Canvas(width, hight);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        Timeline tl = new Timeline(new KeyFrame(Duration.millis(10), e ->run(gc)));
        tl.setCycleCount(Timeline.INDEFINITE);

        //mouse Control
        canvas.setOnMouseMoved(e -> playerOnePosY = e.getY());
        canvas.setOnMouseClicked(e -> gameStarted = true);
        stage.setScene(new Scene(new StackPane(canvas)));
        stage.show();
        tl.play();

    }

    public void run(GraphicsContext gc) {
        //set backround color
        gc.setFill(Color.BLACK);
        gc.fillRect(0,0,width,hight);

        //set text color
        gc.setFill(Color.WHITE);
        gc.setFont(Font.font(25));


    }
}
