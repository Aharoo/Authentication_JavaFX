package com.aharoo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckAndRegisterUserHandler {

	private ErrorsHandler errorsHandler = new ErrorsHandler();
	Pattern usernamePattern = Pattern.compile("(.*?)" + Pattern.quote(":"));

	public boolean checkExistingUser(String login,String password) {

		try {
			BufferedReader reader = new BufferedReader(new FileReader("users.txt"));

			List<String> buffer = new ArrayList<>();
			while(reader.ready()){
				buffer.add(reader.readLine());
			}

			String usernameAndPassword = login + ":" + password;

			for (int i = 0; i < buffer.size();i++) {
				if (buffer.get(i).contains(usernameAndPassword)) {
					return true;
				}
			}

			reader.close();
		} catch (IOException e){
			e.printStackTrace();
		}
		return false;
	}
	public boolean checkExistingUser(String login) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("users.txt"));
			while(reader.ready()){
				Matcher usernameMatcher = usernamePattern.matcher(reader.readLine());
				if (usernameMatcher.find()){
					String buffer = usernameMatcher.group().replace(":","");
					if (buffer.equals(login))
						return true;
				}
			}

			reader.close();
		} catch (IOException e){
			e.printStackTrace();
		}
		return false;
	}

	// Реєстрація нового користувача
	public void registerNewUser(String login,String password){
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("users.txt",true));
			BufferedReader reader = new BufferedReader(new FileReader("users.txt"));
			String lineSeparator = System.getProperty("line.separator");

			while(reader.ready()) {
				Matcher usernameMatcher = usernamePattern.matcher(reader.readLine());
				if (usernameMatcher.find()) {
					String buffer = usernameMatcher.group().replace(":", "");
				}
			}

			writer.write(login + ":");
			writer.write(password + lineSeparator);

			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
