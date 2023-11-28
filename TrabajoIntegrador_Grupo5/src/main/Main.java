package main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import dao.ConfigHibernate;
import dao.DaoCliente;
import dao.DaoEspecialidad;
import dao.DaoIncidente;
import dao.DaoOperador;
import dao.DaoTecnico;
import entidades.Cliente;
import entidades.Especialidad;
import entidades.Incidente;
import entidades.Operador;
import entidades.Tecnico;

public class Main {

	public static void main(String[] args) {
		SessionFactory sessionFactory;
		Configuration configuration = new Configuration();
		configuration.configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties())
				.buildServiceRegistry();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();

		session.beginTransaction();

		// Creamos las especialidades
		Especialidad esp1 = new Especialidad("Windows");
		Especialidad esp2 = new Especialidad("Linux");
		Especialidad esp3 = new Especialidad("Sap");
		Especialidad esp4 = new Especialidad("Tango");
		Especialidad esp5 = new Especialidad("MacOs");

		// Agregamos las especialidades
		DaoEspecialidad daoEspecialidad = new DaoEspecialidad();
		daoEspecialidad.Add(esp1);
		daoEspecialidad.Add(esp2);
		daoEspecialidad.Add(esp3);
		daoEspecialidad.Add(esp4);
		daoEspecialidad.Add(esp5);

		// Creamos los tecnicos
		Tecnico t1 = new Tecnico(esp1, "Matias", false);
		Tecnico t2 = new Tecnico(esp2, "Roxana", false);
		Tecnico t3 = new Tecnico(esp3, "Andrea", false);
		Tecnico t4 = new Tecnico(esp4, "Lautaro", false);
		Tecnico t5 = new Tecnico(esp5, "Nicolas", false);

		// Agregamos los tecnicos
		DaoTecnico daoTecnico = new DaoTecnico();
		daoTecnico.Add(t1);
		daoTecnico.Add(t2);
		daoTecnico.Add(t3);
		daoTecnico.Add(t4);
		daoTecnico.Add(t5);

		ArrayList<Tecnico> listaTecnicos = new ArrayList<Tecnico>();
		listaTecnicos.add(t1);
		listaTecnicos.add(t2);
		listaTecnicos.add(t3);
		listaTecnicos.add(t4);
		listaTecnicos.add(t5);

		// Creamos los clientes
		Cliente c1 = new Cliente("Provemax", "33123312", "Carlos", "Gonzales", "Direccion_1");
		Cliente c2 = new Cliente("HotelStar", "22323322", "Fernando", "Alonso", "Direccion_2");
		Cliente c3 = new Cliente("TodoCar", "212424244", "Juan", "Martinez", "Direccion_3");
		Cliente c4 = new Cliente("FrioStar", "32333334", "Gonzalo", "Perez", "Direccion_4");
		Cliente c5 = new Cliente("ElectroH", "33125223", "Martin", "Rodriguez", "Direccion_5");

		// Agregamos los clientes
		DaoCliente daoCliente = new DaoCliente();
		daoCliente.Add(c1);
		daoCliente.Add(c2);
		daoCliente.Add(c3);
		daoCliente.Add(c4);
		daoCliente.Add(c5);

		// Creamos los operadores
		Operador op1 = new Operador("Tomas", "Rodriguez", "40889765", "Las Higueras 89");
		Operador op2 = new Operador("Noelia", "Martinez", "39456789", "Avenida Mitre 1654");
		Operador op3 = new Operador("Laura", "Perez", "41569894", "Brasil 456");
		Operador op4 = new Operador("Andres", "Romero", "25988741", "Lamadrid 68");
		Operador op5 = new Operador("Lucas", "Velazquez", "42156988", "Corrientes 654");

		// Agregamos los operadores
		DaoOperador daoOperador = new DaoOperador();

		// Creamos los incidentes
		LocalDate fechaReporte = LocalDate.now().minusDays(10);
		String fechaReporteFormateada = fechaReporte.format(DateTimeFormatter.ISO_DATE);

		LocalDate fechaResolucion = LocalDate.of(2023, 11, 24);
		String fechaResolucionFormateada = fechaResolucion.format(DateTimeFormatter.ISO_DATE);

		daoOperador.Add(op1);
		daoOperador.Add(op2);
		daoOperador.Add(op3);
		daoOperador.Add(op4);
		daoOperador.Add(op5);

		// Creamos los incidentes
		Incidente inc1 = new Incidente("Fallo Windows", false, fechaReporteFormateada, fechaResolucionFormateada, c1,
				listaTecnicos, esp1, op1);
		Incidente inc2 = new Incidente("Fallo Linux", false, fechaReporteFormateada, fechaResolucionFormateada, c2,
				listaTecnicos, esp2, op2);
		Incidente inc3 = new Incidente("Fallo Sap", true, fechaReporteFormateada, fechaResolucionFormateada, c3,
				listaTecnicos, esp3, op3);
		Incidente inc3A = new Incidente("Fallo Sap", true, fechaReporteFormateada, fechaResolucionFormateada, c3,
				listaTecnicos, esp3, op3);
		Incidente inc3B = new Incidente("Fallo Sap", true, fechaReporteFormateada, fechaResolucionFormateada, c3,
				listaTecnicos, esp3, op3);
		Incidente inc4 = new Incidente("Fallo Tango", false, fechaReporteFormateada, fechaResolucionFormateada, c4,
				listaTecnicos, esp4, op4);
		Incidente inc5 = new Incidente("Fallo MacOs", true, fechaReporteFormateada, fechaResolucionFormateada, c5,
				listaTecnicos, esp5, op5);
		Incidente inc6 = new Incidente("Fallo MacOs", true, fechaReporteFormateada, fechaResolucionFormateada, c5,
				listaTecnicos, esp5, op5);

		// Agregamos los incidentes
		DaoIncidente daoIncidente = new DaoIncidente();
		daoIncidente.Add(inc1);
		daoIncidente.Add(inc2);
		daoIncidente.Add(inc3);
		daoIncidente.Add(inc4);
		daoIncidente.Add(inc5);
		daoIncidente.Add(inc6);
		daoIncidente.Add(inc3A);
		daoIncidente.Add(inc3B);

		// CLIENTES EXISTENTES
		//System.out.println(daoCliente.ListarClientes()+"\n\n"); //LISTAR TODOS LOS

		//System.out.println(daoTecnico.listarTecnicos()+"\n\n"); //LISTAR TODOS LOS TECNICOS
		// EXISTENTES

		// tecnicosPorEspecialidad("Windows");
		// clientesSistema();
		// System.out.println(daoIncidente.listarIncidentes());

		// tecnicosPorEspecialidad("Windows");
		
		// Punto 3
		incidentesResueltos(10);  // a
		tecnicosPorEspecialidad("Windows"); // b
		clientesSistema();	// c
	}

	public static void incidentesResueltos(int dias) {

		if (dias <= 1) {
			System.out.println("El número de días debe ser mayor a 1.");
			return;
		}

		DaoIncidente daoIncidente = new DaoIncidente();
		List<Incidente> incidentesList = daoIncidente.listarIncidentes();
		LocalDate fechaLimite = LocalDate.now().minusDays(dias);

		Map<String, Integer> contadorTecnicos = new HashMap<>();

		int contadorInc = 0;

		for (Incidente inc : incidentesList) {
			if (inc.getFechaResolucion() != null && LocalDate.parse(inc.getFechaResolucion()).isAfter(fechaLimite)
					&& inc.isResuelto()) {
				List<Tecnico> listaTecnicos = inc.getListaTecnicos();
				contadorInc++;
				for (Tecnico tec : listaTecnicos) {
					if (tec.getEspecialidad().getNombreEspecialidad()
							.equals(inc.getEspecialidad().getNombreEspecialidad())) {
						String nombreTecnico = tec.getNombre();
						// Actualizar la cantidad de veces que aparece el técnico en el mapa
						contadorTecnicos.put(nombreTecnico, contadorTecnicos.getOrDefault(nombreTecnico, 0) + 1);
					}
				}
			}
		}

		System.out.println("Cantidad de incidentes resueltos: " + contadorInc);

		// ENCONTRAR EL TECNICO MAS REPETIDO
		if (!contadorTecnicos.isEmpty()) {
			String tecnicoMasRepetido = null;
			int maxContador = 0;

			for (Map.Entry<String, Integer> entry : contadorTecnicos.entrySet()) {
				if (entry.getValue() > maxContador) {
					maxContador = entry.getValue();
					tecnicoMasRepetido = entry.getKey();
				}
			}

			System.out.println("El técnico más repetido es " + tecnicoMasRepetido + " con un total de " + maxContador
					+ " incidentes resueltos.\n\n");
		} else {
			System.out.println("No hay técnicos repetidos.\n\n");
		}
	}

	public static void tecnicosPorEspecialidad(String especialidad) {

		DaoTecnico daoTecnico = new DaoTecnico();

		List<Tecnico> tecnicosList = daoTecnico.listarTecnicos();

		int contadorTecnicos = 0;

		for (Tecnico tec : tecnicosList) {
			if (tec.getEspecialidad().getNombreEspecialidad().equals(especialidad)) {
				System.out.println("ID del tecnico: " + tec.getIdTecnico() + ", Nombre: " + tec.getNombre());
				contadorTecnicos = contadorTecnicos + 1;
			}
		}

		System.out.println("El numero de tecnicos que corresponden a la especialidad " + especialidad + " es igual a "
				+ contadorTecnicos + "\n\n");

	}

	public static void clientesSistema() {
		DaoCliente daoCliente = new DaoCliente();

		List<Cliente> clientesList = daoCliente.ListarClientes();

		int contadorClientes = 0;

		for (Cliente c : clientesList) {
			contadorClientes = contadorClientes + 1;
		}

		System.out.println("El numero de clientes que pertenecen al sistema es de " + contadorClientes + "\n\n");

	}

}
