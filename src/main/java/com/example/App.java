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

    private void showScene3() // show lots
    {
//        availLotsHeader.setText("Available Slots:"); //center this
        String[] lots = {"Lot 1", "Lot 2", "Lot 3", "Lot 4", "Lot5"};
        VBox lotBtnContainer = new VBox();
        for (String lot : lots) {
            Button lotBtn = new Button(lot);
//            lotBtn.setOnAction(e -> handleButtonClick(lotBtn));
            lotBtnContainer.getChildren().add(lotBtn);
        }
        Button testo = new Button();
        testo.setText("Total Slots: 500 \nSlots available: " + parkingLot.getTotalSlots());
        testo.setFont(macFriendlyFont);
        VBox parkingLotScreen = new VBox(testo);
        scene3 = new Scene(parkingLotScreen, 800, 400);
        stage.setScene(scene3);
        stage.show();

    }
//    private void showScene4() //show lots and zones
//    {
//
//        Button testo1 = new Button();
//        VBox lotAndZonesScreen = new VBox(testo1);
//        scene4 = new Scene(lotAndZonesScreen);
//
//
//    }
public static void main(String[] args) {
launch();
}
}