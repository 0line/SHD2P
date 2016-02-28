package Controller;

import javafx.fxml.FXML;


public class ControllerMenu {
	private ControllerVentanas instancia;
	
	@FXML public void abrirMaestros(){
		instancia=ControllerVentanas.getInstancia();
		instancia.asignarEscena("../Views/fxml/Maestros.fxml", "Maestros");
	}
	
	//Cerrar aplicación
		@FXML public void cerrarSesion(){
			instancia=ControllerVentanas.getInstancia();
			instancia.asignarLogin("../Views/fxml/Acceso.fxml", "Login");
		}
}
