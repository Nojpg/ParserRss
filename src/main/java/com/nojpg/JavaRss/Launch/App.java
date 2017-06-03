package com.nojpg.JavaRss.Launch;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;


import java.io.IOException;
import java.net.URL;

import static javafx.stage.Modality.WINDOW_MODAL;

/**
 * Created by Nojpg on 29.05.17.
 */
public class App extends Application {
    public static void main(String[] args) {
        Application.launch(args);
        com.nojpg.JavaRss.Model.FeedReader.readFeed("https://alogvinov.com/feed/");

    }


    @Override
    public void start(Stage primaryStage) throws Exception{
//         construct a URL for the FXML doc
        URL fxmlURL = this.getClass().getClassLoader().getResource("main.fxml");
//
        Button addBtn = new Button("Add");
        addBtn.setOnAction(e -> showDialog(primaryStage, WINDOW_MODAL));

//        load the FXML doc
        AnchorPane root = FXMLLoader.<AnchorPane>load(fxmlURL);
        root.getChildren().addAll(addBtn);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private void showDialog(Window owner, Modality modality){
        // Create a Stage with specified owner and modality
        try {
            Stage stage = new Stage();
            VBox root = FXMLLoader.load(getClass().getResource("addWin.fxml"));

            stage.initOwner(owner);
            stage.initModality(modality);
            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.setTitle("A Dialog Box");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }



//        Label modalityLabel = new Label(modality.toString());
//        Button closeButton = new Button("Close");
//        closeButton.setOnAction(e -> stage.close());
//
//
//        VBox root = new VBox();
//        root.getChildren().addAll(
////                modalityLabel,
//                closeButton);
//        Scene scene = new Scene(root, 200, 100);


    }
}
