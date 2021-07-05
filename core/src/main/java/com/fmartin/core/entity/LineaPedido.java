/**
 * 
 */
package com.fmartin.core.entity;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * @author fmgar
 *
 */

@Entity
@Table(name="tt_linea_pedido")
public class LineaPedido {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull
	private int unidades;
	
	@ManyToOne
	@JoinColumn(name = "idPedido", nullable=false, foreignKey = @ForeignKey(name = "FK_LINEA_PEDIDO_ID_PEDIDO"))
	private Pedido pedido;
	
	@ManyToOne
	@JoinColumn(name = "idProducto", nullable=false, foreignKey = @ForeignKey(name = "FK_LINEA_PEDIDO_ID_PRODUCTO"))
	private Producto producto;
	
	public LineaPedido() {

	}

	/**
	 * @param unidades
	 * @param pedido
	 * @param producto
	 */
	public LineaPedido(@NotNull int unidades, Pedido pedido, Producto producto) {
		super();
		this.unidades = unidades;
		this.pedido = pedido;
		this.producto = producto;
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
	 * @return the unidades
	 */
	public int getUnidades() {
		return unidades;
	}

	/**
	 * @param unidades the unidades to set
	 */
	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}

	/**
	 * @return the pedido
	 */
	public Pedido getPedido() {
		return pedido;
	}

	/**
	 * @param pedido the pedido to set
	 */
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	/**
	 * @return the producto
	 */
	public Producto getProducto() {
		return producto;
	}

	/**
	 * @param producto the producto to set
	 */
	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "LineaPedido [unidades=" + unidades + ", producto=" + producto + "]";
	}

}
