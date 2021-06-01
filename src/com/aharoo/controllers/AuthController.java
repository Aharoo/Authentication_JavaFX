package com.aharoo.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.aharoo.ChangeSceneHandler;
import com.aharoo.CheckAndRegisterUserHandler;
import com.aharoo.ErrorsHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import com.aharoo.animations.Shake;

public class AuthController {

	private CheckAndRegisterUserHandler checkExistingUser = new CheckAndRegisterUserHandler();
	private ChangeSceneHandler changeSceneHandler = new ChangeSceneHandler();
	private ErrorsHandler errorsHandler = new ErrorsHandler();
	private int tries;

	public AuthController(){
		tries = 3;
	}

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TextField loginField;

	@FXML
	private PasswordField passwordField;

	@FXML
	private Button authSignInButton;

	@FXML
	private Button loginSignUpButton;

	@FXML
	void initialize() {
		authSignInButton.setOnAction(event -> {
			if (tries == 0) errorsHandler.unsuccessAuthentication();

			String login = loginField.getText().trim();
			String password = passwordField.getText().trim();
			if (!login.equals("") && !password.equals("")) {
				if (checkExistingUser.checkExistingUser(login, password)) {
					String path = "/com/aharoo/view/successPage.fxml";
					changeSceneHandler.changeScene(authSignInButton, path, "SuccessAuthenticationWindow");
				} else {
					tries--;
					new Shake(loginField).playAnimation();
					new Shake(passwordField).playAnimation();
					errorsHandler.incorrectFieldsErrorMessage();
				}
			} else {
				errorsHandler.emptyFieldsErrorMessage();
			}

		});

		loginSignUpButton.setOnAction(event -> {
			String path = "/com/aharoo/view/signUp.fxml";
			changeSceneHandler.changeScene(loginSignUpButton,path,"RegistrationWindow");
		});
	}
}


