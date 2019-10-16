package back.ing.procesos.app.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "productos")
public class Producto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Varios atributos serán cambiados a Objetos cuándo se desarrollen las demás
	// funcionalidades.

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nombre_producto")
	private String nombreProducto;

	@Column(name = "descripcion")
	private String descripcion;

	@Column(name = "tipo")
	private String tipo;

	@Column(name = "precio_kilo")
	private String precioKilo;

	@Column(name = "precio_unidad")
	private String precioUnidad;

	@Column(name = "ubicacion")
	private String ubicacion;

	@Column(name = "vendedor")
	private String vendedor;

	@Column(name = "estado")
	private String estado;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getPrecioKilo() {
		return precioKilo;
	}

	public void setPrecioKilo(String precioKilo) {
		this.precioKilo = precioKilo;
	}

	public String getPrecioUnidad() {
		return precioUnidad;
	}

	public void setPrecioUnidad(String precio_unidad) {
		this.precioUnidad = precio_unidad;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getVendedor() {
		return vendedor;
	}

	public void setVendedor(String vendedor) {
		this.vendedor = vendedor;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
