package entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCliente;
	private String razonSocial;
	private String cuit;
	private String nombre;
	private String apellido;
	private String direccion;

public Cliente(String razonSocial, String cuit, String nombre, String apellido, String direccion) {
	 this.razonSocial = razonSocial;
     this.cuit = cuit;
     this.nombre = nombre;
     this.apellido = apellido;
     this.direccion = direccion;
}

public Cliente() {
}

public int getIdCliente() {
	return idCliente;
}

public void setIdCliente(int idCliente) {
	this.idCliente = idCliente;
}

public String getRazonSocial() {
	return razonSocial;
}

public void setRazonSocial(String razonSocial) {
	this.razonSocial = razonSocial;
}

public String getCuit() {
	return cuit;
}

public void setCuit(String cuit) {
	this.cuit = cuit;
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public String getApellido() {
	return apellido;
}

public void setApellido(String apellido) {
	this.apellido = apellido;
}

public String getDireccion() {
	return direccion;
}

public void setDireccion(String direccion) {
	this.direccion = direccion;
}

@Override
public String toString() {
	return "Cliente [idCliente=" + idCliente + ", razonSocial=" + razonSocial + ", cuit=" + cuit + ", nombre=" + nombre
			+ ", apellido=" + apellido + ", direccion=" + direccion + "]";
}


}

