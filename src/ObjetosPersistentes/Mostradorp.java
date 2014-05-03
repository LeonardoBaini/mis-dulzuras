package ObjetosPersistentes;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;



public class Mostradorp {
	@Id
	@GenericGenerator(name="kaugen" , strategy="increment")
	@GeneratedValue(generator="kaugen")
	@Column(name="idProducto")

	
	int id;
	String nombre;
	String fechaElaboracion;
	float precio;
	float dinero_a_reponer;
	
	
	
	public Mostradorp() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getFechaElaboracion() {
		return fechaElaboracion;
	}
	public void setFechaElaboracion(String fechaElaboracion) {
		this.fechaElaboracion = fechaElaboracion;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precioUnitario) {
		this.precio = precioUnitario;
	}
	public float getDinero_a_reponer() {
		return dinero_a_reponer;
	}
	public void setDinero_a_reponer(float dinero_a_reponer) {
		this.dinero_a_reponer = dinero_a_reponer;
	}
	
	
}
