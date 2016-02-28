package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javafx.collections.ObservableList;

public class MMaestros {
	private int maestroid;
	private String nombre,apaterno,amaterno,grado,correo,telefono,direccion,
	ciudad,estado,pais,codigopostal;
	private Boolean estatus;
	
	private Conexion myCon;
	private PreparedStatement ps;
	private ResultSet rsMaster;
	private ObservableList<MMaestros> listMaster;
	
	//Constructor por Default
	public MMaestros() {
		this.maestroid=0;
		this.nombre=this.apaterno=this.amaterno=this.grado=this.correo=this.telefono=this.direccion="";
		this.ciudad=this.estado=this.pais=this.codigopostal;
		this.estatus=false;
		myCon=new Conexion();
		ps=null;
	}
	
	//Constructor inicializando con valores recibidos
	public MMaestros(int maestroid, String nombre, String apaterno, String amaterno,
			String grado,String telefono,String correo, String direccion,
			String ciudad, String estado,
			String pais, String codigopostal, Boolean estatus) {
		this.maestroid = maestroid;
		this.nombre = nombre;
		this.apaterno = apaterno;
		this.amaterno = amaterno;
		this.grado = grado;
		this.correo = correo;
		this.telefono = telefono;
		this.direccion = direccion;
		this.ciudad = ciudad;
		this.estado = estado;
		this.pais = pais;
		this.codigopostal = codigopostal;
		this.estatus = estatus;
	}
	

	

	//Getters and Setters
	public int getMaestroid() {
		return maestroid;
	}

	public void setMaestroid(int maestroid) {
		this.maestroid = maestroid;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApaterno() {
		return apaterno;
	}

	public void setApaterno(String apaterno) {
		this.apaterno = apaterno;
	}

	public String getAmaterno() {
		return amaterno;
	}

	public void setAmaterno(String amaterno) {
		this.amaterno = amaterno;
	}

	public String getGrado() {
		return grado;
	}

	public void setGrado(String grado) {
		this.grado = grado;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getCodigopostal() {
		return codigopostal;
	}

	public void setCodigopostal(String codigopostal) {
		this.codigopostal = codigopostal;
	}

	public Boolean getEstatus() {
		return estatus;
	}

	public void setEstatus(Boolean estatus) {
		this.estatus = estatus;
	}
	
	//Acciones SQL
		//Insertar en BD
	public Boolean insert(MMaestros master){
		try {
			myCon.conectar();
			String sql="insert into maestros (maestroid,nombre,apaterno,amaterno,grado,correoe,telefono,direccion,ciudad,estado,pais,codigopostal,estatus) "
					+ "values (default,?,?,?,?,?,?,?,?,?,?,?,'1') ";
			ps=myCon.getCon().prepareStatement(sql);
			ps.setString(1, master.getNombre());
			ps.setString(2, master.getApaterno());
			ps.setString(3, master.getAmaterno());
			ps.setString(4, master.getGrado());
			ps.setString(5, master.getCorreo());
			ps.setString(6, master.getTelefono());
			ps.setString(7, master.getDireccion());
			ps.setString(8, master.getCiudad());
			ps.setString(9, master.getEstado());
			ps.setString(10, master.getPais());
			ps.setString(11, master.getCodigopostal());
			ps.execute();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		finally {
			myCon.desconectar();
		}
	}
	

	//Método para obtener datos y llenar tabla
	public ObservableList<MMaestros> llenarTabla(String sql){
		try {
			myCon.conectar();
			ps=myCon.getCon().prepareStatement(sql);
			rsMaster=ps.executeQuery();
			while (rsMaster.next()) {
				MMaestros mm= new MMaestros();
				mm.setMaestroid(rsMaster.getInt("maestroid"));
				mm.setNombre(rsMaster.getString("nombre"));
				mm.setApaterno(rsMaster.getString("apaterno"));
				mm.setAmaterno(rsMaster.getString("amaterno"));
				mm.setCiudad(rsMaster.getString("grado"));
				mm.setCorreo(rsMaster.getString("correoe"));
				mm.setTelefono(rsMaster.getString("telefono"));
				mm.setDireccion(rsMaster.getString("direccion"));
				mm.setCiudad(rsMaster.getString("ciudad"));
				mm.setCiudad(rsMaster.getString("estado"));
				mm.setEstado(rsMaster.getString("pais"));
				mm.setCodigopostal(rsMaster.getString("codigopostal"));
				mm.setEstatus(rsMaster.getBoolean("estatus"));
				listMaster.add(mm);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			myCon.desconectar();
		}
		return listMaster;
	}
	
	public Boolean delete(int id) {
		try {
			myCon.conectar();
			String sql="update maestros set estatus='0' where maestroid=?";
			ps=myCon.getCon().prepareStatement(sql);
			ps.setInt(1, id);
			ps.execute();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		finally {
			myCon.desconectar();
		}
	}
	
	public Boolean update(MMaestros master){
		try {
			myCon.conectar();
			String sql="update maestros set maestroid=?,nombre=?,apaterno=?,amaterno=?,grado=?,correoe=?,"
					+ "telefono=?,direccion=?,ciudad=?,estado=?,pais=?,codigopostal=?,estatus=? where maestroid=?";
			ps=myCon.getCon().prepareStatement(sql);
			ps.setString(1, master.getNombre());
			ps.setString(2, master.getApaterno());
			ps.setString(3, master.getAmaterno());
			ps.setString(4, master.getGrado());
			ps.setString(4, master.getCorreo());
			ps.setString(6, master.getTelefono());
			ps.setString(7, master.getDireccion());
			ps.setString(9, master.getCiudad());
			ps.setString(10, master.getEstado());
			ps.setString(11, master.getPais());
			ps.setString(12, master.getCodigopostal());
			ps.execute();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		finally {
			myCon.desconectar();
		}
	}
}
