package ObjetosPersistentes;

public class MateriaPrima {
	String nombre;
	String unidadMedida;
	double cantidad;
	double precioXumedida;
	double avisarCuandoCantidadsea;
	
	public double getAvisarCuandoCantidadsea() {
		return avisarCuandoCantidadsea;
	}
	public void setAvisarCuandoCantidadsea(double avisarCuandoCantidadsea) {
		this.avisarCuandoCantidadsea = avisarCuandoCantidadsea;
	}
	public MateriaPrima() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getUnidadMedida() {
		return unidadMedida;
	}
	public void setUnidadMedida(String unidadMedida) {
		this.unidadMedida = unidadMedida;
	}
	public double getCantidad() {
		return  cantidad;
	}
	public void setCantidad(double d) {
		this.cantidad = d;
	}
	public double getPrecioXumedida() {
		return precioXumedida;
	}
	public void setPrecioXumedida(double precioXumedida) {
		this.precioXumedida = precioXumedida;
	}
	
	

}
