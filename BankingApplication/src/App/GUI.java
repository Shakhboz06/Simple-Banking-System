package App;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class GUI extends Application{
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		
		 primaryStage.setTitle("Banking Application");
		 MainScene mainscene = new MainScene();
		 Scene scene = mainscene.getMainScene(primaryStage);
		 
		 primaryStage.setScene(scene);
	     primaryStage.show();
	}
	

		
	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		launch(args);
	}
}
