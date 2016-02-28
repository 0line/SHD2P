package Controller;


import Model.MUser;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ControllerAcceso {
	//Controles FXML
	@FXML private TextField txtAlias,pfCon;
	@FXML private Label lblContenido;
	
	//Variables E Instancias
	
		private MUser usuario;
		private ControllerVentanas screens;
	
		//Método Constructor
		public ControllerAcceso() {
			usuario=new MUser();
			screens= ControllerVentanas.getInstancia();
		}
		
		//Método boton entrar/login
		@FXML public void login(){
			if (txtAlias.getText().trim().isEmpty()) {
				lblContenido.setText("Faltan datos");
				txtAlias.requestFocus();
			} else {
				if (pfCon.getText().trim().isEmpty()) {
					lblContenido.setText("Faltan datos");
					txtAlias.requestFocus();
				} else {
					usuario.setAlias(txtAlias.getText());
					usuario.setContrasenia(pfCon.getText());
					//VALIDAR SI EXISTE USUARIO
				usuario=usuario.validarUser(usuario);
					if(usuario==null){
						lblContenido.setText("Credenciales no válidas");
						pfCon.clear();
						txtAlias.clear();
					}
					else{
						screens.asignarMenu("../Views/fxml/Menu.fxml", "Menu");
					}
				}
			}
		}
		//Salir de la app
		@FXML public void clickSalir(){
			System.exit(0);
		}
}
