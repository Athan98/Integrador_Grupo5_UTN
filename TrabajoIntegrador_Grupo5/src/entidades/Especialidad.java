package entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Especialidad implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String idEspecialidad;
	private String nombreEspecialidad;

	
	public Especialidad(String idEspecialidad, String nombreEspecialidad) {
		this.idEspecialidad = idEspecialidad;
		this.nombreEspecialidad = nombreEspecialidad;
	}

	public Especialidad() {
	}

	public String getIdEspecialidad() {
		return idEspecialidad;
	}

	public void setIdEspecialidad(String idEspecialidad) {
		this.idEspecialidad = idEspecialidad;
	}

	public String getNombreEspecialidad() {
		return nombreEspecialidad;
	}

	public void setNombreEspecialidad(String nombreEspecialidad) {
		this.nombreEspecialidad = nombreEspecialidad;
	}

	@Override
	public String toString() {
		return "Especialidad [idEspecialidad=" + idEspecialidad + ", nombreEspecialidad=" + nombreEspecialidad + "]";
	}

}