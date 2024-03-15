package App;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.HBox;
import javafx.scene.control.Alert;;


public class AccountCreationForm {

    public Scene getAccountCreationScene(Stage primaryStage) {
    	
        VBox layout = new VBox(10);
        TextField accountNameField = new TextField();
        Button submitButton = new Button("Submit");
        accountNameField.setPromptText("Enter your full name");
        
        
        DatePicker datePicker = new DatePicker();
        datePicker.setPromptText("Date of Birth (dd.mm.yyyy)");

        Map <String, String> countries = jsonparse.countries("src/countries.json");
        ComboBox<country> countryField = new ComboBox<country>();
        countryField.setPromptText("Citizenship");
      
  
        countries.forEach((code, name) ->{
        	String imgpath = "/flags/" + code.toLowerCase() + ".png";
        	countryField.getItems().add(new country(name, imgpath));
        });
        
        
        countryField.setCellFactory(e -> new ListCell<country>(){
        	private final ImageView imageView = new ImageView();
            private final HBox hBox = new HBox(5, imageView);
            
            @Override
            protected void updateItem(country country, boolean empty) {
                super.updateItem(country, empty);
                if (empty || country == null) {
                    setGraphic(null);
                } else {
                    imageView.setImage(new Image(getClass().getResourceAsStream(country.getFlagPath())));
                    imageView.setFitHeight(20); // 
                    imageView.setFitWidth(25);
                    setText(empty || country == null ? "" : country.getCountryName());
                    setGraphic(hBox);
                }
            }
            
        });
        
        
        countryField.setButtonCell(new ListCell<country>() {
            private final ImageView imageView = new ImageView();
            private final HBox hBox = new HBox(5, imageView); 
            
            @Override
            protected void updateItem(country country, boolean empty) {
                super.updateItem(country, empty);
                if (empty || country == null) {
                    setGraphic(null);
                } else {
                    imageView.setImage(new Image(getClass().getResourceAsStream(country.getFlagPath())));
                    imageView.setFitHeight(20); 
                    imageView.setFitWidth(25); 
                    setText(empty || country == null ? "" : country.getCountryName());
                    setGraphic(hBox);
                }
            }
        });
        
   
       

        TextField AddressField = new TextField();
        AddressField.setPromptText("Your Address");
        
        TextField phoneField = new TextField();
        phoneField.setPromptText("Enter phone number");
       
        TextField emailField = new TextField();
        emailField.setPromptText("Enter email address");

        emailField.focusedProperty().addListener((obs, wasFocused, isNowFocused) -> {
            if (!isNowFocused) {
                if (!emailField.getText().matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")) {
                    emailField.setStyle("-fx-border-color: red;");
                    submitButton.setDisable(true);
                } else {
                    emailField.setStyle("");
                }
            }
        });

        
      TextField[] fields = {accountNameField, AddressField, phoneField, emailField};  
      for (TextField textField : fields) {
    	    textField.textProperty().addListener((obs, oldVal, newVal) -> 
    	        checkFieldsFilled(fields, datePicker, countryField, submitButton));
    	}
      
      datePicker.valueProperty().addListener((obs, oldVal, newVal) -> checkFieldsFilled(fields, datePicker, countryField, submitButton));
      countryField.valueProperty().addListener((obs, oldVal, newVal) ->  checkFieldsFilled(fields, datePicker, countryField, submitButton));
      
      
      submitButton.setDisable(true);
      submitButton.setOnAction(e -> {
    	  String accountName = accountNameField.getText();
    	  System.out.println("Account created for " + accountName);
    	  
    	  if(!submitButton.isDisabled()) {
    	       VBox usernamePasswordForm = createUsernamePasswordForm();
    	       layout.getChildren().setAll(usernamePasswordForm); // Replace current form content
    	  }
    	 
    	  
      });
        
        layout.getChildren().addAll(accountNameField, datePicker, countryField, AddressField, phoneField, emailField, submitButton);
        return new Scene(layout, 400, 300);
    }
    
    private void validateName(TextField nameField) {
        String pattern = "^[a-zA-Z\\s'-]+$";
        String text = nameField.getText();

        if (!text.matches(pattern)) {
            nameField.setStyle("-fx-border-color: red;");
        } else {
           
            nameField.setStyle("-fx-border-color: green;");
        }
    }

    private void validatePhoneNumber(TextField phoneField) {
    	String pattern = "^\\s*(?:\\+?(\\d{1,3}))?[-. (]*(\\d{3})[-. )]*(\\d{3})[-. ]*(\\d{4})(?: *x(\\d+))?\\s*$";
    	String text = phoneField.getText();
    	
    	if (!text.matches(pattern)) {
    		phoneField.setStyle("-fx-border-color: red;");
    	} else {
    		phoneField.setStyle("-fx-border-color: green;");
    	}
    }
    
    
    private void checkFieldsFilled(TextField[] fields, DatePicker datePicker, ComboBox<country> countryField, Button submitButton) {
        for (TextField textField : fields) {
            if (textField.getText().trim().isEmpty()) {
                submitButton.setDisable(true);
                return;
            }
        }
        	
        fields[0].focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                validateName(fields[0]);
                submitButton.setDisable(true);
                return;
            }
        });
        
        fields[2].focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) { 
                validatePhoneNumber(fields[2]);
                submitButton.setDisable(true);
                return;
            }
        });

        
        if (datePicker.getValue() == null) {
            submitButton.setDisable(true);
            return;
        }

        if (countryField.getValue() == null) {
            submitButton.setDisable(true);
            return;
        }

        submitButton.setDisable(false);
    }

    private VBox createUsernamePasswordForm() {
        VBox layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);

        TextField usernameField = new TextField();
        usernameField.setPromptText("Username");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");

        Button createAccountButton = new Button("Finish");
        createAccountButton.setOnAction(e -> {
            System.out.println("Creating account for " + usernameField.getText());
            Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
            successAlert.setTitle("Submission Successful");
            successAlert.setHeaderText(null);
            successAlert.setContentText("Your information has been submitted successfully!");
            successAlert.showAndWait();

            Stage stage = (Stage) createAccountButton.getScene().getWindow();
            stage.close();
            
        });
        
        layout.getChildren().addAll(new Label("Create Username and Password"), usernameField, passwordField, createAccountButton);
        return layout;
    }

}

