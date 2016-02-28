package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MUser {
	//Variables
	private int id_usuario,adminid;
	private String alias,contrasenia,nivel;
	private Boolean estatus;
	private Conexion myCon;
	private PreparedStatement ps;
	private ResultSet rs;
	private MUser user;
	
	//Constructores
	
	public MUser() {
		this.id_usuario=0;
		this.adminid=0;
		this.alias=this.contrasenia=this.nivel="";
		this.estatus=false;
		myCon=new Conexion();
		ps=null;
		rs=null;
	}
	
	public MUser(int id_usuario, int adminid, String alias, String contrasenia, String nivel, Boolean estatus) {
		super();
		this.id_usuario = id_usuario;
		this.adminid = adminid;
		this.alias = alias;
		this.contrasenia = contrasenia;
		this.nivel = nivel;
		this.estatus = estatus;
	}
	
	
	//Getters and Setters
	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public int getAdminid() {
		return adminid;
	}

	public void setAdminid(int adminid) {
		this.adminid = adminid;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public Boolean getEstatus() {
		return estatus;
	}

	public void setEstatus(Boolean estatus) {
		this.estatus = estatus;
	}

	//Acciones SQL
	public MUser validarUser(MUser u){
		try {
			myCon.conectar();
			String sql="select alias,contrasenia from usuarios where alias=? and contrasenia=?";
			ps=myCon.getCon().prepareStatement(sql);
			ps.setString(1, u.getAlias());
			ps.setString(2, u.getContrasenia());
			System.out.println(ps);
			rs=ps.executeQuery();
			while (rs.next()) {
				user=new MUser();
				user.setAlias(rs.getString("alias"));
				user.setContrasenia(rs.getString("contrasenia"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			user=null;
		}
		finally {
			myCon.desconectar();
		}
		
		return user;
	}
}
