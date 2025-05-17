package org.openjfx;

import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import javafx.event.EventHandler;

public class MainMenu extends MenuBar {
	public MainMenu(Stage stage, VBox images) {
		Menu mainMenu = new Menu("File");
		
		MenuItem openfile = new MenuItem("Open");
		
		DirectoryChooser directoryChooser = new DirectoryChooser();
		directoryChooser.setTitle("Select Directory");

		openfile.setOnAction(new EventHandler() {
			@Override
			public void handle(Event event) {
				File selectedFile = directoryChooser.showDialog(stage);

				File[] files = selectedFile.listFiles();
				List<String> filesName = Arrays.stream(files)
						.map(file -> file.getAbsolutePath()).sorted().toList();

				images.getChildren().clear();
				for (String file : filesName) {
					FileInputStream imgfile;
					try {
						imgfile = new FileInputStream(file);
						Image img = new Image(imgfile);
						ImageView imgv = new ImageView(img);
						images.getChildren().add(imgv);

					} catch (FileNotFoundException e) {
						System.out.println("File Not Found : " + file);
					}

				}
			}
		});

		mainMenu.getItems().addAll(openfile, new SeparatorMenuItem());

		this.getMenus().add(mainMenu);

	}
}
