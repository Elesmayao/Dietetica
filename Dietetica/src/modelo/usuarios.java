package modelo;

public class usuarios {
	
	private int id;
	private String usuario;
	private String password;
	private String nombre;
	private String correo;
	private String ultimasesion;
	private int idtipo;
	
	//GET Y SET
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getUltimasesion() {
		return ultimasesion;
	}
	public void setUltimasesion(String ultimasesion) {
		this.ultimasesion = ultimasesion;
	}
	public int getIdtipo() {
		return idtipo;
	}
	public void setIdtipo(int idtipo) {
		this.idtipo = idtipo;
	}
	
	
}
