/**
 * 
 */
package com.fmartin.core.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

/**
 * @author fmgar
 *
 */

@Entity
//@Table(name = "tt_pedido", uniqueConstraints={@UniqueConstraint(columnNames={"codigo"},name = "UQ_PEDIDO_CODIGO")})
@Table(name = "tt_pedido", uniqueConstraints = {
   @UniqueConstraint(name = "UQ_PEDIDO_CODIGO", 
	   columnNames = {"codigo"}),
   @UniqueConstraint(name = "UQ_PEDIDO_REF_ALMACEN", 
		columnNames = {"refAlmacen"})})
public class Pedido implements Serializable{

	private static final long serialVersionUID = -8058130391749281202L;
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String codigo; 
	
	private String refAlmacen;
	
	@OneToMany(mappedBy="pedido", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<LineaPedido> lineas;
	
	@NotNull
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="tt_pedido_direccion",
			joinColumns = @JoinColumn(name="idPedido", foreignKey = @ForeignKey(name = "FK_DIRECCION_ID_PEDIDO")),
			inverseJoinColumns = @JoinColumn(name="idDireccion", foreignKey = @ForeignKey(name = "FK_PEDIDO_ID_DIRECCION")))
	private Set<Direccion> direcciones;
	
	@NotNull
	@ManyToOne()
	@JoinColumn(name = "idUsuario", nullable = false)
	private Usuario usuario;
	
	/**
	 * 
	 */
	public Pedido() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param codigo
	 */
	public Pedido(String codigo) {
		super();
		this.codigo = codigo;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return the lineas
	 */
	public List<LineaPedido> getLineas() {
		return lineas;
	}

	/**
	 * @param lineas the lineas to set
	 */
	public void setLineas(List<LineaPedido> lineas) {
		this.lineas = lineas;
	}

	/**
	 * @return the direcciones
	 */
	public Set<Direccion> getDirecciones() {
		return direcciones;
	}

	/**
	 * @param direcciones the direcciones to set
	 */
	public void setDirecciones(Set<Direccion> direcciones) {
		this.direcciones = direcciones;
	}
	
	
	/**
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Pedido [codigo=" + codigo + ", lineas=" + lineas + ", usuario=" + usuario + "]";
	}

	public String getRefAlmacen() {
		return refAlmacen;
	}

	public void setRefAlmacen(String refAlmacen) {
		this.refAlmacen = refAlmacen;
	}

}
