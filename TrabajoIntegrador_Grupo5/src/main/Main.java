package main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
		// daoEspecialidad.Add(esp1);
		// daoEspecialidad.Add(esp2);
		// daoEspecialidad.Add(esp3);
		// daoEspecialidad.Add(esp4);
		// daoEspecialidad.Add(esp5);

		// Creamos los tecnicos
		Tecnico t1 = new Tecnico(esp1, "Matias", false);
		Tecnico t2 = new Tecnico(esp2, "Roxana", false);
		Tecnico t3 = new Tecnico(esp3, "Andrea", false);
		Tecnico t4 = new Tecnico(esp4, "Lautaro", false);
		Tecnico t5 = new Tecnico(esp5, "Nicolas", false);

		// Agregamos los tecnicos
		DaoTecnico daoTecnico = new DaoTecnico();
		// daoTecnico.Add(t1);
		// daoTecnico.Add(t2);
		// daoTecnico.Add(t3);
		// daoTecnico.Add(t4);
		// daoTecnico.Add(t5);

		ArrayList<Tecnico> listaTecnicos = new ArrayList<Tecnico>();
		// listaTecnicos.add(t1);
		// listaTecnicos.add(t2);
		// listaTecnicos.add(t3);
		// listaTecnicos.add(t4);
		// listaTecnicos.add(t5);

		// Creamos los clientes
		Cliente c1 = new Cliente("Provemax", "33123312", "Carlos", "Gonzales", "Direccion_1");
		Cliente c2 = new Cliente("HotelStar", "22323322", "Fernando", "Alonso", "Direccion_2");
		Cliente c3 = new Cliente("TodoCar", "212424244", "Juan", "Martinez", "Direccion_3");
		Cliente c4 = new Cliente("FrioStar", "32333334", "Gonzalo", "Perez", "Direccion_4");
		Cliente c5 = new Cliente("ElectroH", "33125223", "Martin", "Rodriguez", "Direccion_5");

		// Agregamos los clientes
		DaoCliente daoCliente = new DaoCliente();
		// daoCliente.Add(c1);
		// daoCliente.Add(c2);
		// daoCliente.Add(c3);
		// daoCliente.Add(c4);
		// daoCliente.Add(c5);

		// Creamos los operadores
		Operador op1 = new Operador("Tomas");
		Operador op2 = new Operador("Noelia");
		Operador op3 = new Operador("Laura");
		Operador op4 = new Operador("Andres");
		Operador op5 = new Operador("Lucas");

		// Agregamos los operadores
		DaoOperador daoOperador = new DaoOperador();
		// daoOperador.Add(op1);
		// daoOperador.Add(op2);
		// daoOperador.Add(op3);
		// daoOperador.Add(op4);
		// daoOperador.Add(op5);

		// Creamos los incidentes
		Incidente inc1 = new Incidente("Fallo Windows", false, LocalDate.now(), LocalDate.of(2023, 12, 2), c1,
				listaTecnicos, esp1, op1);
		Incidente inc2 = new Incidente("Fallo Linux", false, LocalDate.now(), LocalDate.of(2023, 12, 2), c2,
				listaTecnicos, esp2, op2);
		Incidente inc3 = new Incidente("Fallo Sap", false, LocalDate.now(), LocalDate.of(2023, 12, 2), c3,
				listaTecnicos, esp3, op3);
		Incidente inc4 = new Incidente("Fallo Tango", false, LocalDate.now(), LocalDate.of(2023, 12, 2), c4,
				listaTecnicos, esp4, op4);
		Incidente inc5 = new Incidente("Fallo MacOs", false, LocalDate.now(), LocalDate.of(2023, 12, 2), c5,
				listaTecnicos, esp5, op5);

		// Agregamos los incidentes
		DaoIncidente daoIncidente = new DaoIncidente();
		// daoIncidente.Add(inc1);
		// daoIncidente.Add(inc2);
		// daoIncidente.Add(inc3);
		// daoIncidente.Add(inc4);
		// daoIncidente.Add(inc5);

		// System.out.println(daoCliente.ListarClientes()+""); //LISTAR TODOS LOS
		// CLIENTES EXISTENTES

		// System.out.println(daoTecnico.listarTecnicos()); //LISTAR TODOS LOS TECNICOS
		// EXISTENTES

		 //tecnicosPorEspecialidad("Windows");
		
		clientesSistema();

	}

	public static void incidentesResueltos(int dias) {

	}

	public static void tecnicosPorEspecialidad(String especialidad) {

		DaoTecnico daoTecnico = new DaoTecnico();

		List<Tecnico> tecnicosList = daoTecnico.listarTecnicos();
		
		int contadorTecnicos=0;

		for (Tecnico tec : tecnicosList) {
			if (tec.getEspecialidad().getNombreEspecialidad().equals(especialidad)) {
				System.out.println("ID del tecnico: " + tec.getIdTecnico() + ", Nombre: " + tec.getNombre());
				contadorTecnicos=contadorTecnicos+1;
			}
		}
		
		System.out.println("El numero de tecnicos que corresponden a la especialidad "+especialidad+" es igual a "+contadorTecnicos);

	}
	
	public static void clientesSistema() {
		DaoCliente daoCliente = new DaoCliente();
		
		List<Cliente> clientesList=daoCliente.ListarClientes();
		
		int contadorClientes=0;
		
		for(Cliente c:clientesList) {
			contadorClientes=contadorClientes+1;
		}
		
		System.out.println("El numero de clientes que pertenecen al sistema es de "+contadorClientes);
		
	}
	
	

}
