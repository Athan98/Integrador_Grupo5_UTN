package dao;

import org.hibernate.Session;

import entidades.Tecnico;

public class DaoTecnico {
	public void Add(Tecnico tecnico) 
	{
		ConfigHibernate ch = new ConfigHibernate();
		Session session= ch.abrirConexion();
		     
	    session.beginTransaction();
	    session.save(tecnico);
	    
	    session.getTransaction().commit();    
		ch.cerrarSession();
	}
	
	public Tecnico ReadOne(int id)
	{
		ConfigHibernate config = new ConfigHibernate();
		Session session= config.abrirConexion();
		
		session.beginTransaction();
		Tecnico tecnico=(Tecnico)session.get(Tecnico.class,id);
        
        config.cerrarSession();
        
        return tecnico;
	}
	
	public void Update(Tecnico tecnico)
	{
		ConfigHibernate config = new ConfigHibernate();
		Session session= config.abrirConexion();
		
        session.beginTransaction();
        session.update(tecnico);
        session.getTransaction().commit();        
        
        config.cerrarSession();
	}
	
	public void Delete(Tecnico tecnico)
	{
		ConfigHibernate config = new ConfigHibernate();
		Session session= config.abrirConexion();
		
        session.beginTransaction();
        session.delete(tecnico);
        session.getTransaction().commit();        
        
        config.cerrarSession();
	}
}
