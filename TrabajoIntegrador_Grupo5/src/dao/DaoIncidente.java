package dao;

import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Session;
import entidades.Incidente;
import entidades.Tecnico;

public class DaoIncidente {
	public void Add(Incidente incidente) 
	{
		ConfigHibernate ch = new ConfigHibernate();
		Session session= ch.abrirConexion();
		     
	    session.beginTransaction();
	    session.save(incidente);
	    
	    session.getTransaction().commit();    
		ch.cerrarSession();
	}
	
	public Incidente ReadOne(int id)
	{
		ConfigHibernate config = new ConfigHibernate();
		Session session= config.abrirConexion();
		
		session.beginTransaction();
		Incidente incidente=(Incidente)session.get(Incidente.class,id);
        
        config.cerrarSession();
        
        return incidente;
	}
	
	public void Update(Incidente incidente)
	{
		ConfigHibernate config = new ConfigHibernate();
		Session session= config.abrirConexion();
		
        session.beginTransaction();
        session.update(incidente);
        session.getTransaction().commit();        
        
        config.cerrarSession();
	}
	
	public void Delete(Incidente incidente)
	{
		ConfigHibernate config = new ConfigHibernate();
		Session session= config.abrirConexion();
		
        session.beginTransaction();
        session.delete(incidente);
        session.getTransaction().commit();        
        
        config.cerrarSession();
	}
	
	public List<Incidente> listarIncidentes(){
		
		ConfigHibernate config = new ConfigHibernate();
		Session session = config.abrirConexion();
		List<Incidente> incidentesList = null;

		session.beginTransaction();
		try {
		incidentesList = session.createQuery("FROM Incidente").list();
		}catch (NullPointerException ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
		

		return incidentesList;
	}
}
