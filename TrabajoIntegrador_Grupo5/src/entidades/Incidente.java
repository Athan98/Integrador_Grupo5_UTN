package entidades;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Incidente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idIncidente;
	private String descripcion;
	private boolean resuelto;
	private String fechaReporte;
	private String fechaResolucion;

	@ManyToOne
	@JoinColumn(name = "idCliente")
	private Cliente cliente;

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "Incidente_x_Tecnico", joinColumns = { @JoinColumn(name = "idIncidente") }, 
	inverseJoinColumns = {
			@JoinColumn(name = "idTecnico") })
	List<Tecnico> ListaTecnicos = new ArrayList<Tecnico>();

	@ManyToOne
	@JoinColumn(name = "idEspecialidad")
	private Especialidad especialidad;
	
	@ManyToOne
	@JoinColumn(name = "idOperador")
	private Operador operador;

	
	public Incidente(String descripcion, boolean resuelto, String fechaReporte, String fechaResolucion,
			Cliente cliente, List<Tecnico> listaTecnicos, Especialidad especialidad, Operador operador) {
		this.descripcion = descripcion;
		this.resuelto = resuelto;
		this.fechaReporte = fechaReporte;
		this.fechaResolucion = fechaResolucion;
		this.cliente = cliente;
		ListaTecnicos = listaTecnicos;
		this.especialidad = especialidad;
		this.operador = operador;
	}

	public Incidente(int idIncidente, String descripcion, boolean resuelto, String fechaReporte,
			String fechaResolucion, Cliente cliente, List<Tecnico> listaTecnicos, Especialidad especialidad) {
		super();
		this.idIncidente = idIncidente;
		this.descripcion = descripcion;
		this.resuelto = resuelto;
		this.fechaReporte = fechaReporte;
		this.fechaResolucion = fechaResolucion;
		this.cliente = cliente;
		ListaTecnicos = listaTecnicos;
		this.especialidad = especialidad;
	}

	public Incidente() {
		super();
	}

	public int getIdIncidente() {
		return idIncidente;
	}

	public void setIdIncidente(int idIncidente) {
		this.idIncidente = idIncidente;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public boolean isResuelto() {
		return resuelto;
	}

	public void setResuelto(boolean resuelto) {
		this.resuelto = resuelto;
	}

	public String getFechaReporte() {
		return fechaReporte;
	}

	public void setFechaReporte(String fechaReporte) {
		this.fechaReporte = fechaReporte;
	}

	public String getFechaResolucion() {
		return fechaResolucion;
	}

	public void setFechaResolucion(String fechaResolucion) {
		this.fechaResolucion = fechaResolucion;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Tecnico> getListaTecnicos() {
		return ListaTecnicos;
	}

	public void setListaTecnicos(List<Tecnico> listaTecnicos) {
		ListaTecnicos = listaTecnicos;
	}

	public Especialidad getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Incidente [idIncidente=" + idIncidente + ", descripcion=" + descripcion + ", resuelto=" + resuelto
				+ ", fechaReporte=" + fechaReporte + ", fechaResolucion=" + fechaResolucion + ", cliente=" + cliente
				+ ", ListaTecnicos=" + ListaTecnicos + ", especialidad=" + especialidad + "]";
	}
	
	
	

}
