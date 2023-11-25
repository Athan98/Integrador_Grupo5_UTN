package main;

import java.time.LocalDate;
import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

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
    	ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
    	sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    	Session session = sessionFactory.openSession();
 
    	session.beginTransaction();
    	
 
    	Cliente c1 = new Cliente("Provemax","33123312","Carlos","Gonzales","Direccion_1");
    	Cliente c2 = new Cliente("HotelStar","22323322","Fernando","Alonso","Direccion_2");
    	Cliente c3 = new Cliente("TodoCar","212424244","Juan","Martinez","Direccion_3");
    	Cliente c4 = new Cliente("FrioStar","32333334","Gonzalo","Perez","Direccion_4");
    	Cliente c5 = new Cliente("ElectroH","33125223","Martin","Rodriguez","Direccion_5");
    	
    	Especialidad esp1 = new Especialidad("Windows");
    	Especialidad esp2 = new Especialidad("Linux");
    	Especialidad esp3 = new Especialidad("Sap");
    	Especialidad esp4 = new Especialidad("Tango");
    	Especialidad esp5 = new Especialidad("MacOs");
    	
    	Tecnico t1 = new Tecnico(0,esp1,"Matias",false);
    	Tecnico t2 = new Tecnico(0,esp2,"Roxana",false);
    	Tecnico t3 = new Tecnico(0,esp3,"Andrea",false);
    	Tecnico t4 = new Tecnico(0,esp4,"Lautaro",false);
    	Tecnico t5 = new Tecnico(0,esp5,"Nicolas",false);
    	
    	ArrayList <Tecnico> listaTecnicos = new ArrayList<Tecnico>();
    	listaTecnicos.add(t1);
    	listaTecnicos.add(t2);
    	listaTecnicos.add(t3);
    	listaTecnicos.add(t4);
    	listaTecnicos.add(t5);
    	
    	Operador op1 = new Operador("Tomas");
    	Operador op2 = new Operador("Noelia");
    	Operador op3 = new Operador("Laura");
    	Operador op4 = new Operador("Andres");
    	Operador op5 = new Operador("Lucas");
    	
    	Incidente inc1 = new Incidente("Fallo Windows",false,LocalDate.now(),LocalDate.of(2023, 12, 2), c1,listaTecnicos, esp1,op1);
    	Incidente inc2 = new Incidente("Fallo Linux",false,LocalDate.now(),LocalDate.of(2023, 12, 2), c2,listaTecnicos, esp2,op2);
    	Incidente inc3 = new Incidente("Fallo Sap",false,LocalDate.now(),LocalDate.of(2023, 12, 2), c3,listaTecnicos,esp3,op3);
    	Incidente inc4 = new Incidente("Fallo Tango",false,LocalDate.now(),LocalDate.of(2023, 12, 2), c4,listaTecnicos,esp4,op4);
    	Incidente inc5 = new Incidente("Fallo MacOs",false,LocalDate.now(),LocalDate.of(2023, 12, 2), c5,listaTecnicos,esp5,op5);
    	
    	
	}

}
