package com.nojpg.JavaRss.Launch;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.net.URL;

/**
 * Created by Nojpg on 03.06.17.
 */
public class Controller {
    @FXML
    private Button btnAdd ;
//    = (Button).root.lookup(btnAdd);

    @FXML
    public void showDialog(ActionEvent event){
        Stage stage = new Stage();
        stage.initOwner(stage);
        stage.initModality(Modality.WINDOW_MODAL);

        Label modalityLabel = new Label(Modality.WINDOW_MODAL.toString());
        Button closeButton = new Button("Close");
        closeButton.setOnAction(e -> stage.close());

        VBox root = new VBox();
        root.getChildren().addAll(modalityLabel, closeButton);
        Scene scene = new Scene(root, 200, 100);
        stage.setScene(scene);
        stage.setTitle("A Dialog Box");
        stage.show();
    }

    public Controller(){

    }

    @FXML
    private URL location;

    @FXML
    private void initialize(){
        System.out.println("init" + location);
    }

    @FXML
    private void sayHello(){
        System.out.println("hello");
    }
}
