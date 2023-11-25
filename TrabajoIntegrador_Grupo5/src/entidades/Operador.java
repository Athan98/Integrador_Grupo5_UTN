package entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Operador implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idOperador;
	private String nombre;
	
	
public Operador(int idOperador, String nombre) {
	this.idOperador = idOperador;
	this.nombre = nombre;
	}

public Operador() {
}

public int getIdOperador() {
	return idOperador;
}

public void setIdOperador(int idOperador) {
	this.idOperador = idOperador;
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

@Override
public String toString() {
	return "Operador [idOperador=" + idOperador + ", nombre=" + nombre + "]";
}



}


	
	


