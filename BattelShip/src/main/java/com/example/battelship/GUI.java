package com.example.battelship;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Random;

public class GUI extends Application {

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
    double ballPosY = width /2;
    int scorePlayer1 = 0;
    int scorePlayer2 = 0;
    boolean gameStarted;
    double playerOnePosX;
    int playerTwoPosX = width - playerWidth;

    Stage stage;
    Scene scene;

    //Canvas canvas;

    //GraphicsContext gc;

    public void start(Stage stage) throws Exception {

        this.stage = stage;



        FXMLLoader fxmlLoader = new FXMLLoader(TestApplication.class.getResource("startMenue.fxml"));
        scene = new Scene(fxmlLoader.load(), width, hight);
        this.stage.setTitle("Hello!");
        this.stage.setScene(scene);
        this.stage.show();

    }

    @FXML
    public void startOnePlayerMode(ActionEvent actionEvent) {
        Canvas canvas = new Canvas(width, hight);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        Timeline tl = new Timeline(new KeyFrame(Duration.millis(1), e -> singelPLayerMode(gc)));
        tl.setCycleCount(Timeline.INDEFINITE);

        //mouse Control
        canvas.setOnMouseMoved(e -> playerOnePosX = e.getX());
        canvas.setOnMouseMoved(e -> playerOnePosY = e.getY());
        canvas.setOnMouseClicked(e -> gameStarted = true);

        stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(new StackPane(canvas));
        stage.setScene(scene);
        stage.show();
        tl.play();
    }
    @FXML
    public void startTwoPlayerMode(ActionEvent actionEvent) {
    }
    @FXML
    public void exitTheGame(ActionEvent actionEvent) {
    }

    public void singelPLayerMode(GraphicsContext gc) {
        int fieldCordinatX = 0;
        int fieldCordinatY = 0;

        gc.setFill(Color.BLACK);
        gc.fillRect(0,0,width,hight);

        //set text color
        gc.setFill(Color.WHITE);
        gc.setFont(Font.font(25));

        for (int i = 0; i < 8; i++) {
            gc.fillRect(playerOnePosX, playerOnePosY, playerWidth, playerHeight);

        }
    }
    @FXML
    public void Pong(ActionEvent actionEvent) {
        //stage.setTitle("PONG");
        Canvas canvas = new Canvas(width, hight);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        Timeline tl = new Timeline(new KeyFrame(Duration.millis(1), e -> run(gc)));
        tl.setCycleCount(Timeline.INDEFINITE);

        //mouse Control
        canvas.setOnMouseMoved(e -> playerOnePosY = e.getY());
        canvas.setOnMouseClicked(e -> gameStarted = true);

        stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(new StackPane(canvas));
        stage.setScene(scene);
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

        if (gameStarted) {
            ballPosX+= ballSpeedX;
            ballPosY += ballSpeedY;

            if (ballPosX < width - width/4) {
                playerTwoPosY = ballPosY - playerHeight / 2;
            }

            else {
                playerTwoPosY = ballPosY > playerTwoPosY + playerHeight / 2 ?playerTwoPosY += 1: playerTwoPosY -1;
            }

            gc.fillOval(ballPosX,ballPosY,ballRadios,ballRadios);
        }

        else {
            gc.setStroke(Color.WHITE);
            gc.setTextAlign(TextAlignment.CENTER);
            gc.strokeText("one Click", width / 2, hight / 2);

            ballPosX = width /2;
            ballPosY = hight /2;

            ballSpeedX = new Random().nextInt(2) == 0 ? 1: -1;
            ballSpeedY = new Random().nextInt(2) == 0 ? 1: -1;
        }

        if (ballPosY > hight - ballRadios || ballPosY < 0) ballSpeedY *= -1;

        if ((
                ballPosX == playerOnePosX + playerWidth && ballPosY > playerOnePosY && ballPosY < playerOnePosY + ballRadios + playerHeight) || (
                ballPosX + ballRadios == playerTwoPosX && ballPosY > playerTwoPosY && ballPosY < playerTwoPosY + ballRadios + playerHeight
        )) ballSpeedX *= -1;


        if (ballPosX < playerOnePosX - playerWidth) {
            scorePlayer2 ++;
            gameStarted = false;
        }

        if (ballPosX > playerTwoPosX) {
            scorePlayer2 ++;
            gameStarted = false;
        }

        gc.fillText(scorePlayer1 + "\t\t\t\t\t\t\t\t\t\t" + scorePlayer2, width /2, 100);

        gc.fillRect(playerOnePosX, playerOnePosY, playerWidth, playerHeight);
        gc.fillRect(playerTwoPosX, playerTwoPosY, playerWidth, playerHeight);
    }
}
