package ec.com.birobid.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import ec.com.birobid.enums.VariablesGlobales.Estado;

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
	private String usuario;
	private String clave;
	private Date ingreso;
	private Estado estado = Estado.ACTIVO;
	
	//@GeneratedValue(strategy = GenerationType.SEQUENCE)
	/**
	 *  @ManyToOne
		@JoinColumn(name = "idTutor")
		@NotNull
		private Profesor tutor;
	 */
	@Id
    @Column(name="Usuario", unique = true, nullable = false)
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	@Column(name="Clave", nullable = false)
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
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
