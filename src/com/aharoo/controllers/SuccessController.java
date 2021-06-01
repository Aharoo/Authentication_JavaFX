package com.aharoo.controllers;

import com.aharoo.ChangeSceneHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class SuccessController {

	private ChangeSceneHandler changeSceneHandler = new ChangeSceneHandler();

	@FXML
	private ImageView imageButtonHome;

	@FXML
	private Button mainMenuButton;

	@FXML
	void initialize(){
		mainMenuButton.setOnAction(event -> {
			String path = "/com/aharoo/view/singIn.fxml";
			changeSceneHandler.changeScene(mainMenuButton,path,"AuthenticationWindow");
		});
	}

}