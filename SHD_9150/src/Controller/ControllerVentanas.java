package Controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ControllerVentanas {
	//Clase singleton
		private static ControllerVentanas instancia;
		private Stage primaryStage;
		private BorderPane contenedor;
		private BorderPane contenedorDialog;
		
		private ControllerVentanas() {
			//Constructor de la clase vacio
		}
		
		public static ControllerVentanas getInstancia() {
			if(instancia==null){
				instancia= new ControllerVentanas();
			}
			return instancia;
		}
		
		public void setPrimaryStage(Stage primaryStage) {
			this.primaryStage = primaryStage;
		}
		//M�todo para asignar escena modal.
		public void asignarEscena(String ruta, String titulo){
			try {
				FXMLLoader interfaz = new FXMLLoader(getClass().
						getResource(ruta));
				contenedorDialog = (BorderPane)interfaz.load();
				Stage dialogEscenario = new Stage();
				dialogEscenario.setTitle(titulo);
				dialogEscenario.initModality(Modality.WINDOW_MODAL);
				dialogEscenario.initOwner(primaryStage);
				Scene escena = new Scene(contenedorDialog);
				dialogEscenario.setScene(escena);	
				dialogEscenario.show();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		//Meotod para asignar escena dentro del BorderPane
		public void asignarCentro(String ruta, String titulo){
			try {
				FXMLLoader interfaz = new FXMLLoader(getClass().
						getResource(ruta));
				contenedorDialog = (BorderPane)interfaz.load();			
				contenedor=(BorderPane)primaryStage.getScene().getRoot();
				contenedor.setCenter(contenedorDialog);			
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		//M�todo para asignar menu
		public void asignarMenu(String ruta, String titulo){
			try {
				FXMLLoader interfaz = new FXMLLoader(getClass().
						getResource(ruta));
				contenedorDialog = (BorderPane)interfaz.load();
				Scene scene = new Scene(contenedorDialog);
				primaryStage.setScene(scene);
				primaryStage.centerOnScreen();
				primaryStage.setMaximized(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		//M�todo para asinar login
		public void asignarLogin(String ruta, String titulo){
			try {
				FXMLLoader interfaz = new FXMLLoader(getClass().
						getResource(ruta));
				BorderPane root = (BorderPane)interfaz.load();
				Scene scene = new Scene(root);
				primaryStage.setScene(scene);
				primaryStage.centerOnScreen();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
}
