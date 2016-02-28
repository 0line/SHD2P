package Controller;

import java.net.URL;
import java.util.ResourceBundle;

import Model.MMaestros;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ControllerMaestros implements Initializable {
	@FXML private Button btnNuevo,btnGuardar,btnEliminar,btnModificar,btnCancelar;
	@FXML private TextField txtNombre,txtPaterno,txtMaterno,txtTelefono,txtCorreo,txtDireccion,txtCiudad,txtEstado,txtPais,txtCodigo;
	@FXML private Label Mensaje;
	@FXML private ComboBox<String>cbGrado;
	@FXML private TableView<MMaestros> tvMaestro;
	private ObservableList<MMaestros>listMasters;
	@FXML private CheckBox ckbinactivos;
	private MMaestros mm;
	public ControllerMaestros() {
		listMasters=FXCollections.observableArrayList();
		mm=new MMaestros();
	}
	
	public void llenarTabla(Boolean estatus){
		listMasters.clear();
		if (estatus==true) {listMasters=mm.llenarTabla("select * from maestros where estatus='1'");}
		else{listMasters=mm.llenarTabla("select * from maestros where estatus='0'");
		}
		tvMaestro.setItems(listMasters);
	}
	@FXML public void clickNuevo(){
		btnNuevo.setDisable(true);
		btnGuardar.setDisable(false);
		txtNombre.setDisable(false);
		txtPaterno.setDisable(false);
		txtMaterno.setDisable(false);
		cbGrado.setDisable(false);
		txtTelefono.setDisable(false);txtCorreo.setDisable(false);txtDireccion.setDisable(false);txtCiudad.setDisable(false);txtEstado.setDisable(false);txtPais.setDisable(false);txtCodigo.setDisable(false);
	}
	@FXML public void clickCancelar(){
		btnNuevo.setDisable(false);
		btnGuardar.setDisable(true);
		txtNombre.setDisable(true);
		txtPaterno.setDisable(true);
		txtMaterno.setDisable(true);
		cbGrado.setDisable(true);
		txtTelefono.setDisable(true);txtCorreo.setDisable(true);txtDireccion.setDisable(true);txtCiudad.setDisable(true);txtEstado.setDisable(true);txtPais.setDisable(true);txtCodigo.setDisable(true);
		btnEliminar.setDisable(true);
		btnModificar.setDisable(true);
		txtNombre.clear();
		txtPaterno.clear();
		txtMaterno.clear();
		cbGrado.setValue(null);
		txtTelefono.clear();
		txtCorreo.clear();txtDireccion.clear();txtCiudad.clear();txtEstado.clear();txtPais.clear();txtCodigo.clear();
		
	}
	@FXML public void clickInsertar(){
		if (txtNombre.getText().trim().isEmpty()) {
			Mensaje.setText("Falta el nombre");
		}
		else{
			if (txtPaterno.getText().trim().isEmpty()) {
				Mensaje.setText("Falta el Apellido Paterno");
			}
			else{
				if (txtMaterno.getText().trim().isEmpty()) {
					Mensaje.setText("Falta el Apellido Paterno");
				}
				else{
					if (txtPaterno.getText().trim().isEmpty()) {
						Mensaje.setText("Falta el Apellido Paterno");
					}
					else{
						if (cbGrado.getValue()==null) {
							Mensaje.setText("Falta grado");
						}
						else{
							if (txtTelefono.getText().trim().isEmpty()) {
								Mensaje.setText("Falta el Teléfono");
							}
							else{
								if (txtCorreo.getText().trim().isEmpty()) {
									Mensaje.setText("Falta el correo");
								}
								else{
									if (txtDireccion.getText().trim().isEmpty()) {
										Mensaje.setText("Falta direccion");
									}
									else{
										if (txtCiudad.getText().trim().isEmpty()) {
											Mensaje.setText("Falta CIudad");
										}
										else{
											if (txtEstado.getText().trim().isEmpty()) {
												Mensaje.setText("Falta estado");
											}
											else{
												if (txtPais.getText().trim().isEmpty()) {
													Mensaje.setText("Falta pais");
												}
												else {
													if (txtCodigo.getText().trim().isEmpty()) {
														Mensaje.setText("Falta el codigo");
													}
													else{
														Boolean result=mm.insert(new MMaestros(0,txtNombre.getText(),txtPaterno.getText(),txtMaterno.getText(),cbGrado.getValue(),txtTelefono.getText(),txtCorreo.getText(),txtDireccion.getText(),txtCiudad.getText(),txtEstado.getText(),txtPais.getText(),txtCodigo.getText(),true));
														if(result){
															Mensaje.setText("Los datos se han "
																	+ "insertado satisfactoriamente");
															llenarTabla(true);
														}
														else{
															Mensaje.setText("Ha Ocurrido un"
																	+ " error consulte a su administrador");
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}		
			}
		}
		txtNombre.clear();
		txtPaterno.clear();
		txtMaterno.clear();
		cbGrado.setValue(null);
		txtTelefono.clear();
		txtCorreo.clear();txtDireccion.clear();txtCiudad.clear();txtEstado.clear();txtPais.clear();txtCodigo.clear();	
	}
	
	@FXML public void seeDisable(){
		listMasters.clear();
		if(ckbinactivos.isSelected()){
			//Mostrar inactivos
			llenarTabla(false);
		}
		else{
			//Mostrar Activos
			llenarTabla(true);
		}
	}
	
	@FXML public void clickTableView(){
		//Evaluar si se selecciono una categoria
		if(tvMaestro.getSelectionModel().getSelectedItem()!=null){
			mm=tvMaestro.getSelectionModel().getSelectedItem();
			//Habilitar las cajas de texto
			txtNombre.setDisable(false);
			txtPaterno.setDisable(false);
			txtMaterno.setDisable(false);
			cbGrado.setDisable(false);
			txtTelefono.setDisable(false);txtCorreo.setDisable(false);txtDireccion.setDisable(false);txtCiudad.setDisable(false);txtEstado.setDisable(false);txtPais.setDisable(false);txtCodigo.setDisable(false);
			//Botones eliminar y modificar
			btnEliminar.setDisable(false);
			btnModificar.setDisable(false);
			btnNuevo.setDisable(true);
			//Cargamos los datos
			txtNombre.setText(mm.getNombre());
			txtPaterno.setText(mm.getApaterno());
			txtMaterno.setText(mm.getAmaterno());
			cbGrado.setValue(mm.getGrado());
			txtTelefono.setText(mm.getTelefono());
			txtCorreo.setText(mm.getCorreo());
			txtDireccion.setText(mm.getDireccion());txtCiudad.setText(mm.getCiudad());txtEstado.setText(mm.getEstado());txtPais.setText(mm.getPais());txtCodigo.setText(mm.getCodigopostal());
			
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
	llenarTabla(true);	
	}
}
