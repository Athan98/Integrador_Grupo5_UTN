package dao;

import org.hibernate.Session;

import entidades.Operador;

public class DaoOperador {
	public void Add(Operador operador) 
	{
		ConfigHibernate ch = new ConfigHibernate();
		Session session= ch.abrirConexion();
		     
	    session.beginTransaction();
	    session.save(operador);
	    
	    session.getTransaction().commit();    
		ch.cerrarSession();
	}
	
	public Operador ReadOne(int id)
	{
		ConfigHibernate config = new ConfigHibernate();
		Session session= config.abrirConexion();
		
		session.beginTransaction();
		Operador operador=(Operador)session.get(Operador.class,id);
        
        config.cerrarSession();
        
        return operador;
	}
	
	public void Update(Operador operador)
	{
		ConfigHibernate config = new ConfigHibernate();
		Session session= config.abrirConexion();
		
        session.beginTransaction();
        session.update(operador);
        session.getTransaction().commit();        
        
        config.cerrarSession();
	}
	
	public void Delete(Operador operador)
	{
		ConfigHibernate config = new ConfigHibernate();
		Session session= config.abrirConexion();
		
        session.beginTransaction();
        session.delete(operador);
        session.getTransaction().commit();        
        
        config.cerrarSession();
	}
}
