package ec.com.birobid.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import ec.com.birobid.enums.VariablesGlobales.Estado;

@Entity
@Table(name="Sucursal")
public class Sucursal {
	private int codigo;
	private String descripcion;
	private int empresa;
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
	

	@Column(name="idEmpresa", nullable = false)
	public int getEmpresa() {
		return empresa;
	}
	public void setEmpresa(int empresa) {
		this.empresa = empresa;
	}
	
	@Column(name="Estado", nullable = false)
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
}
