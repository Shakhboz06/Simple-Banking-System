package App;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainScene {
	
	public Scene getMainScene(Stage primaryStage) {
        VBox layout = new VBox(10);
        Button createAccountButton = new Button("Create Account");
        Button loginButton = new Button("Login");

        createAccountButton.setOnAction(e -> {
            AccountCreationForm accountCreationForm = new AccountCreationForm();
            primaryStage.setScene(accountCreationForm.getAccountCreationScene(primaryStage));
        });

        layout.getChildren().addAll(createAccountButton, loginButton);
        return new Scene(layout, 400, 300);
    }
}
