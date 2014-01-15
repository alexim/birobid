package ec.com.birobid.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
*
* Login Entity
*
* @author Alexi Mendoza
* @since 28 Dic 2013
* @version 1.0.0
*
*/
@Entity
@Table(name="Login")
public class Login {
	private String user;
	private String password;
	private Date ingreso;
	private Estado estado = Estado.ACTIVO;
	
	public enum Estado {
		ACTIVO,
		INACTIVO
	}
	
	@Id
    @Column(name="User", unique = true, nullable = false)
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}

	@Column(name="Password", nullable = false)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name="Ingreso", nullable = false)
	public Date getIngreso() {
		return ingreso;
	}
	public void setIngreso(Date ingreso) {
		this.ingreso = ingreso;
	}
	
	@Column(name="Estado", nullable = false)
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado){
		this.estado = estado;
	}
}
