package org.openjfx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class App extends Application {

    @Override
    public void start(Stage stage) {
	BorderPane root = new BorderPane();
		VBox images = new VBox();
		MainMenu mainMenu = new MainMenu(stage, images);
		ScrollPane imgdata = new ScrollPane();

		imgdata.setContent(images);
		images.setAlignment(Pos.CENTER);
		imgdata.setFitToWidth(true);
		imgdata.setPadding(new Insets(20));

		root.setTop(mainMenu);
		root.setCenter(imgdata);

		Scene scene = new Scene(root, 1920, 1080);
		stage.setScene(scene);
		stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
