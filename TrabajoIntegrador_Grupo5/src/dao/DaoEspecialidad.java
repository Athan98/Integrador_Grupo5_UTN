package dao;

import org.hibernate.Session;
import entidades.Especialidad;

public class DaoEspecialidad {
	public void Add(Especialidad especialidad) 
	{
		ConfigHibernate ch = new ConfigHibernate();
		Session session= ch.abrirConexion();
		     
	    session.beginTransaction();
	    session.save(especialidad);
	    
	    session.getTransaction().commit();    
		ch.cerrarSession();
	}
	
	public Especialidad ReadOne(int id)
	{
		ConfigHibernate config = new ConfigHibernate();
		Session session= config.abrirConexion();
		
		session.beginTransaction();
		Especialidad especialidad=(Especialidad)session.get(Especialidad.class,id);
        
        config.cerrarSession();
        
        return especialidad;
	}
	
	public void Update(Especialidad especialidad)
	{
		ConfigHibernate config = new ConfigHibernate();
		Session session= config.abrirConexion();
		
        session.beginTransaction();
        session.update(especialidad);
        session.getTransaction().commit();        
        
        config.cerrarSession();
	}
	
	public void Delete(Especialidad especialidad)
	{
		ConfigHibernate config = new ConfigHibernate();
		Session session= config.abrirConexion();
		
        session.beginTransaction();
        session.delete(especialidad);
        session.getTransaction().commit();        
        
        config.cerrarSession();
	}
}
