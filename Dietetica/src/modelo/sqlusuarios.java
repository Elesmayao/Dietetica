package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class sqlusuarios extends conexion {
	
	public boolean registrar(usuarios usr) {
		
		PreparedStatement ps = null;
		Connection con = getConexion();
		
		String sql = "INSERT INTO usuarios (id,usuario , password, nombre, correo, idtipo) VALUES(?,?,?,?,?,?)";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, usr.getId());
			ps.setString(2, usr.getUsuario());
			ps.setString(3, usr.getPassword());
			ps.setString(4, usr.getNombre());
			ps.setString(5, usr.getCorreo());
			ps.setInt(6, usr.getIdtipo());
			ps.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
}
