package entidades;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Tecnico implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTecnico;
	
    @ManyToOne
	@JoinColumn(name = "idEspecialidad")
	private Especialidad especialidad;
    
    private String nombre;
    private boolean ocupado;
    
    
	public Tecnico(Especialidad especialidad, String nombre, boolean ocupado) {
		super();
		this.especialidad = especialidad;
		this.nombre = nombre;
		this.ocupado = ocupado;
	}

	public Tecnico(int idTecnico, Especialidad especialidad, String nombre, boolean ocupado) {
		super();
		this.idTecnico = idTecnico;
		this.especialidad = especialidad;
		this.nombre = nombre;
		this.ocupado = ocupado;
	}

	public Tecnico() {
		super();
	}

	public int getIdTecnico() {
		return idTecnico;
	}

	public void setIdTecnico(int idTecnico) {
		this.idTecnico = idTecnico;
	}

	public Especialidad getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isOcupado() {
		return ocupado;
	}

	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Tecnico [idTecnico=" + idTecnico + ", especialidad=" + especialidad + ", nombre=" + nombre
				+ ", ocupado=" + ocupado + "]";
	}
	
}
