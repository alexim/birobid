package ec.com.birobid.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
*
* User Entity
*
* @author Alexi Mendoza
* @since 28 Dic 2013
* @version 1.0.0
*
*/
@Entity
@Table(name="Perfil")
public class Perfil {
	
	private double id;
	private String usuario;
	private String modulo;
	
	/**
	 * @author Alexi Mendoza
	 * @since 08 Enero 2013
	 * 
	 */
	@Id
	@GeneratedValue
    @Column(name="Id", unique = true, nullable = false)
	public double getId() {
		return id;
	}
	public void setId(double id) {
		this.id = id;
	}
	
	@Column(name="Usuario", nullable = false)
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	@Column(name="Modulo", nullable = false)
	public String getModulo() {
		return modulo;
	}
	public void setModulo(String modulo) {
		this.modulo = modulo;
	}
}
