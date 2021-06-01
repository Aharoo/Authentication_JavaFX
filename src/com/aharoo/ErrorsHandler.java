package com.aharoo;

import javafx.application.Platform;
import javafx.scene.control.Alert;

public class ErrorsHandler {
	public void emptyFieldsErrorMessage(){
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Error");
		alert.setHeaderText(null);
		alert.setContentText("Логін або пароль не введені");

		alert.showAndWait();
	}

	public void incorrectFieldsErrorMessage(){
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("IncorrectDataError");
		alert.setHeaderText(null);
		alert.setContentText("Логін або пароль був неправильно введений");

		alert.showAndWait();
	}

	public void userAlreadyExistsErrorMessage(){
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("UserAlreadyExistsError");
		alert.setHeaderText(null);
		alert.setContentText("Користувач вже існує у системі!");

		alert.showAndWait();
	}

	public void shortPasswordErrorMessage(){
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("ShortPasswordError");
		alert.setHeaderText(null);
		alert.setContentText("Пароль не повинен бути менше 6 символів!");

		alert.showAndWait();
	}

	public void longPasswordErrorMessage(){
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("LongPasswordError");
		alert.setHeaderText(null);
		alert.setContentText("Пароль не повинен бути більше 25 символів!");

		alert.showAndWait();
	}

	public void unsuccessAuthentication(){
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Unsuccess Authentication");
		alert.setHeaderText(null);
		alert.setContentText("Ви 3 рази ввели неправильні дані,у доступі відмовлено!");
		alert.showAndWait();
		Platform.exit();
	}

	public void shortLoginErrorMessage(){
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("ShortLoginError");
		alert.setHeaderText(null);
		alert.setContentText("Логін повинен бути більше 4 символів!");

		alert.showAndWait();
	}
}
