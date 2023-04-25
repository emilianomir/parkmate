//main controller page, extends to other pages

package com.example;

import javafx.application.Application;
import javafx.event.*;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Random;

public class App extends Application {

    Font macFriendlyFont = new Font("Arial", 12);
    private static Stage stage;
    private static Scene scene1; //login scene
    private static Scene scene2; // homescreen, user has already logged in in scene 1
    private static Scene scene3;
    private static Scene scene4;
    private static Scene scene5;
    // public static Label loginPage;
    @Override
    //start method takes 
    public void start(Stage mainStage)
    {
        stage = mainStage;
        mainStage.setTitle("Login Screen");
        showScene1();
    }
    private void showScene1()
    {

        Button loginBtn = new Button("LOG IN"); //will listen for click and then go to scene 2
        loginBtn.setFont(macFriendlyFont);
        loginBtn.setOnAction(e-> showScene2()); //scnence 2 will be homescreen 
        VBox screen1 = new VBox(loginBtn);
        scene1 = new Scene(screen1, 400, 400);
        stage.setScene(scene1);
        stage.show();
        
    }
    private void showScene2()
    {
        Button checkAvailLotsBtn = new Button("Check available lots");
        checkAvailLotsBtn.setOnAction(e-> showScene3());
        Button signOutBtn = new Button("SIGN OUT");
        signOutBtn.setFont(macFriendlyFont);
        signOutBtn.setOnAction(e-> showScene1());
        checkAvailLotsBtn.setFont(macFriendlyFont);
        VBox screen2 = new VBox(signOutBtn, checkAvailLotsBtn);
        scene2 = new Scene(screen2, 800, 400);
        stage.setScene(scene2);
        stage.show();

    }

    private void showScene3() //show info
    {
        String lotOneInfo = parkingLot.getTotalSlots();
        String lotTwoInfo = parkingLot.getTotalSlots();
        String lotThreeInfo = parkingLot.getTotalSlots();
        String lotFourInfo = parkingLot.getTotalSlots();
        String lotFiveInfo = parkingLot.getTotalSlots();

        Label infoOne = new Label(lotOneInfo);
        Label infoTwo = new Label(lotTwoInfo);
        Label infoThree = new Label(lotThreeInfo);
        Label infoFour = new Label(lotFourInfo);
        Label infoFive = new Label(lotFourInfo);



//        testo.setText("Total Slots: 500 \nSlots available: " + parkingLot.getTotalSlots());
//        testo.setFont(macFriendlyFont);
//        VBox parkingLotScreen = new VBox(testo);
//        scene3 = new Scene(parkingLotScreen, 800, 400);
//        stage.setScene(scene3);
        stage.show();

    }

    public static class parkingLot { ///////////////
        private int lots = 5;


        public parkingLot(int _lots)
        {
            this.lots = _lots;
        }

        public static int totalSlots = 500;
        public static String getTotalSlots()
        {
            Random randomNum = new Random();
            int occupancyNum = randomNum.nextInt(500);
            String occupancyStr = "";
            occupancyStr += occupancyNum;
            totalSlots = occupancyNum;
            return occupancyStr;

        }

    }

public static void main(String[] args) {
launch();
}
}