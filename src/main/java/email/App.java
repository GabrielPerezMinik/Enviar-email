package email;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class App extends Application{

	
	
	
	
	public static void main(String[] args) {
		launch(args);
	}



	@Override
	public void start(Stage primaryStage) throws Exception {
		ViewController control = new ViewController();
		Scene scene=new Scene(control.getView());
		primaryStage.setTitle("Enviar Email");
		primaryStage.getIcons().add(new Image("/image/email-send-icon-32x32.png"));
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
