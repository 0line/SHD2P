package Controller;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	private ControllerVentanas instancia;
	@Override
	public void start(Stage primaryStage) {
		try {
			instancia= ControllerVentanas.getInstancia();
			instancia.setPrimaryStage(primaryStage);
			String Patch="../Views/fxml/Acceso.fxml";
			BorderPane root = FXMLLoader.load(getClass().getResource(Patch));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("../Views/style/MiEstilo.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.initStyle(StageStyle.UNDECORATED);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
