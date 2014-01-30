package ec.com.birobid.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import ec.com.birobid.enums.VariablesGlobales.Estado;

/**
*
* Empresa Entity
*
* @author Alexi Mendoza
* @since 28 Dic 2013
* @version 1.0.0
*
*/
@Entity
@Table(name="Empresa")
public class Empresa {
	private int codigo;
	private String descripcion;
	private Estado estado = Estado.ACTIVO;
	
	@Id
	@GeneratedValue
	@Column(name="Codigo", unique = true, nullable = false)
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	@Column(name="Descripcion", unique = true, nullable = false)
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	@Column(name="Estado", nullable = false)
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
}
